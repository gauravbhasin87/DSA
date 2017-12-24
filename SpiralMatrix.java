
public class SpiralMatrix {
	
	static int matrix[][] = { {1, 2, 3, 4, 5, 6},
			{7, 8, 9, 10, 11, 12},
			{13, 14, 15, 16, 17, 18}
		};
	
	static void printMatrixSpiral(int matrix[][]){
		int rowst = 0;
		int colst = 0;
		int rowend = matrix.length - 1;
		int colend = matrix[0].length - 1;
		
		while(rowst<=rowend && colst<=colend){
			for(int i = colst;i<=colend;i++){
				System.out.print(matrix[rowst][i]+ " ");
			}
			rowst++;
			
			for(int i = rowst;i<=rowend;i++){
				System.out.print(matrix[i][colend] + " ");
			}
			colend--;
			if(rowst<=rowend){
				for(int i = colend;i>=colst;i--){
					System.out.print(matrix[rowend][i] + " ");
				}
				rowend--;
			}
			if(colst<=colend){	
				for(int i = rowend;i>=rowst;i--){
					System.out.print(matrix[i][colst] + " ");
				}
				colst++;
			}
		}
	}
	
	public static void main(String [] arg){
		printMatrixSpiral(matrix);
	}
}
