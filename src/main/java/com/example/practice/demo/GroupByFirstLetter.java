package com.example.practice.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class GroupByFirstLetter {
	public static void main(String[] args) {
		String[] list = { "Alex", "Alice", "Brian", "Bob", "Charles" };
		Map<Object, List<String>> string = Arrays.stream(list).collect(Collectors.groupingBy(t -> t.charAt(0)));
		System.out.println(string);
	}
}
