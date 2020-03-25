package traversal;

import princeton.In;

public class Traversal {

	// TODO: define your 2 dim array
	private static char[][] origBoard;
	private static char[][] board;
	private static int startRow, startCol, curRow, curCol;
	private static int rowCount;
	private static int colCount; 
	
	/**
	 * 
	 * @return
	 */
	private static char[][] copyBoard() {
		char[][] copy = new char[rowCount][colCount];
		// TODO: copy 
		for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
				copy[r][c] = board[r][c];
			}
		}
		return copy;
	}

	
	/**
	 * 
	 */
    private static void moveHorMovers() {
    	char[][] copy = copyBoard();
		for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
				if ("udlrHh".indexOf(copy[r][c]) >= 0) {
					// update board
					switch (copy[r][c]) {
					case 'u':
						if (r > 0) {
							board[r][c] = copy[r-1][c];
						}
						else if (r == 0) {
							board[r][c] = copy[rowCount - 1][c];
						}
						break;
					case 'd':
						if (r < (rowCount-1)) {
							board[r][c] = copy[r+1][c];
						}
						else if (r == (rowCount-1)) {
							board[r][c] = copy[0][c];
						}
						break;
					case 'l':
						if (c > 0) {
							board[r][c] = copy[r][c-1];
						}
						else if (c == 0) {
							board[r][c] = copy[r][colCount-1];
						}
						break;
					case 'r':
						if (c < (colCount-1)) {
							board[r][c] = copy[r][c+1];
						}
						else if (c == (colCount-1)) {
							board[r][c] = copy[r][0];
						}
						break;
					case 'h':
						board[r][c] = 'H';
					break;
					case 'H':
						board[r][c] = 'h';
					}
					
				}
			}
		}
    }
    
	/**
	 * 
	 */
    private static void moveVerMovers() {
    	char[][] copy = copyBoard();
    	for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
				if ("UDLRVv".indexOf(copy[r][c]) >= 0) {
					// update board
					switch (copy[r][c]) {
					case 'U':
						if (r > 0) {
							copy[r][c] = copy[r-1][c];
						}
						else if (r == 0) {
							copy[r][c] = copy[rowCount - 1][c];
						}
						break;
					case 'D':
						if (r < (rowCount-1)) {
							copy[r][c] = copy[r+1][c];
						}
						else if (r == (rowCount-1)) {
							copy[r][c] = copy[0][c];
						}
						break;
					case 'L':
						if (c > 0) {
							copy[r][c] = copy[r][c-1];
						}
						else if (c == 0) {
							copy[r][c] = copy[r][colCount-1];
						}
						break;
					case 'R':
						if (c < (colCount-1)) {
							copy[r][c] = copy[r][c+1];
						}
						else if (c == (colCount-1)) {
							copy[r][c] = copy[r][0];
						}
						break;
					case 'v':
						copy[r][c] = 'V';
						break;
					case 'V':
						copy[r][c] = 'v';
						break;
						
					}
					
				}
			}
		}
    }
    private static void updatePorts() {
    	String key = "kK";
    	char[][] copy = copyBoard();
    	for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
				if (key.indexOf(copy[r][c]) >= 0) {
					for (int i = 0; i < rowCount; i++) {
						for (int j = 0; j < colCount; j++) {
							if ("pP".indexOf(copy[r][c]) >= 0) {
								switch (copy[r][c]) {
								case 'p':
									copy[r][c] = 'P';
									break;
								case 'P':
									copy[r][c] = 'p';
									break;
									
								}
								
								}
								
							}
						}	
					}
				// make key unavailable ('.')
				copy[r][c] = '.';
					
				}
			}
		}

    
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 2) {
			// Text mode
			//System.out.println(args[0]);
			In boardFile = new In(args[0]);
			String boardName = boardFile.readLine();
			rowCount = boardFile.readInt();
			colCount = boardFile.readInt();
			origBoard = new char[rowCount][colCount];
			board = new char[rowCount][colCount];
			for (int r = 0; r < rowCount; r++) {
				boardFile.readChar(); // read new line
				for (int c = 0; c < colCount; c++) {
					char obs = boardFile.readChar();
					board[r][c] = obs;
					switch (board[r][c]) {
					case 's':
							curRow = r; // start row
							curCol = c; // start column 
							board[r][c] = '.';
					case 'S':
							curRow = r; // start row
							curCol = c; // start column 
							board[r][c] = '.';
					}
				}
			}

			// TODO: now read the moves file into a string
			//System.out.println(args[1]);
			In movesFile = new In(args[1]);
			String moves = movesFile.readString();
			boolean gameOver = false;
			String message = "";
			String lostChars = "xXpHVudlrUDLR";
			String target = "tT";
			
			for (int m = 0; m < moves.length(); m++) {
				System.out.print(moves.charAt(m)); // REMOVE AT END, NOT NEEDED FOR OUTPUT, JUST FOR TESTING
				
				
				switch (moves.charAt(m)) { // key inputs and subsequent moves and actions
					case 'h': // left move
						if (curCol > 0) {
							// check what is in the char to the left
							if (target.indexOf(origBoard[curRow][curCol-1]) >= 0) { // target
								message = "You won!";
								gameOver = true;
							} else if (lostChars.indexOf(board[curRow][curCol-1]) >= 0) { // obstacles*
								message = "You lost!";
								gameOver = true;
							} 
							moveHorMovers();
							updatePorts();
							curCol = curCol - 1;
						}
						break;
					case 'l': // right move
						if (curCol < (colCount-1)) {
							if (target.indexOf(origBoard[curRow][curCol+1]) >= 0) { // target
								message = "You won!";
								gameOver = true;
							} else if (lostChars.indexOf(board[curRow][curCol+1]) >= 0) { // wall
								message = "You lost!";
								gameOver = true;
							}
							moveHorMovers();
							updatePorts();
							curCol = curCol + 1;
						}  
						break;
					case 'j': // down move
						if ((curRow < (rowCount-1))) {
							if (target.indexOf(origBoard[curRow+1][curCol]) >= 0) {
								message = "You won!";
								gameOver = true;
							} else if (lostChars.indexOf(board[curRow+1][curCol]) >= 0) { // wall
								message = "You lost!";
								gameOver = true;
							}
							moveVerMovers();
							updatePorts();
							curRow = curRow + 1;
						} else { // at bottom of board
							moveVerMovers();
							updatePorts();
							curRow = 0;
						}
						break;
					case 'k': // up move
						if ((curRow > 0)) {
							if (target.indexOf(origBoard[curRow-1][curCol]) >= 0) {
								message = "You won!";
								gameOver = true;
							} else if (lostChars.indexOf(board[curRow-1][curCol]) >= 0) { // wall
								message = "You lost!";
								gameOver = true;
							}
							moveVerMovers();
							updatePorts();
							curRow = curRow - 1;
						} else { // at top of board
							moveVerMovers();
							updatePorts();
							curRow = (rowCount-1);
						}
						break;
					case 'x': 
						gameOver = true;
						break;
					default: 
						System.out.println("Incorrect move");
						gameOver = true;
						break;
						
				}

				//System.out.println("Usage: java Keys [boardFile] [commandfile]");
				if (gameOver) {
					break;
					
				}
			}
			System.out.println();
			
			// update board
			board[curRow][curCol] = 'Y';
			if (!message.isEmpty()) {
				System.out.println(message);
			}

			// TODO: print out board, changing characters to correct output characters
			String movers = "UDLRudlr";
			String wall = "xX";
			String closedSwitch = "hv";
			String openSwitch = "HV";
			String key = "kK";
			for (int r = 0; r < rowCount; r++) {
				for (int c = 0; c < colCount; c++) {
					if (target.indexOf(board[r][c]) >= 0) {
						board[r][c] = 't';
					}
					else if (key.indexOf(board[r][c]) >= 0) {
						board[r][c] = 'k';
					}
					else if (movers.indexOf(board[r][c]) >= 0) {
						board[r][c] = 'm';
					}
					else if (wall.indexOf(board[r][c]) >= 0) {
						board[r][c] = 'x';
					}
					else if (closedSwitch.indexOf(board[r][c]) >= 0) {
						board[r][c] = 's';
					}
					else if (openSwitch.indexOf(board[r][c]) >= 0) {
						board[r][c] = 'S';
					}
					System.out.print(board[r][c]);
				}
				System.out.print("\n");
			}
			
		}
	}

}
