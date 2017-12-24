
public class RotateMatrixRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = {
							{1,2,3,4},
							{5,6,7,8},
							{9,10,11,12},
							{13,14,15,16}
						 };
		int [][] result = rotateMatrixRightOnePlace(matrix);
		for(int i=0;i<result.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(result[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	static int [][] rotateMatrixRightOnePlace(int [][] matrix){
		int rows = matrix.length;
		int cols = matrix[0].length;
		int layers = rows/2;
		
		for(int layer=0;layer<layers;layer++){
			int first = layer;
			int last = rows-layer-1;
			int temp = matrix[first][first];
			
			//left vertical
			for(int i=first+1;i<=last;i++){
				matrix[i-1][first] = matrix[i][first];
			}
			
			//bottom horizontal
			for(int i=first+1;i<=last;i++){
				matrix[last][i-1] = matrix[last][i];
			}
			
			//right vertical
			for(int i=last-1;i>=0;i--){
				matrix[i+1][last] = matrix[i][last];
			}
			
			//top horizontal
			for(int i=last-1;i>=first+1;i--){
				matrix[first][i+1] = matrix[first][i];
			}
			matrix[first][first+1] = temp;
		}
		
		return matrix;
	}
}
