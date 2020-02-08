package abdielandwolf.ste_men.items;


import abdielandwolf.ste_men.Ste_MenMod;
import abdielandwolf.ste_men.entity.EntityHolyArrow;
import abdielandwolf.ste_men.init.ModItems;
import abdielandwolf.ste_men.util.HasModel;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class HolyArrow extends ItemArrow implements HasModel{
	
	public HolyArrow(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		
		setCreativeTab(Ste_MenMod.modTab);
		ModItems.ITEMS.add(this);
		
	}
	
	@Override
	public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) 
	{
		EntityHolyArrow entityDiamondArrow = new EntityHolyArrow(worldIn, shooter);
		return entityDiamondArrow;
	}

	@Override
	public void registerModels() {
		Ste_MenMod.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
}

