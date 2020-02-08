package abdielandwolf.ste_men.init;

// Import Minecraft Basics
import abdielandwolf.ste_men.items.armor.ArmorBase;
import abdielandwolf.ste_men.items.food.FoodEffectBase;
import abdielandwolf.ste_men.items.tools.*;
import abdielandwolf.ste_men.util.Reference;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;

//Import Java Basics
import java.util.ArrayList;
import java.util.List;

// Import Locals
import abdielandwolf.ste_men.items.HolyArrow;
import abdielandwolf.ste_men.items.ItemBase;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();

	//Materials
	public static final Item.ToolMaterial MATERIAL_SAPPHIRE = EnumHelper.addToolMaterial("material_sapphire", 2, 500, 8.0F, 3.0F, 12);
	public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_SAPPHIRE = EnumHelper.addArmorMaterial("armor_material_sapphire", Reference.MOD_ID +":sapphire",20, new int[]{2, 5, 7, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	
	public static final Item.ToolMaterial MATERIAL_MANA = EnumHelper.addToolMaterial("material_mana", 3, 650, 10.0F, 20.0F, 30);
	public static final Item.ToolMaterial MATERIAL_COPPER = EnumHelper.addToolMaterial("material_copper", 2, 300, 6.0F, 6.0F, 6);
	
	public static final Item.ToolMaterial MATERIAL_TUNGSTEN = EnumHelper.addToolMaterial("material_tungsten", 2, 400, 7.0F, 8.0F, 13);
	public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_PLATINUM = EnumHelper.addArmorMaterial("armor_material_platinum", Reference.MOD_ID + ":platinum_ore", 32, new int[] {1, 3, 5, 7}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F);
	
	public static final Item.ToolMaterial MATERIAL_PLATINUM = EnumHelper.addToolMaterial("material_platinum", 3, 550, 8.0F, 9.0F, 15); 
	public static final Item.ToolMaterial MATERIAL_TIN = EnumHelper.addToolMaterial("material_tin", 3, 200, 5.0F, 5.0F, 6);
	public static final Item.ToolMaterial MATERIAL_BRONZE = EnumHelper.addToolMaterial("material_bronze", 3, 200, 5.0F, 5.0F, 6);
	public static final Item.ToolMaterial MATERIAL_LEAD = EnumHelper.addToolMaterial("material_lead", 3, 200, 5.0F, 5.0F, 6);
	
	//Items
	public static final Item SAPPHIRE = new ItemBase("sapphire");
	public static final Item UNICORN_HORN = new ItemBase("unicorn_horn");
	public static final Item UNICORN_HAIR =  new ItemBase("unicorn_hair", true);
	public static final Item IRON_STICK = new ItemBase("iron_stick");
	
	// Ingot
	public static final Item COPPER_INGOT = new ItemBase("copper_ingot");
	public static final Item TUNGSTEN_INGOT = new ItemBase("tungsten_ingot");
	public static final Item TIN_INGOT = new ItemBase("tin_ingot");
	public static final Item LEAD_INGOT = new ItemBase("lead_ingot");
	public static final Item PLATINUM_INGOT = new ItemBase("platinum_ingot");
	public static final Item BRONZE_INGOT = new ItemBase("bronze_ingot");
	
	//Nugget
	public static final Item BRONZE_NUGGET = new ItemBase("bronze_nugget");
	public static final Item LEAD_NUGGET = new ItemBase("lead_nugget");
	public static final Item TIN_NUGGET = new ItemBase("tin_nugget");
	public static final Item TUNGSTEN_NUGGET = new ItemBase("tungsten_nugget");
	public static final Item COPPER_NUGGET = new ItemBase("copper_nugget");
	public static final Item PLATINUM_NUGGET = new ItemBase("platinum_nugget");
	

	//Food
	public static final Item UNICORN_MEAT = new FoodEffectBase("unicorn_meat", 16, 15F, false, new PotionEffect[] {
			new PotionEffect(MobEffects.NAUSEA, 1*60*20/2, 0, false, true),
			new PotionEffect(MobEffects.MINING_FATIGUE, 3*60*20, 2, false, true),
			new PotionEffect(MobEffects.BLINDNESS, 1*60*20/3, 0, false, true),
			new PotionEffect(MobEffects.REGENERATION, 5*60*20, 2, false, true),
			new PotionEffect(MobEffects.HEALTH_BOOST, 1*60*20, 1, false, true)});
	
	//Tools
	public static final ItemAxe SAPPHIRE_AXE = new ToolAxe("sapphire_axe", MATERIAL_SAPPHIRE, 8.0F, -3.0F);
	public static final ItemHoe SAPPHIRE_HOE = new ToolHoe("sapphire_hoe", MATERIAL_SAPPHIRE);
	public static final ItemPickaxe SAPPHIRE_PICKAXE = new ToolPickaxe("sapphire_pickaxe", MATERIAL_SAPPHIRE);
	public static final ItemSpade SAPPHIRE_SPADE = new ToolSpade("sapphire_spade", MATERIAL_SAPPHIRE);
	public static final ItemSword SAPPHIRE_SWORD = new ToolSword("sapphire_sword", MATERIAL_SAPPHIRE);
	
	public static final ItemSword COPPER_SHORTSWORD = new ToolSword("copper_shortsword", MATERIAL_COPPER);
	public static final ItemSword TUNGSTEN_BROADSWORD = new ToolSword("tungsten_broadsword", MATERIAL_TUNGSTEN);
	public static final ItemSword MANA_SWORD =  new ManaSword("mana_sword", MATERIAL_MANA);
	public static final ItemSword PLATINUM_BROADSWORD = new ToolSword("platinum_broadsword", MATERIAL_PLATINUM);
	
	// Wands
	public static final Item ACTIVATION_WAND = new ActivationWand("activation_wand");
	public static final Item THUNDER_WAND = new ThunderWand("thunder_wand");
	
	// Bows
	//Bows will later be modular, as swords, ax and others.
	public static final ItemBow IRON_BOW = new IronBow("iron_bow");
	
	// Arrows
	public static final ItemArrow HOLY_ARROW = new HolyArrow("holy_arrow");

	//Armor
	public static final Item SAPPHIRE_HELMET = new ArmorBase("sapphire_helmet", ARMOR_MATERIAL_SAPPHIRE, 1, EntityEquipmentSlot.HEAD);
	public static final Item SAPPHIRE_CHESTPLATE = new ArmorBase("sapphire_chestplate", ARMOR_MATERIAL_SAPPHIRE, 1, EntityEquipmentSlot.CHEST);
	public static final Item SAPPHIRE_LEGGINGS = new ArmorBase("sapphire_leggings", ARMOR_MATERIAL_SAPPHIRE, 2, EntityEquipmentSlot.LEGS);
	public static final Item SAPPHIRE_BOOTS = new ArmorBase("sapphire_boots", ARMOR_MATERIAL_SAPPHIRE, 1, EntityEquipmentSlot.FEET);
}
