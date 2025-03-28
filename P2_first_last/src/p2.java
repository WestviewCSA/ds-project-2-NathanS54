import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class p2 {

    static boolean useStack = false;
    static boolean useQueue = false;
    static boolean Opt = false;
    static boolean Time = false;
    static boolean Incoordinate = false;
    static boolean Outcoordinate = false;
    static boolean Help = false;
    static Map map;

    public static void main(String[] args) {
        // Parse command line arguments
        try {
            parseCommandLineArguments(args);
        } catch (IllegalCommandLineInputsException e) {
            System.out.println(e.getMessage());
            return;
        }

        // Example usage:
        if (useStack) {
            stackSolver("TEST01");
        } else if (useQueue) {
            queueSolver("TEST01");
        }
    }

    public static void parseCommandLineArguments(String[] args) throws IllegalCommandLineInputsException {
        if (args.length == 0) {
            throw new IllegalCommandLineInputsException("Missing command-line arguments.");
        }

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-stack")) {
                useStack = true;
            } else if (args[i].equals("-queue")) {
                useQueue = true;
            } else if (args[i].equals("-opt")) {
                Opt = true;
            } else if (args[i].equals("-time")) {
                Time = true;
            } else if (args[i].equals("-incoordinate")) {
                Incoordinate = true;
            } else if (args[i].equals("-outcoordinate")) {
                Outcoordinate = true;
            } else if (args[i].equals("-help")) {
                Help = true;
            } else {
                throw new IllegalCommandLineInputsException("Unknown argument: " + args[i]);
            }
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

            scanner.nextLine();  // Move to next line

            for (int row = 0; row < numRows; row++) {
                String line = scanner.nextLine();
                for (int col = 0; col < numCols; col++) {
                    map.setTile(0, row, col, line.charAt(col));  // Using level 0 here
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
        boolean[][] visited = new boolean[map.getNumRows()][map.getNumCols()];

        // Find Wolverine's start position
        int[] start = findStart();
        stack.push(start);
        visited[start[0]][start[1]] = true;

        // DFS logic
        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int r = pos[0], c = pos[1];

            if (map.getTile(0, r, c) == '$') {
                System.out.println("Found the Diamond Wolverine Buck!");
                return;
            }

            for (int[] dir : directions()) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (isValidMove(nr, nc, visited)) {
                    stack.push(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        System.out.println("No path to the Diamond Wolverine Buck.");
    }

    public static void queueSolver(String filename) {
        readMap(filename);

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[map.getNumRows()][map.getNumCols()];

        // Find Wolverine's start position
        int[] start = findStart();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        // BFS logic
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0], c = pos[1];

            if (map.getTile(0, r, c) == '$') {
                System.out.println("Found the Diamond Wolverine Buck!");
                return;
            }

            for (int[] dir : directions()) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (isValidMove(nr, nc, visited)) {
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        System.out.println("No path to the Diamond Wolverine Buck.");
    }

    // Utility methods
    public static int[] findStart() {
        for (int r = 0; r < map.getNumRows(); r++) {
            for (int c = 0; c < map.getNumCols(); c++) {
                if (map.getTile(0, r, c) == 'W') {
                    return new int[]{r, c};
                }
            }
        }
        return null;
    }

    public static boolean isValidMove(int r, int c, boolean[][] visited) {
        return r >= 0 && r < map.getNumRows() &&
                c >= 0 && c < map.getNumCols() &&
                map.getTile(0, r, c) != '@' &&
                !visited[r][c];
    }

    public static int[][] directions() {
        return new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}  // N, S, W, E
        };
    }
}



