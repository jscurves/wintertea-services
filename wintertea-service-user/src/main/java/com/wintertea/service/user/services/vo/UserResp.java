package com.wintertea.service.user.services.vo;

import lombok.Data;

/**
 * @author woody
 */
@Data
public class UserResp {
    private String uuid;

    private String name;

    private String pass;

    private Boolean state;
}
