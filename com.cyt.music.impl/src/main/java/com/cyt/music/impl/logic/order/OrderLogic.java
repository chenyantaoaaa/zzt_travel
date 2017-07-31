package com.cyt.music.impl.logic.order;

import com.cyt.music.impl.mapper.Order.OrderInfoMapper;
import com.cyt.music.impl.util.HttpUtil;
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

    public List<OrderInfo> queryOrderInfo(OrderInfo dto){
        return orderInfoMapper.queryOrderInfo(dto);
    }

    public void addOrderInfo(OrderInfo dto) {
        boolean insertFlag = true;
        String tx = dto.getTx();
        List<OrderInfo> allList = orderInfoMapper.queryOrderInfo(dto);
        //一个paypal交易流水号  只对应一个订单 只记录一次
        for (OrderInfo orderInfo : allList) {
            if(tx.equals(orderInfo.getTx())){
                insertFlag  = false;
                break;
            }
        }
        if(insertFlag) {
            orderInfoMapper.insert(dto);
        }
    }

    public String getPayInfo(String url,List<NameValuePair> params) throws Exception{
        String returnInfo = HttpUtil.requestByPostMethod(url,params).substring(0,4);
        System.out.println("returnInfo==========="+returnInfo);
        return returnInfo;
    }
}
