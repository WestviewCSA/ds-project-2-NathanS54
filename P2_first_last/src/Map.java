public class Map {
	public class Map {
	    private char[][][] mazes;
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

	    public int getNumRows() {
	        return numRows;
	    }

	    public int getNumCols() {
	        return numCols;
	    }

	    public int getNumLevels() {
	        return numLevels;
	    }

	    public String returnMaze() {
	        StringBuilder sb = new StringBuilder();
	        for (int level = 0; level < numLevels; level++) {
	            sb.append("Level ").append(level).append(":\n");
	            for (int row = 0; row < numRows; row++) {
	                for (int col = 0; col < numCols; col++) {
	                    sb.append(mazes[level][row][col]);
	                }
	                sb.append("\n");
	            }
	        }
	        return sb.toString();
	    }
	}
}