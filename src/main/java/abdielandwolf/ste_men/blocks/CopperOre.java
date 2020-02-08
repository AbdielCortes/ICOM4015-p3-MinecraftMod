package abdielandwolf.ste_men.blocks;

import net.minecraft.block.SoundType;

public class CopperOre extends BlockOreBase {

    public CopperOre(String name) {
        super(name);
        setSoundType(SoundType.STONE);
        setHardness(3);
        setResistance(15);
        setHarvestLevel("pickaxe", 1);
        setLightLevel(0);
    }
}
