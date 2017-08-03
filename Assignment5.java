/**
 * Ryan Stratton
 * CIS212
 * Assignment 5
 * 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main {
	JFrame Frame = new JFrame();
	
	
	public Main(){
		JPanel Button_Window = new JPanel(new GridLayout(2,2));
		Frame.add(Button_Window);
		JButton Selection = new JButton("SelectionSort");
		Selection.setBackground(new Color(255, 255, 255));
		Button_Window.add(Selection);
		Selection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				
				ArrayList RandomStringArray;
				ArrayList Select;
				
				RandomStringArray = createRandomList();
				
				double start = System.nanoTime();
				
				Select = getSelectionSortedCopy(RandomStringArray);
				
				double end = System.nanoTime();
				double selectiontime = (end-start)/1000000000;
				System.out.println(selectiontime + "Seconds");
				boolean Selectionsorted = isSorted(Select);
				System.out.println("Sorted: " + Selectionsorted);
				
				
				
			}
		});
		
		Frame.add(Button_Window);
		JButton Merge = new JButton("MergeSort");
		Merge.setBackground(new Color(255, 255, 255));
		Button_Window.add(Merge);
		Merge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				
				ArrayList RandomStringArray;
				ArrayList Merged;
				
				RandomStringArray = createRandomList();
				
				double start = System.nanoTime();
				
				Merged = getMergeSortedCopy(RandomStringArray);
				
				double end = System.nanoTime();
				double mergetime = (end-start)/1000000000;
				System.out.println(mergetime + "Seconds");
				boolean Mergesorted = isSorted(Merged);
				System.out.println("Sorted: " + Mergesorted);
				
			}
		});
		
		Frame.setPreferredSize(new Dimension(600,300));
		Frame.setResizable(false);
		Frame.add(Button_Window);
		Frame.setVisible(true);
		Frame.pack();
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	
	
	
	
	//Method for creating a random list, it takes a bit of time with the 
	//duplicate checking but I wanted to leave it in.
	 public static ArrayList createRandomList(){
		 
		 ArrayList One = new ArrayList();
				
			for(int i = 0; i < 50000; ++i){
				String str = UUID.randomUUID().toString();
				One.add(str);
				
				for(int j =0; j < i; ++j){
					if(One.get(One.size()-1).equals(One.get(j))){
						One.remove(One.size()-1);
						--i;
					}	
				}		
		}
				
		return One;			
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 //Method to sort by means of selection sort
	 public static ArrayList getSelectionSortedCopy(ArrayList RandomStringArray){
		 
		 ArrayList TempArray = new ArrayList();
		 
		 String Temp;
		 String VariableHolder;
		 TempArray = (ArrayList) RandomStringArray.clone();
		 
		 for(int i =0; i < 50000; ++i){
			 Temp = (String) TempArray.get(i);
			 VariableHolder = (String) TempArray.get(i);
			  
			 for(int j =(i+1); j < TempArray.size(); ++j){
				 int Compare = (Temp.compareTo((String) TempArray.get(j)));
				 
				 if( Compare > 0){
					Temp =  (String) TempArray.get(j);
					
					
					TempArray.set(i, Temp);
					TempArray.set(j, VariableHolder);
				 }
					 
				 }
			 }
		 
		 return TempArray;
		 }
		 
	 
	 
	 
	 
	 
	 
	 
	 
		 
		 
	 //You stated in class that we could use code from other sites as a guide as long as we cited them.
	 
	 //http://stackoverflow.com/questions/13773723/recursive-mergesort-in-java
	 
	 //I used this as a guide for my mergesort so that I got it right and so I understood 
	 //it correctly.
	 
	 //well scratch the earlier comment. I thought this was going to work but it seems
	 //that it does not.
	 public static ArrayList getMergeSortedCopy(ArrayList RandomStringArray){
		
		 ArrayList MergeArray = new ArrayList();
		 ArrayList LeftSide = new ArrayList();
		 ArrayList RightSide = new ArrayList();
		 
		 MergeArray = (ArrayList) RandomStringArray.clone();
		 
		 if(MergeArray.size() <= 1){
			 return MergeArray;
		 }
			 
			int Array_Half_Length = ((MergeArray.size())/2);
			for(int i = 0; i < Array_Half_Length; ++i){
				LeftSide.add(MergeArray.get(i));	
			}
			 
			for(int j = Array_Half_Length; j < (Array_Half_Length*2); ++j){
				RightSide.add(MergeArray.get(j));
			}
			
			return ArrayMerging(LeftSide,RightSide);
	 } 
		 
	 
	 
	 
	 
	 
	//Part of merge sort, it is the merging of the sorted layers	
	 public static ArrayList ArrayMerging(ArrayList Leftside, ArrayList Rightside){
		 
		 ArrayList Merge = new ArrayList();
		 ArrayList Left = new ArrayList();
		 ArrayList Right = new ArrayList();
		 
		 Left = (ArrayList) Leftside.clone();
		 Right = (ArrayList) Rightside.clone();
		 
		 int MergeCompare = 0;
		 
		 while(Left.size() > 0 || Right.size() > 0){
			 
			 if(Left.size() == (0)){
				 MergeCompare = 1;
			 }
			 
			 if(Right.size() == (0)){
				 MergeCompare = -1;
			 }
			 
			 if((Left.size() > (0)) && (Right.size() > (0))){
			 MergeCompare = (((String) Left.get(0)).compareTo((String) Right.get(0)));
			 }
			 
			 if(MergeCompare > 0){
				 Merge.add(Right.get(0));
				 Right.remove(0);
			 }
			 
			 else{
				 Merge.add(Left.get(0));
				 Left.remove(0);
			 }
			 
		 }
		 
		 
		return Merge;
		 
	 }
	 
	 
	 
	 
	 		//Used this as a guide, I was tired.
			//Plus I was looking up how to do this and realized there probably wasn't a lot of variation
			//That I could think of so I just went with this example and cited the source.
			
			//http://stackoverflow.com/questions/17500391/determines-if-the-array-list-is-sorted
			
			public boolean isSorted(ArrayList ArrayToSort)
			{
			    boolean ArraySorted = true;        
			    for (int i = 1; i < ArrayToSort.size(); i++) {
			        if (((String) ArrayToSort.get(i-1)).compareTo((String) ArrayToSort.get(i)) > 0){
			        	ArraySorted = false;
			        }
			    }

			    return ArraySorted;
			}
			
			
			
			
			
			
	 
	 	//simple runtime required main
		public static void main(String[] args){
			
			Main Art_Window = new Main();
			
			
		}
		

}






