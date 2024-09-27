package com.MVC;

import com.MVC.DAO.StudentDAOImpl;
import com.MVC.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Configuration

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //Without using spring
        Student student = context.getBean("student", Student.class);
        student.getRollNo();
        student.getName();
        student.getAddress();

        StudentDAOImpl studentDAO = context.getBean("studentDAO", StudentDAOImpl.class);
        studentDAO.insert(student);
    }
}
