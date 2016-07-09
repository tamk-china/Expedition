package com.tamk.Expedition.jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {
	private static List<String> list = new ArrayList<>();

	static {
		list.add("a");
		list.add("c");
		list.add("b");
	}

	private static void test1() {
		Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
		System.out.println(list);
	}

	private static void test2() {
		System.out.println(list.stream().map(String::toUpperCase).collect(Collectors.toList()));
	}

	public static void main(String[] args) {
		test1();
		test2();
	}

}
