package advance;

import java.util.ArrayList;
import java.util.List;

public class Ces {
	
	List<Integer> list = new ArrayList<>();
	
	public void add(int i) {
		list.add(i);
	}
	public void remove() {
		
		if(list.size()>0) {
			
			int j = list.size()-1;
			list.remove(j);
		};
		
	}


	public static void main(String[] args) throws InterruptedException {
		
		Ces c = new Ces();
		
		Runnable s = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<1000; i++) {
					c.add(i);
				}
			}
		};
		
		Runnable s1 = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<100; i++) {
					c.remove();
				}
				
			}
		};
		
		Thread t = new Thread(s);
		Thread t2 = new Thread(s);
		
		t.start();
		t2.start();
		t.join();
		t2.join();
		
		System.out.println(c.list.size());
	}

}
