/*
 * 
 * author: Erik Muro
 * 
 * 
 */


/*Algorithms File
 *
 * DFS
 * BFS
 * Greedy Best-first search
 * A* search
 * Uniform Cost Search
 *
*/


//imported for the use of calculating the power of integers (x^y)
import java.math.*;
import java.io.*;
import java.util.*;

public class algorithms {



	/*Depth-First Search Algorithm that takes a Maze (by reference) in as a parameter.
	 *The Maze class is defined in Maze.java
	 */
	public static void DFS(Maze maze )
	{
		System.out.println("THIS IS DFS");
		System.out.println();
		
		//stack data structure
		Stack stack = new Stack();
		
		pair [] solutions = new pair[maze.maze.length*maze.maze[0].length];
		int solIndex=0;
		
		int NumberofNodesExpanded=0;
		int depth =0;
		int maxfrontier= 0;
		int tempmax=0;
		//push the start position on to the stack

		pair start = new pair(maze.startX, maze.startY, -1,-1, depth);
		stack.push( start );

		tempmax=tempmax+1;
		
		if(tempmax> maxfrontier)
			maxfrontier=tempmax;
		


		while( !stack.isEmpty() )
		{
			pair curr = stack.pop();
			
			solutions[solIndex]= curr;
			solIndex=solIndex+1;
			
			tempmax=tempmax-1;
			if(curr.first == maze.endX && curr.second == maze.endY)
			{
				
				System.out.println("Found the End!!!");
				System.out.println("Number of Nodes Expanded: " + NumberofNodesExpanded);
				System.out.println("Max tree depth searched: " + depth);
				System.out.println("Max frontier size: "+maxfrontier);
				System.out.println();
				
				printSol(maze, solutions, curr);
				
				return;
			}
			
			

			//add neighbors
			if( !maze.visited[curr.first][curr.second] )
			{
				//update visited
				maze.visited[curr.first][curr.second]=true;
				NumberofNodesExpanded=NumberofNodesExpanded+1;

				
				
				//add up neighbor
				if( canMove(maze, curr, "up") )
				{
					pair temp = new pair(curr.first, curr.second-1, curr.first, curr.second,  curr.ht+1);
					stack.push(temp);
					tempmax=tempmax+1;
					if(tempmax> maxfrontier)
						maxfrontier=tempmax;
					
					if(depth < curr.ht+1)
						depth = curr.ht+1;
				}


				//add right neighbor
				if( canMove(maze, curr, "right") )
				{
					pair temp = new pair(curr.first+1, curr.second, curr.first, curr.second,  curr.ht+1);
					stack.push(temp);
					tempmax=tempmax+1;
					if(tempmax> maxfrontier)
						maxfrontier=tempmax;
					
					if(depth < curr.ht+1)
						depth = curr.ht+1;

				}
				
				//add left neighbor
				if( canMove( maze,curr, "left") )
				{
					pair temp = new pair(curr.first-1, curr.second, curr.first, curr.second, curr.ht+1);
					stack.push(temp);
					tempmax=tempmax+1;
					if(tempmax> maxfrontier)
						maxfrontier=tempmax;
					
					if(depth < curr.ht+1)
						depth = curr.ht+1;
				}
				
				//add down neighbor
				if( canMove(maze, curr, "down") )
				{
					pair temp = new pair(curr.first, curr.second+1, curr.first, curr.second,  curr.ht+1);
					stack.push(temp);
					tempmax=tempmax+1;
					if(tempmax> maxfrontier)
						maxfrontier=tempmax;
					
					if(depth < curr.ht+1)
						depth = curr.ht+1;
				}
			}	
		}
	}


