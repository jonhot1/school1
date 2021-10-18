package pt.iade.school1.controller;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.school1.models.Student;
import pt.iade.school1.models.repository.StudentRepository;
import pt.iade.school1.models.exceptions.NotFoundException;


@RestController 
@RequestMapping(path="/api/students") 
public class StudentController { 
    private Logger logger = LoggerFactory.getLogger(StudentController.class); 
     
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE) 
    public List<Student> getStudents() {
        logger.info("Sending all students.");
        return StudentRepository.returnStudents();
    }
    @GetMapping(path = "{number}", 
    produces= MediaType.APPLICATION_JSON_VALUE) 
    public Student getStudent(@PathVariable("number") int number) throws NotFoundException {
        logger.info("Student by number"+number);
        Student student = StudentRepository.getStudentByNumber(number);
        if (student != null) return student; 
        else throw new NotFoundException(""+number, "Student", "number");
    }
    @DeleteMapping(path = "{number}", 
    produces= MediaType.APPLICATION_JSON_VALUE) 
    public Response deleteStudent(@PathVariable("number") int number) { 
        logger.info("deleting student with number."+number);
        if (StudentRepository.deleteStudent(number)) 
          return new Response(number+" was deleted.",null); 
        else return new Response(number+" not found.",null); 
    }
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student addStudent(@RequestBody Student student) {
        StudentRepository.addStudent(student);
        logger.info("adding student.");
        return student;
    }
}