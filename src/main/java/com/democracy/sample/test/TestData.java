package com.democracy.sample.test;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Setter
@Getter
@Entity( name = "TB_TEST")
@Table(name = "TB_TEST")
@Component
@ToString
public class TestData {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String USER_NAME;
}
