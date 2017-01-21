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

package io.github.lxgaming.silentboss;

import io.github.lxgaming.silentboss.commands.SilentBossCommand;
import io.github.lxgaming.silentboss.config.Configuration;
import io.github.lxgaming.silentboss.listeners.SilentBossListener;
import io.github.lxgaming.silentboss.util.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS, acceptableRemoteVersions = "*", serverSideOnly = true)
public class SilentBoss {
	
	@Instance
	private static SilentBoss instance;
	private Configuration configuration;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		this.configuration = new Configuration(event.getModConfigurationDirectory());
		this.configuration.loadConfig();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new SilentBossListener());
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(new SilentBossCommand());
	}
	
	public static SilentBoss getInstance() {
		return instance;
	}
	
	public Configuration getConfiguration() {
		return this.configuration;
	}
}
