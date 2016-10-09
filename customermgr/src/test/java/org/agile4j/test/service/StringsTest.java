package org.agile4j.test.service;

import org.junit.Test;

import com.google.common.base.Strings;

public class StringsTest {

	@Test
	public void test() {
		System.out.println(Strings.isNullOrEmpty(" ")); ;
		System.out.println(Strings.isNullOrEmpty("")); ;
		System.out.println(Strings.isNullOrEmpty(null)); ;
		System.out.println(Strings.isNullOrEmpty(" a  ")); ;
		System.out.println(Strings.isNullOrEmpty("  ".trim()));
	}

}