	/*Breath-First Search Algorithm that takes a Maze (by reference) in as a parameter.
	 *The Maze class is defined in Maze.java
	 */
	public static void BFS(Maze maze)
	{

		System.out.println("THIS IS BFS");
		System.out.println();
		
		Queue que = new Queue();
		pair [] solutions = new pair[maze.maze.length* maze.maze[0].length];
		int solIndex=0;
		
		int NumberofNodesExpanded=0;
		int depth =0;
		int maxfrontier= 0;
		int tempmax=0;
		
		
		//push the start position on to the stack
		pair start = new pair(maze.startX, maze.startY, -1,-1, depth);
		que.add( start );

		tempmax=tempmax+1;
			
		if(tempmax> maxfrontier)
			maxfrontier=tempmax;
	
		
		while( !que.isEmpty() )
		{
			pair curr = que.remove();
			solutions[solIndex]= curr;
			solIndex=solIndex+1;
			
			tempmax=tempmax-1;
			if(curr.first == maze.endX && curr.second == maze.endY)
			{
				System.out.println("Found the End!!!");
				System.out.println("Number of Nodes Expanded: " + NumberofNodesExpanded);
				System.out.println("Max tree depth searched: " + depth);
				System.out.println("Max frontier size: "+maxfrontier);
				System.out.println();
				
				printSol(maze, solutions, curr);
				
				return;
			}
			

			
			//add neighbors
			if( !maze.visited[curr.first][curr.second] )
			{
				//update visited
				maze.visited[curr.first][curr.second]=true;
				
				NumberofNodesExpanded=NumberofNodesExpanded+1;
			
				//add left neighbor
				if( canMove( maze,curr, "left") )
				{
					pair temp = new pair(curr.first-1, curr.second, curr.first, curr.second,  curr.ht+1);
					que.add(temp);
					tempmax=tempmax+1;
					if(tempmax> maxfrontier)
						maxfrontier=tempmax;
					
					if(depth < curr.ht+1)
						depth = curr.ht+1;
					
				}
				
				//add down neighbor
				if( canMove(maze, curr, "down") )
				{
					pair temp = new pair(curr.first, curr.second+1, curr.first, curr.second, curr.ht+1);
					que.add(temp);
					tempmax=tempmax+1;
					if(tempmax> maxfrontier)
						maxfrontier=tempmax;
					
					if(depth < curr.ht+1)
						depth = curr.ht+1;

				}
				
				//add up neighbor
				if( canMove(maze, curr, "up") )
				{
					pair temp = new pair(curr.first, curr.second-1, curr.first, curr.second,  curr.ht+1);
					que.add(temp);
					tempmax=tempmax+1;
					if(tempmax> maxfrontier)
						maxfrontier=tempmax;

					if(depth < curr.ht+1)
						depth = curr.ht+1;
				}


				//add right neighbor
				if( canMove(maze, curr, "right") )
				{
					pair temp = new pair(curr.first+1, curr.second, curr.first, curr.second, curr.ht+1);
					que.add(temp);
					tempmax=tempmax+1;
					if(tempmax> maxfrontier)
						maxfrontier=tempmax;

					
					if(depth < curr.ht+1)
						depth = curr.ht+1;
				}
			}
		}
	}


	/*Greedy-First Search Algorithm that takes a Maze (by reference) in as a parameter.
	 *The Maze class is defined in maze.java
	 */
	public static void GreedySearch(Maze maze )
	{
		System.out.println("THIS IS GREEDY Best-First Search");
		System.out.println();
		
	
		Queue Gque = new Queue();
		pair [] solutions = new pair[maze.maze.length*2* maze.maze[0].length];
		int solIndex=0;
		
		int NumberofNodesExpanded=0;
		int depth =0;
		int maxfrontier= 0;
	
		
		//push the start position on to the stack
		pair start = new pair(maze.startX, maze.startY, -1,-1, depth);
		Gque.add( start );

		ArrayList< pair > frontier = new ArrayList< pair>();
		
		while( !Gque.isEmpty() )
		{
			pair curr = Gque.remove();
			
			solutions[solIndex]= curr;
			solIndex=solIndex+1;
			

			if(curr.first == maze.endX && curr.second == maze.endY)
			{
				//reachedEnd = true;
				System.out.println("Found the End!!!");
				System.out.println("Number of Nodes Expanded: " + (NumberofNodesExpanded-3) );
				System.out.println("Max tree depth searched: " + depth);
				System.out.println("Max frontier size: "+maxfrontier);
				System.out.println();
				
				printSol(maze, solutions, curr);
				
				return;
			}
			
			if(Gque.isEmpty() && !frontier.isEmpty())
			{
				
				pair min2 = findMinFrontier( maze, frontier);
				Gque.add(min2);
			
				if(frontier.size()> maxfrontier)
					maxfrontier=frontier.size();
			
				if(depth < min2.ht+1)
					depth = min2.ht+1;
			}

			
			//add neighbors
			if( !maze.visited[curr.first][curr.second] )
			{
				//update visited
				maze.visited[curr.first][curr.second]=true;
				
				//
				NumberofNodesExpanded=NumberofNodesExpanded+1;
				
				
				
				//add left neighbor
				if( canMove( maze,curr, "left") )
				{
					pair temp = new pair(curr.first-1, curr.second, curr.first, curr.second,  curr.ht+1);
					frontier.add(temp);
					
				}
				
				//add down neighbor
				if( canMove(maze, curr, "down") )
				{
					pair temp = new pair(curr.first, curr.second+1, curr.first, curr.second, curr.ht+1);
					frontier.add(temp);

				}
				
				//add up neighbor
				if( canMove(maze, curr, "up") )
				{
					pair temp = new pair(curr.first, curr.second-1, curr.first, curr.second,  curr.ht+1);
					frontier.add(temp);
				}


				//add right neighbor
				if( canMove(maze, curr, "right") )
				{
					pair temp = new pair(curr.first+1, curr.second, curr.first, curr.second, curr.ht+1);
					frontier.add(temp);
				}

				
				pair min = findMinFrontier( maze, frontier);
				
				Gque.add(min);
	
			
				if(frontier.size()> maxfrontier)
					maxfrontier=frontier.size();
			
				if(depth < min.ht+1)
					depth = min.ht+1;	
			}	
		}
	}


