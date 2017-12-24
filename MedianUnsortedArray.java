import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianUnsortedArray {

	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10,new Comparator<Integer>(){
		@Override
		public int compare(Integer o1, Integer o2){
			return -Integer.compare(o1, o2);
		}
	});
	
	public MedianUnsortedArray(){
		minHeap.add(Integer.MAX_VALUE);
		maxHeap.add(Integer.MIN_VALUE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianUnsortedArray main = new MedianUnsortedArray();
		for(int i=0;i<10;i++){
			System.out.println(main.findMedian(i));
		}

	}
	
	double findMedian(int num){
		if(num>=maxHeap.peek())
			maxHeap.add(num);
		else
			minHeap.add(num);
		
		if(maxHeap.size()-minHeap.size() == 2){
			minHeap.add(maxHeap.poll());
		}
		else if(minHeap.size()-maxHeap.size() == 2){
			maxHeap.add(minHeap.poll());
		}
		
		if(maxHeap.size() == minHeap.size())
			return (maxHeap.peek()+minHeap.peek())/2.0;
		else if(maxHeap.size()>minHeap.size())
			return maxHeap.peek();
		else
			return minHeap.peek();
	}

}
