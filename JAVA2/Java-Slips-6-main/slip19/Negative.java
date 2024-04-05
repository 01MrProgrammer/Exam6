//Q1
//Simple Way
//Write a java program to accept ‘N’ Integers from a user store them into LinkedList
//Collection and display only negative integers. 

// package com.slip19;

import java.util.*; 

public class Negative {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		LinkedList<Integer> L1=new LinkedList<>();
		int n;
		int add;
		
		System.out.println("Enter how many elements to add: ");
		n=sc.nextInt();
		System.out.println("Enter " +n+ " Integer Elements into Linked List: ");
		for(int i=0; i<n;i++)
		{
			add=sc.nextInt();
			L1.add(add);
		}
		
		System.out.println("\nLinked List Elements are: \n"+L1);
		
		//display only negative integers
        System.out.println("\nNegative Elements in List are: ");
		for (Integer in : L1) {
			if(in<0)
			{
				System.out.println(in);
			}
			
		}
	}

}
