package org.xfacelets.functions;

import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * Classe das funções básicas sobre <code>FacesContext</code>
 * usada nas composições de facelets.
 * 
 * @author <a href="mailto:daniel.souza.braga@gmail.com">Daniel de Souza Braga</a>
 */
public class FacesContextFunctions {
	
	/**
     * Retorna se existe mensagens
     * @return <code>true</code> se existe mensagens ou<code>false</code>se não existe.
     */
    public static Boolean isMessages() {
    	FacesContext context = FacesContext.getCurrentInstance();
    	if (context != null) {
    		Severity severity = context.getMaximumSeverity();
    		return severity != null;
    	}
    	return false;
    }
    
    /**
     * Retorna se existe mensagens para um id específico
     * @param clientId
     * @return <code>true</code> se existe mensagens ou <code>false</code> se não existe.
     */
    public static Boolean isMessagesForClientId(String clientId) {
    	FacesContext context = FacesContext.getCurrentInstance();
    	if (context != null) {
    		Iterator<FacesMessage> messsages = context.getMessages(clientId);
    		return messsages != null && messsages.hasNext();
    	}
    	return false;
    }
    
    /**
     * Retorna se existe <code>clientId</code> com mensagens no contexto do Java Server Faces.
     * @return <code>true</code> se existe mensagens ou <code>false</code> se não existe.
     */
    public static Boolean isClientIdsWithMessages() {
    	FacesContext context = FacesContext.getCurrentInstance();
    	if (context != null) {
    		Iterator<String> clientIds = context.getClientIdsWithMessages();
    		if (clientIds != null) {
    			while (clientIds.hasNext()) {
					String clientId = (String) clientIds.next();
					if (clientId != null && !clientId.isEmpty()) {
						boolean hasMessage = isMessagesForClientId(clientId);
						if (hasMessage) {
							return true;
						}
					}
				};
    		}
    	}
    	return false;
    }
    
    /**
     * Retorna se existe uma messagem específica para algum dos <code>clientIds</code> no contexto do Java Server Faces.
     * @return <code>true</code> se existe {@code message} existe para algum dos <code>clientIds</code>.
     */
    public static Boolean hasMessageWithClientIds(String message) {
    	if (message != null && !message.isEmpty() && isClientIdsWithMessages()) {
    		FacesContext context = FacesContext.getCurrentInstance();
        	if (context != null) {
        		Iterator<String> clientIds = context.getClientIdsWithMessages();
        		while (clientIds.hasNext()) {
					String clientId = (String) clientIds.next();
					boolean equals = message.equalsIgnoreCase(getMessageForClientId(clientId));
					if (equals) {
						return true;
					}
				}
        	}
    	}
    	return false;
    }
    
    /**
     * Retorna se a existe mensagens do tipo error
     * @return <code>true</code> se for uma mensagem de error ou <code>false</code> se não for.
     */
    public static Boolean isMessageError() {
    	return isMessageType(javax.faces.application.FacesMessage.SEVERITY_ERROR);
    }
    
    /**
     * Retorna se a existe mensagens do tipo info
     * @return <code>true</code> se for uma mensagem de info ou <code>false</code> se não for.
     */
    public static Boolean isMessageInfo() {
    	return isMessageType(javax.faces.application.FacesMessage.SEVERITY_INFO);
    }
    
    /**
     * Retorna se a existe mensagens do tipo <code>FacesMessage.SEVERITY_WARN</code>
     * @return <code>true</code> se for uma mensagem de <code>FacesMessage.SEVERITY_WARN</code> ou <code>false</code> se não for.
     */
    public static Boolean isMessageWarn() {
    	return isMessageType(javax.faces.application.FacesMessage.SEVERITY_WARN);
    }
    
    /**
     * Retorna a mensagem para um id específico
     * @param clientId
     * @return <code>String</code> mensagem
     */
    public static String getMessageForClientId(String clientId) {
    	FacesContext context = FacesContext.getCurrentInstance();
    	if (context != null) {
    		Iterator<FacesMessage> messsages = context.getMessages(clientId);
    		if (messsages != null && messsages.hasNext()) {
    			while(messsages.hasNext()) {
    				FacesMessage message = messsages.next();
    				return message.getDetail();
    			}
    		}
    	}
    	return null;
    }
    
    /**
     * Método que indica se o máximo <code>Severity</code> do contexto do Faces é o indicado no parâmetro de entrada.
     * @param type Tipo de <code>Severity</code> da Mensagem
     * @return <code>true</code>se o máximo <code>Severity</code> do contexto do Faces for o indicado.
     */
    private static Boolean isMessageType(Severity type) {
    	FacesContext context = FacesContext.getCurrentInstance();
    	if (context != null) {
    		Severity severity = context.getMaximumSeverity();
    		if (severity != null) {
    			return severity.equals(type);
    		}
    	}
    	return false;
    }
    
    /**
     * Retorna se existe mensagem global no contexto do Java Server Faces.
     * @return <code>true</code> se existe mensagens ou <code>false</code> se não existe.
     */
    public static Boolean hasMessagesGlobal() {
    	FacesContext context = FacesContext.getCurrentInstance();
    	if (context != null) {
    		Iterator<String> clientIds = context.getClientIdsWithMessages();
    		if (clientIds != null && clientIds.hasNext()) {
    			while(clientIds.hasNext()) {
    				String clientId = clientIds.next();
    				if(clientId==null){
    				return Boolean.TRUE;
    				}
    			}
    		}
    	}
    	return Boolean.FALSE;
    }

    /**
     * Retorna o contextPath da aplicaçao em Java Server Faces.
     * @return <code>String</code>.
     */
    public static String contextPath() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    }
    
}
