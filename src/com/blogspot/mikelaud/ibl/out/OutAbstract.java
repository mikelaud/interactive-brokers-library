package com.blogspot.mikelaud.ibl.out;

import com.blogspot.mikelaud.ibl.router.Router;

public class OutAbstract implements Out {

	private Router mRouter;
	
	@Override
	public Router getRouter() {
		return mRouter;
	}
	
	public OutAbstract(Router aRouter) {
		mRouter = aRouter;
	}
	
}
