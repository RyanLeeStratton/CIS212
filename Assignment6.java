/**
 * Ryan Stratton
 * CIS 212
 * Assignment 6
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;



//Giant block of code for comparable was example
//given in class to make the comparable feature work.
class Pair<F,S> implements Comparable<Pair<F,S>>{
	private char  characterValue;
	private int  integerValue;
	
	public Pair(char CharacterValue, int IntegerValue){
		characterValue = CharacterValue;
		integerValue   = IntegerValue;
	}
	
	public char getFirst(){ return characterValue; }
	public int getSecond(){ return integerValue; }

	public int compareTo(Pair<F, S> other) {
		return other.getSecond() - getSecond();
	}
	public String toString() { return "(" + "Character: " + '"' + characterValue + '"'+ ", " + "Occurrence: " + integerValue + ")"; }
}









public class Main {	
	public static void main(String[] args){
		Scanner user_Input = new Scanner(System.in);
		String name = user_Input.nextLine();
	
		HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
	
	
	
		//figuring out how to cycle through the nextline info 
		//and how to map it to the hashmap was obtained from
		//http://stackoverflow.com/questions/15367938/adding-new-strings-to-a-hashmap-java
		for(int i = 0; i < name.length(); ++i){
			char c = name.charAt(i);
		
			if(hMap.get(c)== null)
				hMap.put(c,1);
		
			else{
				int count = hMap.get(c);
				hMap.put(c, count+1);
			}
		
		}
		PriorityQueue<Pair<Character, Integer>> mostOftenCharacterQueue = new PriorityQueue<Pair<Character, Integer>>();
	
		//Information on hashmap set and iterator block code was obtained from
		//http://www.careerbless.com/samplecodes/java/beginners/collections_ds/inertandretrieveMap.php
		Set HashKeys = hMap.keySet();
		Iterator iterationValue = HashKeys.iterator();
		Character Key;
		Integer Value;
	
		while(iterationValue.hasNext()){
			Key = (Character)iterationValue.next();
			Value = (Integer)hMap.get(Key);
			Pair pair1 = new Pair(Key, Value);
			mostOftenCharacterQueue.offer(pair1);
		}
		
		
	
		//code was from example in class
		while (!mostOftenCharacterQueue.isEmpty())
			System.out.println(mostOftenCharacterQueue.poll());
	}	
}



