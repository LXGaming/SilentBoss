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
	public String getCommandName() {
		return "SilentBoss";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/SilentBoss";
	}
	
	@Override
	public List<String> getCommandAliases() {
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
		Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString(TextFormatting.GOLD + "===== " + TextFormatting.AQUA + "SilentBoss" + TextFormatting.GOLD + " ====="));
		Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString(TextFormatting.GOLD + "Version - " + TextFormatting.GREEN + Reference.VERSION));
		return;
	}
}