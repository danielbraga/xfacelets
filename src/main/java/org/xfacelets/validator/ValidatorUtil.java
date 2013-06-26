package org.xfacelets.validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Classe utilitária utilizada na validações de entradas de valores.
 *  
 * @author <a href="mailto:daniel.souza.braga@gmail.com">Daniel de Souza Braga</a>
 */
public class ValidatorUtil {
	
	private static final List<String> CPFS_INVALIDOS = Arrays.asList(new String[] {
            "00000000191", "00000000000", "11111111111", "22222222222",
            "33333333333", "44444444444", "55555555555", "66666666666",
            "77777777777", "88888888888", "99999999999" });

	/**
	 * Método que retorna se um {@code str} está vazia.
	 * @param str
	 * @return
	 */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().equals("");
    }

    /**
     * Método que valida <code>CPF<code>
     * @param value
     * @return
     */
    public static boolean criticaCPF(String value) {
        Pattern pattern = Pattern.compile("[0-9]{11}");

        boolean valid;
        int soma1, soma2, d1, d2;

        value = value.trim().replace(".", "").replace("-", "");

        if (CPFS_INVALIDOS.contains(value)) {
            return false;
        }

        valid = pattern.matcher(value).matches();

        if (valid) {
            soma1 = soma2 = 0;
            for (int i = 0; i < 9; i++) {
                d1 = value.charAt(i) - '0';
                soma1 += d1 * (10 - i);
                soma2 += d1 * (11 - i);
            }

            d1 = soma1 % 11;
            if (d1 < 2) {
                d1 = 0;
            } else {
                d1 = 11 - d1;
            }

            soma2 += d1 * 2;
            d2 = soma2 % 11;
            if (d2 < 2) {
                d2 = 0;
            } else {
                d2 = 11 - d2;
            }

            valid = (value.charAt(9) - '0') == d1
                            && (value.charAt(10) - '0') == d2;
        }
        return valid;
    }

    /**
     * Método que valida <code>CNPJ<code>
     * @param value
     * @return
     */
    public static boolean criticaCNPJ(String value) {
        Pattern pattern = Pattern.compile("[0-9]{14}");

        boolean valid;
        int soma1, soma2, d1, d2, i, j, k, c;

        value = value.trim().replace(".", "").replace("-", "").replace("/", "");

        valid = pattern.matcher(value).matches();

        if (valid) {
           soma2 = soma1 = 0;
           for (i = 11, j = 2, k = 3; i >= 0; i--) {
              c = value.charAt(i) - '0';
              soma1 += c * j;
              soma2 += c * k;
              j = (j + 1) % 10;
              if (j == 0) {
                 j = 2;
              }
              k = (k + 1) % 10;
              if (k == 0) {
                 k = 2;
              }
           }

           d1 = soma1 % 11;
           if (d1 < 2) {
              d1 = 0;
           } else {
              d1 = 11 - d1;
           }

           soma2 += d1 * 2;
           d2 = soma2 % 11;
           if (d2 < 2) {
              d2 = 0;
           } else {
              d2 = 11 - d2;
           }

           valid = value.charAt(12) - '0' == d1 && value.charAt(13) - '0' == d2;
        }
        return valid;
     }
    
    /**
     * Método que valida <code>CEP<code>
     * @param value
     * @return
     */
	public static boolean criticaCEP(String value) {
		Pattern pattern = Pattern.compile("[0-9]{8}");
		
		String testValue = value.trim().replace(".", "").replace("-", "").replace("/", "");
		return pattern.matcher(testValue).matches();
	}
	
	/**
     * Método que valida <code>Telefone<code>
     * @param value
     * @return
     */
	public static boolean criticaTelefone(String value) {
		Pattern pattern = Pattern.compile("[0-9]{10}");
		Pattern patternSaoPaulo = Pattern.compile("11[0-9]{9}");
		
		String testValue = value.trim().replace(".", "").replace("-", "").replace("/", "");
		return pattern.matcher(testValue).matches() || patternSaoPaulo.matcher(testValue).matches();
	}
}
