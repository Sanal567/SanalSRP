/**
 * 
 */
package org.sanal.srp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author sanal567
 *
 */
public class Test {

	/**
	 * 
	 */
	public Test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("kjhgfdsa"));
	}

}
