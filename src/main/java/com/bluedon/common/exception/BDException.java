package com.bluedon.common.exception;

import com.bluedon.common.utils.Result;
import lombok.Data;

/**
 * @date: 2019/12/13 11:26
 * @author: hhong
 * @description: 自定义异常
 **/
@Data
public class BDException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Result r;

    public BDException(Result r) {
        this.r = r;
    }


}
