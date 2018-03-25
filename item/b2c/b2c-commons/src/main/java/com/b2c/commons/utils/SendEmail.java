package com.b2c.commons.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 1.账号要开启服务端邮件发送，开启成功后会设置授权码
 * 2.在OA系统登录163邮件服务器根据用户名和授权码登录
 * 3.要指定账号对应的服务器的IP
 * 4.设置协议
 * @author admin
 *
 */
public class SendEmail {

	public static void SendEmailInfoUser(String sendAddress,String copysendAddress, String title, String content) throws Exception {
		Properties properties = new Properties();
		// 设置服务器名称
		properties.setProperty("mail.host", "smtp.163.com");
		// 设置邮件传输协议
		properties.setProperty("mail.transport.protocol", "smtp");
		// 设置是否要验证服务器用户名和密码
		properties.setProperty("mail.smtp.auth", "true");
		// 1.创建客户端与邮箱服务器的Session对象
		Session session = Session.getInstance(properties);
		// 2.开启session的debug模式，方便查看发送email的运行状态
		session.setDebug(true);
		// 3.通过session得到transport传输对象
		Transport transport = session.getTransport();
		// 4.使用用户名密码连接上邮箱服务器,此处的密码需要到邮箱开启服务设置
		transport.connect("smtp.163.com", "music120326", "qq120326");
		// 5.创建邮件
		Message message = createSimpleMail(session, sendAddress,copysendAddress, title, content);
		// 6.发送邮件
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}

	private static Message createSimpleMail(Session session, String sendAddress,String copysendAddress, String title, String content)
			throws Exception {
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);
		// 指明邮件的发件人
		message.setFrom(new InternetAddress("music120326@163.com"));
		// 设置收件人
        if (sendAddress != null && sendAddress.length() > 0) {
        	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendAddress));
        }
        // 设置抄送人
        if (sendAddress != null && sendAddress.length() > 0) {
        	message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(copysendAddress)); 
        }
		// 邮件的标题
		message.setSubject(title);
		// 邮件的内容
		message.setContent(content, "text/html;charset=UTF-8");
		
		
		return message;
	}

	public static void main(String[] args) throws Exception {
		SendEmailInfoUser("devilweime@163.com","music120326@hotmail.com","你好", "怎么");
	}

}
