package com.jmartin127.tutorial.init;

import com.jmartin127.tutorial.Reference;
import com.jmartin127.tutorial.MicroscopeMod;
import com.jmartin127.tutorial.blocks.BlockTest;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialBlocks {
	
	private enum CustomBlock {
		microscope_ore,
		microscope_slide,
		present,
		present2;
		
		private Block block;
		
		private CustomBlock() {
			this.block =  new Block(Material.cloth)
					.setUnlocalizedName(this.name())
					.setCreativeTab(MicroscopeMod.MICROSCOPE_TAB);
		}
		
		public Block getBlock() {
			return block;
		}
	}
	
	public static void init() {
		// not needed at this time
	}
	
	public static void register() {
		for (CustomBlock block : CustomBlock.values()) {
			GameRegistry.registerBlock(block.getBlock(), block.name());
		}
	}
	
	public static void registerRenders() {
		for (CustomBlock block : CustomBlock.values()) {
			registerRender(block);
		}
	}
	
	public static void registerRender(CustomBlock customBlock) {
		Item item = Item.getItemFromBlock(customBlock.getBlock());
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}

}
