package abdielandwolf.ste_men.util.handler;

import abdielandwolf.ste_men.entity.EntityHolyArrow;
import abdielandwolf.ste_men.entity.EntityUnicorn;
import abdielandwolf.ste_men.entity.render.RenderHolyArrow;
import abdielandwolf.ste_men.entity.render.RenderUnicorn;
import abdielandwolf.ste_men.init.ModBlocks;
import abdielandwolf.ste_men.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

	public static void registerCustomMeshesAndStates() {
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.HOLY_WATER_FLUID),  new ItemMeshDefinition() {
			
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation(Reference.MOD_ID + ":holy_water", "fluid");
			}
		});
		ModelLoader.setCustomStateMapper(ModBlocks.HOLY_WATER_FLUID, new StateMapperBase() {
			
			
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation(Reference.MOD_ID + ":holy_water", "fluid");
			}
		});
	}
	
    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityUnicorn.class, new IRenderFactory<EntityUnicorn>() {
            @Override
            public Render<? super EntityUnicorn> createRenderFor(RenderManager manager) {
                return new RenderUnicorn(manager);
            }
        });
        
        RenderingRegistry.registerEntityRenderingHandler(EntityHolyArrow.class, new IRenderFactory<EntityHolyArrow>() {
			@Override
			public Render<? super EntityHolyArrow> createRenderFor(RenderManager manager) {
				return new RenderHolyArrow(manager);
			}
		});
        
    }
}
