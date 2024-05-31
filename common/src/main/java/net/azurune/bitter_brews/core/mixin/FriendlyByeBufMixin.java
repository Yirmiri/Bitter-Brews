package net.azurune.bitter_brews.core.mixin;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FriendlyByteBuf.class)
public class FriendlyByeBufMixin {

    @Inject(method = "writeResourceLocation", at = @At("HEAD"), cancellable = true)
    public void writeResourceLocation(ResourceLocation resourceLocation, CallbackInfoReturnable<FriendlyByteBuf> cir) {
        if (resourceLocation == null)
            cir.setReturnValue((FriendlyByteBuf) ((Object) this));
    }

}
