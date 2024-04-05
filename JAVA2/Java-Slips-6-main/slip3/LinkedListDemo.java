//Write a Java program to create LinkedList of String objects and perform the following:
//i. Add element at the end of the list
//ii. Delete first element of the list
//iii. Display the contents of list in reverse order

// package com.slip3;

import java.util.*;

public class LinkedListDemo{
	public static void main(String args[])
	{
		LinkedList<String> L1=new LinkedList<>();
		
		//Linked List Adding some Elements into list
		L1.add("Amit");
		L1.add("Yash");
		L1.add("Harsh");
		L1.add("Ravi");
		System.out.println("Linked List Elements are: \n"+L1);
		
		//Add element at the end of the list
		L1.addLast("Om");
		System.out.println("\nAfter adding Element at the end:\n "+L1);
		
		
		//Delete first element of the list
		L1.removeFirst();
		System.out.println("\nAfter removing First Element: \n"+L1);
		
		
		//Display the contents of list in reverse order
		System.out.println("\nLinked List Elements in Reverse Order: ");
		for(int i=L1.size()-1; i>=0; i--)
		{
			System.out.println(L1.get(i));
		}
	}
}