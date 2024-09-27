package com.MVC;

import com.MVC.DAO.StudentDAOImpl;
import com.MVC.model.Student;
import com.mysql.cj.xdevapi.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Configuration

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //Without using spring
        Student student = context.getBean("student", Student.class);

        student.getRollNo();
        student.getName();
        student.getAddress();

        //        StudentDAO dao = new StudentDAOImpl();
        StudentDAOImpl studentDAO = context.getBean("studentDAO", StudentDAOImpl.class);
        studentDAO.insert(student);
        SessionFactory sessionFactory = context.getBean("sessionFactory", SessionFactory.class);

        List<Integer> ls = Arrays.asList(1, 10, 2, 39, 32, 120, 2, 4, 3);

        int Sum = ls.stream().reduce(0,Integer::sum);
        System.out.println(Sum);





    }
}
