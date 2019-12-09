package com.bluedon.common.utils;

import com.bluedon.common.exception.RRException;
import lombok.Data;

/**
 * 自定义返回类
 */
@Data
public class Return {
    private int code;
    private Object data;
    private String msg;

    public static void error(Object data, String msg) {
        Return r = new Return();
        r.setCode(500);
        r.setData(data);
        r.setMsg(msg);
        throw new RRException(r);
    }

    public static Return error() {
        Return r = new Return();
        r.setCode(500);
        r.setMsg("error");
        return r;
    }


    public static Return success() {
        Return r = new Return();
        r.setCode(200);
        r.setMsg("success");
        return r;
    }

    public static Return success(Object data) {
        Return r = new Return();
        r.setCode(200);
        r.setData(data);
        r.setMsg("success");
        return r;
    }


}