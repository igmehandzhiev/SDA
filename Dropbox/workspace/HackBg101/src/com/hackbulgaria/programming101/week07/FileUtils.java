package com.hackbulgaria.programming101.week07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
	private static final FileUtils INSTANCE = new FileUtils();

	private FileUtils() {
	}

	public static FileUtils getInstance() {
		return INSTANCE;

	}

	public static String readFrom(File file) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(file));
		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = input.readLine()) != null) {
			sb.append(line);
		}
		input.close();
		return sb.toString();
	}

	public static String readFrom(Path path) throws IOException {
		return readFrom(path.toFile());
	}

	public static void writeTo(File source, File output) throws IOException {
		FileWriter fw = new FileWriter(output);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(readFrom(source));
		bw.close();
	}

	public static void writeTo(Path source, Path output) throws IOException {
		writeTo(source.toFile(), output.toFile());
	}

	public static void main(String[] args) throws IOException {
		System.out.println(readFrom(Paths.get("/home/igm/Desktop/Test.txt")));
		writeTo(new File("/home/igm/Desktop/Test.txt"), new File(
				"/home/igm/Desktop/Test2.txt"));
	}
}