package com.hackbulgaria.programming101.week07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * @author Ivan Mehandzhiev
 */
public class FixSubtitles {
	public static void fixEncoding(Path path) throws IOException {
		BufferedReader br = Files.newBufferedReader(path);
		String str = new String(Files.readAllBytes(Paths
				.get("/home/igm/Desktop/lost.s04e11.hdtv.xvid-2hd.srt")),
				"windows-1251");
		String result = new String(str.getBytes(), StandardCharsets.UTF_8);
		overWrite(path, result);
	}

	public static void overWrite(Path path, String str) throws IOException {
		BufferedWriter bw = Files.newBufferedWriter(path);
		bw.write(str);
	}

	public static void main(String[] args) throws IOException {
		fixEncoding(Paths
				.get("/home/igm/Desktop/lost.s04e11.hdtv.xvid-2hd.srt"));
	}
}
