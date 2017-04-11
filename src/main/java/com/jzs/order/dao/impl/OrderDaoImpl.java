package com.jzs.order.dao.impl;

import com.jzs.order.dao.OrderDao;
import com.jzs.order.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by jiangzs@gmail.com on 2017/3/21.
 */
@Component
@Slf4j
public class OrderDaoImpl implements OrderDao {

    @Override
    public Order queryOrderById(Integer id) {
        log.info("id:{}",id);
        if(id<10){
            Order o=new Order();
            o.setId(id);
            o.setUid(id * 10);
            o.setUserName("username");

            o.setSupplier(11);
            o.setSupplierName("supplierName");

            o.setPrice(111);
            o.setDesc("DESCCCCCCCCC");

            return o;
        }else{
            return null;
        }
    }
}
