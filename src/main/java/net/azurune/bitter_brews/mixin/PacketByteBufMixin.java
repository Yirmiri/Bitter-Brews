package net.azurune.bitter_brews.mixin;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PacketByteBuf.class)
public class PacketByteBufMixin {

    @Inject(method = "writeIdentifier", at = @At("HEAD"), cancellable = true)
    public void writeResourceLocation(Identifier id, CallbackInfoReturnable<PacketByteBuf> cir) {
        if (id == null) cir.setReturnValue((PacketByteBuf) ((Object) this));
    }
}
