package com.capstone.healthcare.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DelFlagEnum {
    NOT_DEL(0,"No deleted"),
    DEL(1,"Deleted"),




    ;

    private final Integer code;
    private final String message;

}
