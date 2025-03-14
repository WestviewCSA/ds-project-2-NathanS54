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
	
	public static void firstChecks(boolean s, boolean q, boolean o, boolean t, boolean i, boolean ou, boolean h ) {
		if(s && !q && !o) {
			
			
			}
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
	
	public static void stackSolver(String string) {
	
	}
	public static void readCoordinateMap(String filename) {
		try {
				File file = new File(filename);
				Scanner scanner = new Scanner(file);
				
				int numRows = scanner.nextInt();
				int numCols = scanner.nextInt();
				int numRooms = scanner.nextInt();
				
				while(scanner.hasNextLine()) {
					String row = scanner.nextLine();
					
					if(row.length() > 0) {
						char mapElement = row.charAt(0);
						int rowIndex = row.charAt(1);
						int colIndex = row.charAt(2);
						int mazeLeve = row.charAt(3);
					}
				}
				
		} catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}
	public static void queueSolver() {
		
	}
	
}
