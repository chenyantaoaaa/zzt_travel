package service.order;

import com.cyt.music.interfaces.pojo.order.OrderDto;
import com.cyt.music.interfaces.pojo.order.OrderInfo;

import java.util.List;

/**
 * Created by chen on 2017/6/24.
 */
public interface OrderInfoService {
    public List<OrderInfo> queryOrderInfo(OrderDto dto) throws Exception;
}
