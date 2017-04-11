package com.jzs.order.service;

import com.jzs.order.dto.OrderProtos;

/**
 * Created by jiangzs@gmail.com on 2017/3/21.
 */
public interface OrderService {

    OrderProtos.OrderDTO queryOrderById(Integer id);
}
