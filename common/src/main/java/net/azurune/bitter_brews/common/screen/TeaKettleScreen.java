package net.azurune.bitter_brews.common.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.azurune.bitter_brews.BitterBrewsConstants;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;

public class TeaKettleScreen extends AbstractContainerScreen<TeaKettleMenu> {
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(BitterBrewsConstants.MOD_ID, "textures/gui/tea_kettle.png");

    public TeaKettleScreen(TeaKettleMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
        this.titleLabelX = 10000;
        this.imageWidth = 176;
        this.imageHeight = 192;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
        renderProgressArrow(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if (menu.isCrafting()) {
            guiGraphics.blit(GUI_TEXTURE, x + 176, y + 45, 226, 0, 46, menu.getScaledProgress());
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void slotClicked(Slot slot, int i, int j, ClickType clickType) {
        if (clickType == ClickType.THROW) { // Hardcoded for now TODO: fix fabric
            clickType = ClickType.PICKUP;
        }
        super.slotClicked(slot, i, j, clickType);
    }
}
