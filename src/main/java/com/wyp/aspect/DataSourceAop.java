package com.wyp.aspect;

import com.wyp.config.DBContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.wyp.annotation.Master) " +
            "&& (execution(* com.wyp.service..*.query*(..)) " +
            "|| execution(* com.wyp.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.wyp.annotation.Master) " +
            "|| execution(* com.wyp.service..*.insert*(..)) " +
            "|| execution(* com.wyp.service..*.add*(..)) " +
            "|| execution(* com.wyp.service..*.update*(..)) " +
            "|| execution(* com.wyp.service..*.edit*(..)) " +
            "|| execution(* com.wyp.service..*.delete*(..)) " +
            "|| execution(* com.wyp.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.wyp.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}