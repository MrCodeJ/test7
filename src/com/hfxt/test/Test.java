package com.hfxt.test;

import com.hfxt.utils.Md5Utils;

// ≤‚ ‘
public class Test extends Md5Utils{
	public static void main(String[] args) {
		
		String admin="this is";
		
		// º”√‹
		System.out.println(MD5(admin));
		
		// Ω‚√‹
		System.out.println(convertMD5(convertMD5(admin)));
	}
}
