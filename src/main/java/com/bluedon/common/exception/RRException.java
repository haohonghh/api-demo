package com.bluedon.common.exception;

import com.bluedon.common.utils.Return;
import lombok.Data;

/**
 * 自定义异常
 */
@Data
public class RRException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Return r;

    public RRException(Return r) {
        this.r = r;
    }


}
