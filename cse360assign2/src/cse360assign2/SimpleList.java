package cse360assign2;

/* Author: Megan McElenney
 * Class ID: 388
 * Assignment #: 1
 * Description: This file creates a class and performs functions on it.
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
	}
	
	/**
	 *  This function adds a given element into the array the first spot of the array 
	 *  and shifts everything to accommodate it. 
	 * @param addition
	 */
	public void add(int addition)
	{
		count = count();
		for(int i = count; i > 0; i--)
		{
			if(count == 10) // accounts for the kicking the last element out
			{
				list[count] = 0;
				i--;
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
}
