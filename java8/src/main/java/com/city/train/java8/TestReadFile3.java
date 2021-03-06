package com.city.train.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestReadFile3{

	public static void main(String args[]) {

		String fileName = "lines.txt";
		List<String> list = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

			//br returns as stream and convert it into a List
			list = br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		list.forEach(System.out::println);
		
		steamFilter();

	}
	

	
	private static void steamFilter(){
		List<String> lines = Arrays.asList("spring", "node", "mkyong");
		lines=lines.stream().filter(e-> !e.equals("mkyong")).collect(Collectors.toList());
		lines.forEach(System.out::println);
	}

}