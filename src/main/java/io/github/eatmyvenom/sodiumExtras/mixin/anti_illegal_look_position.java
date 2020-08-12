package io.github.eatmyvenom.sodiumExtras.mixin;

import java.io.IOException;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.PacketByteBuf;

@Mixin({PlayerMoveC2SPacket.PositionOnly.class})
public class anti_illegal_look_position extends PlayerMoveC2SPacket
{

    @Inject(method = "write", at = @At("HEAD"))
    public void writeFix(PacketByteBuf buf, CallbackInfo c) throws IOException {
        if (Math.abs(this.x) > 3.2E7 || Math.abs(this.y) > 3.2E7 || Math.abs(this.z) > 3.2E7) throw new IOException("Invalid position");
    }

    @Override
    public boolean isWritingErrorSkippable() {
        return true;
    }
}