package com.democracy;

import com.democracy.config.IndependentTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// 독립 테스트 For TDD
public class TddTest extends IndependentTest {
		
		@Test
		public void 연산_테스트() {
				
				int result = 1 + 1;
				Assertions.assertEquals( result , 2 );
		}
}
