package com.ezenac.controller;

import com.ezenac.controller.action.Action;
import com.ezenac.controller.action.IndexAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory ist = new ActionFactory();
	public static ActionFactory getInstance() {return ist;}
	
	public Action getAction(String command) {
		Action ac = null;
		
		if(command.equals("index")) ac = new IndexAction();
		
		return ac;
	}
}
