package com.jzs.order.dao;

import com.jzs.order.domain.Order;

/**
 * Created by jiangzs@gmail.com on 2017/3/21.
 */
public interface OrderDao {

    Order queryOrderById(Integer id);
}
