package com.cyt.music.impl.service.order;

import com.cyt.music.impl.logic.order.OrderLogic;
import com.cyt.music.interfaces.pojo.order.OrderInfo;
import org.apache.http.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.order.OrderInfoService;

import java.util.List;

/**
 * Created by chen on 2017/6/24.
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderLogic orderLogic;

    @Override
    public List<OrderInfo> queryOrderInfo(OrderInfo dto) throws Exception {
        return orderLogic.queryOrderInfo(dto);
    }

    @Override
    public void addOrderInfo(OrderInfo dto) throws Exception {
        orderLogic.addOrderInfo(dto);
    }

    @Override
    public String getPayInfo(String url,List<NameValuePair> params) throws Exception{
        return orderLogic.getPayInfo(url,params);
    }
}
