package io.github.eatmyvenom.sodiumExtras.mixin;

import com.mojang.authlib.GameProfile;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.network.ClientConnection;
import net.minecraft.network.NetworkThreadUtils;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.c2s.play.TeleportConfirmC2SPacket;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.thread.ThreadExecutor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.player.PlayerEntity;

@Mixin(ClientPlayNetworkHandler.class)
public class looknt_mixin extends ClientPlayNetworkHandler {
    @Shadow
    private MinecraftClient client;

    @Shadow
    private ClientConnection connection;

    @Shadow
    private boolean positionLookSetup;

    public looknt_mixin(MinecraftClient client, Screen screen, ClientConnection connection, GameProfile profile) {
        super(client, screen, connection, profile);
        // TODO Auto-generated constructor stub
        
    }



    @Inject(at = @At("HEAD"), method = "onPlayerPositionLook")
    public void looknt(PlayerPositionLookS2CPacket packet, CallbackInfo ci)
    {
        NetworkThreadUtils.forceMainThread(packet, this, (ThreadExecutor)this.client);
        PlayerEntity playerEntity = this.client.player;
        Vec3d vec3d = playerEntity.getVelocity();
        boolean bl = packet.getFlags().contains(PlayerPositionLookS2CPacket.Flag.X);
        boolean bl2 = packet.getFlags().contains(PlayerPositionLookS2CPacket.Flag.Y);
        boolean bl3 = packet.getFlags().contains(PlayerPositionLookS2CPacket.Flag.Z);
        double f;
        double g;
        if (bl) {
            f = vec3d.getX();
            g = playerEntity.getX() + packet.getX();
            playerEntity.lastRenderX += packet.getX();
        } else {
            f = 0.0D;
            g = packet.getX();
            playerEntity.lastRenderX = g;
        }

        double j;
        double k;
        if (bl2) {
            j = vec3d.getY();
            k = playerEntity.getY() + packet.getY();
            playerEntity.lastRenderY += packet.getY();
        } else {
            j = 0.0D;
            k = packet.getY();
            playerEntity.lastRenderY = k;
        }

        double n;
        double o;
        if (bl3) {
            n = vec3d.getZ();
            o = playerEntity.getZ() + packet.getZ();
            playerEntity.lastRenderZ += packet.getZ();
        } else {
            n = 0.0D;
            o = packet.getZ();
            playerEntity.lastRenderZ = o;
        }

        playerEntity.setPos(g, k, o);
        playerEntity.prevX = g;
        playerEntity.prevY = k;
        playerEntity.prevZ = o;
        playerEntity.setVelocity(f, j, n);
        float p = playerEntity.pitch;
        float q = playerEntity.yaw;

        playerEntity.updatePositionAndAngles(g, k, o, p, q);
        this.connection.send(new TeleportConfirmC2SPacket(packet.getTeleportId()));
        this.connection.send(new PlayerMoveC2SPacket.Both(playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), playerEntity.yaw, playerEntity.pitch, false));
        if (!this.positionLookSetup) {
            this.positionLookSetup = true;
            this.client.openScreen((Screen)null);
        }
    }


    
}// Player382 lost connection: Internal Exception: java.lang.ClassCastException: class net.minecraft.server.network.ServerPlayNetworkHandler cannot be cast to class net.minecraft.network.listener.ClientPlayPacketListener (net.minecraft.server.network.ServerPlayNetworkHandler and net.minecraft.network.listener.ClientPlayPacketListener are in unnamed module of loader net.fabricmc.loader.launch.knot.KnotClassLoader @1f760b47)