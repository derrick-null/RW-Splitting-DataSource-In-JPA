package com.derrick.foundation;

import org.slf4j.LoggerFactory;

/**
 * Created by Derrick on 2016/4/1.
 */
public class DatasourceProvider {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(DatasourceProvider.class.getName());

    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<DataSourceType>();

    public static void setDataSourceType(DataSourceType dataSourceType) {
        if(dataSourceType == null){
            throw new NullPointerException();
        }
        contextHolder.set(dataSourceType);
        LOG.debug("dataSourceType:" + dataSourceType);
    }

    public static DataSourceType getDataSourceType() {
        return (DataSourceType) contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }
}
