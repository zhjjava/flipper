 
  
package edu.mum.hrms.component.integration;

import org.springframework.integration.annotation.Gateway;

import edu.mum.hrms.component.mail.MailInfoObject;


/**
 * The entry point for the 
 * Bus Flow.
 * 
 */
public interface EmailGateway {

    /**
     * Process a book order.
     */
	@Gateway(requestChannel="processEmail")
	public void process(MailInfoObject order);

}
