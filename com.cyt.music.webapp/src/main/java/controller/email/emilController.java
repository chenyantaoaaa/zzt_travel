package controller.email;


import com.cyt.music.interfaces.pojo.system.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.email.EmailService;

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
    void queryOrderInfo(@RequestBody EmailDTO dto) throws Exception {
        String title="客户意见反馈";

        StringBuilder emailStr=new StringBuilder();
        emailStr.append("客户名:").append(dto.getName()).append("  ").append("邮箱地址:").append(dto.getEmail()).append("  ")
                .append("客户电话:").append(dto.getPhone()).append("  ").append("意见内容:").append(dto.getContent());
        emailService.sendEmail(emailStr.toString(),title);
    }
}

