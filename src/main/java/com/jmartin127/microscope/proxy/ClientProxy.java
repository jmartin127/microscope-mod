package com.jmartin127.microscope.proxy;

import com.jmartin127.microscope.init.MicroscopeBlocks;
import com.jmartin127.microscope.init.MicroscopeItems;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenders() {
		MicroscopeItems.registerRenders();
		MicroscopeBlocks.registerRenders();
	}

}
