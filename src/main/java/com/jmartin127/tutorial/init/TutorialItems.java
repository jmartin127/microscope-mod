package com.jmartin127.tutorial.init;

import java.util.List;

import com.jmartin127.tutorial.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialItems {
	
	private enum CustomItem {
		MICROSCOPE_TOP,
		MICROSCOPE_BOTTOM,
		MICROSCOPE,
		MICROSCOPE_PLUG,
		MICROSCOPE_LIGHT;
		
		private Item item;
		
		private CustomItem() {
			this.item = new Item().setUnlocalizedName(this.name());
		}
		
		public Item getItem() {
			return item;
		}
	}

	public static List<Item> ITEMS;
	
	public static void init() {
		// not needed at this time
	}
	
	public static void register() {
		for (CustomItem customItem : CustomItem.values()) {
			GameRegistry.registerItem(customItem.getItem(), customItem.name());
		}
	}
	
	public static void registerRenders() {
		for (CustomItem customItem : CustomItem.values()) {
			registerRender(customItem);
		}
	}
	
	public static void registerRender(CustomItem customItem) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(customItem.getItem(), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + customItem.name(), "inventory"));
	}
	
}
