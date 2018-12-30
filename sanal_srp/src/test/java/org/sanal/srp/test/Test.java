package org.sanal.srp.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author sanal567 Date 14-10-18 00:22 AM
 */
public class Test {

	public Test() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("kjhgfdsa"));
	}

}
