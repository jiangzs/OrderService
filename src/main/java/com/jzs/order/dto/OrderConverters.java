package com.jzs.order.dto;

import com.jzs.order.domain.Order;

/**
 * Created by jiangzs@gmail.com on 2017/3/21.
 */
public class OrderConverters {
    public static OrderProtos.OrderDTO asDto(Order order){
        if (order!=null){
            return
            OrderProtos.OrderDTO.newBuilder()
                    .setId(order.getId())
                    .setUid(order.getUid())
                    .setUsername(order.getUserName())
                    .setSupplierid(order.getSupplier())
                    .setSuppliername(order.getSupplierName())
                    .setPrice(order.getPrice())
                    .setDesc(order.getDesc())
                    .build();
        }
        return null;
    }

    public static Order asDomain(OrderProtos.OrderDTO dto){
        return null;
    }


}
