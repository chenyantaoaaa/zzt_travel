package controller.email;


import com.cyt.music.impl.util.StringUtil;
import com.cyt.music.interfaces.pojo.common.Result;
import com.cyt.music.interfaces.pojo.system.EmailDTO;
import controller.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.email.EmailService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chen on 2017/7/9.
 */
@Controller
@RequestMapping("/email")
public class emilController extends BaseAction{

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/sendemail")
    public @ResponseBody
    Result queryOrderInfo(@RequestBody EmailDTO dto, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Result result = new Result();
        Cookie[] cookies=request.getCookies();
        Cookie sendFlag=getCookieByName(request,"sendFlag");
        String emailAd ="";
        if(StringUtil.isEmpty(dto.getPageFlag())){
            emailAd = "yyyvoyage@gmail.com";
        }else{
            emailAd = "freevel1@163.com";
        }
        if(sendFlag==null) {
            //设置cookie 2分钟允许发送一次email
            Cookie cookie = new Cookie("sendFlag", "sendFlag");
            cookie.setMaxAge(2 * 60);// 设置为2min
            cookie.setPath("/");
            response.addCookie(cookie);
            String title="客户意见反馈";
            StringBuilder emailStr=new StringBuilder();
            emailStr.append("客户名:").append(dto.getName()).append("  ").append("邮箱地址:").append(dto.getEmail()).append("  ")
                    .append("客户电话:").append(dto.getPhone()).append("  ").append("意见内容:").append(dto.getContent());
            String msg = emailService.sendEmail(emailStr.toString(),title,emailAd);
            if(StringUtil.isNotEmptyStr(msg) && msg.equals("fail")){
                //如果发送失败则清除cookie 允许客户再次发送
                cookie.setMaxAge(0);
            }
            result.setMsg(msg);
            return result;
        }else{
            result.setMsg("busy");
            return result;
        }
    }
}

