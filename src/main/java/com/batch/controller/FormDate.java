package com.batch.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postman")
public class FormDate {

	@PostMapping(value = "/formdata", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String testMethod(@ModelAttribute String formData) {
		
		System.out.println(formData);
		return formData;
	}
}
