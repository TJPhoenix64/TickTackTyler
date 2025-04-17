public class TickTackBoard {
    public TickTackBoard parentNode;
    public int height;
    public TickTackBoard[] childArray;
    public int[] board = new int[9];
    public final double winPoints = 10;
    public TickTackHelper helper = new TickTackHelper();

    public TickTackBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = 0;
        }
        childArray = new TickTackBoard[9];
        childArray = helper.populateBoardArray(board, helper);
        parentNode = null;
        height = 0;
    }

    public TickTackBoard(int[] board, int height) {
        childArray = new TickTackBoard[9 - height];
        this.board = board;
    }

    public int getHeight() {
        return height;
    }

    public int[] getCurrentBoard() {
        return board;
    }

    public TickTackBoard[] getChildArray() {
        return childArray;
    }

    @Override
    public String toString() {
        String printString = "\n";
        String currentChar;
        for (int i = 0; i < 9; i++) {
            switch (board[i]) {
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

}
