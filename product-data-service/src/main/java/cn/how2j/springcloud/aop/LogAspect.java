package cn.how2j.springcloud.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 */
@Component
@Aspect // 标注为切面
public class LogAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 切入点表达式，表示切入点为控制器包中的所有方法
	@Pointcut("within(cn.how2j.springcloud.controller..*)")
	public void LogAspect() {
	}

	// 切入点之前执行
	@Before("LogAspect()")
	public void doBefore(JoinPoint joinPoint) {
		logger.info("访问时间：{}--访问接口:{}", new Date(), joinPoint.getSignature());
	}
}

