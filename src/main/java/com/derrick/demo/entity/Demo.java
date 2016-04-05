package com.derrick.demo.entity;

import javax.persistence.*;

/**
 * Created by Derrick on 2016/4/1.
 */
@Entity
@Table(name = "RW_SPLITTER_DEMO", uniqueConstraints = @UniqueConstraint(columnNames = "ID"))
public class Demo {

    private Long id;

    private String name;

    private String position;

    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "POSITION", nullable = true, length = 100)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
