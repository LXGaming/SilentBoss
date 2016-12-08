package io.github.lxgaming.silentboss.util;

import org.apache.logging.log4j.Level;

import net.minecraftforge.fml.common.FMLLog;

public class LogManager {
	
	public static void all(String string) {
		FMLLog.log(Reference.MOD_NAME, Level.ALL, string);
	}
	
	public static void debug(String string) {
		FMLLog.log(Reference.MOD_NAME, Level.DEBUG, string);
	}
	
	public static void error(String string) {
		FMLLog.log(Reference.MOD_NAME, Level.ERROR, string);
	}
	
	public static void fatal(String string) {
		FMLLog.log(Reference.MOD_NAME, Level.FATAL, string);
	}
	
	public static void info(String string) {
		FMLLog.log(Reference.MOD_NAME, Level.INFO, string);
	}
	
	public static void off(String string) {
		FMLLog.log(Reference.MOD_NAME, Level.OFF, string);
	}
	
	public static void trace(String string) {
		FMLLog.log(Reference.MOD_NAME, Level.TRACE, string);
	}
	
	public static void warn(String string) {
		FMLLog.log(Reference.MOD_NAME, Level.WARN, string);
	}
}