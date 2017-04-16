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
import io.github.lxgaming.silentboss.util.LogHelper;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

public class SilentBossPacketHandler extends ChannelDuplexHandler {
	
	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
		ByteBuf byteBuf = null;
		
		try {
			if (ByteBuf.class.isAssignableFrom(msg.getClass())) {
				byteBuf = ((ByteBuf) msg).copy();
				if (readVarInt(byteBuf) == 33 && shouldSilence(byteBuf.readInt())) {
					return;
				}
			}
			super.write(ctx, msg, promise);
		} catch (Exception ex) {
			LogHelper.error("Exception in SilentBossPacketHandler!");
			ex.printStackTrace();
		} finally {
			if (byteBuf != null) {
				byteBuf.release();
				byteBuf = null;
			}
		}
		return;
	}
	
	private boolean shouldSilence(int effectId) {
		if (effectId == 1028 && SilentBoss.getInstance().getConfig().isSilenceEnderDragon()) {
			SilentBoss.getInstance().debugMessage("Successfully suppressed 'EnderDragon' sound.");
			return true;
		}
		
		if (effectId == 1023 && SilentBoss.getInstance().getConfig().isSilenceWither()) {
			SilentBoss.getInstance().debugMessage("Successfully suppressed 'Wither' sound.");
			return true;
		}
		return false;
	}
	
	private int readVarInt(ByteBuf byteBuf) {
		int out = 0;
		int bytes = 0;
		
		while (true) {
			byte read = byteBuf.readByte();
			out |= (read & 127) << (bytes++ * 7);
			
			if (bytes > 5) {
				return 0;
			}
			
			if ((read & 128) != 128) {
				break;
			}
		}
		return out;
	}
}