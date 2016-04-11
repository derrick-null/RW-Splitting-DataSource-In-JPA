package com.derrick.foundation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccc on 2016/4/11.
 */
public class DataSourceRouterInterceptor {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(DatasourceProvider.class.getName());
    // 方法名的前缀
    private List<String> methodNamePrefixes = new ArrayList<String>();

    public void before(JoinPoint point) {
        LOG.info("@Before：目标方法为：" +
                point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        if (isQueryMethod(point)) {
            DatasourceProvider.setDataSourceType(DataSourceType.READ_ONLY);
        } else {
            DatasourceProvider.setDataSourceType(DataSourceType.WRITE_ONLY);
        }

    }

    public void after() {
        DatasourceProvider.clearDataSourceType();
    }

    /**
     * 判断是否是查询方法
     *
     * @param point 方法调用
     * @return 是否是查询方法
     */
    private boolean isQueryMethod(JoinPoint point) {
        // 如果不指定prefix，则默认是查询
        if (methodNamePrefixes.isEmpty()) {
            return true;
        }
        // 如果方法名和前缀列表相符
        String methodName = point.getSignature().getName();
        for (String methodNamePrefix : methodNamePrefixes) {
            if (methodName.startsWith(methodNamePrefix)) {
                return true;
            }
        }
        //不是查询方法
        return false;
    }

    /**
     * 设置方法名前缀集合
     *
     * @param methodNamePrefixes 方法名前缀集合
     */
    public void setMethodNamePrefixes(List<String> methodNamePrefixes) {
        this.methodNamePrefixes = methodNamePrefixes;
    }
}
