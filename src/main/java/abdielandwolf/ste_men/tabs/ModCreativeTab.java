package abdielandwolf.ste_men.tabs;

import abdielandwolf.ste_men.init.ModBlocks;
import abdielandwolf.ste_men.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModCreativeTab extends CreativeTabs {

	public ModCreativeTab(String label) {
		super("mod_creative_tab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModBlocks.MANA_FLOWER);
	}
}