	/* A* Search Algorithm that takes a Maze (by reference) in as a parameter.
	 * The Maze class is defined in maze.java
	 * @param Maze maze is the maze we are in 
	 */
	public static void Astar(Maze maze )
	{
		
		//queue data structure
		System.out.println("THIS IS A* Search");
		System.out.println();
		
		Queue Aque = new Queue();
		pair [] solutions = new pair[maze.maze.length*2* maze.maze[0].length];
		int solIndex=0;
		
		int NumberofNodesExpanded=0;
		int depth =0;
		int maxfrontier= 0;
	
		
		//push the start position on to the stack
		pair start = new pair(maze.startX, maze.startY, -1,-1, depth, 0);
		Aque.add( start );
	
		ArrayList< pair > frontier = new ArrayList< pair>();

		while( !Aque.isEmpty() )
		{
			pair curr = Aque.remove();
			
			solutions[solIndex]= curr;
			solIndex=solIndex+1;
			
	
			if(curr.first == maze.endX && curr.second == maze.endY)
			{
				System.out.println("Found the End!!!");
				System.out.println("Number of Nodes Expanded: " + (NumberofNodesExpanded-3) );
				System.out.println("Max tree depth searched: " + depth);
				System.out.println("Max frontier size: "+maxfrontier);
				System.out.println();
				
				printSol(maze, solutions, curr);
				
				return;
			}
			
			if(Aque.isEmpty() && !frontier.isEmpty())
			{
				
				pair min2 = findMinFrontierWithCost( maze, frontier);
				Aque.add(min2);
			
				if(frontier.size()> maxfrontier)
					maxfrontier=frontier.size();
			
				if(depth < min2.ht+1)
					depth = min2.ht+1;
			}
	
			
			//add neighbors
			if( !maze.visited[curr.first][curr.second] )
			{
				//update visited
				maze.visited[curr.first][curr.second]=true;
				
				//
				NumberofNodesExpanded=NumberofNodesExpanded+1;
				
				
				
				//add left neighbor
				if( canMove( maze,curr, "left") )
				{
					pair temp = new pair(curr.first-1, curr.second, curr.first, curr.second,  curr.ht+1, 
										(curr.costFromStart+ maze.maze[curr.first-1][curr.second]) );
					frontier.add(temp);
					
				}
				
				//add down neighbor
				if( canMove(maze, curr, "down") )
				{
					pair temp = new pair(curr.first, curr.second+1, curr.first, curr.second, curr.ht+1,
										(curr.costFromStart+ maze.maze[curr.first][curr.second+1]) );
					frontier.add(temp);
	
				}
				
				//add up neighbor
				if( canMove(maze, curr, "up") )
				{
					pair temp = new pair(curr.first, curr.second-1, curr.first, curr.second,  curr.ht+1,
										(curr.costFromStart+ maze.maze[curr.first][curr.second-1]) );
					frontier.add(temp);
				}
	
	
				//add right neighbor
				if( canMove(maze, curr, "right") )
				{
					pair temp = new pair(curr.first+1, curr.second, curr.first, curr.second, curr.ht+1,
										(curr.costFromStart+ maze.maze[curr.first+1][curr.second]));
					frontier.add(temp);
				}
	
				
				pair min = findMinFrontierWithCost( maze, frontier);
				
				Aque.add(min);
	
			
				if(frontier.size()> maxfrontier)
					maxfrontier=frontier.size();
			
				if(depth < min.ht+1)
					depth = min.ht+1;
			}
		}
	}


