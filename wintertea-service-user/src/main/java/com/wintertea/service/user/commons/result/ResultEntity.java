package com.wintertea.service.user.commons.result;

import lombok.Data;

@Data
public class ResultEntity {
    private int code = 200;
    private String message;
    private String errMessage;
    private Object entity;
}
