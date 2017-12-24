import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
	
	static class ArrayContainer implements Comparable<ArrayContainer>{
		int [] array;
		int curIndex;
		public ArrayContainer(int [] ar){
			curIndex = 0;
			array = ar;
		}
		@Override
		public int compareTo(ArrayContainer o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.array[this.curIndex], o.array[o.curIndex]);
		}
		
		public boolean increaseIndex(){
			if(curIndex<array.length-1){
				curIndex++;
				return true;
			}
			else{
				return false;
			}
		}
	}
	
	public static int [] mergeKArrays(int [][] arrays){
		int k = arrays.length;
		int sizeOFArray = arrays[0].length;
		
		PriorityQueue<ArrayContainer> minHeap = new PriorityQueue<>();
		//ArrayContainer array ;
		for(int i=0;i<k;i++){
			ArrayContainer array = new ArrayContainer(arrays[i]);
			minHeap.add(array);
			//array.increaseIndex();
		}
		System.out.println(minHeap.size());
		int result [] =  new int[k*sizeOFArray];
		for(int i=0;i<k*sizeOFArray;i++){
			ArrayContainer array = minHeap.poll();
			result[i] = array.array[array.curIndex];
			if(array.increaseIndex()){
				minHeap.add(array);
			}
			else{
				// do nothing
			}
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arrays[][] = new int[][]{{7,8,9},{4,5,6},{1,2,3},{10,11,13}};
		int result[] = mergeKArrays(arrays);
		System.out.println(Arrays.toString(result));
	}

}
