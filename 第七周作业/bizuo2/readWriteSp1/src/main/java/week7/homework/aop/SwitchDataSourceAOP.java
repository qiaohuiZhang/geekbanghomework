package week7.homework.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import week7.homework.config.DataSourceContextHandler;

@Aspect
@Component
@Lazy(false)
@Order(0) // Order设定AOP执行顺序 使之在数据库事务上先执行
public class SwitchDataSourceAOP {

    @Before("execution(* week7.homework.service.*.*(..))")
    public void process(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        if (methodName.startsWith("get") || methodName.startsWith("count") || methodName.startsWith("find")
                || methodName.startsWith("list") || methodName.startsWith("select") || methodName.startsWith("check")) {
            // 读
            DataSourceContextHandler.setDbType("selectDataSource");
        } else {
            // 写
            DataSourceContextHandler.setDbType("updateDataSource");
        }
    }
}