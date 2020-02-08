package abdielandwolf.ste_men.tabs.guis;

import abdielandwolf.ste_men.blocks.container.ContainerTreasureChest;
import abdielandwolf.ste_men.tileentity.TileEntityTreasureChest;
import abdielandwolf.ste_men.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiTreasureChest extends GuiContainer {
	
	private static final ResourceLocation GUI_CHEST = new ResourceLocation(Reference.MOD_ID + ":textures/guis/treasure_chest.png");
	private final InventoryPlayer playerInventory;
	private final TileEntityTreasureChest thing;
	
	public GuiTreasureChest(InventoryPlayer playerInventory, TileEntityTreasureChest chestInventory, EntityPlayer player) {
		super(new ContainerTreasureChest(playerInventory, chestInventory, player));
		this.playerInventory = playerInventory;
		this.thing = chestInventory;
		
		this.xSize = 179;
		this.ySize = 256;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(this.thing.getDisplayName().getUnformattedText(), 8, 6, 16086784);
		this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 16086784);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_CHEST);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}
