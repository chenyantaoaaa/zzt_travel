package service.email;

/**
 * Created by chen on 2017/7/9.
 */
public interface EmailService {
    public void sendEmail(String emailStr,String title) throws Exception;
}
