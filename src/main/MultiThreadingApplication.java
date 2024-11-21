package main;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import main.Assignment8a.Assignment8;

public class MultiThreadingApplication {
	
		
	Assignment8a assignment= new Assignment8a();
	private List<Integer> allNumbers= new ArrayList<Integer>();
	private AtomicInteger i= new AtomicInteger(0);
    ConcurrentMap<Integer, Integer> listOfValues= new ConcurrentHashMap<>();
    ExecutorService pool= new Executors.newCachedThreadPool();
	


public void asynchronousFutures() {
	for(int i=0; i<1000;i++) {
		
	CompletableFuture<void>futureList= CompletableFuture.runAsync(()->{
		List<Integer> numbers= assignment.getNumber();
		countUniqueNumbers(numbers);
		
	}
, pool).exceptionally(ex -> { ex.printStackTrace();
		
	}
}


	
		
}

}
