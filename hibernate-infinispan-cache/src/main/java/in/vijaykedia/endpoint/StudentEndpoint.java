package in.vijaykedia.endpoint;

import in.vijaykedia.dao.Student;
import in.vijaykedia.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentEndpoint {
  private final StudentRepository repository;

  @Autowired
  public StudentEndpoint(final StudentRepository repository) {
    this.repository = repository;
  }

  @PostMapping("/save")
  public Student saveStudent(@RequestBody final Student student) {
    return repository.save(student);
  }

  @GetMapping("/get/{id}")
  public Optional<Student> getStudentById(@PathVariable("id") final int id) {
    return repository.findById(id);
  }

  @GetMapping("/list")
  public List<Student> getAllStudents() {
    return repository.findAll();
  }
}
