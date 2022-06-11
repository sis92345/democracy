package com.democracy.config;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

/**
 * Democracy Banner
 * */
public class DemocracyBanner implements Banner {
		
		@Override public void printBanner( Environment environment, Class<?> sourceClass, PrintStream out ) {
				
				
				out.println( "    ____  ________  _______  __________  ___   ________  __\n" +
										 "   / __ \\/ ____/  |/  / __ \\/ ____/ __ \\/   | / ____/\\ \\/ /\n" +
										 "  / / / / __/ / /|_/ / / / / /   / /_/ / /| |/ /      \\  / \n" +
										 " / /_/ / /___/ /  / / /_/ / /___/ _, _/ ___ / /___    / /  \n" +
										 "/_____/_____/_/  /_/\\____/\\____/_/ |_/_/  |_\\____/   /_/   \n" +
										 "                                                          ");
		}
}
