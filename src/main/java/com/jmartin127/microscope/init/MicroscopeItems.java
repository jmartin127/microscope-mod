package com.jmartin127.microscope.init;

import java.util.List;

import com.jmartin127.microscope.MicroscopeMod;
import com.jmartin127.microscope.Constants;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MicroscopeItems {

	public enum MicroscopeItem {
		MICROSCOPE_TOP,
		MICROSCOPE_BOTTOM,
		MICROSCOPE,
		MICROSCOPE_PLUG,
		MICROSCOPE_LIGHT;
		
		private Item item;
		
		private MicroscopeItem() {
			this.item = new Item()
					.setUnlocalizedName(this.name())
					.setCreativeTab(MicroscopeMod.MICROSCOPE_TAB);
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
		for (MicroscopeItem customItem : MicroscopeItem.values()) {
			GameRegistry.registerItem(customItem.getItem(), customItem.name());
		}
	}
	
	public static void registerRenders() {
		for (MicroscopeItem customItem : MicroscopeItem.values()) {
			registerRender(customItem);
		}
	}
	
	public static void registerRender(MicroscopeItem customItem) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(customItem.getItem(), 0, new ModelResourceLocation(Constants.MOD_ID + ":" + customItem.name(), "inventory"));
	}
	
}
