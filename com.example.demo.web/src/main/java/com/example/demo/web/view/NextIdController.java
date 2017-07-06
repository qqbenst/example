package com.example.demo.web.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IdCreatService;

@RestController
@RequestMapping("/nextId")
public class NextIdController {

	@Autowired
	IdCreatService idCreatService;
	@GetMapping("/getId")
	void getId(){
		System.out.println("获取id:####################################");
		for(int i=0;i<120;i++){
			System.out.println(idCreatService.nextId("ECR", "CORE", "test", "user"));
		}
		
	}
}
