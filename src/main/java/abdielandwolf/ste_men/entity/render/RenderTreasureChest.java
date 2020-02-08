//package abdielandwolf.ste_men.entity.render;
//
//import abdielandwolf.ste_men.entity.model.ModelTreasureChest;
//import abdielandwolf.ste_men.tileentity.TileEntityTreasureChest;
//import abdielandwolf.ste_men.util.Reference;
//import net.minecraft.client.renderer.GlStateManager;
//import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
//import net.minecraft.util.ResourceLocation;
//
//public class RenderTreasureChest extends TileEntitySpecialRenderer<TileEntityTreasureChest>
//{
//	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/blocks/treasure_chest.png");
//	private final ModelTreasureChest MODEL = new ModelTreasureChest();
//
//	@Override
//	public void render(TileEntityTreasureChest te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
//	{
//		GlStateManager.enableDepth();
//        GlStateManager.depthFunc(515);
//        GlStateManager.depthMask(true);
//
//    	ModelTreasureChest model = MODEL;
//
//    	if (destroyStage >= 0)
//        {
//            this.bindTexture(DESTROY_STAGES[destroyStage]);
//            GlStateManager.matrixMode(5890);
//            GlStateManager.pushMatrix();
//            GlStateManager.scale(4.0F, 4.0F, 1.0F);
//            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
//            GlStateManager.matrixMode(5888);
//        }
//    	else this.bindTexture(TEXTURE);
//
//    	GlStateManager.pushMatrix();
//        GlStateManager.enableRescaleNormal();
//        GlStateManager.translate((float)x, (float)y + 1.0F, (float)z + 1.0F);
//        GlStateManager.scale(1.0F, -1.0F, -1.0F);
//        GlStateManager.translate(0.5F, 0.5F, 0.5F);
//        GlStateManager.translate(-0.5F, -0.5F, -0.5F);
//
//        float f = te.prevLidAngle + (te.lidAngle - te.prevLidAngle) * partialTicks;
//        f = 1.0F - f;
//        f = 1.0F - f * f * f;
//        model.chestLid.rotateAngleX = -(f * ((float)Math.PI / 2F));
//        model.renderAll();
//        GlStateManager.disableRescaleNormal();
//        GlStateManager.popMatrix();
//        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//
//        if (destroyStage >= 0)
//        {
//            GlStateManager.matrixMode(5890);
//            GlStateManager.popMatrix();
//            GlStateManager.matrixMode(5888);
//        }
//	}
//}