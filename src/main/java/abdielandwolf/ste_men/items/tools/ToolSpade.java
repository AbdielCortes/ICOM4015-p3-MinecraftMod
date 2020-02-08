package abdielandwolf.ste_men.items.tools;

import abdielandwolf.ste_men.Ste_MenMod;
import abdielandwolf.ste_men.init.ModItems;
import abdielandwolf.ste_men.util.HasModel;
import net.minecraft.item.ItemSpade;

public class ToolSpade extends ItemSpade implements HasModel {
    public ToolSpade(String name, ToolMaterial material) {
        super(material);
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
