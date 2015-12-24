package com.jmartin127.tutorial.init;

import com.jmartin127.tutorial.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialItems {

	public static Item TEST_ITEM;
	
	public static void init() {
		TEST_ITEM = new Item().setUnlocalizedName("TEST_ITEM");
	}
	
	public static void register() {
		GameRegistry.registerItem(TEST_ITEM, TEST_ITEM.getUnlocalizedName().substring(5)); // "tile.TEST_ITEM"
	}
	
	public static void registerRenders() {
		registerRender(TEST_ITEM);
	}
	
	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
}
