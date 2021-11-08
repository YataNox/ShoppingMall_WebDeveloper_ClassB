package com.ezenac.controller;

import com.ezenac.controller.action.Action;
import com.ezenac.controller.action.ContractAction;
import com.ezenac.controller.action.FindIdPwdAction;
import com.ezenac.controller.action.FindZipNumAction;
import com.ezenac.controller.action.IdCheckFormAction;
import com.ezenac.controller.action.IndexAction;
import com.ezenac.controller.action.JoinAction;
import com.ezenac.controller.action.JoinFormAction;
import com.ezenac.controller.action.LoginAction;
import com.ezenac.controller.action.LoginFormAction;
import com.ezenac.controller.action.LogoutAction;
import com.ezenac.controller.action.MEditFormAction;
import com.ezenac.controller.action.MemberUpdateAction;

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
		else if(command.equals("idCheckForm")) ac = new IdCheckFormAction();
		else if(command.equals("findZipNum")) ac = new FindZipNumAction();
		else if(command.equals("join")) ac = new JoinAction();
		else if(command.equals("logout")) ac = new LogoutAction();
		else if(command.equals("mEditForm")) ac = new MEditFormAction();
		else if(command.equals("memberUpdate")) ac = new MemberUpdateAction();
		else if(command.equals("findIdPwd")) ac = new FindIdPwdAction();
		return ac;
	}
}
