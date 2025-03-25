import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class p2 {

	static boolean Stack = false;
	static boolean Queue = false;
	static boolean Opt = false;
	static boolean Time = false;
	static boolean Incoordinate = false;
	static boolean Outcoordinate = false;
	static boolean Help = false;
	static Map map;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		readMap("TEST01");
		System.out.println(map.returnMaze());

	}
	

	
	
	public static void readMap(String filename) {
		
		try {
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			
			int numRows = scanner.nextInt();
			int numCols = scanner.nextInt();
			int numRooms = scanner.nextInt();
			map = new Map(numRows, numCols, numRooms);
			
			int rowIndex = 0;
			
			while(scanner.hasNextLine()) {
				String row = scanner.nextLine();
				
				if(row.length() > 0) {
					for(int i = 0; i < numCols && i < row.length(); i++) {
						char el = row.charAt(i);
						
						
					}
				}
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
	
	public static void readCoordinateMap(String filename) {
		try {
			File file = new File(filename);
			Scanner scanner = new Scanner(file);

			int numRows = scanner.nextInt();
			int numCols = scanner.nextInt();
			int numLevels = scanner.nextInt();
			scanner.nextLine();

			map = new Map(numRows, numCols, numLevels);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();
				if (line.isEmpty()) continue;

				String[] parts = line.split(" ");
				if (parts.length == 4) {
					char tile = parts[0].charAt(0);
					int row = Integer.parseInt(parts[1]);
					int col = Integer.parseInt(parts[2]);
					int level = Integer.parseInt(parts[3]);

					map.setTile(level, row, col, tile);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}
	public static void stackSolver(String filename) {
		readMap(filename);

		Stack<int[]> stack = new Stack<>();
		boolean[][][] visited = new boolean[map.getLevels()][map.getNumRows()][map.getNumCols()];

		// Find start
		for (int l = 0; l < map.getLevels(); l++) {
			for (int r = 0; r < map.getNumRows(); r++) {
				for (int c = 0; c < map.getNumCols(); c++) {
					if (map.getTile(l, r, c) == 'S') {
						stack.push(new int[]{l, r, c});
						visited[l][r][c] = true;
						break;
					}
				}
			}
		}

		// DFS logic
		int[][] directions = {
			{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1},
			{-1, 0, 0}, {1, 0, 0}
		};

		while (!stack.isEmpty()) {
			int[] pos = stack.pop();
			int l = pos[0], r = pos[1], c = pos[2];

			if (map.getTile(l, r, c) == 'E') {
				System.out.println("Found the end at L:" + l + " R:" + r + " C:" + c);
				return;
			}

			for (int[] d : directions) {
				int nl = l + d[0];
				int nr = r + d[1];
				int nc = c + d[2];

				if (nl >= 0 && nl < map.getLevels() &&
					nr >= 0 && nr < map.getNumRows() &&
					nc >= 0 && nc < map.getNumCols() &&
					!visited[nl][nr][nc] &&
					map.getTile(nl, nr, nc) != '#') {

					stack.push(new int[]{nl, nr, nc});
					visited[nl][nr][nc] = true;
				}
			}
		}

		System.out.println("No path to the end found.");
	}
	
}
