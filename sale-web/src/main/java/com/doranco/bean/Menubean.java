package com.doranco.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.component.menu.Menu;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
@SessionScoped
public class Menubean {

	public String gotoStore () {
		return "/pages/store.xhtml?faces-redirect=true";
	}
	
}
