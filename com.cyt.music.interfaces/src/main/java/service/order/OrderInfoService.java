package service.order;

import com.cyt.music.interfaces.pojo.order.OrderInfo;
import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Created by chen on 2017/6/24.
 */
public interface OrderInfoService {
    public List<OrderInfo> queryOrderInfo(OrderInfo dto) throws Exception;

    public void addOrderInfo(OrderInfo dto) throws Exception;

    public String getPayInfo(String url,List<NameValuePair> params) throws Exception;
}
