package abdielandwolf.ste_men.items.tools;

import abdielandwolf.ste_men.tileentity.ManaFlowerTileEntity;
import com.google.common.collect.Multimap;

import abdielandwolf.ste_men.Ste_MenMod;
import abdielandwolf.ste_men.init.ModItems;
import abdielandwolf.ste_men.util.HasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ManaSword extends ItemSword implements HasModel{

	private int mana;

	public ManaSword(String name, Item.ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setMaxStackSize(1);
        setCreativeTab(Ste_MenMod.modTab);
        ModItems.ITEMS.add(this);
        this.mana = 0;
	}

    public int getSwordMana() {
        return this.mana;
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
		Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
			multimap.removeAll(SharedMonsterAttributes.ATTACK_DAMAGE.getName());
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (this.mana / 10) - 1, 0));
		}

        return multimap;
    }

    @Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(worldIn.getTileEntity(pos) instanceof ManaFlowerTileEntity) {
			if (((ManaFlowerTileEntity) worldIn.getTileEntity(pos)).getMana() >= 10 && this.getSwordMana() < 300) {
				this.mana = this.getSwordMana() + 10;
				((ManaFlowerTileEntity) worldIn.getTileEntity(pos)).decrementMana(10);

				if (((ManaFlowerTileEntity) worldIn.getTileEntity(pos)).getMana() > 0) {
					((ManaFlowerTileEntity) worldIn.getTileEntity(pos)).decrementMana(10);
				}
			}
//			((ManaFlowerTileEntity) worldIn.getTileEntity(pos)).decrementMana(10);

			TextComponentTranslation component = new TextComponentTranslation("message.ste_men.mana", ((ManaFlowerTileEntity) worldIn.getTileEntity(pos)).getMana());
			component.getStyle().setColor(TextFormatting.BLUE);
			player.sendStatusMessage(component, false);

			return EnumActionResult.SUCCESS;
		}

    	return EnumActionResult.FAIL;
	}

	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
    	if (this.getSwordMana() > 0) {
    		this.mana -= 1;
		}
    	return false;
	}
	
    @Override
    public void registerModels() {
        Ste_MenMod.proxy.registerItemRenderer(this, 0, "inventory");
    }

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    	tooltip.add("Stored mana: " + getSwordMana());
    	super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}
