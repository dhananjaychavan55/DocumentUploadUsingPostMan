
package com.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.DocService.DocumentService;
import com.demo.model.Documents;

@RestController
@RequestMapping("/docApi")
public class DocumentController {

	@Autowired
	 private DocumentService service;
	 
	
	@GetMapping("/check")
	public String check() {
		return "Doc Api Working";
	}
	
	@RequestMapping(value = "/uploadDocument",
			method = RequestMethod.POST,
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> insertDocuments(
			@RequestPart(required = true,value ="photo")MultipartFile f1,
			@RequestPart(required = true,value = "signature")MultipartFile f2,
			@RequestPart(required = true,value = "pan")MultipartFile f3) throws IOException {
		
		Documents d=new Documents();
		d.setPhoto(f1.getBytes());
		d.setSignature(f2.getBytes());
		d.setPan(f3.getBytes());
		
		service.insertDocuments(d);
		
		return new ResponseEntity<String>("File Uploaded",HttpStatus.CREATED);
		
	}
}
