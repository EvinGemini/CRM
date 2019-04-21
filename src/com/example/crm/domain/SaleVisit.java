package com.example.crm.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class SaleVisit {
//    `visit_id` varchar(32) NOT NULL,
//    `visit_cust_id` bigint(32) DEFAULT NULL COMMENT '客户id',
//    `visit_user_id` bigint(32) DEFAULT NULL COMMENT '负责人id',
//    `visit_time` datetime DEFAULT NULL COMMENT '拜访时间',
//    `visit_addr` varchar(128) DEFAULT NULL COMMENT '拜访地点',
//    `visit_detail` varchar(256) DEFAULT NULL COMMENT '拜访详情',
//    `visit_nexttime` date DEFAULT NULL COMMENT '下次拜访时间',
    private String visit_id;
    private Date visit_time;
    private String visit_addr;
    private String visit_detail;
    private Date visit_nexttime;
    private User user;
    private Customer customer;


}
