/*
 * Copyright 2017 Alex Thomson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.lxgaming.silentboss.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import io.github.lxgaming.silentboss.SilentBoss;
import io.github.lxgaming.silentboss.util.LogManager;

public class Configuration {
	
	private File configFile;
	private JsonObject config;
	
	public Configuration(File file) {
		configFile = new File(file.getAbsolutePath() + "/SilentBoss.json");
	}
	
	public void loadConfig() {
		try {
			if (!configFile.exists()) {
				InputStream inputStream = SilentBoss.class.getResourceAsStream("/config.json");
				Files.copy(inputStream, Paths.get(configFile.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
				LogManager.info("Successfully created configuration file.");
			}
			
			config = new JsonParser().parse(new String(Files.readAllBytes(Paths.get(configFile.getAbsolutePath())), StandardCharsets.UTF_8)).getAsJsonObject();
			
			LogManager.info("Successfully loaded configuration file.");
		} catch (IllegalStateException | InvalidPathException | IOException | JsonParseException | OutOfMemoryError | SecurityException ex) {
			LogManager.info("Exception loading configuration file!");
			ex.printStackTrace();
		}
		return;
	}
	
	public JsonObject getConfig() {
		return this.config;
	}
}
