package com.doranco.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LogginBean {

	
	public String connect () {
		return "/menu/menu.xhtml?faces-redirect=true";
	}
}
