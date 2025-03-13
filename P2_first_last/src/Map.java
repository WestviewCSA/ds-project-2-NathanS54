
public class Map {
	
	private Tile[][] map;
	private int row, col,rooms;
	private char type;
	public Tile[][] getMap() {
		return map;
	}
	public void setMap(Tile[][] map) {
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
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public Map(Tile[][] map, int row, int col, int rooms, char type) {
		super();
		this.map = map;
		this.row = row;
		this.col = col;
		this.rooms = rooms;
		this.type = type;
	}
	
}