	//Uniform Cost search 
	/*
	 * @param Maze maze is the the current maze we are in
	 */
	public static void UCS(Maze maze)
	{

		System.out.println("THIS IS Uniform Cost Search");
		System.out.println();
		
		Queue Uque = new Queue();
		pair [] solutions = new pair[maze.maze.length* maze.maze[0].length];
		int solIndex=0;
		
		int NumberofNodesExpanded=0;
		int depth =0;
		int maxfrontier= 0;
	
		
		//push the start position on to the stack
		pair start = new pair(maze.startX, maze.startY, -1,-1, depth, 0);
		Uque.add( start );
	
		ArrayList< pair > frontier = new ArrayList< pair>();
	
		while( !Uque.isEmpty() )
		{
			pair curr = Uque.remove();
			
			solutions[solIndex]= curr;
			solIndex=solIndex+1;
			
	
			if(curr.first == maze.endX && curr.second == maze.endY)
			{
				System.out.println("Found the End!!!");
				System.out.println("Number of Nodes Expanded: " + (NumberofNodesExpanded-3) );
				System.out.println("Max tree depth searched: " + depth);
				System.out.println("Max frontier size: "+maxfrontier);
				System.out.println();
				
				printSol(maze, solutions, curr);
				
				return;
			}
			
			if(Uque.isEmpty() && !frontier.isEmpty())
			{
				
				pair min2 = findMinFrontierUCS( maze, frontier);
				Uque.add(min2);
			
				if(frontier.size()> maxfrontier)
					maxfrontier=frontier.size();
			
				if(depth < min2.ht+1)
					depth = min2.ht+1;
			}
	
			
			//add neighbors
			if( !maze.visited[curr.first][curr.second] )
			{
				//update visited
				maze.visited[curr.first][curr.second]=true;
				
				NumberofNodesExpanded=NumberofNodesExpanded+1;
				
				
				
				//add left neighbor
				if( canMove( maze,curr, "left") )
				{
					pair temp = new pair(curr.first-1, curr.second, curr.first, curr.second,  curr.ht+1, 
										(curr.costFromStart+ maze.maze[curr.first-1][curr.second]) );
					frontier.add(temp);
					
				}
				
				//add down neighbor
				if( canMove(maze, curr, "down") )
				{
					pair temp = new pair(curr.first, curr.second+1, curr.first, curr.second, curr.ht+1,
										(curr.costFromStart+ maze.maze[curr.first][curr.second+1]) );
					frontier.add(temp);
	
				}
				
				//add up neighbor
				if( canMove(maze, curr, "up") )
				{
					pair temp = new pair(curr.first, curr.second-1, curr.first, curr.second,  curr.ht+1,
										(curr.costFromStart+ maze.maze[curr.first][curr.second-1]) );
					frontier.add(temp);
				}
	
	
				//add right neighbor
				if( canMove(maze, curr, "right") )
				{
					pair temp = new pair(curr.first+1, curr.second, curr.first, curr.second, curr.ht+1,
										(curr.costFromStart+ maze.maze[curr.first+1][curr.second]));
					frontier.add(temp);
				}
	
				pair min = findMinFrontierUCS( maze, frontier);
				
				Uque.add(min);
			
				if(frontier.size()> maxfrontier)
					maxfrontier=frontier.size();
			
				if(depth < min.ht+1)
					depth = min.ht+1;
			}
		}
	}


	
	//heuristic for greedy best search
	/*
	 * @param Maze maze is the the current maze we are in
	 * @param ArrayList<pair> frontier is the frontier of our search. Unexpanded nodes.
	 */
	private static pair findMinFrontier( Maze maze, ArrayList<pair> frontier) {
	
		pair minPair= null;
		int distance;
		
		for(int i=0; i < frontier.size(); i++)
		{
			pair temp = frontier.get(i);
			distance =  ( Math.abs( temp.first - maze.endX ) +  Math.abs( temp.second - maze.endY) );
					
			if(minPair == null)
			{
				minPair = temp;
			}
			else 
			{
				int minDist = ( Math.abs( minPair.first - maze.endX ) +  Math.abs( minPair.second - maze.endY) );
				if(minDist >= distance)
				{
					minPair = temp;
				}
				
			}

		}
		frontier.remove(minPair);
		return minPair;
	}






