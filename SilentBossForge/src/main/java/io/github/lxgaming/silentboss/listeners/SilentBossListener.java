package io.github.lxgaming.silentboss.listeners;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ServerConnectionFromClientEvent;

public class SilentBossListener {
	
	@SubscribeEvent
	public void onServerConnectionFromClient(ServerConnectionFromClientEvent event) {
		event.getManager().channel().pipeline().addBefore("encoder", "silentboss_encoder", new SilentBossPacketHandler());
	}
}