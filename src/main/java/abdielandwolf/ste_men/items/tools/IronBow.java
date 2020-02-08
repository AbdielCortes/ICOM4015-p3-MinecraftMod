package abdielandwolf.ste_men.items.tools;

import javax.annotation.Nullable;

import abdielandwolf.ste_men.Ste_MenMod;
import abdielandwolf.ste_men.init.ModItems;
import abdielandwolf.ste_men.util.HasModel;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class IronBow extends ItemBow implements HasModel{

	public IronBow(String name) {
	setUnlocalizedName(name);
	setRegistryName(name);
	setMaxStackSize(1);
    setCreativeTab(Ste_MenMod.modTab);
    ModItems.ITEMS.add(this);
	
    this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter() {
		
		@SideOnly(Side.CLIENT)
		public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
			if (entityIn == null) return 0.0F;
			else return entityIn.getActiveItemStack().getItem() != ModItems.IRON_BOW ? 0.0F: (float) (stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
					
		}
	});
    this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter() {
		
		@SideOnly(Side.CLIENT)
		public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
			return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
		}
	});
    ModItems.ITEMS.add(this);
	}

	@Override
    public int getItemEnchantability() {
    	return 11;
    }
	
    @Override
    protected boolean isArrow(ItemStack stack) {
    	if (stack.getItem() == ModItems.IRON_BOW) return true;
    	return false;
    }


    @Override
    public void registerModels() {
        Ste_MenMod.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
