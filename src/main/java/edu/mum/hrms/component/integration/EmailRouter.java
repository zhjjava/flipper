 
package edu.mum.hrms.component.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import edu.mum.hrms.component.mail.MailInfoObject;

/**
 * Routes order based on order type.
 * 
 */
@MessageEndpoint
public class EmailRouter {

    final Logger logger = LoggerFactory.getLogger(EmailRouter.class);
    
    /**
     * Process order.  Routes based on whether or 
     * not the order is a delivery or pickup.
     */
	@Router(inputChannel="processEmail")
	public String processEmail(MailInfoObject order) {
	    String destination = "forgotPassword";
	    
//  	    switch (order.getBookOrderType()) {
//	        case DELIVERY:
//	        	destination = "deliveryOrder";
//	            break;
//            case PICKUP:
//            	destination = "pickupProcess";
//                break;	            
//	    }
	
		return destination;
	}

}
