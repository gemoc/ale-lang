package fr.inria.diverse.objectalgebragenerator.test;

import org.junit.Assert;
import org.junit.Test;

import fr.inria.diverse.objectalgebragenerator.popup.actions.CharsSequence;

public class CharsSequenceTest {

	private static final int N = 'Z' - 'A';
	private final CharsSequence charsSequence = new CharsSequence();

	@Test
	public void testA() throws Exception {
		Assert.assertEquals("A", charsSequence.generateString(0));
	}

	@Test
	public void testB() throws Exception {
		Assert.assertEquals("B", charsSequence.generateString(1));
	}

	@Test
	public void testZ() throws Exception {
		Assert.assertEquals("Z", charsSequence.generateString(N));
	}

	@Test
	public void testAA() throws Exception {
		Assert.assertEquals("AA", charsSequence.generateString(N + 1));
	}

	@Test
	public void testAB() throws Exception {
		Assert.assertEquals("AB", charsSequence.generateString(N + 2));
	}

	@Test
	public void testAZ() throws Exception {
		Assert.assertEquals("AZ", charsSequence.generateString(N + N + 1));
	}

	@Test
	public void testZZZ() throws Exception {
		Assert.assertEquals("ZZZ", charsSequence.generateString(18277));
	}

	@Test
	public void testAAAA() throws Exception {
		Assert.assertEquals("AAAA", charsSequence.generateString(18278));
	}
	

}
