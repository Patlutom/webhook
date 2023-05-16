package com.batch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class ListUser {

	@GetMapping("/searchid")
	public  Map<String, Object> searchEmployeeId()  {

		List<Student> read = new ArrayList<>();
		read.add(new Student(1, "hiii","IN"));
		read.add(new Student(2, "hero","IN"));
		read.add(new Student(1, "hiii","IN"));
		read.add(new Student(2, "hero","IN"));
		read.add(new Student(1, "hiii","IN"));
		read.add(new Student(2, "hero","OUT"));
		read.add(new Student(1, "hiii","IN"));
		read.add(new Student(2, "hero","IN"));
		read.add(new Student(1, "hiii","OUT"));
		read.add(new Student(1, "hiii","IN"));
		read.add(new Student(2, "hero","IN"));
		read.add(new Student(1, "hiii","IN"));
		read.add(new Student(1, "hiii","IN"));
		read.add(new Student(4, "jack","OUT"));
		read.add(new Student(4, "jack","IN"));
		read.add(new Student(4, "jack","IN"));
		read.add(new Student(4, "jack","IN"));
		read.add(new Student(3, "rose","OUT"));
		read.add(new Student(3, "rose","IN"));
		read.add(new Student(4, "jack","IN"));
		read.add(new Student(4, "jack","OUT"));
		read.add(new Student(5, "jack","OUT"));

		Map<Integer, List<Student>> collect = read.stream().collect(Collectors.groupingBy(Student :: getId));
		System.out.println(collect);


		Map<String, Object> setNewResult = new HashMap<>();
		
		
		String  getStudentName = "";
		Map<String, Object> finalResult = null;
		List userTracked = new ArrayList<>();

		for (Entry<Integer, List<Student>>  test : collect.entrySet()) {
			List<Student> student = test.getValue();
			finalResult = new HashMap<>();
			int totalCount  = student.size();
			System.out.println(totalCount);
			System.out.println(student);


			Map<String, Object> entry = new HashMap<>();
			Map<String, Object> exit = new HashMap<>();

			List<Student> userEntry = new ArrayList<>();
			List<Student> userOutside = new ArrayList<>();

			for (int i = 0; i < student.size(); i++) {
				if(student.get(i).getStatus().equals("IN")){
					userEntry.add(student.get(i));
					getStudentName = student.get(i).getName();
				}
				else if(student.get(i).getStatus().equals("OUT")){
					userOutside.add(student.get(i));

				}
			}

			entry.put("userEntry", userEntry);
			entry.put("Count", userEntry.size());

			exit.put("userOutside", userOutside);
			exit.put("Count", userOutside.size());

			finalResult.put("Name", getStudentName);
			finalResult.put("totalCount", totalCount);
			finalResult.put("IN", entry);
			finalResult.put("OUT", exit);
			userTracked.add(finalResult);
			System.out.println(finalResult);
		}
		
		setNewResult.put("response", userTracked);
		
		return setNewResult;
	}
}
