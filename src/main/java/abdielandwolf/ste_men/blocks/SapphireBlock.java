package abdielandwolf.ste_men.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SapphireBlock extends BlockBase {

    public SapphireBlock(String name, Material material) {
        super(name, material);
        setSoundType(SoundType.METAL);
        setHardness(5);
        setResistance(30);
        setHarvestLevel("pickaxe", 2);
        setLightLevel(0);
    }
}
