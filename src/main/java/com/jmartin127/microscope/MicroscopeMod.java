package com.jmartin127.microscope;

import com.jmartin127.microscope.init.MicroscopeBlocks;
import com.jmartin127.microscope.init.MicroscopeItems;
import com.jmartin127.microscope.init.MicroscopeItems.MicroscopeItem;
import com.jmartin127.microscope.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.VERSION)
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
	
	@SidedProxy(clientSide = Constants.CLIENT_PROXY_CLASS, serverSide = Constants.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MicroscopeBlocks.init();
		MicroscopeBlocks.register();
		MicroscopeItems.init();
		MicroscopeItems.register();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenders();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
}
