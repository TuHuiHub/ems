package com.dream.ems.advice;
import java.util.Arrays;
import java.util.Date;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dream.ems.po.OperationLog;
import com.dream.ems.service.OperationLogService;
@Component
public class OperationLogAdvice implements MethodInterceptor{
	@Autowired
	private OperationLogService operationLogService;
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		OperationLog log = new OperationLog(); 
		log.setClazz(mi.getThis().getClass().getName());
		log.setMethod(mi.getMethod().getName());
		log.setArgs(Arrays.toString(mi.getArguments()));
		log.setCreateTime(new Date());
		log.setCreateTimeLong(log.getCreateTime().getTime());
		this.operationLogService.save(log);
		Object re = mi.proceed();
		return re;
	}
}
