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
