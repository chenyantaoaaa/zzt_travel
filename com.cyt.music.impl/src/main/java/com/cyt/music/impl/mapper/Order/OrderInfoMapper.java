package com.cyt.music.impl.mapper.Order;


import com.cyt.music.interfaces.pojo.order.OrderDto;
import com.cyt.music.interfaces.pojo.order.OrderInfo;

import java.util.List;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    List<OrderInfo> queryOrderInfo(OrderDto orderDto);
}