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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {
    
    private static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);
    
    public static void all(String string, Object... objects) {
        getLogger().log(Level.ALL, string, objects);
    }
    
    public static void debug(String string, Object... objects) {
        getLogger().log(Level.DEBUG, string, objects);
    }
    
    public static void error(String string, Object... objects) {
        getLogger().log(Level.ERROR, string, objects);
    }
    
    public static void fatal(String string, Object... objects) {
        getLogger().log(Level.FATAL, string, objects);
    }
    
    public static void info(String string, Object... objects) {
        getLogger().log(Level.INFO, string, objects);
    }
    
    public static void off(String string, Object... objects) {
        getLogger().log(Level.OFF, string, objects);
    }
    
    public static void trace(String string, Object... objects) {
        getLogger().log(Level.TRACE, string, objects);
    }
    
    public static void warn(String string, Object... objects) {
        getLogger().log(Level.WARN, string, objects);
    }
    
    public static Logger getLogger() {
        return LOGGER;
    }
}