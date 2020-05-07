package com.sxbang.friday.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author lhx
 * @date 2020/5/6 10:08
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderFormVO implements Serializable {
    private String orderNum;
    private String orderStatus;
    private String createDate;
    private String phone;
    private String username;
    private BigDecimal money;
    private String detailAddress;
    private String province;
    private String city;
    private String area;
    private String receiver;
    private String status;
}