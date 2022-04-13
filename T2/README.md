# Connect 4

Connect Four is a two-player connection board game, in which the players choose a color and then take turns dropping colored tokens into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the lowest available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own tokens. Connect Four is a solved game. The first player can always win by playing the right moves.

In this project, since connect four is a solved game, our goal was to implement an artificial intelligence cappable of never losing to a human opponent. We did this by using the MinMax algorithm: for each possible action of the player, we check all possible actions of the other players and determine the worst possible combination of actions—the one that gives player i the smallest value. Then, we determine which action player i can take in order to make sure that this smallest value is the highest possible.

To reduce complexity, we used Alpha–beta pruning: a search algorithm that seeks to decrease the number of nodes that are evaluated by the minimax algorithm in its search tree. It stops evaluating a move when at least one possibility has been found that proves the move to be worse than a previously examined move. Such moves need not be evaluated further. When applied to a standard minimax tree, it returns the same move as minimax would, but prunes away branches that cannot possibly influence the final decision.

To run, simply execute the 'Connect4' file with the "ALFABETA" or "MINIMAX" arguments to adjust the AI to the different methods
