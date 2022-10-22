package com.jayshree;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jayshree.Entity.Student;
import com.jayshree.Service.StudentServiceImpl;

@SpringBootApplication
public class PdfProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PdfProjectApplication.class, args);
		  StudentServiceImpl stdimpl  =  context.getBean(StudentServiceImpl.class);
		  Student student = new Student ("Anil","Sudsare","Amravati",50000);
			Student student1 = new Student ("Rupali","Karule","Pune",51000);
			Student student2 = new Student ("Pratiksha","date","Nashik",60000);
			Student student3 = new Student ("Rohit","Sarnagat","Pune",70000);
			Student student4 = new Student ("Vikas","Zirape","Shevgaon",50000);
			Student student5 = new Student ("Vaibhav","Zirape","Shevgaon",120000);
			Student student6 = new Student ("Vijay","Zirape","Shevgaon",50000);
			Student student7 = new Student ("Vipul","Zirape","Shevgaon",80000);
			Student student8 = new Student ("Bhagyashree","Dolase","Pune",180000);
			Student student9 = new Student ("Dadasaheb","Dolase","Ahemadnagar",45000);
	    	Student student10 = new Student ("Nikita","Dolase","Ahemadnagar",45000);

			  List<Student> std1 = Arrays.asList(student,student1,student2,student3,student4,student5,student6,student7,student8,student9,student10);
			  stdimpl.saveAll(std1);
		}
	}


