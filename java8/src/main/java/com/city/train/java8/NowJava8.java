package com.city.train.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NowJava8 {

	volatile int[] a=new int[2];
    public static void main(String[] args) {

        List<String> lines = Arrays.asList("spring", "node", "mkyong");

        List<String> result = lines.stream()                // convert list to stream
                .filter(line -> !"mkyong".equals(line))     // we dont like mkyong
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        result.forEach(System.out::println);                //output : spring, node
        findByName();
    }
    
    private static void findByName(){
    	List<Person> persons = Arrays.asList(
                new Person("mkyong", 30,"female"),
                new Person("jack", 20,"male"),
                new Person("lawrence", 40,"male")
        );
    	
    	/*long count=persons.stream().filter(person-> !person.getName().equals("jack")).count();
    	int sum=persons.stream().filter(person-> !person.getName().equals("jack")).mapToInt(Person::getAge).sum();
    	System.out.println(count);
    	System.out.println(sum);*/
    	
    	Map<String,Integer> maps=persons.parallelStream().collect(Collectors.groupingBy(Person::getGender,Collectors.summingInt(p->1)));
    	maps.forEach((key,value)->{System.out.print("K="+key);System.out.print(" V="+value);System.out.println();});
    	
    	Map<String,List<String>> maps1=persons.parallelStream().collect(Collectors.groupingBy(Person::getGender,Collectors.mapping(Person::getName, Collectors.toList())));
    	
    	maps1.forEach((k,v)->System.out.println("KEY="+k +" "+"VALUE="+v));
    	
    	Map<String, Integer> map2 = persons.parallelStream().collect(Collectors.groupingBy(Person::getGender, Collectors.reducing(0,Person::getAge, Integer::sum)));
    	System.out.println(map2);
    }

}