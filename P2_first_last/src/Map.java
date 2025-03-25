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

}
