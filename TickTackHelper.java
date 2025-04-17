import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class TickTackHelper {
    public TickTackHelper() {
    }

    Scanner sc = new Scanner(System.in);
    int playerMove;
    public final double winPoints = 10;
    public TickTackBoard[] childArray;

    /**
     * handles the start of the game loop, ends with the startGame method
     * encapsulates all code, but the rest is in the startGame method
     */
    public void startGameLoop() {
        TickTackToe game = new TickTackToe(true);

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Type 1 for additional instructions");
        System.out.println("Type 2 to start the game");
        int choice = sc.nextInt();
        while (!(choice == 2 || choice == 1)) {
            System.out.println("Please either type 1(instructions) or 2(start)");
            choice = sc.nextInt();
        }
        if (choice == 1) {
            printInstructions();
            // this is basically a wait till key pressed statement
            sc.next();
            choice = 2;
        }
        if (choice == 2) {
            startGame(game);
        }
    }

    /**
     * prints the instructions
     */
    public void printInstructions() {
        System.out.println("Instructions:");
        System.out.println("1. The game is played on a 3x3 grid.");
        System.out.println(
                "2. Players take turns placing their mark (X or O) in an empty cell, by entering the cell number (1-9).");
        System.out.println(
                "3. The first player to get 3 marks in a row (horizontally, vertically, or diagonally) wins.");
        System.out.println("4. If all cells are filled and no player has 3 marks in a row, the game is a draw.");
        System.out.println("Press any key to start game");
    }

    /**
     * evaluates all moves and returns best move
     * 
     * @param tree the tree of possible moves
     * @return returns the index of the best move in the array
     */
    public int evaluateMoves(TickTackBoard tree) {
        Stack<TickTackBoard> stack = new Stack<>();
        int i = 0;
        int counter = 0;
        stack.add(tree);
        System.out.println(tree);
        while (!stack.isEmpty()) {
            TickTackBoard currentBoard = stack.peek();
            System.out.println(counter);
            // while (currentBoard.getChildArray() != null) {
            while (counter < 10) {
                childArray = currentBoard.getChildArray();
                System.out.println(Arrays.toString(childArray) + " This is getting outputted!!!");
                stack.add(childArray[i]);
                counter++;
                currentBoard = stack.peek();
                System.out.println(counter);
            }
            i++;
        }
        return 0;
    }

    /*
     * while every move has not been processed
     * go until one has no children, so it is a win loss, or tie.
     * assign a value to the position
     * the ones with children should just be the bext min-max option for the robot,
     * so if the best it can do(forced), is a tie then it should be 0
     * so then just go with the highest number move every time
     */

    /**
     * populates all the possible positions resulting from the board
     * 
     * @param board  the position that is looked at
     * @param helper
     * @return returns an array containing all of the possible positions from a
     *         certain board
     */
    public TickTackBoard[] populateBoardArray(int[] board, TickTackHelper helper) {
        int numPreviousMoves = helper.numPreviousMoves(board);
        TickTackBoard[] possibleMoves = new TickTackBoard[9 - numPreviousMoves];
        int arrayPos = 0;
        TickTackBoard currentBoard;
        for (int position = 0; position < 9; position++) {
            int currentPiece = board[position];
            if (currentPiece == 0) {
                // if(currentPiece == 1)
                // {
                int[] newBoard = new int[9];
                for (int i = 0; i < 9; i++) {
                    if (i != position) {
                        newBoard[i] = board[i];
                    }
                }
                // }
                currentBoard = new TickTackBoard(board, 9 - numPreviousMoves);
                possibleMoves[arrayPos] = currentBoard;
            } else {

            }
        }
        /*
         * go through the array
         * if the space is not populated
         * then make a new ticktackboard at position i with that spot populated
         */

        return possibleMoves;
    }

    /**
     * evaluates the current board/node
     * 
     * @param board the current board/node to evaluate
     * @return the score for the robot
     */
    public double evaluateBoard(int[] board) {
        if (isRobotMove(board)) {

        }

        return 0.0;
    }

    // TODO: finish this method
    /**
     * gets the piece for the next turn
     * 
     * @param board        the current board
     * @param starterPiece the piece type that started
     * @return returns the nextPiece type(int)
     */
    public int getNextPiece(int[] board, int starterPiece) {
        int pieceCounter = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i] != 0) {
                pieceCounter++;
            }
        }
        return 0;
    }

    /**
     * checks to see if it is the robots turn
     * 
     * @param board  the board the method checks
     * @param helper
     * @return returns true if its the robot's turn
     */
    public boolean isRobotMove(int[] board) {
        int numMoves = 0;
        boolean playerStarted = playerStarted();
        int modNum;
        if (playerStarted) {
            modNum = 2;
        } else {
            modNum = 1;
        }
        for (int i = 0; i < 9; i++) {
            if (board[i] != 0) {
                numMoves += 1;
            }
        }
        return numMoves % modNum == 0;
        // return ("Did Player Start: " + playerStarted + " ModNum: " + modNum + "
        // NumMoves: " + numMoves
        // + " isRobotTurn: " + (numMoves % modNum == 0));
    }

    /**
     * returns the number of possible moves
     * 
     * @param board the board that is being evaluated
     * @return returns the number of possible moves for a certain board
     */
    public int getNumPossibleMoves(int[] board) {
        return 9 - numPreviousMoves(board);
    }

    /**
     * checks if the move is valid
     * 
     * @param location the location of the move that this method checks
     * @param board    the board this move checks
     * @return returns if the move is valid
     */
    public boolean isValidMove(int location, int[] board) {
        if (location < 0 || location > 8) {
            return false;
        }
        return (board[location] == 0);
    }

    /**
     * 
     * @param board the board it is checking for all valid moves
     * @return returns an array of length of possible moves, that contains the
     *         location of each possible move
     */
    public int[] getValidMoves(int[] board) {
        int numValidMoves = getNumPossibleMoves(board);
        System.out.println("There are " + numValidMoves + " possible moves.");
        int[] validMoves = new int[numValidMoves];
        int counter = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i] != 0) {
                validMoves[counter] = i;
                counter++;
            } else {
                validMoves[counter] = i;
                counter++;
            }
        }
        return validMoves;
    }

    /**
     * checks to see if a certain board is full
     * 
     * @param board the board being checked
     * @return true if the board is full, false if there are possible moves
     */
    public boolean isFull(int[] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i] == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * returns the number of previous moves
     * 
     * @param board the board being checked
     * @return returns the number of previous moves
     */
    public int numPreviousMoves(int[] board) {
        int counter = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i] != 0) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * checks if somone won, checks for ties, checks if the game ended early due to
     * an error
     * 
     * @param game the current TickTackToe object being examined
     * @return returns true if the game is over
     */
    public boolean gameOver(TickTackToe game) {
        // System.out.println("HI YO, gameOver method runs!!");
        int winner = hasWon(game);
        if (winner != 0) {
            System.out.println(game);
            System.out.println("Player " + winner + " wins!");
            System.exit(0);
        }
        if (isFull(game.board) && winner == 0) {
            System.out.println("Tie Game");
            return true;
        }
        if (game.endEarly) {
            System.out.println("Game ended early.");
            System.exit(0);
        }
        return false;
    }

    /**
     * checks if anyone has won
     * 
     * @return returns the number of the player that won, zero if tied currently
     */
    public int hasWon(TickTackToe game) {
        int[] board = game.board;
        int targetInt;
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                targetInt = 1;
            } else {
                targetInt = 2;
            }
            if (board[4] == targetInt) {
                if (board[1] == targetInt && board[7] == targetInt) {
                    return targetInt;
                } else if (board[3] == targetInt && board[5] == targetInt) {
                    return targetInt;
                } else if (board[0] == targetInt && board[8] == targetInt) {
                    return targetInt;
                } else if (board[6] == targetInt && board[2] == targetInt) {
                    return targetInt;
                }
            }
            if (board[0] == targetInt) {
                if (board[1] == targetInt && board[2] == targetInt) {
                    return targetInt;
                }
                if (board[6] == targetInt && board[3] == targetInt) {
                    return targetInt;
                }
            }
            if (board[8] == targetInt) {
                if (board[2] == targetInt && board[5] == targetInt) {
                    return targetInt;
                }
                if (board[6] == targetInt && board[7] == targetInt) {
                    return targetInt;
                }
            }
        }
        return 0;
    }

    /**
     * handles the game type selection
     * 
     * @return returns the option the user picked
     */
    public int selectGameType() {
        System.out.println("Would you like to play a robot(0) or a friend(1)?");
        int robotOrFriend = sc.nextInt();
        while (robotOrFriend != 0 && robotOrFriend != 1) {
            System.out.println("Please either select 0(robot) or 1(friend).");
            robotOrFriend = sc.nextInt();
        }
        return robotOrFriend;
    }

    /**
     * checks if the player started
     * 
     * @return returns true if the player started
     */
    public boolean playerStarted() {
        return (playerMove == 1);
    }

    // TODO: finish the random robot code
    // TODO: make an option to pick between a smart or a random robot
    /**
     * executes the code for playing vs a robot
     * 
     * @param game        the current TickTackToe object
     * @param randomRobot
     */
    public void playRobotGame(TickTackToe game, boolean randomRobot) {

        playerMove = (int) (Math.random() + 0.5);
        // System.out.println("\n" + playerMove);
        // System.out.println("Sorry, that functionality is unavailible");
        System.out.println("Starting a PvE game");
        executeRandRobotTurn(game, playerMove);

        // evaluateMoves(new TickTackBoard());
    }

    /**
     * overloads the play2Playergame method so the playRobotGame method can use it
     * it is slightly modified
     * 
     * @param game
     * @param isRobotGame
     */
    public void play2PlayerGame(TickTackToe game, boolean isRobotGame) {
        System.out.println(game);
        while (!game.gameOver) {
            System.out.println("New Turn\n\n");
            int currentPlayer;
            if (game.player1Turn) {
                currentPlayer = 1;
                System.out.println("you are playing as a human");
            } else {
                currentPlayer = 2;
                System.out.println("You are playing as the robot");
            }
            if (!gameOver(game)) {
                executeHumanTurn(game, currentPlayer);
                System.out.println(isRobotMove(game.board));
            } else {
                game.gameOver = true;
            }
        }
    }

    /**
     * handles the two player game
     * 
     * @param game the current TickTackToe object
     */
    public void play2PlayerGame(TickTackToe game) {
        System.out.println(game);
        while (!game.gameOver) {
            int currentPlayer;
            if (game.player1Turn) {
                currentPlayer = 1;
            } else {
                currentPlayer = 2;
            }
            if (!gameOver(game)) {
                executeHumanTurn(game, currentPlayer);
                // System.out.println(Arrays.toString(game.board));
            } else {
                game.gameOver = true;
            }
        }
    }

    /**
     * Executes the human's turn
     * 
     * @param player the number of the player whose turn it is.
     */
    public void executeHumanTurn(TickTackToe game, int player) {
        String playerTolken;
        if (player == 1) {
            playerTolken = "X";
        } else {
            playerTolken = "O";
        }
        System.out.println("please place an " + playerTolken + " in any empty cell");
        int cell = sc.nextInt();
        boolean isValid = isValidMove(cell, game.board);
        if (!isValid) {
            System.out.println("Please pick a diffent cell");
            System.out.println(game);
        } else {
            game.board[cell] = player;
            game.player1Turn = !game.player1Turn;
            gameOver(game);
            System.out.println(game);
        }
    }

    /**
     * Executes the random robot's turn
     * 
     * @param player the number of the player whose turn it is.
     */
    public void executeRandRobotTurn(TickTackToe game, int player) {
        String playerTolken;
        if (player == 1) {
            playerTolken = "X";
        } else {
            playerTolken = "O";
        }
        // System.out.println("please place an " + playerTolken + " in any empty cell");
        System.out.println("this is the board i am evaluating " + Arrays.toString(game.board));
        int[] possibleMoves = getValidMoves(game.board);
        System.out.println(Arrays.toString(possibleMoves));
        int location = (int) (Math.random() * possibleMoves.length);
        boolean isValid = isValidMove(location, game.board);
        if (!isValid) {
            System.out.println("Please pick a diffent cell");
            System.out.println(game);
        } else {
            game.board[location] = player;
            game.player1Turn = !game.player1Turn;
            gameOver(game);
            System.out.println(game);
        }
    }

    /**
     * commences the game, either PvE or two-player
     * 
     * @param game the current TickTackToe object
     */
    public void startGame(TickTackToe game) {
        int robotOrFriend = selectGameType();
        if (robotOrFriend == 0) {
            playRobotGame(game, false);
        } else {
            play2PlayerGame(game);
        }
    }
}
