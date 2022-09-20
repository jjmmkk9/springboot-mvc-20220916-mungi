package com.boot.mvc20220916mungi.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDataDto {
    private String value1;
    private boolean value2;
    private int value3;
}
