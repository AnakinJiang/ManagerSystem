package com.teetaa.util;

import java.util.Calendar;  
import java.util.Properties;  
  
import javax.mail.Authenticator;  
import javax.mail.MessagingException;  
import javax.mail.PasswordAuthentication;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.Message.RecipientType;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
  
public class SendMail {  
    @SuppressWarnings("static-access")  
    public static void sendMessage(String smtpHost, String from,  
            String fromUserPassword, String to, String subject,  
            String messageText, String messageType) throws MessagingException {  
        // 第一步：配置javax.mail.Session对象  
        System.out.println("为" + smtpHost + "配置mail session对象");  
          
          
        Properties props = new Properties();  
        props.put("mail.smtp.host", smtpHost);  
        props.put("mail.smtp.starttls.enable","true");//使用 STARTTLS安全连接  
        props.put("mail.smtp.port", "25");             //google使用465或587端口  
        props.put("mail.smtp.auth", "true");        // 使用验证  
        props.put("mail.debug", "true");  
        Session mailSession = Session.getInstance(props,new MyAuthenticator(from,fromUserPassword));  
  
        // 第二步：编写消息  
        System.out.println("编写消息from——to:" + from + "——" + to);  
  
        InternetAddress fromAddress = new InternetAddress(from);  
        InternetAddress toAddress = new InternetAddress(to);  
  
        MimeMessage message = new MimeMessage(mailSession);  
  
        message.setFrom(fromAddress);  
        message.addRecipient(RecipientType.TO, toAddress);  
  
        message.setSentDate(Calendar.getInstance().getTime());  
        message.setSubject(subject);  
        message.setContent(messageText, messageType);  
  
        // 第三步：发送消息 
        System.out.print(1);
        Transport transport = mailSession.getTransport("smtp");  
        transport.connect(smtpHost,"289200105@qq.com", fromUserPassword);  
        System.out.print(2);
        transport.send(message, message.getRecipients(RecipientType.TO));  
        System.out.println("message yes");  
    }  
  
    public static void main(String[] args) {  
    	 
        try {  
            SendMail.sendMessage("smtp.qq.com", "289200105@qq.com",  
                    "gloplwnovnmpcbbj", "jiang_jin_peng@163.com", "nihao",  
                    "<a href=\"http://www.google.cn\">谷歌</a>",  
                    "text/html;charset=gb2312");  
        } catch (MessagingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
}  
class MyAuthenticator extends Authenticator{  
    String userName="";  
    String password="";  
    public MyAuthenticator(){  
          
    }  
    public MyAuthenticator(String userName,String password){  
        this.userName=userName;  
        this.password=password;  
    }  
     protected PasswordAuthentication getPasswordAuthentication(){     
        return new PasswordAuthentication(userName, password);     
     }   
}  