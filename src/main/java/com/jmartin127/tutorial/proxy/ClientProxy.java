package com.jmartin127.tutorial.proxy;

import com.jmartin127.tutorial.init.TutorialItems;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenders() {
		TutorialItems.registerRenders();
	}

}
