package com.revature;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Array {
	
	public static class Arrays {
		
		//making array list global
		public static ArrayList<String> arr = new ArrayList<String>();
		
		
		public static ArrayList<String> palindromes( ArrayList<String> list )
		{
			//declare a variable to compare the length of the string
			int compare;
			
			//declare an index for For loop iteration
			int index;
			
			for(String str: list)
			{
				//check if the condition is met
				if( str.length() % 2 == 0 )
				{
					compare = str.length() / 2;
					index = 0;
					
					for(int i = 0; i < compare; i++)
					{		
						if( str.charAt(i) == str.charAt( str.length() - i - 1) )
							index++;
						
						if( index == compare )
							arr.add(str);
					}
				}//end-if
				
				else
				{
					compare = (str.length()- 1) / 2;
					index = 0;
					
					for(int j = 0; j < compare; j++)
					{	
						if( str.charAt(j) ==  str.charAt( str.length() - j - 1)  )
							index++;
						
						if( index == compare )
							arr.add(str);	
					}
				}//end-else
				
				
			}
			return arr;
		}
		
		
		
		
		public static void main(String[] args) 
		{
			ArrayList<String> arr = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"));
			
			//try and catch to handle exceptions
			try{
				
			BufferedWriter outfile = new BufferedWriter((new FileWriter("C:\\Users\\tawbi\\Desktop\\JavaPractice\\Tawbin_project0\\Palindromes.txt")));
			{
				//Iterating the array list to write to the new array list file
				Iterator<String> itr = arr.iterator();
				
				while( itr.hasNext() )
					outfile.write( "\""+ itr.next() + "\", " );
			}
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			
			System.out.println("ArrayList: " + arr);
			System.out.println("ArrayList palindromes: " + palindromes(arr) );
		}

		private static Collection<? extends String> asList(String string, String string2, String string3,
				String string4, String string5, String string6, String string7, String string8, String string9,
				String string10, String string11, String string12) 
		{
			return null;
		}
	}
}
	