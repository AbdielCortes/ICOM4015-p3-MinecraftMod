package abdielandwolf.ste_men.items.armor;

import abdielandwolf.ste_men.Ste_MenMod;
import abdielandwolf.ste_men.init.ModItems;
import abdielandwolf.ste_men.util.HasModel;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorBase extends ItemArmor implements HasModel {

    public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Ste_MenMod.modTab);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Ste_MenMod.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
