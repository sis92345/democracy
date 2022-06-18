package com.democracy.member.service.impl;

import com.democracy.member.dto.Member;
import com.democracy.member.service.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberBridge {
		
		@Autowired
		MemberRepository memberRepository;
		/**
		 * 회원을 등록합니다,
		 *
		 * @param member - 회원 객체
		 * @return member - 등록된 회원의 객체
		 * */
		public Member save ( Member member ) {
				
				if ( member == null ) {
						return null;
				}
				
				return memberRepository.save( member );
		}
		
}
