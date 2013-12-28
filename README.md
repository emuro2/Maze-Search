Maze-Search
===========

DFS, BFS, Greedy Best-First Search, A-Star Search


Assignment link: http://www.cs.illinois.edu/~slazebni/fall13/assignment1.html

Description:

1.1 Basic pathfinding

To begin with, you will consider the problem of finding a path through a maze from a given start state to a given goal state. This scenario is illustrated in the figure above, where the start position is indicated by the "Pacman" icon and the goal state is a dot. The maze layout will be given to you in a simple text format, where '%' stands for walls, 'P' for the starting position, and '.' for the goal (see sample maze file). For this part of the assignment, all step costs are equal to one.
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

In general, we may want to penalize the agent differently for going to different maze cells. Consider the medium maze and these two cost functions:
c1 = 1/2^x;
c2 = 2^x.
That is, you calculate the cost of a move by computing this function for the cell that the move is taking you to (x denotes the x-coordinate of the cell). Intuitively, c1 should cause the agent to prefer the right side of the maze, and c2 should cause it to prefer the left side. Implement uniform cost search and run it on the medium maze, and include in your report items a-d from Part 1 for both c1 and c2.
1.3 Search with multiple dots

Now we consider a harder problem of finding the shortest path through a maze while hitting all the dots. Once again, the Pacman is initially at P, but now there is no single goal position. Instead, the goal is achieved whenever the Pacman manages to eat all the dots. Here is a sample problem instance. In this part, we assume unit step costs.
Revise your code from Part 1 to deal with this scenario. This will require changing the goal test (have you eaten all the dots?) and the state representation (besides your current position in the maze, is there anything else you need to know?).

Run the four search algorithms from Part 1 on the tiny search, small search, and tricky search. In your report, for each search method and problem instance, show your solution by modifying the maze file to number the goals in the order in which you reach them (once you run out of numbers, use lowercase letters). Also, report the solution cost and number of nodes expanded.

You will be surprised how inefficient the uninformed searches are even on the very small problems! For the uninformed searches, feel free to put some reasonable upper limit on the number of nodes expanded, and quit without returning a solution if this limit is exceeded. To be able to find a solution in a reasonable amount of time, it is crucial to design a good heuristic. You should spend some time thinking about this. In the report, discuss the heuristic that you chose and explain why it is admissible. Feel free to propose multiple heuristics and show results for all of them. For reference, my implementation of A* search on the tricky search found a path of length 61 after expanding around 7600 nodes. Try to design a heuristic that will do even better!

1.4 Suboptimal search

Sometimes, even with A* and a good heuristic, finding the optimal path through all the dots is hard. In these cases, we'd still like to find a reasonably good path, quickly. Write a suboptimal search algorithm that will do a good job on medium search and big search. Your algorithm could either be A* with a non-admissible heuristic, or something different altogether. To get full points, you should be able to find a path of length around 320 on the big search after expanding around 600 nodes (of course, you're welcome to try to do even better than that!).
