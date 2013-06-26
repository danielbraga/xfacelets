package org.xfacelets.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Classe abstrata para validação de valores em Java Server Faces
 * 
 * @author <a href="mailto:daniel.souza.braga@gmail.com">Daniel de Souza Braga</a>
 */
public abstract class AbstractValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		validate(value);
	}
	
	/**
	 * Método abstrato para implementação da validação do {@code value}
	 * @param value
	 * @throws ValidatorException Exception que indica a error ao validar a informação
	 */
	public abstract void validate(Object value) throws ValidatorException;

}
