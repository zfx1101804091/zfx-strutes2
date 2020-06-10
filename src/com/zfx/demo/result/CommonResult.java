package com.zfx.demo.result;

/**
 * @description:
 * @author: zheng-fx
 * @time: 2020/6/11 0011 00:17
 */
public class CommonResult {
    
    private Integer code;
    private String msg;
    private Object data;

    public CommonResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public CommonResult() {
    }
    
    public CommonResult success (String msg,Object data){
        this.code = 200;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public CommonResult fail (String msg,Object data){
        this.code = 200;
        this.msg = msg;
        this.data = data;
        return this;
    }
}
