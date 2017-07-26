package controller.order;

import com.cyt.music.interfaces.pojo.common.PageResultForBootstrap;
import com.cyt.music.interfaces.pojo.order.OrderDto;
import com.cyt.music.interfaces.pojo.order.OrderInfo;
import com.cyt.music.interfaces.pojo.order.PayInfo;
import com.cyt.music.interfaces.pojo.order.PayRes;
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
    PageResultForBootstrap queryOrderInfo(@RequestBody OrderDto dto) throws Exception {
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
        String url="https://www.sandbox.paypal.com/cgi-bin/webscr";
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        list.add(new BasicNameValuePair("amt",payInfo.getAmt()));
        list.add(new BasicNameValuePair("cc", payInfo.getCc()));
        list.add(new BasicNameValuePair("item_name", payInfo.getItem_name()));
        list.add(new BasicNameValuePair("st", payInfo.getSt()));
        list.add(new BasicNameValuePair("tx", payInfo.getTx()));
        list.add(new BasicNameValuePair("at", "WivpNtUYlYsV6h7socwoaRGguEL19Uu541QR81dK0k-EBHobEBSMx7XIK28"));
        list.add(new BasicNameValuePair("cmd", "_notify-synch"));
        String returnMsg = orderInfoService.getPayInfo(url,list);
        payRes.setInfo(returnMsg);
        return  payRes;
    }

    @RequestMapping(value = "/saveCustomInfo")
    public void saveCustomInfo(@RequestBody OrderDto dto, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Cookie cookieN = new Cookie("name", dto.getName());
        Cookie cookieP = new Cookie("phone", dto.getPhone());
        cookieN.setMaxAge(30 * 60);// 设置为30min
        cookieN.setPath("/");
        cookieP.setMaxAge(30 * 60);// 设置为30min
        cookieP.setPath("/");
        response.addCookie(cookieN);
        response.addCookie(cookieP);
    }
}
