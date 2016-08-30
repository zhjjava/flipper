package edu.mum.hrms.component.mail;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.messaging.MessageDeliveryException;
import org.springframework.stereotype.Service;

import edu.mum.core.exception.AppException;
import edu.mum.hrms.component.integration.EmailGateway;
import edu.mum.hrms.model.SysUser;
import edu.mum.hrms.util.AppContextUtil;

/**
 * MIME.
 * 
 */
@Service(value = "mailService")
public class MailServiceImpl implements MailService {

	private static final String DEFAULT_ENCODING = "utf-8";

	private static Log log = LogFactory.getLog(MailServiceImpl.class);

	private JavaMailSender mailSender;

	private String fromEmail;

	/**
	 * @param mailSender
	 */

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * @param fromEmail
	 *            fromEmail。
	 */
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	/**
	 * sample: sendText("subject","email content","1@test.com;2@test.com");
	 * 
	 * @param subject
	 * @param emailContent
	 * @param email
	 * @throws AppException
	 */
	public void sendText(String subject, String emailContent, String email) throws AppException {
		log.debug("send mail begin.");
		try {
			if (StringUtils.isEmpty(email)) {
				throw new AppException(1001);
			}
			String[] emailArr = email.split(";");
			sendText(subject, emailContent, emailArr);
		} catch (Exception e) {
			throw new AppException(1001, e);
		}
		log.debug("send mail end.");
	}

	/**
	 * sample：
	 * 
	 * sendText("subject","email content","1@test.com","2@test.com");
	 * sendText("subject","email content",new
	 * String[]{"1@test.com","2@test.com"});
	 * 
	 * @param subject
	 * @param emailContent
	 * @param email
	 * @throws AppException
	 */
	public void sendText(String subject, String emailContent, String... email) throws AppException {
		log.debug("send mail begin.");
		try {
			if (ArrayUtils.isEmpty(email)) {
				throw new AppException(1001);
			}
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo(email);
			mail.setSubject(subject);
			mail.setText(emailContent);
			mail.setFrom(fromEmail);
			mailSender.send(mail);
		} catch (Exception e) {
			throw new AppException(1001, e);
		}
		log.debug("send mail end.");
	}

	/**
	 * @throws Exception
	 */

	public void sendMimeMessage() throws AppException {
		try {
			final List files = new ArrayList();
			MimeMessagePreparator mimeMail = new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws MessagingException {
					mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("demo@126.com"));
					mimeMessage.setFrom(new InternetAddress("demo@126.com"));
					mimeMessage.setSubject("Test email with attachment", DEFAULT_ENCODING);

					Multipart mp = new MimeMultipart();

					// Add content into Multipart
					MimeBodyPart content = new MimeBodyPart();
					content.setText("test!");

					// add something into MimeMessage
					mp.addBodyPart(content);
					files.add("src/demo1.txt");
					files.add("src/demo.txt");

					// Add an attachment into Multipart
					Iterator it = files.iterator();
					while (it.hasNext()) {
						MimeBodyPart attachFile = new MimeBodyPart();
						String filename = it.next().toString();
						FileDataSource fds = new FileDataSource(filename);
						attachFile.setDataHandler(new DataHandler(fds));
						attachFile.setFileName(fds.getName());
						mp.addBodyPart(attachFile);
					}

					files.clear();

					// add MimeMessage into Multipart
					mimeMessage.setContent(mp);
					mimeMessage.setSentDate(new Date());
				}
			};

			mailSender.send(mimeMail);
		} catch (Exception e) {
			throw new AppException(1001);
		}
		log.debug("send successfully.");
	}

	public static void main(String args[]) {
		try {
			System.out.println("java.class.path:" + System.getProperty("java.class.path"));
			ApplicationContext context = AppContextUtil.getInstance().getApplicationContext();
			// MailService mailService = context.getBean("mailService",
			// MailServiceImpl.class);
			// MimeMailService springMail = new MimeMailService();
			// mimeMailService.sendText("I am a hacker,show me the money");
			// springMail.sendMimeMessage(javaMailSender);
			// mailService.sendText("test email component", "test!",
			// "yidao.zhou@gmail.com;zhjjava@126.com");
			SysUser user = new SysUser();
			user.setUserId(1000);
			user.setFirstName("michale");
			user.setLastName("z");

			MailInfoObject message = new MailInfoObject("Reset Password", user, "zhjjava@126.com", "zhjjava@126.com");

			EmailGateway emailGateway = (EmailGateway) context.getBean("emailGateway");

			emailGateway.process(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
