/*
 * Copyright (c) 2014-2015 Janith Bandara, This source is a part of
 * Audit4j - An open source auditing framework.
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

import java.io.FilePermission;
import java.security.AccessControlException;
import java.security.AccessController;

import org.audit4j.core.exception.InitializationException;
import org.audit4j.core.handler.Handler;

/**
 * The Class FileAuditHandler.
 * 
 * @author <a href="mailto:janith3000@gmail.com">Janith Bandara</a>
 * 
 * @since 1.0.0
 */
public class FileAuditHandler extends Handler {

	/** asdas. */
	private static final long serialVersionUID = 1L;

	/** The writer. */
	AuditFileWriter writer;

	private String archive;
	
	/** The date pattern. */
	private String datePattern;

	/** The path. */
	private String path;

	/** The cron pattern. */
	private String cronPattern;

	/** The job. */
	private ArchiveJob job;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.audit4j.core.handler.Handler#init()
	 */
	@Override
	public void init() throws InitializationException {
		writer = new ZeroCopyFileWriter(getProperty("log.file.location"));
		
		//writer = new MemoryMappedFileWriter(getProperty("log.file.location"));
		
		writer.init();
		
		// if (!hasDiskAccess(getProperty("log.file.location"))) {
		// throw new InitializationException(
		// "Can not write a file. Disk is not accessible. Please set read,write permission for "
		// + getProperty("log.file.location"));
		// }
		
		if (null != archive && "true".equals(archive)) {
			ArchiveManager manager = new ArchiveManager();
			manager.setArchiveDate(datePattern);
			manager.setCronPattern(cronPattern);
			manager.setPath(getProperty("log.file.location"));
			manager.setJob(job);
			manager.init();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.audit4j.core.handler.Handler#handle()
	 */
	@Override
	public void handle() {
		writer.write(getQuery());
	}

	/**
	 * Checks for disk access.
	 * 
	 * @param path
	 *            the path
	 * @return true, if successful
	 */
	static boolean hasDiskAccess(final String path) {
		try {
			AccessController.checkPermission(new FilePermission(path, "read,write"));
			return true;
		} catch (AccessControlException e) {
			return false;
		}
	}
	
	

	public void setArchive(String archive) {
		this.archive = archive;
	}

	/**
	 * Sets the date pattern.
	 *
	 * @param datePattern the new date pattern
	 */
	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}

	/**
	 * Sets the path.
	 *
	 * @param path the new path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Sets the cron pattern.
	 *
	 * @param cronPattern the new cron pattern
	 */
	public void setCronPattern(String cronPattern) {
		this.cronPattern = cronPattern;
	}

	@Override
	public void stop() {
		writer.stop();
	}
}
