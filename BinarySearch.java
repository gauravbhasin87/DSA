package vmWare;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] elements = {1,1,2,3,4,5};
		System.out.println(binarySearch(elements,3));
	}
	
	static int binarySearch(int [] elements, int target){
			if (elements == null || elements.length <= 0) 
				return -1;
					
			int left = 0, right = elements.length - 1;
					while (left < right) {
						int middle = (left + right + 1) / 2;
						if (elements[middle] > target) 
							right = middle - 1;
						else
							left = middle + 1;
				}
					

			if (elements[right] == target) 
				return right;
							
			return -1;
		}
	
	}
