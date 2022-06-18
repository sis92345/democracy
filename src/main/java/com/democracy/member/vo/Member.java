package com.democracy.member.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
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
