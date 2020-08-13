package io.github.eatmyvenom.sodiumExtras.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.eatmyvenom.sodiumExtras.SodiumExtra;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PaintingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.decoration.painting.PaintingEntity;

@Mixin(PaintingEntityRenderer.class)
public class PaintingEntityRendererMixin {
    @Inject(at = @At("HEAD"), method = "render", cancellable = true)
    public void render(PaintingEntity paintingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if(!SodiumExtra.getSettings().options.renderPaintings)
            ci.cancel();
    }
}