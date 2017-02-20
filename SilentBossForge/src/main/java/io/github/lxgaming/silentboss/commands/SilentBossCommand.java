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

package io.github.lxgaming.silentboss.commands;

import java.util.ArrayList;
import java.util.List;

import io.github.lxgaming.silentboss.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class SilentBossCommand extends CommandBase {
	
	@Override
	public String getName() {
		return "SilentBoss";
	}
	
	@Override
	public String getUsage(ICommandSender sender) {
		return "/SilentBoss";
	}
	
	@Override
	public List<String> getAliases() {
		List<String> aliases = new ArrayList<String>();
		aliases.add("SilentBoss");
		return aliases;
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}
	
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		Minecraft.getMinecraft().player.sendMessage(new TextComponentString(TextFormatting.GOLD + "===== " + TextFormatting.AQUA + "SilentBoss" + TextFormatting.GOLD + " ====="));
		Minecraft.getMinecraft().player.sendMessage(new TextComponentString(TextFormatting.GOLD + "Version - " + TextFormatting.GREEN + Reference.VERSION));
		return;
	}
}