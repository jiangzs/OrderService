package com.jzs.order.domain;

import lombok.Data;

/**
 * Created by jiangzs@gmail.com on 2017/3/21.
 */
@Data
public class Order {
    private Integer id;

    private Integer uid;
    private String userName;

    private Integer supplier;
    private String supplierName;

    private Integer price;
    private String desc;
}
