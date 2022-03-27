package servicebase.exceptionhandler;

import com.czf.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j //日志
@ControllerAdvice
public class GlobalExceptionHandler { //全局异常处理类

    @ExceptionHandler(Exception.class) //指定了什么异常执行这个方法
    @ResponseBody//为了返回数据
    public R error(Exception e){
        e.printStackTrace();
        log.error(e.getMessage()); //输出到日志
        return R.error().message("执行了全局异常处理...");
    }

    //特定异常处理
    //自定义异常处理



}
