package com.eai.common.utils;

import com.eai.common.ExceptionEnum;
import com.eai.compont.Result;

/**
 * 
 * @author xudong.li
 * resultutil to form the result
 * 结果封装，统一输出结果以及异常
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.getData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static Result error(ExceptionEnum exceptionEnum){
        Result result = new Result();
        result.setCode(exceptionEnum.getCode());
        result.setMsg(exceptionEnum.getMsg());
        result.setData(null);
        return result;
    }
}
