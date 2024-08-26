// Problem link - https://www.geeksforgeeks.org/find-paths-from-corner-cell-to-middle-cell-in-maze/

public static void printPath(int[][] maze, int i, int j, String ans){
	    int n = maze.length;
	    if(maze[i][j] == -1) return;
	    if(i == n/2 && j == n/2){
	        //mid
	        ans += " -> (" + i + ", " + j + ")" + " -> MID";
	        System.out.println(ans);
	        return;
	    }
	    
	    int k = maze[i][j];
	    maze[i][j] = -1;
	    
	    ans += (" -> ("+i+", "+j+")");
	    
	    if(i - k >= 0){
	        printPath(maze, i - k, j, ans);
	    }
	    if(i + k < n){
	        printPath(maze, i + k, j, ans);
	    }
	    if(j - k >= 0){
	        printPath(maze, i, j - k, ans);
	    }
	    if(j + k < n){
	        printPath(maze, i, j + k, ans);
	    }
	    
	    maze[i][j] = k;
	}
	
