Maze-Search
===========

DFS, BFS, Greedy Best-First Search, A-Star Search


Assignment link: http://www.cs.illinois.edu/~slazebni/fall13/assignment1.html

Description:

1.1 Basic pathfinding

Implement the following search algorithms for solving different mazes:

Depth-first search;
Breadth-first search;
Greedy best-first search;
A* search.

For greedy and A* search, use the Manhattan distance from the current position to the goal as the heuristic function.
Run each of the above algorithms on the small maze, medium maze, big maze, and the open maze. For each problem instance and each search algorithm, include the following in your report:

The solution and its path cost;
Number of nodes expanded;
Maximum tree depth searched;
Maximum size of the frontier.
You can display the solution by putting a '.' in every maze square visited on the path (example solution to the big maze).

1.2 Search with different cost functions

c1 = 1/2^x;
c2 = 2^x.
That is, you calculate the cost of a move by computing this function for the cell that the move is taking you to (x denotes the x-coordinate of the cell). Intuitively, c1 should cause the agent to prefer the right side of the maze, and c2 should cause it to prefer the left side. Implement uniform cost search and run it on the medium maze, and include in your report items a-d from Part 1 for both c1 and c2.

1.3 Suboptimal search

Sometimes, even with A* and a good heuristic, finding the optimal path through all the dots is hard. In these cases, we'd still like to find a reasonably good path, quickly. Write a suboptimal search algorithm that will do a good job on medium search and big search. Your algorithm could either be A* with a non-admissible heuristic, or something different altogether. To get full points, you should be able to find a path of length around 320 on the big search after expanding around 600 nodes (of course, you're welcome to try to do even better than that!).
