package abdielandwolf.ste_men.items.tools;

import abdielandwolf.ste_men.entity.model.ModelLightningSphere;
import abdielandwolf.ste_men.init.ModItems;
import abdielandwolf.ste_men.items.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ThunderWand extends ItemBase {
	public ThunderWand(String name) {
		super(name);
        this.maxStackSize = 1;
        this.setMaxDamage(64);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		Vec3d look = playerIn.getLookVec();
		ModelLightningSphere lightningShere = new ModelLightningSphere(worldIn, 1D, 1D, 1D);
		lightningShere.setPosition(playerIn.posX + look.x * 1.5D, playerIn.posY + look.y * 1.5D, playerIn.posZ + look.z * 1.5D);
		lightningShere.motionX = look.x * 2.0D;
		lightningShere.motionY = look.y * 2.0D;
		lightningShere.motionZ = look.z * 2.0D;
		lightningShere.setGlowing(true);
		playerIn.getCooldownTracker().setCooldown(ModItems.THUNDER_WAND, 1);;
		worldIn.spawnEntity(lightningShere);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
	}
}






