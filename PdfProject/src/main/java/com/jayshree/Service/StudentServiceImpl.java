package com.jayshree.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayshree.Entity.Student;
import com.jayshree.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
    private StudentRepository stdrepo;
	@Override
	public Student getByid(Integer id) {
		Student student = stdrepo.findById(id).orElse(null);
 		return student;
	}

	@Override

	public List<Student> getAll() {
		List<Student> stdList =  stdrepo.findAll();
		return stdList;
	}

	@Override
	public void save(Student student) {

		stdrepo.save(student);		
	}

	@Override
	public void saveAll(List<Student> stdlist) {

		stdrepo.saveAll(stdlist);		
	}

	@Override
	public void updateStdById(Integer id, String name, String surname, String address, Integer fees) {
		Student student = stdrepo.findById(id).orElse(null);
		student.setName(name);
		student.setSurname(surname);
		student.setAddress(address);
		student.setFees(fees);
		
	}

	@Override
	public void deleteStdById(Integer id) {

		stdrepo.deleteById(id);		
	}

	@Override
	public void deleteAllStd() {

		stdrepo.deleteAll();		
	}

	@Override
	public List<Student> getByname(String name) {
		List<Student> stdlist = stdrepo.findByName(name);
		return stdlist;
	}

	@Override
	public List<Student> getBysurname(String surname) {
		List<Student> stdlist = stdrepo.findBySurname(surname);
	return stdlist;
	}

	@Override
	public List<Student> getByMore10k() {
		List<Student> stdlist = stdrepo.findBy10k();
	return stdlist;
	}

	@Override
	public List<Student> getByFeesFromUser(Integer fees) {
		List<Student>	stdlist =stdrepo.findByFees(fees);
	return stdlist;
	}

//	@Override
//	public List<Student> findAll() {
//	List<Student> stdlist = stdrepo.findAll();
//		
//		return stdlist;
//	}



}
