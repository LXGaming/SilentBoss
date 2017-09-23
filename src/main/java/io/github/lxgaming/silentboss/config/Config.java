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

import io.github.lxgaming.silentboss.util.LogHelper;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {
    
    private final Configuration configuration;
    private boolean debug;
    private boolean silenceEnderDragon;
    private boolean silenceWither;
    
    public Config(File file) {
        this.configuration = new Configuration(file);
    }
    
    public void loadConfig() {
        getConfiguration().load();
        
        debug = getConfiguration().getBoolean("debug", Configuration.CATEGORY_GENERAL, false, "Debug mode.");
        silenceEnderDragon = getConfiguration().getBoolean("silenceEnderDragon", Configuration.CATEGORY_GENERAL, true, "Silence the EnderDragon?");
        silenceWither = getConfiguration().getBoolean("silenceWither", Configuration.CATEGORY_GENERAL, true, "Silence the Wither?");
        
        getConfiguration().save();
        LogHelper.info("Configuration file successfully loaded.");
    }
    
    public void reloadConfig() {
        getConfiguration().save();
        loadConfig();
    }
    
    public Configuration getConfiguration() {
        return configuration;
    }
    
    public boolean isDebug() {
        return debug;
    }
    
    public boolean isSilenceEnderDragon() {
        return silenceEnderDragon;
    }
    
    public boolean isSilenceWither() {
        return silenceWither;
    }
}