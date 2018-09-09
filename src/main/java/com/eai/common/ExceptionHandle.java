package com.eai.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.eai.common.utils.ResultUtil;
import com.eai.compont.Result;

/**
 * 
 * @author xudong.li
 * 异常记录
 * 便于在log中寻找
 */

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result catchFromService(Exception e){
        if(e instanceof BootException){
            BootException bootException = (BootException) e;
            return ResultUtil.error(100,e.getMessage());
        }
        LOGGER.error("【系统异常】{}",e);
        return ResultUtil.error(ExceptionEnum.UNKONW_ERROR);
    }
    
    @ExceptionHandler({ RuntimeException.class })
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView processException(RuntimeException exception) {
    	LOGGER.info("自定义异常处理-RuntimeException");
		ModelAndView m = new ModelAndView();
		m.addObject("roncooException", exception.getMessage());
		m.setViewName("error/error");
		return m;
	}
}
