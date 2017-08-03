/**
 * Ryan Stratton
 * CIS212
 * Assignment 7
 * 
 */

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


//The main sources of information I used for coding were from these websites.

//http://www.concretepage.com/java/linkedblockingqueue_java
//This website gave a good start on the general construction of the 
//producer/consumer setup.

//http://www.journaldev.com/1034/java-blockingqueue-example-implementing-producer-consumer-problem
//This website showed me how to get the linkedblockingqueue to work
//across the different classes while making them access all the same one.
//it also showed me how to setup the executor service.



//Producer class
class Producer implements Runnable {
	private LinkedBlockingQueue<String> LBQueue;
	
	public Producer(LinkedBlockingQueue<String> Queue){
		this.LBQueue = Queue;

	}
	public void run(){
		try {
		for(int i = 0; i < 2000000; ++i){
				
				LBQueue.put(UUID.randomUUID().toString());
				if((i+1)%1000 == 0){
					System.out.println((i+1) + " UUIDs Produced");
				}
				Thread.yield();
			
			}
		}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			}
		}
	}





//Consumer class
class Consumer implements Runnable{
	private LinkedBlockingQueue<String> LBQueue;

	public Consumer(LinkedBlockingQueue<String> Queue){
		this.LBQueue = Queue;
	}
	
	String BiggestUUID = "0000000000000000000000";
	String temp;
	public void run(){
		try {
			for(int j = 0; j < 2000000; ++j){
				temp = LBQueue.take();
				if((temp.compareTo(BiggestUUID)) > 0){
					BiggestUUID = temp;
				}
				if((j+1)%1000 == 0){
					System.out.println((j+1) + " UUIDs Consumed");
				}
				Thread.sleep(1);
			}
			System.out.println("The max UUID is: "+ BiggestUUID);
			
		}
			 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


public class Main {
	
	//Queue with limit
	static LinkedBlockingQueue<String> LBQueue = new LinkedBlockingQueue<String>(100000);
		
	public static void main(String[] args){
		ExecutorService producerConsumerRun = Executors.newFixedThreadPool(2);
		
		producerConsumerRun.submit(new Producer(LBQueue));
		producerConsumerRun.submit(new Consumer(LBQueue));
	}
}
	



