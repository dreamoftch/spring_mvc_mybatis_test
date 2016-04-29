package com.tch.test.spring_mvc_mybatis.utils.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

//import java.util.Properties;

@Component
public class MailUtil {

	private static Logger logger = LoggerFactory.getLogger(MailUtil.class);
	public static final String DEFAULT_CHARSET = "UTF-8";

	public String from = "dreamoftch";

	@Autowired
	private JavaMailSenderImpl senderImpl;

	public void sendMailAndFile(String sendTo, String subject, String content, String attachName, String attachfilePath) throws MessagingException {
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, DEFAULT_CHARSET);
		// 设置收件人，寄件人
		messageHelper.setTo(sendTo);
		messageHelper.setFrom(from);
		messageHelper.setSubject("" + subject);
		// true 表示启动HTML格式的邮件
		messageHelper.setText("" + content, true);

		if (attachfilePath != null) {
			File f = new File("" + attachfilePath);
			if (f.exists() && f.isFile()) {
				if (f.length() > 1024 * 1024 * 32) {
					logger.error("file size is too big {}", f.getAbsolutePath());
				} else {
					messageHelper.addAttachment(attachName, new FileSystemResource(f));
				}
			}
		}
		senderImpl.send(mailMessage);

		logger.info("邮件发送成功..");
	}

	public void sendMail(String sendTo, String subject, String content, String attachName, File file) throws MessagingException {
        MimeMessage mailMessage = senderImpl.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, DEFAULT_CHARSET);
        // 设置收件人，寄件人
        messageHelper.setTo(sendTo);
        messageHelper.setFrom(from);
        messageHelper.setSubject("" + subject);
        // true 表示启动HTML格式的邮件
        messageHelper.setText("" + content, true);

        if (file != null) {
            if (file.exists() && file.isFile()) {
                if (file.length() > 1024 * 1024 * 32) {
                    logger.error("file size is too big {}", file.getAbsolutePath());
                } else {
                    messageHelper.addAttachment(attachName, file);
                }
            }
        }
        senderImpl.send(mailMessage);
        logger.info("邮件发送成功..");
    }
	public static void main(String[] args) throws MessagingException {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

		// 设定mail server
		senderImpl.setHost("xx");
		senderImpl.setUsername("xx"); // 根据自己的情况,设置username
		senderImpl.setPassword("xx"); // 根据自己的情况, 设置password
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		prop.put("mail.smtp.timeout", "25000");
		senderImpl.setJavaMailProperties(prop);
		// 建立邮件消息,发送简单邮件和html邮件的区别
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		// 注意这里的boolean,等于真的时候才能嵌套图片，在构建MimeMessageHelper时候，所给定的值是true表示启用，
		// multipart模式 为true时发送附件 可以设置html格式
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, DEFAULT_CHARSET);

		// 设置收件人，寄件人
		messageHelper.setTo("xx");
		messageHelper.setFrom("xx");
		messageHelper.setSubject("");
		// true 表示启动HTML格式的邮件
		messageHelper.setText("xx", true);

		File f = new File("xx");
		if (f.exists() && f.isFile()) {
			// System.out.println(f.length());
			if (f.length() > 1024 * 1024 * 32) {

			} else {
				messageHelper.addAttachment("20141008_222708_728.txt", new FileSystemResource(f));
			}
		}

		// 发送邮件
		senderImpl.send(mailMessage);

		logger.info("邮件发送成功..");
	}

}
