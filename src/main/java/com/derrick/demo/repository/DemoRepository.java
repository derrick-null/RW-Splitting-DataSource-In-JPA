package com.derrick.demo.repository;

import com.derrick.demo.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Derrick on 2016/4/1.
 */

public interface DemoRepository extends JpaRepository<Demo, Long> {

}
