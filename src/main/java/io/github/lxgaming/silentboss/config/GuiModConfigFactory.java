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

import io.github.lxgaming.silentboss.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

import java.util.Set;

public class GuiModConfigFactory implements IModGuiFactory {
    
    @Override
    public void initialize(Minecraft minecraftInstance) {
    }
    
    /**
     * Used by Forge 1.11.x - 1.12.x
     */
    public boolean hasConfigGui() {
        return true;
    }
    
    /**
     * Used by Forge 1.11.x - 1.12.x
     */
    public GuiScreen createConfigGui(GuiScreen parentScreen) {
        return new GuiModConfig(parentScreen, Reference.MOD_ID, Reference.MOD_NAME);
    }
    
    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() {
        return GuiModConfig.class;
    }
    
    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }
    
    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
        return null;
    }
}