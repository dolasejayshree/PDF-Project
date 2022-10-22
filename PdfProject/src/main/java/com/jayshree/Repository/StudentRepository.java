package com.jayshree.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository ;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jayshree.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository  <Student,Integer>{

	public List<Student> findByName(String name);
	
	public List<Student> findBySurname(String surname);
	
	@Query(value ="select * from Student Where  fees >10000",  nativeQuery=true)
	public List<Student> findBy10k();
	
	@Query(value ="select * from Student Where fees>=:fees",nativeQuery=true)
	public List<Student> findByFees(Integer fees);
}
