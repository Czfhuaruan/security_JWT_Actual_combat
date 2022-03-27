package com.czf.commonutils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R { //统一返回的前端的数据类型

    private Boolean success; //是否成功
    private Integer code; //返回码
    private String message; //返回消息
    private Map<String,Object> data = new HashMap<>(); //返回数据

    private R(){} //构造方法私有化

    public static R ok(){ //成功的静态方法
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }
    public static R error(){ //失败的静态方法
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }
    public R message(String message){
        this.setMessage(message);
        return this;
    }
    public R code(Integer code){
        this.setCode(code);
        return this;
    }
    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }
    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
