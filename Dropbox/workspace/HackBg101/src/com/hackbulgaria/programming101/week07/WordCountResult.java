package com.hackbulgaria.programming101.week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordCountResult {
	private int words = 0;
	private int lines = 0;
	private int characters = 0;

	WordCountResult wordCount(Path path) throws IOException {
		WordCountResult wcr = new WordCountResult();
		BufferedReader br = Files.newBufferedReader(path);
		String line = null;
		int lineLen = 0;
		while ((line = br.readLine()) != null) {
			setLines(lineLen++);
			setWords(getWords(line));
			setCharacters(getCharacters(line));
		}
		System.out.println("Lines:" + lineLen + " Words:" + getWords()
				+ " Characters:" + getCharacters());
		return wcr;
	}

	public int getWords(String str) {
		String[] subStr = str.split(" ");
		return subStr.length;
	}

	public void setWords(int words) {
		this.words += words;
	}

	public int getWords() {
		return words;
	}

	public int getCharacters() {
		return characters;
	}

	public int getLines() {
		return lines;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	public int getCharacters(String str) {
		String[] subStr = str.split(" ");
		int carCount = 0;
		for (String string : subStr) {
			carCount += string.length();
		}
		return carCount;
	}

	public void setCharacters(int characters) {
		this.characters += characters;
	}

	public static void main(String[] args) throws IOException {
		WordCountResult wcr = new WordCountResult();
		wcr.wordCount(Paths.get("/home/igm/Desktop/Test.txt"));
	}
}
