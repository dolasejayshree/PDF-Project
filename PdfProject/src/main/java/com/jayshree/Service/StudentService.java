package com.jayshree.Service;

import java.util.List;

import com.jayshree.Entity.Student;

public interface StudentService  {

	
	public Student getByid(Integer id);
	
		List<Student> getByMore10k();

	List<Student> getBysurname(String surname);

	List<Student> getByname(String name);

	void deleteAllStd();

	void updateStdById(Integer id, String name, String surname, String address, Integer fees);

	void deleteStdById(Integer id);

	void saveAll(List<Student> stdlist);

	void save(Student student);

	List<Student> getAll();

	List<Student> getByFeesFromUser(Integer fees);
	
}
