package com.MVC.DAO;

import com.MVC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO{
    //Without use of Spring
    //private JdbcTemplate template = new JdbcTemplate(getDataSource());

    private JdbcTemplate jdbcTemplate;

    // I need to have a setter method for setter injection in beans
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void insert(Student student) {
        //logic of insert
        String sql = "INSERT INTO Students VALUES(?, ?, ?)";
        Object[] arg = {student.getRollNo(), student.getName(), student.getAddress()};
        int totAffected = jdbcTemplate.update(sql, arg);
        System.out.println("No of Rows Affected: " + totAffected);
    }





}
