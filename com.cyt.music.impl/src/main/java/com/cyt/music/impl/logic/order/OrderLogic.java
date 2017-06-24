package com.cyt.music.impl.logic.order;

import com.cyt.music.impl.mapper.order.OrderInfoMapper;
import com.cyt.music.interfaces.pojo.order.OrderDto;
import com.cyt.music.interfaces.pojo.order.OrderInfo;
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
}
