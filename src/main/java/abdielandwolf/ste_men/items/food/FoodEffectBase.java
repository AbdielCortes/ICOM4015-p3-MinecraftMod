package abdielandwolf.ste_men.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FoodEffectBase extends FoodBase {

    public PotionEffect[] potionEffects;

    public FoodEffectBase(String name, int amount, float saturation, boolean isWolfFood, PotionEffect effect) {
        super(name, amount, saturation, isWolfFood);
        setAlwaysEdible();
        this.potionEffects = new PotionEffect[] {effect};
    }

    public FoodEffectBase(String name, int amount, float saturation, boolean isWolfFood, PotionEffect[] potionEffects) {
        super(name, amount, saturation, isWolfFood);
        setAlwaysEdible();
        this.potionEffects = potionEffects;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        if(!worldIn.isRemote) {
            for(int i = 0; i < this.potionEffects.length; i++) {
                player.addPotionEffect(new PotionEffect(this.potionEffects[i].getPotion(), this.potionEffects[i].getDuration(), this.potionEffects[i].getAmplifier(), this.potionEffects[i].getIsAmbient(), this.potionEffects[i].doesShowParticles()));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
