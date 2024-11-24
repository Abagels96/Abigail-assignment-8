package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
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
	List<CompletableFuture<Void>> futureList= new ArrayList<>();
	for(int i=0; i<1000;i++) {
		
			CompletableFuture<Void>futures= CompletableFuture.runAsync(()->{
			List<Integer> numbers= assignment.getNumbers();
			uniqueNumbers(numbers);}
			
		
	

			, pool).exceptionally(ex -> { ex.printStackTrace();
	return null;
	});
			futureList.add(futures);
			
			CompletableFuture completeListOfFutures= CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
			try { 
				completeListOfFutures.get();				
			}
	catch(InterruptedException| ExecutionException e){
		e.printStackTrace();
	}
			
}
	printTotalCounts(listOfValues);
	}

	
		












private void printTotalCounts(ConcurrentMap<Integer, Integer> listOfValues) {
for(Entry<Integer, Integer> entry:listOfValues.entrySet()) {
	System.out.println(entry.getKey()+":"+entry.getValue().toString());
}
	
}















private void uniqueNumbers(List<Integer> numbers) {
for(Integer number:numbers) {
	listOfValues.put(number, listOfValues.getOrDefault(number,0)+1);
}
	
	
}

}
