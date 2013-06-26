package org.xfacelets.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Classe abstrata para conversão de valores em Java Server Faces
 * 
 * @author <a href="mailto:daniel.souza.braga@gmail.com">Daniel de Souza Braga</a>
 */
public abstract class AbstractConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Método que transforma uma entrada {@code value} em <code>Object</code>
	 */
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return getAsObject(value);
	}

	/**
	 * Método que transforma uma entrada {@code value} em <code>String</code>
	 */
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return getAsString(value);
	}
	
	/**
	 * Método abstrato para a transformação como <code>Object</code> de uma entrada {@code value}
	 * @param value - valor de entrada
	 * @return Objeto transformado
	 */
	public abstract Object getAsObject(String value);
	
	/**
	 * Método abstrato para a transformação como <code>String</code> de uma entrada {@code value}
	 * @param value - objeto de entrada
	 * @return valor transformado
	 */
	public abstract String getAsString(Object value);
	

}
