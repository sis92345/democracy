package com.democracy.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Component
@Table( name = "member" )
@ToString
public class Member {
		
		@Id
		private String id;
		
		private String password;
		
		private String name;
		
		@Column( name = "input_date" )
		private LocalDate inputDate;
		
		private String email;
		
		@Column( name = "join_type" )
		private int joinType;
}
