# 15 Puzzle

The 15 Puzzle consists of a square box with fifteen square pieces, which contain numbers, figures, or drawings, and an empty space where you can move them. The pieces can be moved in 4 directions (up, down, right, or left) occupying the empty space, there is no limit to the number of moves, and the final goal is to form a picture made up of the 15 pieces in the correct order.

In this project we explored different algorithm's performance in finding the correct solution for this puzzle. The algorithms work on a search tree, where their nodes are generated as the algorithm is run through. Not all starting configurations are solvable, so just before running any algorithm, we had to check if it was an unsolvable case. To do this we looked at the number of inversions of the configuration and the position where the blank is for both the initial and final configurations. If the puzzle is solvable the configurations have to follow a specific format: 
<ul>
  <li>If the number of inversions is even, the line from the zero position (from the end) has to be odd.</li>
  <li>If the number of inversions is odd, the line from the zero position has to be even.</li>
</ul>
If these conditions are met, we can proceed with the search algorithm and get the final configuration from the initial one.

The algorithms studied were: Breadth-First Search (BFS), Depth-First Search (DFS), Iterative Deepening Depth-First Search (IDS or IDDFS), Greddy Search with 2 heuristcs (Manthattan distance and # of pieces wrongly placed) and A* Search.
