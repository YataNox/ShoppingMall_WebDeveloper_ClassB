package com.ezenac.controller;

import com.ezenac.controller.action.Action;
import com.ezenac.controller.action.ContractAction;
import com.ezenac.controller.action.IndexAction;
import com.ezenac.controller.action.JoinFormAction;
import com.ezenac.controller.action.LoginAction;
import com.ezenac.controller.action.LoginFormAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory ist = new ActionFactory();
	public static ActionFactory getInstance() {return ist;}
	
	public Action getAction(String command) {
		Action ac = null;
		
		if(command.equals("index")) ac = new IndexAction();
		else if(command.equals("loginForm")) ac = new LoginFormAction();
		else if(command.equals("login")) ac = new LoginAction();
		else if(command.equals("contract")) ac = new ContractAction();
		else if(command.equals("joinForm")) ac = new JoinFormAction();
		return ac;
	}
}
