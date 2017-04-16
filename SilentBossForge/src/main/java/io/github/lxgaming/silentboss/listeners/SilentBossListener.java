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

package io.github.lxgaming.silentboss.listeners;

import io.github.lxgaming.silentboss.SilentBoss;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ServerConnectionFromClientEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SilentBossListener {
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onPlaySoundEvent(PlaySoundEvent event) {
		if (event.getName() == null) {
			return;
		}
		
		if (event.getName().equals("entity.enderdragon.death") && SilentBoss.getInstance().getConfig().isSilenceEnderDragon()) {
			event.setResultSound(null);
			SilentBoss.getInstance().debugMessage("Successfully suppressed 'EnderDragon' sound.");
		}
		
		if (event.getName().equals("entity.wither.spawn") && SilentBoss.getInstance().getConfig().isSilenceEnderDragon()) {
			event.setResultSound(null);
			SilentBoss.getInstance().debugMessage("Successfully suppressed 'Wither' sound.");
		}
	}
	
	@SubscribeEvent
	@SideOnly(Side.SERVER)
	public void onServerConnectionFromClient(ServerConnectionFromClientEvent event) {
		if (event.getManager().channel().pipeline().get("silentboss:encoder") == null) {
			event.getManager().channel().pipeline().addBefore("encoder", "silentboss:encoder", new SilentBossPacketHandler());
			SilentBoss.getInstance().debugMessage("Successfully added channel.");
			return;
		}
		SilentBoss.getInstance().debugMessage("Failed to add channel!");
	}
}