package com.cyt.music.impl.util.email;

import com.sun.mail.util.MailSSLSocketFactory;
import org.apache.log4j.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

public class SendmailUtil {
    private static Logger log = Logger.getLogger(SendmailUtil.class);
    // 设置服务器
    private static String KEY_SMTP = "mail.smtp.host";
    private static String VALUE_SMTP = "smtp.mxhichina.com";
//    private static String VALUE_SMTP = "smtp.taoshaome.com";
    // 服务器验证
    private static String KEY_PROPS = "mail.smtp.auth";
    private static boolean VALUE_PROPS = true;
    // 发件人用户名、密码
    private static String SEND_USER = "postmaster@taoshaome.cn";
    private static String SEND_UNAME = "postmaster@taoshaome.cn";
    private static String SEND_PWD = "Aa86358201";
    // 建立会话
    private MimeMessage message;
    private Session s;

    /*
     * 初始化方法
     */
//    public SendmailUtil() {
//        Properties props = System.getProperties();
//        props.setProperty(KEY_SMTP, VALUE_SMTP);
//        props.put(KEY_PROPS, "true");
//        props.put("mail.smtp.port", "80");
//        //props.put("mail.smtp.auth", "true");
//        s =  Session.getDefaultInstance(props, new Authenticator(){
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(SEND_UNAME, SEND_PWD);
//            }});
//        s.setDebug(true);
//        message = new MimeMessage(s);
//    }

    /**
     * 发送邮件
     *
     * @param headName
     *            邮件头文件名
     *            邮件内容
     */
    public String doSendTextEmail(String headName, String sendText) {
        try {
            // 发件人
            InternetAddress from = new InternetAddress(SEND_USER);
            message.setFrom(from);
            // 收件人
            InternetAddress to = new InternetAddress("yyyvoyage@hotmail.com");
            message.setRecipient(Message.RecipientType.TO, to);
            // 邮件标题
            message.setSubject(headName);
            String content = sendText.toString();
            // 邮件内容,也可N以使纯文本"text/plain"
            message.setContent(content, "text/plain;charset=GBK");
            message.saveChanges();
            Transport transport = s.getTransport("smtp");
            // smtp验证，就是你用来发邮件的邮箱用户名密码
            transport.connect(VALUE_SMTP, SEND_UNAME, SEND_PWD);
            // 发送
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return "succ";
        } catch (AddressException e) {
            e.printStackTrace();
            return "fail";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "fail";
        }
    }

    public static String sslSend(String headName, String sendText)
            throws AddressException, MessagingException, IOException {
        log.info("sslSend");
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        sf.setTrustAllHosts(true);
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        // Get a Properties object
        Properties props = new Properties();
//        props.setProperty("mail.smtp.host", emailAccount.getPlace());
        props.setProperty("mail.smtp.host", "smtp.mxhichina.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port.enable", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");

        final String username = SEND_USER;
        final String password = SEND_PWD;
        Session session = Session.getDefaultInstance(props, new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }});
        Message msg = new MimeMessage(session);

        // 设置发件人和收件人
        msg.setFrom(new InternetAddress(SEND_USER));
//        yyyvoyage@hotmail.com
        InternetAddress to = new InternetAddress("yyyvoyage@gmail.com");
        // 多个收件人地址
        msg.setRecipient(Message.RecipientType.TO, to);
        msg.setSubject(headName); // 标题
        msg.setText(sendText);// 内容
        msg.setSentDate(new Date());
        Transport.send(msg);
        System.out.println("EmailUtil ssl协议邮件发送打印" +msg.toString());
        return "succ";
    }



    public static void main(String[] args) {
        SendmailUtil se = new SendmailUtil();
//        se.doSendTextEmail("邮件头文件名", "邮件内容");
        try {
            se.sslSend("邮件头文件名", "邮件内容");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}