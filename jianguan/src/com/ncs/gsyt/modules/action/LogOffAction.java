package com.ncs.gsyt.modules.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ncs.gsyt.core.base.action.BaseAction;

@Controller
@Namespace("/admin")
public class LogOffAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	@Action(value = "/logOff", results = {@Result(name=SUCCESS,location="/admin/index.jsp")})
	@Override
	public String execute() {
		httpServletRequest.getSession(true).removeAttribute("LoginBean");
		return SUCCESS;
	}
}
