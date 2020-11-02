package com.cruds.entity;

public class Main {
	
	public static void main (String[] args )
	{
		try{
			int[] arr={10,25,2,6,8,9,7,32};
			for(int i=0;i<arr.length;i++)
			{
				System.out.println(arr[i+1]);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
