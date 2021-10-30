package pt.iade.school1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.school1.models.Person;
import pt.iade.school1.models.repository.StudentRepository;
import pt.iade.school1.models.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/api/people")
public class PersonController {
    private Logger logger = LoggerFactory.getLogger(StudentController.class);
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPersons() {
        logger.info("Sending all persons");
        ArrayList<Person> persons = getPeople();
        return persons;
    }

    private ArrayList<Person> getPeople() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.addAll(StudentRepository.returnStudents());
        persons.addAll(TeacherRepository.getTeachers());
        return persons;
    }
    @GetMapping(path = "/search",
            produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Person> searchPersons(
            @RequestParam(value = "name",defaultValue="") String name,
            @RequestParam(value = "email",defaultValue="") String email) {
        ArrayList<Person> persons = getPeople();
        persons.removeIf(
                (p) -> !(p.getName().contains(name) &&
                        p.getEmail().contains(email)));
        return persons;
    }
}
