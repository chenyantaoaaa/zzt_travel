package com.cyt.music.impl.logic.email;

import com.cyt.music.impl.util.email.SendmailUtil;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by chen on 2017/7/9.
 */
@Component
public class EmailLogic {
    public String sendEmail(String emailStr,String title) throws Exception {
        SendmailUtil sendmailUtil=new SendmailUtil();
        String returnStr = "";
        try {
            returnStr = sendmailUtil.sslSend(title,emailStr);
        } catch (MessagingException e) {
            e.printStackTrace();
            returnStr = "fail";
        } catch (IOException e) {
            e.printStackTrace();
            returnStr = "fail";
        }
        return returnStr;
    }
}
