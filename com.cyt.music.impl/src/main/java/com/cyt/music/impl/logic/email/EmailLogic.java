package com.cyt.music.impl.logic.email;

import com.cyt.music.impl.util.email.SendmailUtil;
import org.springframework.stereotype.Component;

/**
 * Created by chen on 2017/7/9.
 */
@Component
public class EmailLogic {
    public void sendEmail(String emailStr,String title) throws Exception {
        SendmailUtil sendmailUtil=new SendmailUtil();
        sendmailUtil.sslSend(title,emailStr);
    }
}
