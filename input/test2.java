package com.acme;

public class A {
	static void m1() {
		B.m2();
		C.m2();
	}

	
}

class B {
	static void m1() {
		A.m1();
	}

	static void m2() {
		C.m3();
	}
}

class C {
	static void m1() {}
}