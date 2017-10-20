package service.email;

/**
 * Created by chen on 2017/7/9.
 */
public interface EmailService {
    public String sendEmail(String emailStr,String title,String emailAd) throws Exception;
}
