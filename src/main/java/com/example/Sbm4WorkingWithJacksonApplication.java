package com.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pojo.StudentPojo;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class Sbm4WorkingWithJacksonApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Sbm4WorkingWithJacksonApplication.class, args);
		ObjectMapper mapper = new ObjectMapper();
		StudentPojo pojo = new StudentPojo();
		pojo.setId("1");
		pojo.setName("s1");
		// object to json
//		String json = mapper.writeValueAsString(pojo);
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
		System.out.println(json);

		// json to object
		File file = new File("student.json");
		/* StudentPojo pj = mapper.readValue(json, StudentPojo.class); */
		StudentPojo pj = mapper.readValue(file, StudentPojo.class);
		System.out.println(pj);

		// object List to json
		List<StudentPojo> students = new ArrayList<>();
		StudentPojo s1 = new StudentPojo();
		s1.setId("99");
		s1.setName("ppp");

		StudentPojo s2 = new StudentPojo();
		s2.setId("99");
		s2.setName("ppp");

		students.add(s1);
		students.add(s2);

		System.out.println(mapper.writeValueAsString(students));

		// REad json array;

		File file2 = new File("students.json");
		StudentPojo[] pjs = mapper.readValue(file2, StudentPojo[].class);
		for (StudentPojo studentPojo : pjs) {
			System.out.println(studentPojo);
		}

	}

}
