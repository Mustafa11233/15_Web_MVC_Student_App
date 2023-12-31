package in.ashokit.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.Student;
import in.ashokit.entity.StudentEntity;
import in.ashokit.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;
	
	
	public boolean saveStudent(Student student) {
		
		System.out.println(student);
		StudentEntity entity =new StudentEntity();
		//datatypes & variables should match
		BeanUtils.copyProperties(student, entity);
		
		//Converting Arrays value into String format
		entity.setTimings(Arrays.toString(student.getTimings()));
		
		System.out.println(entity);
		
		
		repo.save(entity);
		
		return true;
		
	}
	
	public List<String> getCourses(){
		return Arrays.asList("Java","Phython","AWS","DevOps");
		
	}
	public List<String> getTimings(){
		return Arrays.asList("Morning","Afternoon","Evening");
	}

}
