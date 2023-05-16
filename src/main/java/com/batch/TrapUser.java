package com.batch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class TrapUser {
	
	
	
	@GetMapping("/track")
	public Map<String, Object> userTrackingSheet() {
		
		
		
		List<Student> read = new ArrayList<>();
		read.add(new Student(1, "hiii","IN"));
		read.add(new Student(2, "hero","IN"));
		read.add(new Student(3, "hiii","IN"));
		read.add(new Student(4, "hero","IN"));
		read.add(new Student(5, "hiii","IN"));
		read.add(new Student(6, "hero","OUT"));
		read.add(new Student(7, "hiii","IN"));
		read.add(new Student(8, "hero","IN"));
		read.add(new Student(9, "hiii","OUT"));
		read.add(new Student(10, "hiii","IN"));
		read.add(new Student(11, "hero","IN"));
		read.add(new Student(12, "hiii","IN"));
		read.add(new Student(13, "hiii","IN"));
		read.add(new Student(14, "jack","OUT"));
		read.add(new Student(15, "jack","IN"));
		read.add(new Student(16, "jack","IN"));
		read.add(new Student(17, "jack","IN"));
		read.add(new Student(18, "rose","OUT"));
		read.add(new Student(19, "rose","IN"));
		read.add(new Student(20, "jack","IN"));
		read.add(new Student(21, "jack","OUT"));
		read.add(new Student(22, "jack","OUT"));
		
		
		Collections.sort(read);
		System.out.println(read);
		
//		List<String> array = read.stream().map(t -> t.getName()).collect(Collectors.toList());
//		Map<String, Integer> collect = array.stream().collect(Collectors.toMap(Function.identity(), name -> 3, Integer :: sum ));
//		System.out.println(collect);
		
		Set<String> countStudent = read.stream().map(t -> t.getName()).collect(Collectors.toSet());
		 
		List<String> array = new ArrayList<>(countStudent);
		System.out.println("--------"+array);
		
		List<Map<String, Object>> result = new ArrayList<>();
		List<Integer> noteDot = new ArrayList<>(array.size());
		int index = 0;
		int nextElement = 0;
		for (int j = 0; j < array.size(); j++) {
			List<Student> singleUser = new ArrayList<>();
			Map<String, Object> trackingUserList = new HashMap<>();
		for (int i = 0; i < read.size(); i++) {
			String name = read.get(i).getName();
				if(array.get(j).equals(name)) {
					singleUser.add(read.get(i));
					index++;
					
				} 
//				else {
//					array.remove(i);
//					nextElement++;
//				}
			}
		noteDot.add(index);
//		trackingUserList.put("name", noteDot);
		trackingUserList.put("count", index);
		trackingUserList.put("Object", singleUser);
		result.add(trackingUserList);
		index =0;
		}
		
		System.out.println("======"+noteDot);
		System.out.println(result);
		
		
		List userTracked = new ArrayList<>();
		Map<String, Object> setNewResult = new HashMap<>();
		String  getStudentName = "";
		Integer totalCount = 0;
		
		Map<String, Object> finalResult = null;
		for (Map<String, Object> separateSingleUser : result) {

			 finalResult  = new HashMap<>();
			for (Map.Entry<String, Object> perfectUser : separateSingleUser.entrySet()) {

				Map<String, Object> entry = new HashMap<>();
				Map<String, Object> exit = new HashMap<>();
				
				List<Student> userEntry = new ArrayList<>();
				List<Student> userOutside = new ArrayList<>();
				
				if(perfectUser.getKey().equals("count")) {
					totalCount = (Integer) perfectUser.getValue();
				}
				
				if(perfectUser.getKey().equals("Object")) {
					List<Student> student = (List<Student>)perfectUser.getValue();
					
					for (int i = 0; i < student.size(); i++) {
						if(student.get(i).getStatus().equals("IN")){
							userEntry.add(student.get(i));
							getStudentName = student.get(i).getName();
						}
						else if(student.get(i).getStatus().equals("OUT")){
							userOutside.add(student.get(i));
							
						}
						
					}
					System.out.println(userEntry + "\n count------>" + userEntry.size() + "\n Name Of the User =======>"  + getStudentName);
					System.out.println(userOutside +   "\n, count------>" + userOutside.size() +"\n, Name Of the User =======>" + getStudentName);
					System.out.println();
					System.out.println();
				}
				entry.put("userEntry", userEntry);
				entry.put("Count", userEntry.size());
				
				exit.put("userOutside", userOutside);
				exit.put("Count", userOutside.size());
				
				finalResult.put("Name", getStudentName);
				finalResult.put("totalCount", totalCount);
				finalResult.put("IN", entry);
				finalResult.put("OUT", exit);
			}
			userTracked.add(finalResult);
			
		}
		setNewResult.put("response", userTracked);
		return setNewResult ;
		
	}

}
