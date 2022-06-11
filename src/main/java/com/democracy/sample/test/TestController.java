package com.democracy.sample.test;

import com.democracy.sample.test.TestRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
		
		@Autowired TestRepository testRepository;
		
		@GetMapping( value = "/test")
		public ResponseEntity<?> test() {
				
				return ResponseEntity.ok( testRepository.findAll() );
		}
		
		@RequestMapping( value = "1234")
		public ResponseEntity<?> test2() {
				
				return ResponseEntity.ok( "!23" );
		}
		
		@RequestMapping( value = "/loggg")
		public ResponseEntity<?> test3() {
				
				return ResponseEntity.ok("123");
		}

}
