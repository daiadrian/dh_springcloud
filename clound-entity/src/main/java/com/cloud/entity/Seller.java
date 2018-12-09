package com.cloud.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Seller implements Serializable {

    private Long id;
    private Long dealerId;
    private String sellerPhone;
    private String sellerName;
    private Date createDate;
    private Date updateDate;
    private String updateBy;

}
