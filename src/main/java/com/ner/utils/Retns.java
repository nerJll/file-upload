package com.ner.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc 封装返回数据
 * @date 2018/3/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Retns implements java.io.Serializable {
    private int states;
    private String msg;
    private Object data;

    public static Retns success(String msg, Object data) {
        Retns retns = new Retns();
        retns.setStates(1);
        retns.setMsg(msg);
        retns.setData(data);
        return retns;
    }

    public static Retns fail(String msg, Object data) {
        Retns retns = new Retns();
        retns.setStates(0);
        retns.setMsg(msg);
        retns.setData(data);
        return retns;
    }
}
