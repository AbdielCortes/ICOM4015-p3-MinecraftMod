package abdielandwolf.ste_men.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;


public class ClientProxy extends CommonProxy{
	public void registerItemRenderer(Item item, int meta, String id){
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
}
 