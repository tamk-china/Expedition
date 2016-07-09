package com.tamk.Expedition.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamTest {
	private static List<String> list = new ArrayList<String>();

	static {
		list.add("tamk");
		list.add("messi");
		list.add("ronaldo");
	}

	private static void test1() {
		System.out.println(list.stream().filter(str -> null != str).count());
	}

	private static void test2() {
		Stream<Integer> stream = Stream.of(1, 2, 3, 4);
		System.out.println(stream.count());
	}

	private static void test3() {
		Stream<Double> stream = Stream.generate(new Supplier<Double>() {

			@Override
			public Double get() {
				return Math.random();
			}

		}).limit(100);
		stream.forEach(one -> System.out.println(one));
	}

	private static void test4() {
		Stream.iterate(1, item -> item + 1).limit(100).forEach(System.out::println);
	}

	public static void main(String[] args) {
		test4();
	}
}
