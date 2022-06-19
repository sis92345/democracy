package com.democracy.member.service.impl;

import com.democracy.member.dto.Member;
import com.democracy.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
		
		@Autowired
		MemberBridge memberBridge;
		
		@Override
		public Member save( Member member ) {
				
				return memberBridge.save( member );
		}
}
