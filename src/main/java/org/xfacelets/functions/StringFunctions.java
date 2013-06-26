package org.xfacelets.functions;


/**
 * Classe das funções básicas sobre <code>String</code>
 * usada nas composições de facelets.
 * 
 * @author <a href="mailto:daniel.souza.braga@gmail.com">Daniel Braga</a>
 */
public class StringFunctions {

	/**
	 * Método para concatenação de duas <code>String</code>
	 * @param a
	 * @param b
	 * @return
	 */
    public static String concat(String a, String b) {
    	return a + b;
    }
    
    /**
     * Método que indica que se o {@code obj} no parâmetro é uma instância de <code>String</code>
     * @param obj -  parâmetro para verificação
     * @return <code>true</code> se o parâmetro para uma instância de <code>String</code>.
     */
	public static boolean isString(Object obj) {
		return obj != null && obj instanceof String;
	}
	
	/**
	 * Método que retorna o tamanho de {@code value}
	 * @param value
	 * @return
	 */
	public static int length(String value) {
		return (value == null) ? 0 : value.length();
	}

}
