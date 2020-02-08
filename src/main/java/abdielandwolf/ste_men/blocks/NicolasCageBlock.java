package abdielandwolf.ste_men.blocks;


import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class NicolasCageBlock extends BlockBase{

	public NicolasCageBlock(String name, Material material) {
		super(name, material);
		setUnlocalizedName(name);
		setSoundType(SoundType.SLIME);
		setHardness(64);
		setHarvestLevel("shovel", 0);
		setLightLevel(1);
		
	}

}
 