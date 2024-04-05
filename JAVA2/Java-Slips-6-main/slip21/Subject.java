//Q1
//Simple Way
//Write a java program to accept ‘N’ Subject Names from a user store them into
//LinkedList Collection and Display them by using Iterator interface. 

// package com.slip21;

import java.util.*;

public class Subject {
	public static void main(String args[])
	{
		LinkedList<String> L1 =new LinkedList<>();
		Scanner sc=new Scanner(System.in);
		int n;
		String subjects;
		
		System.out.println("Enter how many Subject to store: ");
		n=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter " +n+ " Subjects: ");
		for(int i=0; i<n; i++)
		{
			subjects=sc.nextLine();
			L1.add(subjects);
		}
		
		//System.out.println("Subjects are: \n"+L1);
		
		System.out.println("\nSubject names using Iterator:");
		
		Iterator<String> iterator = L1.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
