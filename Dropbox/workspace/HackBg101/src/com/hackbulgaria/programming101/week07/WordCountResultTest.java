package com.hackbulgaria.programming101.week07;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Paths;
import org.junit.BeforeClass;
import org.junit.Test;

public class WordCountResultTest {
	private static WordCountResult wcr;

	@BeforeClass
	public static void initWCR() throws IOException {
		wcr = new WordCountResult();
		wcr.wordCount(Paths.get("/home/igm/Desktop/Test.txt"));
	}

	@Test(expected = IOException.class)
	public void exceptionTest() throws IOException {
		wcr.wordCount(Paths.get("/home/igm/Desktop/Test15milionazvezdi.txt"));
	}

	@Test
	public void testWordCount() {
		int actual = wcr.getWords();
		int expected = 6;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetCharactersString() {
		int actual = wcr.getCharacters();
		int expected = 29;
		assertEquals(expected, actual);
	}

}
