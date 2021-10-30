package pt.iade.school1.models.repository;

import pt.iade.school1.models.Person;
import pt.iade.school1.models.Student;
import pt.iade.school1.models.Teacher;

import java.util.ArrayList;
import java.util.Collection;

public class TeacherRepository {
    private static ArrayList<Teacher> teachers =  new ArrayList<Teacher>();
    public static Collection<? extends Person> getTeachers() {
        return teachers;
    }
}
