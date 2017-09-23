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

import io.github.lxgaming.silentboss.SilentBoss;
import io.github.lxgaming.silentboss.util.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuiModConfig extends GuiConfig {
    
    /**
     * Used by Forge 1.10.x
     */
    public GuiModConfig(GuiScreen parentScreen) {
        this(parentScreen, Reference.MOD_ID, Reference.MOD_NAME);
    }
    
    /**
     * Used by Forge 1.11.x - 1.12.x
     */
    public GuiModConfig(GuiScreen parentScreen, String modid, String title) {
        super(parentScreen, getConfigElements(), modid, false, false, title);
    }
    
    private static List<IConfigElement> getConfigElements() {
        return SilentBoss.getInstance().getConfig().getConfiguration().getCategoryNames().stream()
                .map(categoryName -> new ConfigElement(SilentBoss.getInstance().getConfig().getConfiguration().getCategory(categoryName)))
                .flatMap(configElement -> configElement.getChildElements().stream())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}