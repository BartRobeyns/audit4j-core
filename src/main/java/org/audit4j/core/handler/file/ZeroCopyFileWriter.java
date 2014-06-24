/*
 * Copyright 2014 Janith Bandara, This source is a part of Audit4j - 
 * An open-source audit platform for Enterprise java platform.
 * http://mechanizedspace.com/audit4j
 * http://audit4j.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.audit4j.core.handler.file;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

import org.audit4j.core.CoreConstants;

/**
 * The Class ZeroCopyFileWriter.
 * 
 * @author <a href="mailto:janith3000@gmail.com">Janith Bandara</a>
 */
public final class ZeroCopyFileWriter extends AuditFileWriter implements Serializable{


	/** The path. */
	private final String path;

	/**
	 * Instantiates a new zero copy file writer.
	 * 
	 * @param conf
	 *            the conf
	 */
	public ZeroCopyFileWriter(String path) {
		this.path = path;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.audit4j.core.io.AuditOutputStream#write(org.audit4j.core.dto.AuditEvent
	 * )
	 */
	@Override
	public ZeroCopyFileWriter write(String event) {
		String str2 = event + CoreConstants.NEW_LINE;
		RandomAccessFile randomAccessFile;
		String realPath = FileHandlerUtil.generateOutputFilePath(path);

		long numBytes = str2.getBytes().length;

		InputStream inputStream = new ByteArrayInputStream(str2.getBytes(Charset.forName("UTF-8")));

		try {
			if (FileHandlerUtil.isFileAlreadyExists(realPath)) {
				randomAccessFile = new RandomAccessFile(realPath, CoreConstants.READ_WRITE);
			} else {
				randomAccessFile = new RandomAccessFile(new File(realPath), CoreConstants.READ_WRITE);
			}
			// move the cursor to the end of the file
			randomAccessFile.seek(randomAccessFile.length());

			// obtain the a file channel from the RandomAccessFile
			try (FileChannel fileChannel = randomAccessFile.getChannel();
					ReadableByteChannel inputChannel = Channels.newChannel(inputStream);

			) {
				fileChannel.transferFrom(inputChannel, randomAccessFile.length(), numBytes);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.audit4j.core.io.AuditOutputStream#close()
	 */
	public void close() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {
		return null;
	}
}
