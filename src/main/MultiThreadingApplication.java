package main;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


public class MultiThreadingApplication {
	
		
	Assignment8a assignment= new Assignment8a();
	private List<Integer> allNumbers= new ArrayList<Integer>();
	private AtomicInteger i= new AtomicInteger(0);
    ConcurrentMap<Integer, Integer> listOfValues= new ConcurrentHashMap<>();
    ExecutorService pool=  Executors.newCachedThreadPool();
	


public void asynchronousFutures() {
	for(int i=0; i<1000;i++) {
		
	CompletableFuture<Void>futureList= CompletableFuture.runAsync(()->{
		try {
			List<Integer> numbers= assignment.getNumbers();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		countUniqueNumbers(numbers);
		
	}
	, pool).exceptionally(ex -> { ex.printStackTrace();
	return null;
	});
	}
		
	
}


	
		




private void countUniqueNumbers(List<Integer> numbers) {

	
	
}

}
