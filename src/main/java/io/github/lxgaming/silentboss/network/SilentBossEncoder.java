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

package io.github.lxgaming.silentboss.network;

import io.github.lxgaming.silentboss.SilentBoss;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SPacketEffect;

public class SilentBossEncoder extends ChannelOutboundHandlerAdapter {
    
    private final int packetId;
    
    public SilentBossEncoder() {
        packetId = EnumConnectionState.PLAY.getPacketId(EnumPacketDirection.CLIENTBOUND, new SPacketEffect());
    }
    
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (!(msg instanceof ByteBuf)) {
            super.write(ctx, msg, promise);
            return;
        }
        
        PacketBuffer packetBuffer = new PacketBuffer(((ByteBuf) msg).retain());
        packetBuffer.markReaderIndex();
        if (packetBuffer.readVarIntFromBuffer() == getPacketId() && shouldSilence(packetBuffer.readInt())) {
            packetBuffer.release(packetBuffer.refCnt());
            return;
        }
        
        packetBuffer.resetReaderIndex();
        packetBuffer.release();
        super.write(ctx, msg, promise);
    }
    
    private boolean shouldSilence(int effectId) {
        if (effectId == 1028 && SilentBoss.getInstance().getConfig().isSilenceEnderDragon()) {
            SilentBoss.getInstance().debugMessage("Successfully suppressed EnderDragon sound.");
            return true;
        }
        
        if (effectId == 1023 && SilentBoss.getInstance().getConfig().isSilenceWither()) {
            SilentBoss.getInstance().debugMessage("Successfully suppressed Wither sound.");
            return true;
        }
        
        return false;
    }
    
    private int getPacketId() {
        return packetId;
    }
}