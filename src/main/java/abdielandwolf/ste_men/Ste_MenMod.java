package abdielandwolf.ste_men;

import abdielandwolf.ste_men.util.handler.RegistryHandler;
import abdielandwolf.ste_men.world.ModWorldGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.FluidRegistry;

// import necessary libraries

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;

import org.apache.logging.log4j.Logger;

// import local libraries
import abdielandwolf.ste_men.util.Reference;
import abdielandwolf.ste_men.proxy.CommonProxy;
import abdielandwolf.ste_men.tabs.ModCreativeTab;

// Reference 
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)

public class Ste_MenMod {
	
	public static File config;
	
	public static final CreativeTabs modTab = new ModCreativeTab("mod_creative_tab");

	@Instance
	public static Ste_MenMod instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	static {
		FluidRegistry.enableUniversalBucket();
	}
	
    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
        RegistryHandler.preInitRegistries();
    }
	
    @EventHandler
    public static void init(FMLInitializationEvent event) {}
	
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {}
	
}
