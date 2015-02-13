/*
 * Copyright 2014 Janith Bandara, This source is a part of 
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

package org.audit4j.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.audit4j.core.exception.ConfigurationException;
import org.audit4j.core.exception.TroubleshootException;
import org.audit4j.core.handler.ConsoleAuditHandler;
import org.audit4j.core.handler.Handler;
import org.audit4j.core.handler.file.FileAuditHandler;
import org.audit4j.core.layout.SimpleLayout;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;

/**
 * The Class ConfigUtil.
 *
 * @author <a href="mailto:janith3000@gmail.com">Janith Bandara</a>
 * 
 * @since 1.0.1
 */
public final class ConfigUtil {

	/**
	 * Instantiates a new config util.
	 */
	private ConfigUtil() {
	}

	/**
	 * Creates the dummy config.
	 *
	 * @return the configuration
	 */
	static Configuration createDummyConfig() {
		Configuration conf = new Configuration();
		List<Handler> handlers = new ArrayList<>();
		FileAuditHandler handler = new FileAuditHandler();
		handler.setArchive("true");
		handler.setCronPattern("1d1M");
		handlers.add(handler);
		//FileAuditHandler handler = new FileAuditHandler();
		//handlers.add(handler);
		ConsoleAuditHandler handler2 = new ConsoleAuditHandler();
		handlers.add(handler2);
		conf.setHandlers(handlers);
		conf.setLayout(new SimpleLayout());
		conf.setOptions("sd");
		Map<String,String> properties = new HashMap<String,String>();
		properties.put("log.file.location", "$user.dir");
		conf.setProperties(properties);
		//conf.setMetaData(new DummyMetaData());
		return conf;
	}

	/**
	 * Generate config from object.
	 */
	static void generateConfigFromObject() {
		YamlWriter writer;
		try {
			writer = new YamlWriter(new FileWriter("audit4j.conf.yml"));
			writer.getConfig().setClassTag("Configuration", Configuration.class);
			writer.write(createDummyConfig());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Generate config from text.
	 */
	public static void generateConfigFromText() {
		StringBuffer yml = new StringBuffer("!Configuration\n");
		yml.append("released: ").append(CoreConstants.RELEASE_DATE).append("\n");
		yml.append("version: ").append(CoreConstants.RELEASE_VERSION).append("\n");
		yml.append("handlers:").append("\n");
		yml.append("- !org.audit4j.core.handler.ConsoleAuditHandler {}").append("\n");
		yml.append("- !org.audit4j.core.handler.file.FileAuditHandler {}").append("\n");
		yml.append("layout: !org.audit4j.core.layout.SimpleLayout {}").append("\n");
		yml.append("metaData: !org.audit4j.core.DummyMetaData {}").append("\n");
		yml.append("properties:").append("\n");
		yml.append("   log.file.location: user.dir").append("\n");
		
		File file = new File(CoreConstants.CONFIG_FILE_NAME);
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(yml.toString());
			bw.close();
		} catch (IOException e) {
			throw new TroubleshootException("Unable to create configuration file. ", e);
		}
	}

	/**
	 * Read config.
	 *
	 * @return the configuration
	 * @throws ConfigurationException the configuration exception
	 */
	static Configuration readConfig(final String filePath) throws ConfigurationException {
		try {
			YamlReader reader = new YamlReader(new FileReader(filePath));
			reader.getConfig().setClassTag("Configuration", Configuration.class);

			return (Configuration) reader.read();

		} catch (FileNotFoundException e) {
			throw new ConfigurationException("Configuration Exception", "CONF_001", e);
		} catch (YamlException e) {
			throw new ConfigurationException("Configuration Exception", "CONF_002", e);
		}
	}
	
	static List<String> getHandlerClassNames(List<Handler> handlers){
		List<String> handlerClassNameList = new ArrayList<>();
		for (Handler handler : handlers) {
			handlerClassNameList.add(handler.getClass().getName());
		}
		return handlerClassNameList;
	}
	
	public static void main(String[] args) {
		generateConfigFromObject();
	}
}
