package com.tamk.Expedition.jdk8;

import java.util.Optional;

public class OptionalTest {
	private static void test1() {
		Optional<String> opt = Optional.of(null);
		System.out.println(opt.get());
	}

	public static void main(String[] args) {
		test1();
	}

}
