
public class TickTackToe {
  boolean player1Turn;
  boolean gameOver = false;
  boolean endEarly = false;
  int[] board = new int[9];

  public TickTackToe(boolean is2Player) {
    player1Turn = true;
    for (int i = 0; i < 9; i++) {
      board[i] = 0;
    }
  }

  public TickTackToe(boolean player1Turn, int[] board) {
    this.player1Turn = player1Turn;
    this.board = board;
    for (int i = 0; i < 9; i++) {
      board[i] = 0;
    }
  }

  public int getBoardValue(int location) {
    return board[location];
  }

  public void updateBoard(int[] board) {
    this.board = board;
  }

  @Override
  public String toString() {
    String printString = "\n";
    String currentChar;
    for (int i = 0; i < 9; i++) {
      switch (getBoardValue(i)) {
        case 1:
          currentChar = "X";
          break;
        case 2:
          currentChar = "O";
          break;
        default:
          currentChar = i + "";
          break;
      }
      printString += currentChar;
      if (!(i == 2 || i == 5 || i == 8)) {
        printString += "|";
      } else {
        printString += "\n";
      }
    }
    return printString;
  }

  public static void main(String[] args) {
    TickTackHelper helper = new TickTackHelper();
    helper.startGameLoop();
  }
}
