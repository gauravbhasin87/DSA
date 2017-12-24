package wepay;

public class ZombieNoOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String zombies[] = {
								"1100",
								"1110",
								"0110",
								"0001"
						   };
		String zombies2[] = {
									"10000",
									"01000",
									"00100",
									"00010",
									"00001"
									
							  };
		System.out.println(countIslands(zombies2));
	}
	
	public static int countIslands(String [] zombies ){
		int count = 0;
		int n = zombies.length;
		char [][] matrix = new char[n][n];
		for(int i=0;i<n;i++){
			matrix[i] = zombies[i].toCharArray();
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j] == '1'){
					dfs(matrix,i,j);
					count++;
				}
			}
		}
		
		
		return count;
	}
	
	public static void dfs(char[][] matrix, int i, int j){
		if(i<0 || i>=matrix.length || j<0 || j>=matrix.length)
			return;
		if(matrix[i][j] == '1'){
			matrix[i][j] = '#';
			dfs(matrix,i-1,j);
			dfs(matrix,i,j-1);
			dfs(matrix,i+1,j);
			dfs(matrix,i,j+1);
		}
	}

}
