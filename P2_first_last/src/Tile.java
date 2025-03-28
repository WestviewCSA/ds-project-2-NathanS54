public class Tile {
    private char type;         // '@', '.', 'W', '$', '|', '+'
    private int row, col, level;
    private boolean visited;
    private Tile parent;       // Used to reconstruct the path

    public Tile(char type, int row, int col, int level) {
        this.type = type;
        this.row = row;
        this.col = col;
        this.level = level;
        this.visited = false;
        this.parent = null;
    }

    // Getters and Setters
    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getLevel() {
        return level;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Tile getParent() {
        return parent;
    }

    public void setParent(Tile parent) {
        this.parent = parent;
    }

    public boolean isWalkable() {
        return type == '.' || type == 'W' || type == '$' || type == '|';
    }

    public String toString() {
        return String.valueOf(type);
    }
}

