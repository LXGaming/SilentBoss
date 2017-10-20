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

import io.github.lxgaming.silentboss.config.Config;
import io.github.lxgaming.silentboss.listeners.SilentBossListener;
import io.github.lxgaming.silentboss.util.LogHelper;
import io.github.lxgaming.silentboss.util.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.MOD_VERSION,
        guiFactory = Reference.GUI_FACTORY,
        acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS,
        acceptableRemoteVersions = Reference.ACCEPTABLE_REMOTE_VERSIONS,
        certificateFingerprint = Reference.CERTIFICATE_FINGERPRINT
)
public class SilentBoss {
    
    @Mod.Instance
    private static SilentBoss instance;
    
    private Config config;
    
    @Mod.EventHandler
    public void fingerprintViolation(FMLFingerprintViolationEvent event) {
        throw new SecurityException("Certificate Fingerprint Violation Detected!");
    }
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        config = new Config(event.getSuggestedConfigurationFile());
        getConfig().loadConfig();
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new SilentBossListener());
    }
    
    public void debugMessage(String message) {
        if (getConfig() != null && getConfig().isDebug()) {
            LogHelper.info(message);
        }
    }
    
    public static SilentBoss getInstance() {
        return instance;
    }
    
    public Config getConfig() {
        return config;
    }
}