package com.cyt.music.impl.service.email;


import com.cyt.music.impl.logic.email.EmailLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.email.EmailService;

/**
 * Created by chen on 2017/7/9.
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private EmailLogic emailLogic;

    @Override
    public String sendEmail(String emailStr,String title,String emailAd) throws Exception {
        return emailLogic.sendEmail(emailStr,title,emailAd);
    }
}
