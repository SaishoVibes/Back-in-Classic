
package net.backinclassic.gui;

import net.backinclassic.BackInClassicMod;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class StructureAdvancerGUIGuiWindow extends ContainerScreen<StructureAdvancerGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = StructureAdvancerGUIGui.guistate;
	TextFieldWidget AddStructure;
	public StructureAdvancerGUIGuiWindow(StructureAdvancerGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("structure_advancer_tool:textures/structure_advancer_gui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		AddStructure.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (AddStructure.isFocused())
			return AddStructure.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		AddStructure.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		AddStructure = new TextFieldWidget(this.font, this.guiLeft + 26, this.guiTop + 24, 120, 20, new StringTextComponent("Structure Name Here")) {
			{
				setSuggestion("Structure Name Here");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Structure Name Here");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Structure Name Here");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:AddStructure", AddStructure);
		AddStructure.setMaxStringLength(32767);
		this.children.add(this.AddStructure);
		this.addButton(new Button(this.guiLeft + 54, this.guiTop + 75, 65, 20, new StringTextComponent("Generate"), e -> {
			if (true) {
				BackInClassicMod.PACKET_HANDLER.sendToServer(new StructureAdvancerGUIGui.ButtonPressedMessage(0, x, y, z));
				StructureAdvancerGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 48, this.guiTop + 49, 75, 20, new StringTextComponent("Apply Name"), e -> {
			if (true) {
				BackInClassicMod.PACKET_HANDLER.sendToServer(new StructureAdvancerGUIGui.ButtonPressedMessage(1, x, y, z));
				StructureAdvancerGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
