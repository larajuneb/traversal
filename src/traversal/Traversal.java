package traversal;

import princeton.In;


public class Traversal {

	private static String[][] board;
	private static int startRow, startCol, curRow, curCol;
	private static int rowCount;
	private static int colCount;

	/**
	 * 
	 * @return
	 */
	private static String[][] copyBoard() {
		String[][] copy = new String[rowCount][colCount];
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

	/**
	 * removes a char form the string and sets it to . if empty after remove
	 * 
	 * @param s
	 * @return
	 */
	private static String removeChar(String s, char c) {
		s = s.replaceFirst(String.valueOf(c), "");
		if (s.isEmpty()) {
			s = ".";
		}
		return s;
	}
	/*private static String removeChar(String s, int p) {
		if (p < s.length()) {
			s = s.substring(0, p) + s.substring(p + 1);
			if (s.isEmpty()) {
				s = ".";
			}
		}
		return s;
	}*/

	/**
	 * 
	 * @param s
	 * @param p
	 * @param newChar
	 * @return
	 */
	private static String replaceChar(String s, int p, char newChar) {
		return s.substring(0, p) + String.valueOf(newChar) + s.substring(p + 1);
	}

	/**
	 * adds char to he end of a string
	 * 
	 * @param s
	 * @return
	 */
	private static String addChar(String s, char c) {

		return s + String.valueOf(c);
	}

	/**
	 * 
	 * @param r
	 * @param c
	 * @param horChar
	 */
	private static void moveHorChar(int r, int c, char horChar) {
	 	//int charPos = currentString.indexOf(horChar);
		int newR=-1, newC=-1;
		// update board
		switch (horChar) {
		case 'u':
			if (r > 0) {
				newR = r-1; newC = c;
			} else if (r == 0) {
				newR = rowCount - 1; newC = c;
			}
			break;
		case 'd':
			if (r < (rowCount - 1)) {
				newR = r + 1; newC = c;
			} else if (r == (rowCount - 1)) {
				newR = 0; newC = c;
			}
			break;
		case 'l':
			if (c > 0) {
				newR = r; newC = c-1;
			} else if (c == 0) {
				newR = r; newC = colCount-1;
			}
			break;
		case 'r':
			if (c < (colCount - 1)) {
				newR = r; newC = c+1;
			} else if (c == (colCount - 1)) {
				newR = r; newC = 0;
			}
			break;
		/*case 'h':
			board[r][c] = replaceChar(currentString, i, 'H');
			break;
		case 'H':
			board[r][c] = replaceChar(currentString, i, 'h');*/
		}
		
		System.out.println(String.format("BEFORE moveHorMovers %s, prevPos[%d,%d]:%s, newPos[%d,%d]:%s ", 
				String.valueOf(horChar), 
				r, c, board[r][c],
				newR, newC, board[newR][newC]));
		
		if (newR != -1 && newC != -1) {
			// nothing must be changed
			board[r][c] = removeChar(board[r][c], horChar);
			board[newR][newC] = addChar(board[newR][newC], horChar);
		}
		
		System.out.println(String.format("AFTER moveHorMovers %s, prevPos[%d,%d]:%s, newPos[%d,%d]:%s ", 
				String.valueOf(horChar), 
				r, c, board[r][c],
				newR, newC, board[newR][newC]));
	}
	
	
	// TO DO: change to vertical
	private static void moveVerChar(int r, int c, char verChar) {
	 	//int charPos = currentString.indexOf(horChar);
		int newR=-1, newC=-1;
		// update board
		switch (verChar) {
		case 'U':
			if (r > 0) {
				newR = r-1; newC = c;
			} else if (r == 0) {
				newR = rowCount - 1; newC = c;
			}
			break;
		case 'D':
			if (r < (rowCount - 1)) {
				newR = r + 1; newC = c;
			} else if (r == (rowCount - 1)) {
				newR = 0; newC = c;
			}
			break;
		case 'L':
			if (c > 0) {
				newR = r; newC = c-1;
			} else if (c == 0) {
				newR = r; newC = colCount-1;
			}
			break;
		case 'R':
			if (c < (colCount - 1)) {
				newR = r; newC = c+1;
			} else if (c == (colCount - 1)) {
				newR = r; newC = 0;
			}
			break;
		/*case 'h':
			board[r][c] = replaceChar(currentString, i, 'H');
			break;
		case 'H':
			board[r][c] = replaceChar(currentString, i, 'h');*/
		}
		
		System.out.println(String.format("BEFORE moveHorMovers %s, prevPos[%d,%d]:%s, newPos[%d,%d]:%s ", 
				String.valueOf(verChar), 
				r, c, board[r][c],
				newR, newC, board[newR][newC]));
		
		if (newR != -1 && newC != -1) {
			// nothing must be changed
			board[r][c] = removeChar(board[r][c], verChar);
			board[newR][newC] = addChar(board[newR][newC], verChar);
		}
		
		System.out.println(String.format("AFTER moveHorMovers %s, prevPos[%d,%d]:%s, newPos[%d,%d]:%s ", 
				String.valueOf(verChar), 
				r, c, board[r][c],
				newR, newC, board[newR][newC]));
	}
	
	/**
	 * 
	 */
	private static void moveHorMovers() {
		String[][] copy = copyBoard();
		for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
				// loop through all of the characters in the string at r,c
				String currentString = copy[r][c];
				if (copy[r][c].indexOf('u') >= 0) {
					moveHorChar(r, c, 'u');
				}
				if (copy[r][c].indexOf('d') >= 0) {
					moveHorChar(r, c, 'd');
				}
				if (copy[r][c].indexOf('l') >= 0) {
					moveHorChar(r, c, 'l');
				}
				if (copy[r][c].indexOf('r') >= 0) {
					moveHorChar(r, c, 'r');
				}
			}
		}
	}

	private static void moveVerMovers() {
		String[][] copy = copyBoard();
		for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
				// loop through all of the characters in the string at r,c
				String currentString = copy[r][c];
				if (copy[r][c].indexOf('U') >= 0) {
					moveVerChar(r, c, 'U');
				}
				if (copy[r][c].indexOf('D') >= 0) {
					moveVerChar(r, c, 'D');
				}
				if (copy[r][c].indexOf('L') >= 0) {
					moveVerChar(r, c, 'L');
				}
				if (copy[r][c].indexOf('R') >= 0) {
					moveVerChar(r, c, 'R');
				}
			}
		}
	}


	/**
	 * 
	 */
	private static void updatePorts() {
		for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
				String currentString = board[r][c];
				for (int t = 0; t < currentString.length(); t++) {
					char currentChar = currentString.charAt(t);
					switch (currentChar) {
					case 'p':
						board[r][c] = replaceChar(currentString, t, 'P');
						break;
					case 'P':
						board[r][c] = replaceChar(currentString, t, 'p');
						break;
					default:
						break;
					}

				}

			}
		}
	}

	/**
	 * 
	 * @param b
	 */
	private static void printBoard(String[][] b) {
		for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
				System.out.print(b[r][c]);
			}
			System.out.print("\n");
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 2) {
			// Text mode
			// System.out.println(args[0]);
			In boardFile = new In(args[0]);
			String boardName = boardFile.readLine();
			rowCount = boardFile.readInt();
			colCount = boardFile.readInt();
			board = new String[rowCount][colCount];
			for (int r = 0; r < rowCount; r++) {
				boardFile.readChar(); // read new line
				for (int c = 0; c < colCount; c++) {
					char obs = boardFile.readChar();
					if ('s'==obs || 'S'==obs) {
						curRow = r; // start row
						curCol = c; // start column
						board[r][c] = ".";
					} else {
						board[r][c] = String.valueOf(obs);
					}
				}
			}

			// TODO: now read the moves file into a string
			// System.out.println(args[1]);
			In movesFile = new In(args[1]);
			String moves = movesFile.readString();
			boolean gameOver = false;
			String message = "";
			String lostChars = "xXpHVudlrUDLR";
			String target = "tT";

			for (int m = 0; m < moves.length(); m++) {
				// System.out.print(moves.charAt(m)); // REMOVE AT END, NOT
				// NEEDED
				// FOR OUTPUT, JUST FOR
				// TESTING
				System.out.println(String.format("\nMOVE %d: ", (m+1)));
				switch (moves.charAt(m)) { // key inputs and subsequent moves
											// and actions
				case 'h': // left move
					if (curCol > 0) {
						moveHorMovers();
						// check what is in the char to the left
						if (target.indexOf(board[curRow][curCol - 1]) >= 0) { // target
							message = "You won!";
							gameOver = true;
						} else if (lostChars.indexOf(board[curRow][curCol - 1]) >= 0) { // obstacles*
							message = "You lost!";
							gameOver = true;
						}
						curCol = curCol - 1;
					}
					break;
				case 'l': // right move
					if (curCol < (colCount - 1)) {
						moveHorMovers();
						if (target.indexOf(board[curRow][curCol + 1]) >= 0) { // target
							message = "You won!";
							gameOver = true;
						} else if (lostChars.indexOf(board[curRow][curCol + 1]) >= 0) { // wall
							message = "You lost!";
							gameOver = true;
						}
						curCol = curCol + 1;
					}
					break;
				case 'j': // down move
					moveVerMovers();
					if ((curRow < (rowCount - 1))) {
						if (target.indexOf(board[curRow + 1][curCol]) >= 0) {
							message = "You won!";
							gameOver = true;
						} else if (lostChars.indexOf(board[curRow + 1][curCol]) >= 0) { // wall
							message = "You lost!";
							gameOver = true;
						}
						curRow = curRow + 1;
					} else { // at bottom of board
						curRow = 0;
					}
					break;
				case 'k': // up move
					moveVerMovers();
					if ((curRow > 0)) {
						if (target.indexOf(board[curRow - 1][curCol]) >= 0) {
							message = "You won!";
							gameOver = true;
						} else if (lostChars.indexOf(board[curRow - 1][curCol]) >= 0) { // wall
							message = "You lost!";
							gameOver = true;
						}
						curRow = curRow - 1;
					} else { // at top of board
						curRow = (rowCount - 1);
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

				// if current string contains key,move ports
				if (board[curRow][curCol].contains("k")|| board[curRow][curCol].contains("K")) {
						updatePorts();
						board[curRow][curCol] = board[curRow][curCol].replace("k", "").replace("K", "");
						if (board[curRow][curCol].isEmpty()) {
							board[curRow][curCol] = ".";
						}
				}
				System.out.println("*****************************************************************************");
				printBoard(board);
				System.out.println("*****************************************************************************");
				
				// System.out.println("Usage: java Keys [boardFile] [commandfile]");
				if (gameOver) {
					break;

				}
			}
			System.out.println();

			// update board
			board[curRow][curCol] = addChar(board[curRow][curCol], 'Y');
			if (!message.isEmpty()) {
				System.out.println(message);
			}

			// TODO: print out board, changing characters to correct output
			// characters
			String movers = "UDLRudlr";
			String wall = "xX";
			String closedSwitch = "hv";
			String openSwitch = "HV";
			String key = "kK";
			for (int r = 0; r < rowCount; r++) {
				for (int c = 0; c < colCount; c++) {
					char lastChar = board[r][c].charAt(board[r][c].length()-1);
					if (target.indexOf(lastChar) >= 0) {
						lastChar = 't';
					} else if (key.indexOf(lastChar) >= 0) {
						lastChar = 'k';
					} else if (movers.indexOf(lastChar) >= 0) {
						lastChar = 'm';
					} else if (wall.indexOf(lastChar) >= 0) {
						lastChar = 'x';
					} else if (closedSwitch.indexOf(lastChar) >= 0) {
						lastChar = 's';
					} else if (openSwitch.indexOf(lastChar) >= 0) {
						lastChar = 'S';
					}
					System.out.print(lastChar);
				}
				System.out.print("\n");
			}
		}
	}
}