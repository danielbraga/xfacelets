package org.xfacelets.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

/**
 * Classe que implementa a validação de <code>E-mail<code> em Java Server Faces
 * 
 * <p>Use em campos de entradas de informações da seguinte maneira
 * <blockquote><pre>
 *     &lth:inputText value="#{email.value}"&gt
 *       &ltf:validator validatorId="org.xfacelets.validator.email" /&gt
 *     &lt/h:inputText&gt
 * </pre></blockquote>
 * </p>
 * 
 * @author <a href="mailto:daniel.souza.braga@gmail.com">Daniel de Souza Braga</a>
 */
@FacesValidator("org.xfacelets.validator.email")
public class EmailValidador extends AbstractValidator {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    
    /*
     * (non-Javadoc)
     * @see org.xfacelets.validator.AbstractValidator#validate(java.lang.Object)
     */
    @Override
    public void validate(Object value) throws ValidatorException {
    	Matcher matcher = pattern.matcher(value.toString());
        if(!matcher.matches()){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail informado é inválido.", null);
            throw new ValidatorException(msg);
        }
    }
}
