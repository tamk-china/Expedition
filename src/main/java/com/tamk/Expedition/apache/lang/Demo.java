package com.tamk.Expedition.apache.lang;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.BitField;

public class Demo {

	public static void main(String[] args) {
		long[] arr = { 1L, 2L };
		arr = ArrayUtils.add(arr, 3L);
		System.out.println(arr);
	}
}

