package com.example.studentapp.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    public final static Model instance=new Model();
    private Model(){
        Student student=new Student();
        student.id="1234";
        student.name="moshe";
        data.add(student);

    }
    List<Student>data=new LinkedList<Student>();

    public List<Student> getAllStudents() {
        return data;
    }

    public void getStudentById(String id) {
    }
}
