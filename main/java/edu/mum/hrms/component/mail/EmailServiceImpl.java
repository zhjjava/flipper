/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package edu.mum.hrms.component.mail;

import java.util.Locale;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import edu.mum.hrms.model.SysUser;
import edu.mum.hrms.util.AppContextUtil;

@Service("emailService")
public class EmailServiceImpl implements EmailService{

     private static final String IM_THE_GUY = "templates/images/imtheguy.jpg";
     
     private static final String FLIPPER_ICON = "templates/images/flipper.jpg";
     
    
     private static final String JPG_MIME = "image/jpg";
     private static final String DOCX_MIME = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

  @Autowired
    private JavaMailSender mailSender;
 
  @Autowired
    private SpringTemplateEngine templateEngine;
    
//    /* 
//     * Send HTML mail (simple) 
//     */
//    public void sendOrderReceivedMail(
//            final String recipientName, final String recipientEmail, Order order,String documentName,final Locale locale) 
//            throws MessagingException {
//        
//        // Prepare the evaluation context
//        final Context thymeContext = new Context(locale);
//        thymeContext.setVariable("name", recipientName);
//        thymeContext.setVariable("order", order);
//          
//        // Prepare message using a Spring helper
//        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
//        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true,"UTF-8");
//        message.setSubject("Order Details");
// 
//        // could have CC, BCC, will also take an array of Strings
//        message.setTo(recipientEmail);
//
//        // Create the HTML body using Thymeleaf
//        final String htmlContent = this.templateEngine.process("orderReceivedMail", thymeContext);
//        message.setText(htmlContent, true /* isHtml */);
//   
//        message.addInline("imtheguy", new ClassPathResource(IM_THE_GUY), JPG_MIME);
//        
//        
//
//        String documentLocation = "templates/images/" + documentName ;
//         message.addAttachment(documentName, new ClassPathResource(documentLocation));
// 
///* 
//   // Alternative
//        File file = new File(documentLocation);
//      message.addAttachment(documentName, file);
//*/        
//        // Send email
//        this.mailSender.send(mimeMessage);
//
//    }

    public void sendResetPasswordMail(
            final String recipientName, final String recipientEmail, SysUser sysUser, Locale locale) 
            throws MessagingException {
        
        try {
			// Prepare the evaluation context
			if(locale==null){
				locale = new Locale("en");
			}
			final Context thymeContext = new Context(locale);
			thymeContext.setVariable("sysUser", sysUser);
			thymeContext.setVariable("url", "http://localhost:8080/hrms/resetpassword/"+sysUser.getUserId()+".do");
//        thymeContext.setVariable("order", order);
			  
			// Prepare message using a Spring helper
			final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
			final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true,"UTF-8");
			message.setSubject("Flipper.com login assistance ");
 
			// could have CC, BCC, will also take an array of Strings
			message.setTo(recipientEmail);

			// Create the HTML body using Thymeleaf
			final String htmlContent = this.templateEngine.process("resetPassword", thymeContext);
			message.setText(htmlContent, true /* isHtml */);
   
			message.addInline("flipper", new ClassPathResource(FLIPPER_ICON), JPG_MIME);
			
			       
			// Send email
			this.mailSender.send(mimeMessage);
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    public static void main(String[] args) throws MessagingException {

    	EmailServiceImpl emailService = AppContextUtil.getInstance().getBean("emailService", EmailServiceImpl.class);
        SysUser user = new SysUser();
        user.setUserId(1000);
        user.setFirstName("michale");
        user.setLastName("z");
    	
        emailService.sendResetPasswordMail("Kemosabe", "zhjjava@126.com",user,new Locale("en"));
      
        System.out.println("                      The Email is on the WAY!!!");

      }
}
