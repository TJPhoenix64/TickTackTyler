public TickTackToe{
  boolean player1Turn;
  boolean gameOver = false;
  boolean player1Win = false;
  boolean endEarly = false;
  boolean is2Player;
  int[] board = new int[9];
  for(int i = 0; i < 9; i++){
    board[i] = 0;
  }
  public TickTackToe(boolean 2Player)
  {
    this.is2Player = 2Player;
    player1Turn = true;
  }
  public TickTackToe(boolean player1Turn, int[] board)
  {
    this.player1Turn = player1Turn;
    this.board = board;
  }
  public static void Main(String[] args)
    {
      if(endEarly){
        System.out.println("Game ended early.");
        System.exit(0);
      }
      if(gameOver){
        int winner = 0;
        if(player1Win){
          winner = 1;
        }
        else{
          winner = 2;
        }
        System.out.println("Player " + winner + " wins!");
        System.exit(0);
      }

      Scanner sc = new Scanner(System.in);

      System.out.println("Welcome to Tic Tac Toe!");
      System.out.println("Type 1 for additional instructions");
      System.out.println("Type 2 to start the game");
      int choice = sc.nextInt();
      if(choice == 1){
        System.out.println("Instructions:");
        System.out.println("1. The game is played on a 3x3 grid.");
        System.out.println("2. Players take turns placing their mark (X or O) in an empty cell, by entering the cell number (1-9).");
        System.out.println("3. The first player to get 3 marks in a row (horizontally, vertically, or diagonally) wins.");
        System.out.println("4. If all cells are filled and no player has 3 marks in a row, the game is a draw.");
      }
      else if(choice == 2){
        System.out.println("Would you like to play a robot(0) or a friend(1)?");
        int robotOrFriend = sc.nextInt();
        while(robotOrFriend != 0 && robotOrFriend != 1){
          System.out.println("Please either select 0(robot) or 1(friend).");
          robotOrFriend = sc.nextInt();
        }
        if(robotOrFriend == 0){
          System.out.println("Sorry, that functionality is unavailible");
          System.out.println("Starting a two-player game");
        }
        TickTackToe game = new TickTackToe(true);
        if(!gameOver){
          if(player1Turn){
            System.out.prinln("please place an X in any empty cell");
            int cell = sc.nextInt();
            if(cell < 1 || cell > 9){
              System.out.println("Invalid cell. Please enter a number between 1 and 9.");
            }
            else if(board[cell - 1] != 0){
              System.out.println("Cell already occupied. Please choose another cell.");
            }
            else{
              board[cell - 1] = 1;
              player1Turn = false;
            }
          }
        }
      }
      else{
        System.out.println("Invalid choice. Exiting...");
        gameOver = true;
        endEarly = true;
      }
      System.out.println("HI");
    }
}
