package com.example.demo.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Student;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass());

	@GetMapping("/students")
	public List<Student> readAll() {
		LOG.info("Request to display all students");
		return this.studentRepository.findAll();
	}

	@GetMapping("/students/{id}")
	public Student readOne(@PathVariable Long id) {
		LOG.info("Request to display one student with ID " + id);
		Optional<Student> optional = this.studentRepository.findById(id);
		Student student = optional.get();
		return student;
	}

	@PostMapping("/students")
	public Student saveOne(@Valid @RequestBody Student student) {
		LOG.info("Request to save one student");
		return this.studentRepository.save(student);
	}

	@DeleteMapping("/students/{id}")
	public void deleteOne(@PathVariable Long id) {
		LOG.info("Request to delete one student");
		if (this.studentRepository.findById(id) != null) {
			this.studentRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Could not find the desired resource");
		}
	}

	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateOne(@PathVariable Long id, @RequestBody Student updatedStudent) {
		LOG.info("Request to update one student");
		List<Student> students = this.studentRepository.findAll();
		for (Student student : students) {
			if (student.getId() == id) {
				student.setName(updatedStudent.getName());
				student.setStandard(updatedStudent.getStandard());
				student.setSection(updatedStudent.getSection());
				return ResponseEntity.ok(this.studentRepository.save(student));
			}
		}
		return null;

	}

}
