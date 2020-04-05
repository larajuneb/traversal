package traversal;

import princeton.In;


public class Traversal {

	// TODO: define your 2 dim array
	private static String[][] origBoard;
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
	private static String removeChar(String s, int p) {
		if (p < s.length()) {
			s = s.substring(0, p) + s.substring(p + 1);
			if (s.isEmpty()) {
				s = ".";
			}
		}
		return s;
	}

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
	 */

	private static void moveHorMovers() {
		String[][] copy = copyBoard();
		for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
				// loop through all of the characters in the string at r,c
				String currentString = copy[r][c];
				for (int i = 0; i < currentString.length(); i++) {
					char currentChar = currentString.charAt(i);
					if ("udlrHh".indexOf(currentChar) >= 0) {
						// update board
						switch (currentChar) {
						case 'u':
							if (r > 0) {
								board[r - 1][c] = addChar(board[r - 1][c],
										currentChar); // add this char at the
														// end of the string at
														// new position
								board[r][c] = removeChar(currentString, i); // remove
																			// the
																			// char
																			// from
																			// string
																			// at
																			// current
																			// position
							} else if (r == 0) {
								board[rowCount - 1][c] = addChar(
										board[rowCount - 1][c], currentChar);
								board[r][c] = removeChar(currentString, i);
							}
							break;
						case 'd':
							if (r < (rowCount - 1)) {
								board[r + 1][c] = addChar(board[r + 1][c],
										currentChar);
								board[r][c] = removeChar(currentString, i);
							} else if (r == (rowCount - 1)) {
								board[0][c] = addChar(board[0][c], currentChar);
								board[r][c] = removeChar(currentString, i);
							}
							break;
						case 'l':
							if (c > 0) {
								board[r][c - 1] = addChar(board[r][c - 1],
										currentChar);
								board[r][c] = removeChar(currentString, i);
							} else if (c == 0) {
								board[r][colCount - 1] = addChar(
										board[r][colCount - 1], currentChar);
								board[r][c] = removeChar(currentString, i);
							}
							break;
						case 'r':
							if (c < (colCount - 1)) {
								board[r][c + 1] = addChar(board[r][c + 1],
										currentChar);
								board[r][c] = removeChar(currentString, i);
							} else if (c == (colCount - 1)) {
								board[r][0] = addChar(board[r][0], currentChar);
								board[r][c] = removeChar(currentString, i);
							}
							break;
						case 'h':
							board[r][c] = replaceChar(currentString, i, 'H');
							break;
						case 'H':
							board[r][c] = replaceChar(currentString, i, 'h');
						}

					}
				}
			}
		}
	}

	private static void moveVerMovers() {
		String[][] copy = copyBoard();
		for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
				// loop through all the chars in the string at r,c
				String currentString = copy[r][c];
				for (int i = 0; i < currentString.length(); i++) {
					char currentChar = currentString.charAt(i);
					if ("UDLRVv".indexOf(currentChar) >= 0) {
						// update board
						switch (currentChar) {
						case 'U':
							if (r > 0) {
								board[r - 1][c] = addChar(board[r - 1][c],
										currentChar); // add this char at the
														// end of the string at
														// new position
								board[r][c] = removeChar(currentString, i); // remove
																			// the
																			// char
																			// from
																			// string
																			// at
																			// current
																			// position
							} else if (r == 0) {
								board[rowCount - 1][c] = addChar(
										board[rowCount - 1][c], currentChar);
								board[r][c] = removeChar(currentString, i);
							}
							break;
						case 'D':
							if (r < (rowCount - 1)) {
								board[r + 1][c] = addChar(board[r + 1][c],
										currentChar);
								board[r][c] = removeChar(currentString, i);
							} else if (r == (rowCount - 1)) {
								board[0][c] = addChar(board[0][c], currentChar);
								board[r][c] = removeChar(currentString, i);
							}
							break;
						case 'L':
							if (c > 0) {
								board[r][c - 1] = addChar(board[r][c - 1],
										currentChar);
								board[r][c] = removeChar(currentString, i);
							} else if (c == 0) {
								board[r][colCount - 1] = addChar(
										board[r][colCount - 1], currentChar);
								board[r][c] = removeChar(currentString, i);
							}
							break;
						case 'R':
							if (c < (colCount - 1)) {
								board[r][c + 1] = addChar(
										board[r][colCount + 1], currentChar);
								board[r][c] = removeChar(currentString, i);
							} else if (c == (colCount - 1)) {
								board[r][0] = addChar(board[r][colCount + 1],
										currentChar);
								board[r][c] = removeChar(currentString, i);
							}
							break;
						case 'v':
							board[r][c] = replaceChar(currentString, i, 'V');
							break;
						case 'V':
							board[r][c] = replaceChar(currentString, i, 'v');
							break;

						}
					}
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
						board[curRow][curCol] = "Y";
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

				switch (moves.charAt(m)) { // key inputs and subsequent moves
											// and actions
				case 'h': // left move
					if (curCol > 0) {
						moveHorMovers();
						// check what is in the char to the left
						if (target.indexOf(origBoard[curRow][curCol - 1]) >= 0) { // target
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
						if (target.indexOf(origBoard[curRow][curCol + 1]) >= 0) { // target
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
						if (target.indexOf(origBoard[curRow + 1][curCol]) >= 0) {
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
						if (target.indexOf(origBoard[curRow - 1][curCol]) >= 0) {
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
				if (board[curRow][curCol].contains("k")
						|| board[curRow][curCol].contains("K")) {
					updatePorts();
					board[curRow][curCol] = board[curRow][curCol].replace("k",
							"").replace("K", "");
					if (board[curRow][curCol].isEmpty()) {
						board[curRow][curCol] = ".";
					}
				}

				// System.out.println("Usage: java Keys [boardFile] [commandfile]");
				if (gameOver) {
					break;

				}
			}
			System.out.println();

			// update board
			board[curRow][curCol] = addChar(board[curRow][curCol], 'y');
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
					if (target.indexOf(board[r][c]) >= 0) {
						board[r][c] = "t";
					} else if (key.indexOf(board[r][c]) >= 0) {
						board[r][c] = "k";
					} else if (movers.indexOf(board[r][c]) >= 0) {
						board[r][c] = "m";
					} else if (wall.indexOf(board[r][c]) >= 0) {
						board[r][c] = "x";
					} else if (closedSwitch.indexOf(board[r][c]) >= 0) {
						board[r][c] = "s";
					} else if (openSwitch.indexOf(board[r][c]) >= 0) {
						board[r][c] = "S";
					}
					System.out.print(board[r][c]);
				}
				System.out.print("\n");
			}
		}
	}
}