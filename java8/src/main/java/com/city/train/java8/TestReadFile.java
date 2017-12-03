package com.city.train.java8;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TestReadFile {

	public static void main(String args[]) throws Exception {
		/*InputStream inputStream = TestReadFile.class.getClassLoader().getSystemResourceAsStream("com/city/train/java8/lines.txt");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String li=null;
		while((li=bufferedReader.readLine() )!=null){
			System.out.println(li);
		}*/
		
		
		String fileName = "lines.txt";

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}