package com.wintertea.service.user.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WinterTeaException extends Exception {

    private int code;
    private String message;
}
