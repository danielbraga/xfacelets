package org.xfacelets.converter;

import javax.faces.convert.FacesConverter;

/**
 * Classe de conversão Java Server Faces para remoção de máscaras em entradas pontuais.
 * 
 * <p>Use em campos de entradas de informações da seguinte maneira
 * <blockquote><pre>
 *     &lth:inputText value="#{mask.value}"&gt
 *       &ltf:converter converterId="removeMask" binding="#{removeMask}" /&gt
 *     &lt/h:inputText&gt
 * </pre></blockquote>
 * </p>
 * 
 * @author <a href="mailto:daniel.souza.braga@gmail.com">Daniel de Souza Braga</a>
 */
@FacesConverter("org.xfacelets.converter.removeMask")
public class RemoveMaskConverter extends AbstractConverter {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * @see org.xfacelets.converter.AbstractConverter#getAsObject(java.lang.String)
	 */
	@Override
	public Object getAsObject(String value) {
		return value.trim().replace(".", "").replace("-", "").replace("/", "");
	}

	/*
	 * (non-Javadoc)
	 * @see org.xfacelets.converter.AbstractConverter#getAsObject(java.lang.String)
	 */
	@Override
	public String getAsString(Object value) {
		return value.toString();
	}

}
