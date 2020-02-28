package cse360assign2;

/* Author: Megan McElenney
 * Class ID: 388
 * Assignment #: 2
 * Description: This file creates a class and performs functions on it.
 * URL: https://github.com/meganmcelenney/SimpleList/blob/master/cse360assign2/src/cse360assign2/SimpleList.java
 * It is public and can be accessed through the link.
 */

/**
 * This is a class containing the code for making a simple list and also performing actions on it
 * such as add, remove, and search. 
 * @author MeganElizabeth
 */
public class SimpleList 
{
	public int list [];
	public int count;
	
/**
 *  SimpleList is a constructor which creates a new array of 10 elements and sets the int count to 0
 * 	@author MeganElizabeth
 */
	SimpleList()
	{
		list = new int[10];
		count = 0;
		System.out.println("test");
	}
	
	/**
	 *  This function adds a given element into the array the first spot of the array 
	 *  and shifts everything to accommodate it. 
	 * @param addition
	 */
	public void add(int addition)
	{
		count = count();
		for(int i = list.length; i > 0; i--)
		{
			if(count == list.length) // accounts for the kicking the last element out
			{
				//adjusts size
				int increase = (list.length)/2;
				int [] biggerList = new int[list.length + increase];
				for(int j = 0; j < list.length; j++)
				{
					biggerList[j] = list[j];
				}
				list = new int[biggerList.length];
				for(int j = 0; j < list.length; j++)
				{
					 list[j] = biggerList[j];
				}
				i++;
			}
			else // moves the rest of the list
			{
				list[i+1] = list[i];
			}		
		}
		list[0] = addition; // adds the new element
		count++;
	}
	
	/**
	 * This function removes a given element from the array and adjusts all other elements
	 * @param removal
	 */
	public void remove(int removal)
	{
		count = count();
		for(int i = 0; i <= count; i++)
		{
			if(list[i] == removal)
			{
				for(int j = 0; j <= count; j++)
				{
					list[j] = list[j+1];
				}
			}
		}
		count --;
		int emptyCount = 0;
		for(int j = 0; j < list.length; j++)
		{
			if(list[j] == 0)
				emptyCount++;
		}
		//adjusts size
		if(emptyCount/list.length >= 0.25)
		{
			int reduceAmount = (int) (list.length * (0.25));
			int [] smallerList = new int[list.length - reduceAmount];
			if(list.length-reduceAmount >= 1)
			{
				for(int j = 0; j < smallerList.length; j++)
				{
					smallerList[j] = list[j];
				}
				list = new int[smallerList.length];
				for(int j = 0; j < list.length; j++)
				{
					 list[j] = smallerList[j];
				}
			}
			
		}
	}
	
	/**
	 *  This function counts the number of elements in the array
	 * @return returns the number of element in the array
	 */
	public int count()
	{
		count = 0;
		for(int i = 0; i < 10; i++)
		{
			if(list[i] > 0)
				count++;
		}
		return count;
	}
	
	/**
	 * This function returns a string with each element with a space between them 
	 * @return returns a string of the elements in the array
	 */
	public String toString()
	{
		count = count();
		String printThis = "";
		for(int i = 0; i < count; i++)
		{
			printThis += list[i] + " "; // adds each element to the string
		}
		printThis += list[count];//allows for there to be no space after the last element
		return printThis;
	}
	
	/**
	 * This function searches the array for the given element
	 * @param element
	 * @return returns the index of where the element was found
	 */
	public int search(int element)
	{
		count = count();
		for(int i = 0; i < count; i++)
		{
			if(list[i] == element)
				return i;
		}
		return -1;
	}
	
	public void append(int appendThis)
	{
		count = count();
		if(count == list.length) // accounts for the kicking the last element out
		{
			int increase = (list.length)/2;
			int [] biggerList = new int[list.length + increase];
			for(int j = 0; j < list.length; j++)
			{
				biggerList[j] = list[j];
			}
			list = new int[biggerList.length];
			for(int j = 0; j < list.length; j++)
			{
				 list[j] = biggerList[j];
			}
		}
		list[count] = appendThis;
		count++;
	}
	
	public int first()
	{
		if(list.length < 1)
			return -1;
		else
			return list[0];
	}
	public int last()
	{
		if(list.length < 1)
			return -1;
		else
			return list[count];
	}
	
	public int size()
	{
		return list.length+1;
	}
	
}
