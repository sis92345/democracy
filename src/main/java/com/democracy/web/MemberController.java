package com.democracy.web;

import com.democracy.member.dto.Member;
import com.democracy.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
		
		@Autowired MemberService memberService;
		
		@RequestMapping( "/save_member")
		public ResponseEntity<?> saveMember( @RequestBody Member member ) {
				
				return ResponseEntity.ok( memberService.save( member ) );
		}
}
