package abdielandwolf.ste_men.init;

import abdielandwolf.ste_men.blocks.fluids.FluidHolyWater;
import abdielandwolf.ste_men.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidInit {
	public static final Fluid HOLY_WATER_FLUID = 
			new FluidHolyWater("holy_water", 
			new ResourceLocation(Reference.MOD_ID + ":blocks/holy_water_still"),
			new ResourceLocation(Reference.MOD_ID + ":blocks/holy_water_flow"),
			new ResourceLocation(Reference.MOD_ID + ":blocks/holy_water_overlay"));

	

	public static void registerFluids() {
		registerFluid(HOLY_WATER_FLUID);
	}
	
	public static void registerFluid(Fluid fluid) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
		
	}
}
