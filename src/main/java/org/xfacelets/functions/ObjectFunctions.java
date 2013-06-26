package org.xfacelets.functions;


/**
 * Classe das funções básicas sobre <code>Object</code>
 * usada nas composições de facelets.
 * 
 * @author <a href="mailto:daniel.souza.braga@gmail.com">Daniel Braga</a>
 */
public class ObjectFunctions {

	/**
	 * Método que retorna o objeto {@code defaultValue} caso o objeto {@code valueToTest} seja nulo.
	 * 
	 * @param valueToTest valor para teste e substituição do valor padrão
	 * @param defaultValue valor padrão
	 * @return
	 */
	public static Object defaultValue(Object valueToTest, Object defaultValue) {
        Object retorno = (valueToTest == null ? defaultValue : valueToTest);
        return retorno;
    }

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
	 * Método que retorna o objeto {@code valueToReturn} caso o objeto {@code valueToTest} não seja nulo.
	 * 
	 * @param valueToTest valor para teste
	 * @param valueToReturn valor para retorno
	 * @return
	 */
    public static Object getValueIfNotEmpty(Object valueToTest, Object valueToReturn){
        Object retorno = (valueToTest != null ? valueToReturn : null);
        return retorno;
    }
    
    /**
     * Método que indica que se o {@code obj} no parâmetro não é nulo
     * @param obj -  parâmetro para verificação
     * @return <code>true</code> se o parâmetro não for nulo.
     */
    public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}
	
    /**
     * Método que indica que se o {@code obj} no parâmetro é nulo
     * @param obj -  parâmetro para verificação
     * @return <code>true</code> se o parâmetro for nulo.
     */
	public static boolean isNull(Object obj) {
		return obj == null;
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
