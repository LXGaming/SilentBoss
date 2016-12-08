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