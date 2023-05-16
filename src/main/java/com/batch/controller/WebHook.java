package com.batch.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hook")
public class WebHook {

	@PostMapping("/implement") 
	public ResponseEntity<String> callWebHook(@RequestBody String requestBody) {
		System.out.println("Print the webheook" +requestBody + " Result*************");
System.out.println("Print the webheook" +requestBody + " Result*************");
System.out.println("Print the webheook" +requestBody + " Result*************");
		return new ResponseEntity<String>(requestBody, HttpStatus.OK);
	}

}
