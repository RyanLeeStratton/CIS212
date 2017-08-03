/**
 * Ryan Stratton
 * CIS 212
 * Assignment1
 */
import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		
		// Foo is the while loop variable.
		int Foo = 0;
		int Total = 0;
		
		Scanner number = new Scanner(System.in);
		
		System.out.println("Please enter an integer.");
		System.out.println("Use -1 to reset the count.");
		System.out.println("Use 0 to end.");
		System.out.println("A sum of all integers will be shown at");
		System.out.println("the end.");
		
		// loop until certain conditions are met.
		// 0 is end, -1 is reset.
		// add all inputs at the end and display.
		while(Foo == 0){
			int Count = number.nextInt();
			
			if(Count == 0){
				Foo = 1;
				System.out.print("Sum of integers: ");
				System.out.println(Total);
				break;
			}
			if(Count == -1){
				Total = 0;
			}
			else{
				Total = (Total+Count);
			}
				
			}
		}
	}
	


