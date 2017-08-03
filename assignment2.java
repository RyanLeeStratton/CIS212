/**
 * Ryan Stratton
 * CIS212
 * Assignment 2
 */

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;


public class assignment2 {
	
	//Takes the user submitted length and density values. Produces a 
	//dense array, where any random value less than the density
	//will be 0.0, otherwise the random value is used.
	public static double[] createDenseArray(int Length, double Density){
		double[] array = new double[Length];
		double hold; 
		
		for (int i = 0; i < Length; ++i){
			hold = Math.random();
			if (hold < Density){
				array[i] = hold;
			}
			
			else{
				array[i] =0.0;
			}
		
		}
		return array;	
	}
	
	
	//Uses the dense array and length to create a sparse array. The 
	//sparse array takes all the values of the dense array that are
	//non-zero. 
	public static ArrayList createSparseArray(int Length, double[] Array){
		
		ArrayList Sparse = new ArrayList();
		
		for (int m = 0; m < Length; ++m){
	
			if (Array[m] != 0.0)
				Sparse.add(Array[m]);	
		}
		
		return Sparse;
	}
	
	
	
	//Sums all the values of the dense array together and returns that value.
	public static double ArraySum(int Length, double[] Array){
		
		double sum = 0;
		
		for (int x = 0; x < Length; ++x){
			sum += Array[x];
		}
		
	return sum;
		
	}
	
	
	
	//Sums all the values of the sparse array together and returns that value.
	public static double SparseArraySum(ArrayList sparse_array){
		
		double Arraylist_sum = 0;
		
		for (int z = 0; z < sparse_array.size(); ++z){
			Arraylist_sum += (double) sparse_array.get(z);
		}
		
	return Arraylist_sum;
			
	}

	
	

	//main program
	public static void main(String[] args){
		
		int loop = 1;
		int Array_Length = 0;
		double Array_Density = 0;
		double double_array[];
		ArrayList sparse_array;
		double dense_sum = 0;
		double sparse_sum = 0;
		double createDenseArray_Time = 0;
		double createSparseArray_Time = 0;
		double DenseSum_Time = 0;
		double SparseSum_Time = 0;
		
		
		System.out.println("Please enter an integer for the length of the array");
		System.out.println("and a double for the array density.");
		System.out.println("The density needs to be in the range of (0.0,1.0].");
		
		Scanner Array_Info = new Scanner(System.in);
		
		Array_Length = Array_Info.nextInt();
		Array_Density = Array_Info.nextDouble();
		
		//Ensures that the density is within the proper range or (0.0,1.0]
		while(loop == 1)
		if (Array_Density >= 0.0 & Array_Density < 1.0){
			++loop;
			
		}
		else{
			System.out.println("The density needs to be in the range of (0.0,1.0].");
			System.out.println("Please enter a new density.");
			
			Array_Density = Array_Info.nextDouble();
		}
		
		//Calls all the functions and records the time to run each.
		createDenseArray_Time = System.nanoTime();
		double_array = createDenseArray(Array_Length, Array_Density);
		
		createSparseArray_Time = System.nanoTime();
		sparse_array = createSparseArray(Array_Length, double_array);
		
		DenseSum_Time = System.nanoTime();
		dense_sum = ArraySum(Array_Length,double_array);
		
		SparseSum_Time = System.nanoTime();
		sparse_sum = SparseArraySum(sparse_array);
		
		
		//prints out all the needed info.
		System.out.print("createDenseArray time: ");
		System.out.println(createDenseArray_Time);
		System.out.print("createSparseArray time: ");
		System.out.println(createSparseArray_Time);
		System.out.print("DenseSum time: ");
		System.out.println(DenseSum_Time);
		System.out.print("Dense Sum: ");
		System.out.println(dense_sum);
		System.out.print("SparseSum time: ");
		System.out.println(SparseSum_Time);
		System.out.print("Sparse Sum: ");
		System.out.println(sparse_sum);
		
	}
}

	
