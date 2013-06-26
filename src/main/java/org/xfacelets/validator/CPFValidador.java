package org.xfacelets.validator;

import javax.faces.application.FacesMessage;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

/**
 * Classe que implementa a validação de <code>CPF<code> em Java Server Faces
 * 
 * <p>Use em campos de entradas de informações da seguinte maneira
 * <blockquote><pre>
 *     &lth:inputText value="#{cpf.value}"&gt
 *       &ltf:validator validatorId="org.xfacelets.validator.cpf" /&gt
 *     &lt/h:inputText&gt
 * </pre></blockquote>
 * </p>
 * 
 * @author <a href="mailto:daniel.souza.braga@gmail.com">Daniel de Souza Braga</a>
 */
@FacesValidator("org.xfacelets.validator.cpf")
public class CPFValidador extends AbstractValidator {

	/*
	 * (non-Javadoc)
	 * @see org.xfacelets.validator.AbstractValidator#validate(java.lang.Object)
	 */
    @Override
    public void validate(Object value) throws ValidatorException {
        if (!ValidatorUtil.criticaCPF(value.toString())) {
            //FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "validator.cpf", null);
        	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF informado é inválido!", null);
            throw new ValidatorException(message);
        }

    }
}
