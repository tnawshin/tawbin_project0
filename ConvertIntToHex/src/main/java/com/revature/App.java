//Write a method that will take in an int (whole number base 10) and 
//return its hexadecimal value (whole number base 16)

package com.revature;
import java.util.Scanner;

public class App {
public static void main(String[] args) {
	System.out.println("Enter an integer to convert into Hexadecimal value: ");
	Scanner sc = new Scanner(System.in);
	int number = sc.nextInt();
	
	//Array of 16 characters in Hexadecimal number system
	char hexadecimal[]= {'0','1','2','3','4','5','6','7','8','9','A','B','C', 'D', 'E', 'F'};
	
	//declare a variable to store remainder
	int remainder;
	
	//create an empty string to store the result
	String str = "";
	
	System.out.println("Convertion from Integer "+ number+" to hexadecimal value is: ");
	
	while(number>0) {
		remainder = number%16;   
		str = hexadecimal[remainder]+str; 
		number = number/16;
	}
	System.out.print(str);

}

}
