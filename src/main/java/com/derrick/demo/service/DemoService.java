package com.derrick.demo.service;

import com.derrick.demo.entity.Demo;
import com.derrick.demo.repository.DemoRepository;
import com.derrick.foundation.DataSourceType;
import com.derrick.foundation.DatasourceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Derrick on 2016/4/1.
 */
@Service
public class DemoService {

    @Autowired
    DemoRepository demoRepository;

    @Transactional
    public void save(Demo entity){
        try{
            DatasourceProvider.setDataSourceType(DataSourceType.WRITE_ONLY);
            demoRepository.save(entity);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DatasourceProvider.clearDataSourceType();
        }
    }

    @Transactional(readOnly = true)
    public Demo find(Long id){
        Demo demo = null;
        try{
            DatasourceProvider.setDataSourceType(DataSourceType.READ_ONLY);
            demo = demoRepository.findOne(id);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DatasourceProvider.clearDataSourceType();
        }
        return demo;
    }

}
