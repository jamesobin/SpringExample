package com.jamesobin.spring.ex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jamesobin.spring.ex.jpa.domain.Student;
import com.jamesobin.spring.ex.jpa.repository.StudentRepository;
import com.jamesobin.spring.ex.jpa.service.StudentService;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	// 절대 Controller에서 Repository 활용 금지
	// 임시로 사용하는 것
	@Autowired
	private StudentRepository studentRepository;

	// create, update, delete
	// 한 학생의 정보 저장 기능
	@ResponseBody
	@GetMapping("/create")
	public Student createStudent() {
		// 김인규, 010-1234-5678, lecture@hagulu.com, 개발자
		Student student = studentService.addStudent("김인규", "010-1234-5678", "lec@hagulu.com", "개발자");
		
		return student;
	}
	
	@ResponseBody
	@GetMapping("/update")
	public Student updateStudent() {
		//id가 3인 학생 장래희망을 강사로 변경
		Student student = studentService.updateStudent(3,  "강사");
		
		return student;
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public String deleteStudent() {
		// id가 3인 학생정보 삭제
		studentService.deleteStudent(3);
		
		return "삭제!!";
	}
	
	@ResponseBody
	@GetMapping("/find")
	public List<Student> findStudent() {
		List<Student> studentList = null;
		// 모든 행 조회
//		List<Student> studentList = studentRepository.findAll();
		
		// 모든 행을 id 컬럼 내림 차순으로 조회
//		studentList = studentRepository.findAllByOrderByIdDESC();
		
//		studentList = studentRepository.findTop2ByOrderByIdDESC();
		
//		studentList = studentRepository.findByName("김인규");
		
		List<String> nameList = new ArrayList<>();
		nameList.add("유재석");
		nameList.add("조세호");
//		
//		studentList = studentRepository.findByNameIn(nameList);
		
//		studentList = studentRepository.findByEmailContaining("gmail");
		
//		studentList = studentRepository.findByIdBetweenOrderByIdDesc(2, 5);
		
		studentList = studentRepository.selectByDreamJob("모델");
		
		return studentList;
	}

	@ResponseBody
	@GetMapping("/lombok")
	public Student lombokTest() {
//		Student student = new student(1, "김인규", "010-1234-5678", "lecture@hagulu.com", "개발자", null, null);
//		student.setName("김인규");
//		student.setEmail("lecture@hagulu.com");
//		student.setPhoneNumber("010-1234-5678");
		
		// builder 패턴
		Student student = Student.builder()
			.name("김인규")
			.email("lecture@hagulu.com")
			.phoneNumber("010-1234-5678").build();

		return student;
	}
	
}
