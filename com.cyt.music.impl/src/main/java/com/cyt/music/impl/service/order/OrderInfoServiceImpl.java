package com.cyt.music.impl.service.order;

import com.cyt.music.impl.logic.order.OrderLogic;
import com.cyt.music.interfaces.pojo.order.OrderDto;
import com.cyt.music.interfaces.pojo.order.OrderInfo;
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
    public List<OrderInfo> queryOrderInfo(OrderDto dto) throws Exception {
        return orderLogic.queryOrderInfo(dto);
    }
}
