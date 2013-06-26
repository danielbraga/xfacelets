package org.xfacelets.validator;

import javax.faces.application.FacesMessage;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

/**
 * Classe que implementa a validação de <code>CPNJ<code> em Java Server Faces
 * 
 * <p>Use em campos de entradas de informações da seguinte maneira
 * <blockquote><pre>
 *     &lth:inputText value="#{cnpj.value}"&gt
 *       &ltf:validator validatorId="org.xfacelets.validator.cnpj" /&gt
 *     &lt/h:inputText&gt
 * </pre></blockquote>
 * </p>
 * 
 * @author <a href="mailto:daniel.souza.braga@gmail.com">Daniel de Souza Braga</a>
 */
@FacesValidator("org.xfacelets.validator.cnpj")
public class CNPJValidador extends AbstractValidator {

	/*
	 * (non-Javadoc)
	 * @see org.xfacelets.validator.AbstractValidator#validate(java.lang.Object)
	 */
    public void validate(Object value) throws ValidatorException {
        if (!ValidatorUtil.criticaCNPJ(value.toString())) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "validator.cnpj", null);
            throw new ValidatorException(message);
        }

    }
}
