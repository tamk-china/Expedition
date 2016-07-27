package com.tamk.Expedition.jdk8;

import java.util.Optional;

public class OptionalTest {
	private static void test1() {
		Optional<String> opt = Optional.of(null);
		System.out.println(opt.get());
	}

	private static void test2() {
		Optional<String> opt = Optional.ofNullable("tamk");
		// opt = Optional.ofNullable(null);
		System.out.println(opt.isPresent());
		System.out.println(opt.get());
	}

	private static void test3() {
		Optional<String> opt = Optional.ofNullable(null);
		opt.ifPresent((value) -> System.out.println(value));
	}
	
	private static void test4() {
		Optional<String> opt = Optional.ofNullable(null);
		System.out.println(opt.orElse("hello"));
	}
	
	private static void test5() {
		Optional<String> opt = Optional.ofNullable("tamk");
		System.out.println(opt.orElseGet(() -> "hello"));
	}
	
	private static void test6() {
		Optional<String> opt = Optional.ofNullable("tamk");
		System.out.println(opt.map((value) -> value.toUpperCase()).get());
	}
	
	private static void test7(){
		Optional<String> opt = Optional.of("tamk");
		System.out.println(opt.filter((value) -> "tamk".equals(value)).get());
	}

	public static void main(String[] args) {
		test7();
	}

}
