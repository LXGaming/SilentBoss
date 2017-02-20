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

package io.github.lxgaming.silentboss.configuration;

import java.io.File;

import io.github.lxgaming.silentboss.util.LogManager;
import net.minecraftforge.common.config.Configuration;

public class Config {
	
	private Configuration configuration;
	
	private boolean debug;
	private boolean silenceEnderDragon;
	private boolean silenceWither;
	
	public void loadConfig(File file) {
		this.configuration = new Configuration(file);
		getConfiguration().load();
		
		this.debug = getConfiguration().getBoolean("debug", Configuration.CATEGORY_GENERAL, false, "Debug mode.");
		this.silenceEnderDragon = getConfiguration().getBoolean("silenceEnderDragon", Configuration.CATEGORY_GENERAL, true, "Silence the EnderDragon?");
		this.silenceWither = getConfiguration().getBoolean("silenceWither", Configuration.CATEGORY_GENERAL, true, "Silence the Wither?");
		
		getConfiguration().save();
		LogManager.info("Configuration file successfully loaded.");
	}
	
	public Configuration getConfiguration() {
		return this.configuration;
	}
	
	public boolean isDebug() {
		return this.debug;
	}
	
	public boolean isSilenceEnderDragon() {
		return this.silenceEnderDragon;
	}
	
	public boolean isSilenceWither() {
		return this.silenceWither;
	}
}