package com.asanast.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Prueba {

	public static void main(String[] args) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("user"));

	}

}
