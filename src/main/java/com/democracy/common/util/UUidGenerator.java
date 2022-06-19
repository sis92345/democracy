package com.democracy.common.util;

import java.util.UUID;

/**
 * UUID Generate Util
 * */
public class UUidGenerator {
		
		public static String Generate() {
				return UUID.randomUUID().toString();
		}
}
