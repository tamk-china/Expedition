package com.tamk.classloader;

public class TestClassLoader extends ClassLoader {

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		System.out.println(name);
		return super.loadClass(name);
	}

	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader loader = new TestClassLoader();
		String.class.getClassLoader();
	}

}
