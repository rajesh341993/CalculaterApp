package com.rm;

public class Calculater {
	public float add(float a,float b) {
		return a+b;
	}
	
	public float sub(float av,float b) {
		return av-b;
	}
	
	public float mult(float a,float b) {
		return a*b;
	}
	
	public float div(float a,float b) {
		return a/b;
	}
	public static void main(String[] args) {
	Calculater c=new Calculater();
	System.out.println(c.add(5,9));
	
	}
	
}
