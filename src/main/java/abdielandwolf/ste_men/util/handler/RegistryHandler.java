package abdielandwolf.ste_men.util.handler;

import abdielandwolf.ste_men.Ste_MenMod;
//import abdielandwolf.ste_men.entity.render.RenderTreasureChest;
import abdielandwolf.ste_men.init.FluidInit;
import abdielandwolf.ste_men.init.ModBlocks;
import abdielandwolf.ste_men.init.ModEntities;
import abdielandwolf.ste_men.init.ModItems;
import abdielandwolf.ste_men.tileentity.TileEntityTreasureChest;
import abdielandwolf.ste_men.util.HasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
		//TileEntityHandler.registerTileEntities();
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTreasureChest.class, new RenderTreasureChest());
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {		
		//Ste_MenMod.proxy.registerModel(Item.getItemFromBlock(ModBlocks.TREASURE_CHEST), 0);
		
		for(Item item : ModItems.ITEMS)	{
			if(item instanceof HasModel) {
				((HasModel)item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS)
		{
			if(block instanceof HasModel)
			{
				((HasModel)block).registerModels();
			}
		}
	}
	
	public static void initRegistries(FMLInitializationEvent event)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Ste_MenMod.instance, new GuiHandler());	
	}	
	
//	
//	@SubscribeEvent
//	public static void onModelRegister(ModelRegistryEvent event) {
//		Ste_MenMod.proxy.registerItemRenderer(Item.getItemFromBlock(ModBlocks.TREASURE_CHEST), 0, "inventory");
//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTreasureChest.class, new RenderTreasureChest());
//		RenderHandler.registerCustomMeshesAndStates();
//		RenderHandler.registerEntityRenders();
//		for(Item item: ModItems.ITEMS) {
//			if(item instanceof HasModel) {
//				((HasModel)item).registerModels();
//			}
//		}
//		
//		for(Block block: ModBlocks.BLOCKS) {
//			if(block instanceof HasModel) {
//				((HasModel)block).registerModels();
//			}
//		}
//	}

	public static void preInitRegistries() {
		// DO NOT CHANGE!!! Fluids MUST go first, don't ask questions, just believe me, have some faith.
		FluidInit.registerFluids();
		RenderHandler.registerCustomMeshesAndStates();
		
		ModEntities.registerEntities();
		RenderHandler.registerEntityRenders();
	}
	
}
