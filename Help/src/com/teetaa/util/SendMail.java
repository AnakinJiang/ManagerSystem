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
        // ��һ��������javax.mail.Session����  
        System.out.println("Ϊ" + smtpHost + "����mail session����");  
          
          
        Properties props = new Properties();  
        props.put("mail.smtp.host", smtpHost);  
        props.put("mail.smtp.starttls.enable","true");//ʹ�� STARTTLS��ȫ����  
        props.put("mail.smtp.port", "25");             //googleʹ��465��587�˿�  
        props.put("mail.smtp.auth", "true");        // ʹ����֤  
        props.put("mail.debug", "true");  
        Session mailSession = Session.getInstance(props,new MyAuthenticator(from,fromUserPassword));  
  
        // �ڶ�������д��Ϣ  
        System.out.println("��д��Ϣfrom����to:" + from + "����" + to);  
  
        InternetAddress fromAddress = new InternetAddress(from);  
        InternetAddress toAddress = new InternetAddress(to);  
  
        MimeMessage message = new MimeMessage(mailSession);  
  
        message.setFrom(fromAddress);  
        message.addRecipient(RecipientType.TO, toAddress);  
  
        message.setSentDate(Calendar.getInstance().getTime());  
        message.setSubject(subject);  
        message.setContent(messageText, messageType);  
  
        // ��������������Ϣ 
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
                    "<a href=\"http://www.google.cn\">�ȸ�</a>",  
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