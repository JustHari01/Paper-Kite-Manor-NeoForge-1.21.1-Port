package com.kazi_cat.papercraft_magic_decoration.client.gui;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import com.kazi_cat.papercraft_magic_decoration.inventory.container.CopperBartenderContainer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CopperBartenderScreen extends AbstractContainerScreen<CopperBartenderContainer> {
    public static final ResourceLocation backgroundImage = PaperKiteManor.modLoc("textures/screens/copper_bartender.png");
    public static final ResourceLocation clockworkImage = PaperKiteManor.modLoc("textures/screens/atlas/clockwork.png");
    ImageButton clockwork;

    public CopperBartenderScreen(CopperBartenderContainer container, Inventory inventory, Component title) {
        super(container, inventory, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float v, int i, int i1) {
        renderBackground(graphics, i, i1, v);
        graphics.blit(backgroundImage, this.leftPos, this.topPos, 0, 0, 176, 166, 176, 166);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float pt) {
        super.render(graphics, mouseX, mouseY, pt);
        this.renderTooltip(graphics, mouseX, mouseY);
    }

    @Override
    public void init() {
        super.init();
        clockwork = new ImageButton(this.leftPos + 72, this.topPos + 48, 32, 32, new WidgetSprites(clockworkImage, clockworkImage), e -> {
            if (this.minecraft != null && this.minecraft.gameMode != null) {
                this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, 0);
            }
        }) {
            @Override
            public void renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
                graphics.blit(clockworkImage, this.getX(), this.getY(), 0.0F,
                        this.isHoveredOrFocused() ? 32.0F : 0.0F, 32, 32, 32, 64);
            }
        };
        this.addRenderableWidget(clockwork);
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {}
}
