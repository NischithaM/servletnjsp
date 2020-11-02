package com.cruds.entity;

public class Test {
	int a=10;
	public static void main(String[] args) {
		try
		{
			Test t=new Test();
			System.out.println(t.a);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	static
	{
		int a=20;
		System.out.println(a);
	}
}
