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
import io.github.lxgaming.silentboss.util.LogManager;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import net.minecraft.network.PacketBuffer;

public class SilentBossPacketHandler extends ChannelDuplexHandler {
	
	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
		ByteBuf byteBuf = null;
		
		try {
			if (!ByteBuf.class.isAssignableFrom(msg.getClass())) {
				super.write(ctx, msg, promise);
				return;
			}
			
			byteBuf = ((ByteBuf) msg).copy();
			PacketBuffer packetBuffer = new PacketBuffer(byteBuf);
			int packetId = packetBuffer.readVarIntFromBuffer();
			
			if (packetId != 33) {
				super.write(ctx, msg, promise);
				return;
			}
			
			int effectId = packetBuffer.readInt();
			if (effectId == 1028 && SilentBoss.getInstance().getConfiguration().getConfig().get("SilenceEnderDragon").getAsBoolean()) {
				process("EnderDragon");
				return;
			}
			
			if (effectId == 1023 && SilentBoss.getInstance().getConfiguration().getConfig().get("SilenceWither").getAsBoolean()) {
				process("Wither");
				return;
			}
			super.write(ctx, msg, promise);
		} catch (Exception ex) {
			LogManager.error("Exception in SilentBossPacketHandler!");
			ex.printStackTrace();
		} finally {
			if (byteBuf != null) {
				byteBuf.release();
				byteBuf = null;
			}
		}
		return;
	}
	
	private void process(String boss) {
		if (SilentBoss.getInstance().getConfiguration().getConfig().get("Debug").getAsBoolean()) {
			LogManager.info("Successfully suppressed '" + boss + "' sound.");
		}
	}
}
