
public class Map {
	
	private Tile[][][] map;
	private int row, col,rooms;

	public Map(Tile[][][] map, int row, int col, int rooms) {
		super();
		map = new Tile[row][col][rooms];
		this.row = row;
		this.col = col;
		this.rooms = rooms;
	
	}
	public Map(int numRows, int numCols, int numRooms) {
		// TODO Auto-generated constructor stub
	}
	public void setTile(int row, int col, int rooms, Tile obj) {
		map[row][col][rooms] = obj;
	}
	
	public String returnMaze() {
		String maze = "";
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; i++) {
				
				
			}
		}
	}

	public Tile[][][] getMap() {
		return map;
	}

	public void setMap(Tile[][][] map) {
		this.map = map;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
}
