package homework9;

import homework9.interfaces.Course;
import homework9.interfaces.Student;

import java.util.List;

public class StudentImpl implements Student {
    private String name;
    private List<Course> courses;

    public StudentImpl(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Course> getAllCourses() {
        return this.courses;
    }
}
