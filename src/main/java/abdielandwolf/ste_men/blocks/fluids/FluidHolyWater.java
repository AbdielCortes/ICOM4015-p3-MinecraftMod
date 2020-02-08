package abdielandwolf.ste_men.blocks.fluids;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidHolyWater extends Fluid{

	public FluidHolyWater(String name, ResourceLocation still, ResourceLocation flow, ResourceLocation overlay) {
		super(name, still, flow, overlay);
		this.setUnlocalizedName(name);
		
		this.setLuminosity(7); // I like number 3.
		this.setDensity(870); // Crude oil density, I google it.
		this.setRarity(EnumRarity.RARE); // Holy water heals, it has to be rare
		this.setViscosity(1300); // A bit more viscous than water, guess that could make some sense.
		this.setTemperature(250); // Slightly cooler than water in a natural enviroment 
	}

	
}
