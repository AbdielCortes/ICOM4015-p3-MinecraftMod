package abdielandwolf.ste_men.items;

import abdielandwolf.ste_men.Ste_MenMod;
import abdielandwolf.ste_men.init.ModItems;
import abdielandwolf.ste_men.util.HasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBase extends Item implements HasModel {

	private boolean enchanted;

	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Ste_MenMod.modTab);
		ModItems.ITEMS.add(this);
		this.enchanted = false;
	}

	public ItemBase(String name, boolean enchanted) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Ste_MenMod.modTab);
		ModItems.ITEMS.add(this);
		this.enchanted = enchanted;
	}
	
	@Override
	public void registerModels() {
		Ste_MenMod.proxy.registerItemRenderer(this, 0, "inventory");
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return enchanted;
	}
}
