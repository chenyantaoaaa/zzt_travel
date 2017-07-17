package com.cyt.music.impl.logic.order;

import com.cyt.music.impl.mapper.Order.OrderInfoMapper;
import com.cyt.music.impl.util.HttpUtil;
import com.cyt.music.interfaces.pojo.order.OrderDto;
import com.cyt.music.interfaces.pojo.order.OrderInfo;
import org.apache.http.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chen on 2017/6/24.
 */
@Component
public class OrderLogic {
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    public List<OrderInfo> queryOrderInfo(OrderDto dto){
        return orderInfoMapper.queryOrderInfo(dto);
    }

    public void addOrderInfo(OrderInfo dto) {
        orderInfoMapper.insert(dto);
    }

    public String getPayInfo(String url,List<NameValuePair> params) throws Exception{
        String returnInfo = HttpUtil.requestByPostMethod(url,params).substring(0,4);
        System.out.println("returnInfo==========="+returnInfo);
        return returnInfo;
    }
}
