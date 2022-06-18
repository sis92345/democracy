package com.democracy.member.service;

import com.democracy.member.dto.Member;
import org.springframework.stereotype.Service;

public interface MemberService {
		
		/**
		 * 회원을 등록합니다,
		 *
		 * @param member - 회원 DTO
		 * @return Member
		 * */
		public Member save( Member member );
}
