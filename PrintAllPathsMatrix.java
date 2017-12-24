
public class PrintAllPathsMatrix {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		int [][] matrix = {
							{1,2,3},
							{4,5,6},
							{7,8,9}
						};
		int rows = matrix.length;
		int cols = matrix[0].length;
		printAllPaths(matrix,0,0,rows,cols,sb);
	}
	
	static void printAllPaths(int [][] matrix, int i, int j, int rows, int cols, StringBuilder sb){
		
		sb.append(matrix[i][j]);
		if(i==rows-1 && j==cols-1){
			System.out.println(sb);
			return;
		}
		if(i<rows-1){
			printAllPaths(matrix,i+1,j,rows,cols,sb);
			sb.setLength(sb.length()-1);
		}
		if(j<cols-1){
			printAllPaths(matrix,i,j+1,rows,cols,sb);
			sb.setLength(sb.length()-1);
		}
	}

}
