package homework9;

import homework9.interfaces.Course;
import homework9.interfaces.Student;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Course maths = new CourseImpl("Математика");
        Course physics = new CourseImpl("Физика");
        Course history = new CourseImpl("История");
        Course biology = new CourseImpl("Биология");

        List<Student> students = new ArrayList<>();
        students.add(new StudentImpl("Пётр", Arrays.asList(maths)));
        students.add(new StudentImpl("Анна", Arrays.asList(physics, biology)));
        students.add(new StudentImpl("Фёдор", Arrays.asList(history, physics, maths, biology)));
        students.add(new StudentImpl("Настя", Arrays.asList(history, physics)));
        students.add(new StudentImpl("Антон", Arrays.asList(history, physics, maths, biology)));
        students.add(new StudentImpl("Марат", Arrays.asList(maths, history, biology)));

        getUniqueCourses(students);
        getCuriousStudent(students);
        getStudentsByCourses(students, biology);
    }

    /**
     * Получение уникальных курсов студентов
     * **/
    public static List<Course> getUniqueCourses(List<Student> students) {
        students = students == null ? new ArrayList<>() : students;

        return students.stream()
                .map(Student::getAllCourses)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Получение трех любопытных студентов.
     * **/
    public static List<Student> getCuriousStudent(List<Student> students) {
        students = students == null ? new ArrayList<>() : students;

        return students.stream()
                .filter(Objects::nonNull)
                .sorted((o1, o2) -> {
                    List<Course> c1 = o1.getAllCourses();
                    List<Course> c2 = o2.getAllCourses();
                    return Integer.compare(
                            c2 == null ? 0 : c2.size(),
                            c1 == null ? 0 : c1.size()
                    );
                })
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * Получение студентов курсу.
     * **/
    public static List<Student> getStudentsByCourses(List<Student> students, Course course) {
        if (course == null) {
            return new ArrayList<>();
        }

        students = students == null ? new ArrayList<>() : students;

        return students.stream()
                .filter(student -> student.getAllCourses() != null && student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }
}