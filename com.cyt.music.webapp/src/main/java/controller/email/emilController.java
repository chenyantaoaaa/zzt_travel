package controller.email;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.email.EmailService;
import service.order.OrderInfoService;

/**
 * Created by chen on 2017/7/9.
 */
@Controller
@RequestMapping("/email")
public class emilController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/sendemail")
    public @ResponseBody
    void queryOrderInfo() throws Exception {
        String title="我是一封test邮件";
        String emailStr="test邮件";
        emailService.sendEmail(emailStr,title);
    }
}

