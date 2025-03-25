public class Map {
	    private char[][][] mazes; // 3D maze representation: level, row, col
	    private int numRows, numCols, numLevels;

	    public Map(int numRows, int numCols, int numLevels) {
	        this.numRows = numRows;
	        this.numCols = numCols;
	        this.numLevels = numLevels;
	        mazes = new char[numLevels][numRows][numCols];
	    }

	    public void setTile(int level, int row, int col, char tile) {
	        mazes[level][row][col] = tile;
	    }

	    public char getTile(int level, int row, int col) {
	        return mazes[level][row][col];
	    }

	    public String returnMaze() {
	        String result = "";

	        for (int level = 0; level < numLevels; level++) {
	            result += "Maze Level " + level + ":\n";
	            for (int row = 0; row < numRows; row++) {
	                for (int col = 0; col < numCols; col++) {
	                    result += mazes[level][row][col];
	                }
	                result += "\n";
	            }
	            result += "\n";
	        }

	        return result;
	    }

		public char[][][] getMazes() {
			return mazes;
		}

		public void setMazes(char[][][] mazes) {
			this.mazes = mazes;
		}

		public int getNumRows() {
			return numRows;
		}

		public void setNumRows(int numRows) {
			this.numRows = numRows;
		}

		public int getNumCols() {
			return numCols;
		}

		public void setNumCols(int numCols) {
			this.numCols = numCols;
		}

		public int getNumLevels() {
			return numLevels;
		}

		public void setNumLevels(int numLevels) {
			this.numLevels = numLevels;
		}

}
