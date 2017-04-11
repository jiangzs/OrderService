package com.jzs.order.service.impl;

import com.jzs.order.dao.OrderDao;
import com.jzs.order.domain.Order;
import com.jzs.order.dto.OrderConverters;
import com.jzs.order.dto.OrderProtos;
import com.jzs.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiangzs@gmail.com on 2017/3/21.
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public OrderProtos.OrderDTO queryOrderById(Integer id) {
        log.info("id:{}",id);
        Order order = orderDao.queryOrderById(id);
        return OrderConverters.asDto(order);
    }
}
