package com.derrick.foundation;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by Derrick on 2016/4/1.
 */
public class DatasourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DatasourceProvider.getDataSourceType();
    }
}
