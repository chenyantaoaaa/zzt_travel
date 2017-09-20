package controller.order;

import com.cyt.music.interfaces.pojo.common.PageResultForBootstrap;
import com.cyt.music.interfaces.pojo.common.Result;
import com.cyt.music.interfaces.pojo.order.OrderInfo;
import com.cyt.music.interfaces.pojo.order.PayInfo;
import com.cyt.music.interfaces.pojo.order.PayRes;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.order.OrderInfoService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/6/24.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderInfoService orderInfoService;

    @RequestMapping(value = "/queryOrderInfo")
    public @ResponseBody
    PageResultForBootstrap queryOrderInfo(@RequestBody OrderInfo dto) throws Exception {
        List<OrderInfo> list=orderInfoService.queryOrderInfo(dto);
        PageResultForBootstrap pageResultForBootstrap = new PageResultForBootstrap();
        pageResultForBootstrap.setRows(list);
        return pageResultForBootstrap;
    }

    @RequestMapping(value = "/addOrderInfo")
    public void addOrderInfo(@RequestBody OrderInfo dto) throws Exception {
        orderInfoService.addOrderInfo(dto);
    }

    @RequestMapping(value = "/getPayInfo")
    public @ResponseBody PayRes addOrderInfo(@RequestBody PayInfo payInfo) throws Exception {
        PayRes payRes = new PayRes();
//        String url="https://www.sandbox.paypal.com/cgi-bin/webscr";
        String url="https://www.paypal.com/cgi-bin/webscr";
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        String at = "CCs8kTCxktMBax3Oy3KvhNzzujMtBEZdyiYPxjhuKtn1SQMQvddpyt0Lgr0";
        list.add(new BasicNameValuePair("amt",payInfo.getAmt()));
        list.add(new BasicNameValuePair("cc", payInfo.getCc()));
        list.add(new BasicNameValuePair("item_name", payInfo.getItem_name()));
        list.add(new BasicNameValuePair("st", payInfo.getSt()));
        list.add(new BasicNameValuePair("tx", payInfo.getTx()));
        list.add(new BasicNameValuePair("at", at));
        list.add(new BasicNameValuePair("cmd", "_notify-synch"));
        System.out.println(at);
        String returnMsg = orderInfoService.getPayInfo(url,list);
        OrderInfo dto=new OrderInfo();
        if("SUCC".equals(returnMsg)){//如果付款成功 则记入客户填写的信息
            BeanUtils.copyProperties(dto,payInfo);
            dto.setTarget("Zhangjiajie");
            orderInfoService.addOrderInfo(dto);
        }
        payRes.setInfo(returnMsg);
        return  payRes;
    }

    @RequestMapping(value = "/saveCustomInfo")
    public @ResponseBody
    Result saveCustomInfo(@RequestBody OrderInfo dto, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Result result = new Result();
        Cookie cookieN = new Cookie("name", dto.getName());
        Cookie cookieP = new Cookie("phone", dto.getPhone());
        Cookie cookieE = new Cookie("email", dto.getEmail());
       Cookie cookieM = new Cookie("moneySum", dto.getMoneySum());
        Cookie cookiePA = new Cookie("passport", dto.getPassport());
        Cookie cookiePE = new Cookie("personNum", dto.getPersonNum());
        Cookie cookieTT = new Cookie("schedule", dto.getSchedule());
        Cookie cookieR = new Cookie("roomType", dto.getRoomType());
        cookieN.setMaxAge(30 * 60);// 设置为30min
        cookieN.setPath("/");
        cookieP.setMaxAge(30 * 60);// 设置为30min
        cookieP.setPath("/");
        cookieE.setMaxAge(30 * 60);// 设置为30min
        cookieE.setPath("/");
        cookieM.setMaxAge(30 * 60);// 设置为30min
        cookieM.setPath("/");
        cookiePA.setMaxAge(30 * 60);// 设置为30min
        cookiePA.setPath("/");
        cookiePE.setMaxAge(30 * 60);// 设置为30min
        cookiePE.setPath("/");
        cookieR.setMaxAge(30 * 60);// 设置为30min
        cookieR.setPath("/");
        cookieTT.setMaxAge(30 * 60);// 设置为30min
        cookieTT.setPath("/");
        response.addCookie(cookieN);
        response.addCookie(cookieP);
        response.addCookie(cookieE);
        response.addCookie(cookieM);
        response.addCookie(cookiePA);
        response.addCookie(cookiePE);
        response.addCookie(cookieR);
        response.addCookie(cookieTT);
        result.setMsg("succ");
        return result;
    }
}
