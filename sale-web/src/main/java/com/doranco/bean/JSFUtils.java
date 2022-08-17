package com.doranco.bean;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.shaded.commons.io.FilenameUtils;

/**
 * 
 * @author Elliot Sharon This class proposes the utilities class for JSF
 *
 */

public class JSFUtils {

	public static SelectOneMenu createSelectOneMenu(String width,boolean disable,ValueExpression valueExpression) {
		SelectOneMenu selectOneMenu = new SelectOneMenu();
		selectOneMenu.setStyle(width);
		selectOneMenu.setDisabled(disable);
		selectOneMenu.setValueExpression("value", valueExpression);
        return selectOneMenu;
	}
	
	public static SelectOneMenu createSelectOneMenuWithoutBinding(String width,boolean disable) {
		SelectOneMenu selectOneMenu = new SelectOneMenu();
		selectOneMenu.setStyle(width);
		selectOneMenu.setDisabled(disable);
        return selectOneMenu;
	}

	public static HtmlOutputLabel createLabel(String lbl, String codeColor) {
		HtmlOutputLabel lblD = new HtmlOutputLabel();
		lblD.setValue(lbl);
		lblD.setStyle(codeColor);
	
		return lblD;
	}
	
	public static InputText createInputText( String width,String inputId) {
		InputText ipt = new InputText();
		ipt.setStyle(width);
		ipt.setId(inputId);
		return ipt;
	}

	public static CommandButton createButton(String lbl) {
		CommandButton btn = new CommandButton();
		btn.setValue(lbl);
		return btn;

	}

	/**
	 * 
	 * @param columns
	 * @return Panel grid
	 */
	public static HtmlPanelGrid createPanelgrid(int columns) {
		HtmlPanelGrid grid = new HtmlPanelGrid();
		grid.setColumns(columns);
		return grid;
	}

	/**
	 * 
	 * @param cleObjet
	 * @return Object By Key
	 */
	public static Object getSessionMap(String key) {

		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);

	}

	/**
	 * 
	 * @return the @IP for Remote Client
	 */
	public static String getRemoteIPClient() {

		HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();

		String ip = httpServletRequest.getRemoteAddr();

		return ip;
	}

	/**
	 * 
	 * @return the host name for client
	 */
	public static String getRemoteHostClient() {

		HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();

		String hostName = httpServletRequest.getRemoteHost().toString();

		return hostName;
	}

	public static String getRemoteNameClient() {

		HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();

		String hostName = httpServletRequest.getRemoteUser().toString();

		return hostName;
	}

	/**
	 * 
	 * @param id
	 * @param summary
	 * @param detail
	 * @param severity
	 */
	public static void addMessage(String id, String summary, String detail, FacesMessage.Severity severity) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		FacesMessage facesMessage = new FacesMessage();

		facesMessage.setSeverity(severity);

		facesMessage.setSummary(summary);

		facesMessage.setDetail(detail);

		facesContext.addMessage(id, facesMessage);
	}

	/**
	 * Message d'Informations
	 * 
	 * @param summary
	 * @param detail
	 */
	public static void addInfoMessage(String summary, String detail) {

		addMessage(null, summary, detail, FacesMessage.SEVERITY_INFO);
	}

	/**
	 * Message d'avertissement (Warning)
	 * 
	 * @param summary
	 * @param detail
	 */
	public static void addWarnMessage(String summary, String detail) {

		addMessage(null, summary, detail, FacesMessage.SEVERITY_WARN);
	}

	/***
	 * Message d'Erreur
	 * 
	 * @param summary
	 * @param detail
	 */
	public static void addErrorMessage(String summary, String detail) {

		addMessage(null, summary, detail, FacesMessage.SEVERITY_ERROR);
	}

	/**
	 * Message d'Erreur Fatale
	 * 
	 * @param id
	 * @param summary
	 * @param detail
	 */
	public static void addFatalMessage(String summary, String detail) {

		addMessage(null, summary, detail, FacesMessage.SEVERITY_FATAL);
	}

	/**
	 * Recupération d'un objet dans le scope Session
	 * 
	 * @param key : Nom de la clé
	 * @return
	 */
	public static void removeSessionMapValue(String key) {

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(key);

	}

	/**
	 * Recupération d'un objet dans le scope Application
	 * 
	 * @param key : Clé identifiant l'objet
	 * @return
	 */
	public static Object getApplicationMapValue(String key) {

		return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(key);

	}

	public static Object getSessionMapValue(String key) {

		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);

	}

	/**
	 * Injection d'une objet dans le scope Session
	 * 
	 * @param key   : Clé identifiant l'objet
	 * @param value : Valeur
	 */
	public static void setSessionMapValue(String key, Object value) {

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);

	}

	public static void setApplicationMapValue(String key, Object value) {

		FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put(key, value);

	}

	/**
	 * Retrieve Current Session
	 * 
	 * @return
	 */
	public static HttpSession getSession() {

		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	/**
	 * 
	 * @param valueExpression
	 * @param valueType       Create Value Expression
	 */
	public static ValueExpression createValueExpression(String valueExpression, Class<?> valueType) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		return facesContext.getApplication().getExpressionFactory().createValueExpression(facesContext.getELContext(),

				valueExpression, valueType);
	}

	public static MethodExpression createMethodExpression(String expression, Class<?> returnType,
			Class<?>... parameterTypes) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return facesContext.getApplication().getExpressionFactory().createMethodExpression(facesContext.getELContext(),
				expression, returnType, parameterTypes);
	}

	/**
	 * 
	 * @param expression
	 * @param returnType
	 * @return
	 */
//	public static MethodExpression createMethodExpression(String expression, Class<?> returnType) {
//		
//		FacesContext context = FacesContext.getCurrentInstance();
//		
//		return context.getApplication().getExpressionFactory().createMethodExpression(context.getELContext(),
//				expression, returnType, new Class<?>[0]);
//	}

	public static MethodExpression createAction(String expression) {

		MethodExpression action;

		FacesContext facesContext = FacesContext.getCurrentInstance();

		ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();

		ELContext elContext = facesContext.getELContext();

		action = expressionFactory.createMethodExpression(elContext, expression, String.class, new Class<?>[] {});

		return action;
	}

	public static ValueExpression createBindingComponent(String binding, Class typ) {
		FacesContext context = FacesContext.getCurrentInstance();
		ExpressionFactory ef = context.getApplication().getExpressionFactory();
		return ef.createValueExpression(context.getELContext(), binding, typ);
	}
	
	

}