	//Heuristic for A* search
	/*
	 * @param Maze maze is the the current maze we are in
	 * @param ArrayList<pair> frontier is the frontier of our search. Unexpanded nodes.
	 */
	private static pair findMinFrontierWithCost(Maze maze, ArrayList<pair> frontier) {
		pair minPair= null;
		int distance;
		
		for(int i=0; i < frontier.size(); i++)
		{
			pair temp = frontier.get(i);
			distance =  (temp.costFromStart + Math.abs( temp.first - maze.endX ) +  Math.abs( temp.second - maze.endY) );
					
			if(minPair == null)
			{
				minPair = temp;
			}
			else 
			{
				int minDist = ( minPair.costFromStart+ Math.abs( minPair.first - maze.endX ) +  Math.abs( minPair.second - maze.endY) );
				if(minDist >= distance)
				{
					minPair = temp;
				}
				
			}

		}
		frontier.remove(minPair);
		return minPair;

	}


	//heuristic for UCS (Uniform Cost Search)
	//Finds the best path to take from our frontier
	/*
	 * @param Maze maze is the the current maze we are in
	 * @param ArrayList<pair> frontier is the frontier of our search. Unexpanded nodes.
	 */
	private static pair findMinFrontierUCS(Maze maze, ArrayList<pair> frontier) {
	
		pair minPair= null;
		
		float distance;
		
		for(int i=0; i < frontier.size(); i++)
		{
			pair temp = frontier.get(i);
			distance =  ( temp.costFromStart );
					
			if(minPair == null)
			{
				minPair = temp;
			}
			else 
			{
				float minDist = ( minPair.costFromStart );
				if(minDist >= distance)
				{
					minPair = temp;
				}
			}
		}
		frontier.remove(minPair);
		return minPair;
	}


	//determines if we can move in a certain direction from the current node
	/*
	 * @param Maze m is the maze currently in
	 * @param pair p is the current x and y pos
	 * @param String s is the direction we want to move in
	 */
	private static boolean canMove(Maze m, pair p, String s)
	{
		if(s=="right")
		{
			if((p.first+1< m.Xlength-1) && ( m.maze[(p.first)+1][p.second]!= -1 ) )
			{
					//no wall to the right of the current position and it is inbounds of the walls
					return true;
			}
			
			else return false;
		}
		if(s=="left")
		{
			if(p.first-1> 0 && ( m.maze[(p.first)-1][p.second]!= -1 ) )
			{
					//no wall to the left of the current position and it is inbounds of the walls
					return true;
			}
			
			else return false;
		}
		if(s=="up")
		{
			if(p.second-1 > 0 && ( m.maze[p.first][p.second-1]!= -1 ) )
			{
					//no wall above the current position and it is inbounds of the walls
					return true;
			}
			
			else return false;
		}
		if(s=="down")
		{
			if(p.second+1< m.Ylength-1 && ( m.maze[p.first][p.second+1]!= -1 ) )
			{
					//no wall to the right of the current position and it is inbounds of the walls
					return true;
			}
			else 
				return false;
		}
		
		else
			return false;
		
	}


	
	//prints out the solution path from the pair passed in
	private static void printSol( Maze m, pair[] sol, pair p) 
	{
		if(p.parentF == m.startX && p.parentS == m.startY)
		{ 
			System.out.println("Start: "+  "("+p.parentF + ", " + p.parentS + ")"+ " moved to : "+ "("+ p.first +
					", "+ p.second + ")"+ "  Path Cost : " + m.maze[p.first][p.second] + "        Depth: " +p.ht);
			
			return;
		}
		//haven't finished printing out the solution
		else 
			System.out.println("Next: "+ "("+p.parentF + ", " + p.parentS + ")"+ " moved to : "+ "("+ p.first +
					", "+ p.second + ")"+ "  Path Cost : " + m.maze[p.first][p.second]+ "        Depth: " +p.ht);
	
	
		for(int i = 0; i< sol.length; i++)
		{
			if(sol[i].first ==p.parentF && sol[i].second == p.parentS)
			{
				printSol(m, sol, sol[i]);
				return;
			}
		}
	}

}
