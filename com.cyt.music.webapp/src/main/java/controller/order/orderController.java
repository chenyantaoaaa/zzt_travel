package controller.order;

import com.cyt.music.interfaces.pojo.common.PageResultForBootstrap;
import com.cyt.music.interfaces.pojo.order.OrderDto;
import com.cyt.music.interfaces.pojo.order.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.order.OrderInfoService;

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
}
