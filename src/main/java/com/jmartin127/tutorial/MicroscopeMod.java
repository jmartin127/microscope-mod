package com.jmartin127.tutorial;

import com.jmartin127.tutorial.init.TutorialBlocks;
import com.jmartin127.tutorial.init.TutorialItems;
import com.jmartin127.tutorial.init.TutorialItems.MicroscopeItem;
import com.jmartin127.tutorial.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MicroscopeMod {
	
	public static CreativeTabs MICROSCOPE_TAB = new CreativeTabs("microscopeTab") {

		@Override
		public Item getTabIconItem() {
			return MicroscopeItem.MICROSCOPE.getItem();
		}
		
		@Override
		public String getTranslatedTabLabel() {
			return "Awesome microscope stuff!";
		}

	};
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		TutorialBlocks.init();
		TutorialBlocks.register();
		TutorialItems.init();
		TutorialItems.register();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenders();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
}
