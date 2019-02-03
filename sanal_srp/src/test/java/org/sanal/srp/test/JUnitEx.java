/**
 * 
 */
package org.sanal.srp.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Nalluru Sunil Reddy
 *
 */
public class JUnitEx {

	@Test
	public void newArrayListsHaveNoElements() {
		assertThat(new ArrayList<Integer>().size(), is(0));
	}

	@Test
	public void sizeReturnsNumberOfElements() {
		List<Object> instance = new ArrayList<Object>();
		instance.add(new Object());
		instance.add(new Object());
		assertThat(instance.size(), is(2));
	}
}