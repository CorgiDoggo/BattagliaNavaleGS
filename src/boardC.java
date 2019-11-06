public class boardC {
	public int[][] boardC;
	//this will hold info if the boat can be created
	public boolean boatBool;
	public boolean loss = true;
	public String  str;
	public boardC(){
		boardC = new int[10][10];
	}
	public void testPos(int a, int b){
		int row1 = Math.abs(a/10);
		int col1 = a%10;
		int row2 = Math.abs(b/10);
		int col2 = b%10;
		if(row1 == row2 || col1 == col2){
			boatBool = true;
		}
		else
			boatBool = false;
	}
	//we create a boat
	public void createBoat(int a, int b){
		//we also need to test for the existence of other boats
		
		//create the head and tail of the ship
		int row1 = Math.abs(a/10);
		int col1 = a%10;
		int row2 = Math.abs(b/10);
		int col2 = b%10;
		//testing to see if they are on the same column or row
		//this way we know how to put the ship in the array
		if(row1 == row2){
			//if the boat is on the same row we have to fill the 
			//columns out
			for(int i = col1; i<=col2; i++){
				boardC[row1-1][i-1] = 1;
			}
		}
		else if(col1 == col2){
			for(int i = row1; i<=row2; i++){
				boardC[i-1][col1-1] = 1;
			}
		}
		else{
			boatBool = false;
		}
	}
	//printing the board
	public void printBoardC(){
		for(int i = 0; i<boardC.length; i++){
			for(int c = 0; c<boardC[i].length; c++){
				System.out.print(boardC[i][c]+" ");
			}
			System.out.println();
		}
	}
	public boolean testHit(int row, int col){
		if(boardC[row][col] == 1){
			boardC[row][col] = 5;
			printBoardC();
			return true;
		}
		else 
			return false;
	}
	//test for loss, when all the board is 0's again
	public boolean testLoss(){
		int count = 0;
		boolean bool1 = true;
		for(int i = 0; i<boardC.length; i++){
			for(int c = 0; c<boardC[i].length; c++){
				if(boardC[i][c]==0 || boardC[i][c]==5){
					count++;
				}				
			}
		}
		if(count == 100)
			bool1 = false;
		return bool1;
	}
}