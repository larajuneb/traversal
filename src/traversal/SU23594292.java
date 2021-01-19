package traversal;

import princeton.In;
import princeton.StdDraw;

public class SU23594292 {

	private static String[][] board;
	private static int curRow, curCol;
	private static int rowCount;
	private static int colCount;

	/**
	 * 
	 * @return
	 */
	private static String[][] copyBoard() { // create copy board
		String[][] copy = new String[rowCount][colCount];
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
	private static String removeChar(String s, char c) { // remove a character from a string
		s = s.replaceFirst(String.valueOf(c), "");
		if (s.isEmpty()) {
			s = ".";
		}
		return s;
	}

	/**
	 * adds char to he end of a string
	 * 
	 * @param s
	 * @return
	 */
	private static String addChar(String s, char c) { // add a character to a string

		return s + String.valueOf(c);
	}

	/**
	 * 
	 * @param r
	 * @param c
	 * @param horChar
	 */
	private static void moveHorChar(int r, int c, char horChar) { // move horizontal movers' characters
		int newR = -1, newC = -1;
		switch (horChar) {
		case 'u':
			if (r > 0) {
				newR = r - 1;
				newC = c; // update character's new position
			} else if (r == 0) {
				newR = rowCount - 1;
				newC = c; // update character's new position
			}
			break;
		case 'd':
			if (r < (rowCount - 1)) {
				newR = r + 1;
				newC = c; // update character's new position
			} else if (r == (rowCount - 1)) {
				newR = 0;
				newC = c; // update character's new position
			}
			break;
		case 'l':
			if (c > 0) {
				newR = r;
				newC = c - 1; // update character's new position
			} else if (c == 0) {
				newR = r;
				newC = colCount - 1; // update character's new position
			}
			break;
		case 'r':
			if (c < (colCount - 1)) {
				newR = r;
				newC = c + 1; // update character's new position
			} else if (c == (colCount - 1)) {
				newR = r;
				newC = 0; // update character's new position
			}
			break;
		}


		if (newR != -1 && newC != -1) { // nothing must be changed
			board[r][c] = removeChar(board[r][c], horChar);
			board[newR][newC] = addChar(board[newR][newC], horChar);
		}
		
	}

	private static void moveVerChar(int r, int c, char verChar) { // move vertical movers
		int newR = -1, newC = -1;
		switch (verChar) {
		case 'U':
			if (r > 0) {
				newR = r - 1;
				newC = c; // update character's new position
			} else if (r == 0) {
				newR = rowCount - 1;
				newC = c; // update character's new position
			}
			break;
		case 'D':
			if (r < (rowCount - 1)) {
				newR = r + 1;
				newC = c; // update character's new position
			} else if (r == (rowCount - 1)) {
				newR = 0;
				newC = c; // update character's new position
			}
			break;
		case 'L':
			if (c > 0) {
				newR = r;
				newC = c - 1; // update character's new position
			} else if (c == 0) {
				newR = r;
				newC = colCount - 1; // update character's new position
			}
			break;
		case 'R':
			if (c < (colCount - 1)) {
				newR = r;
				newC = c + 1; // update character's new position
			} else if (c == (colCount - 1)) {
				newR = r;
				newC = 0; // update character's new position
			}
			break;
		}


		if (newR != -1 && newC != -1) { // nothing must be changed
			board[r][c] = removeChar(board[r][c], verChar);
			board[newR][newC] = addChar(board[newR][newC], verChar);
		}
		
	}

	/**
	 * 
	 */
	private static void moveHorMovers() { // update all horizontal obstacles
		String[][] copy = copyBoard();
		for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
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
				if (copy[r][c].contains("h")) {
					board[r][c] = board[r][c].replaceAll("h", "H"); // change closed switch to open
				}
				if (copy[r][c].contains("H")) {
					board[r][c] = board[r][c].replaceAll("H", "h"); // change open switch to closed
				}
			}
		}
	}

	private static void moveVerMovers() { // update all vertical obstacles
		String[][] copy = copyBoard();
		for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
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
				if (copy[r][c].contains("v")) {
					board[r][c] = board[r][c].replaceAll("v", "V"); // change closed switch to open
				}
				if (copy[r][c].contains("V")) {
					board[r][c] = board[r][c].replaceAll("V", "v"); // change open switch to closed
				}
			}
		}
	}

	/**
	 * 
	 */
	private static void updatePorts() { // update all ports
		String[][] copy = copyBoard();
		for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
				if (copy[r][c].contains("p")) {
					board[r][c] = board[r][c].replaceAll("p", "P"); // change closed port to open
				}
				if (copy[r][c].contains("P")) {
					board[r][c] = board[r][c].replaceAll("P", "p"); // change open port to closed
				}
			}
		}
	}

	private static char get_next_key() {
		while (StdDraw.hasNextKeyTyped() == false) {
		}
		return StdDraw.nextKeyTyped();
	}

	private static void drawBoard(int colCount, int rowCount) {
		StdDraw.setCanvasSize(108 * colCount, 108 * rowCount);
		StdDraw.setXscale(0, colCount);
		StdDraw.setYscale(0, rowCount);
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		StdDraw.filledRectangle(((double) (colCount) / 2), ((double) rowCount) / 2, ((double) (colCount) / 2), ((double) rowCount) / 2);
		StdDraw.picture(0, rowCount, "images/tvl_e.png", 0.76, 0.76);
	}

	private static void updateElements() { // draw updated elements on board
		for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
				char lastChar = board[r][c].charAt(board[r][c].length() - 1);
				if (("t".indexOf(lastChar) >= 0) || ("T".indexOf(lastChar) >= 0)) { // target
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5), "images/tvl_t.png", 0.76, 0.76);
				}
				if (("x".indexOf(lastChar) >= 0)
						|| ("X".indexOf(lastChar) >= 0)) { // wall
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_x.png", 0.76, 0.76);
				}
				if (".".indexOf(lastChar) >= 0) { // empty square
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_e.png", 0.76, 0.76);
				}
				if (("k".indexOf(lastChar) >= 0) || ("K".indexOf(lastChar) >= 0)) { // available key
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5), "images/tvl_k1.png", 0.76, 0.76);
				}
				if ("g".indexOf(lastChar) >= 0) { // unavailable key
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_k0.png", 0.76, 0.76);
				}
				if ("P".indexOf(lastChar) >= 0) { // open port
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_p0.png", 0.76, 0.76);
				}
				if ("p".indexOf(lastChar) >= 0) { // closed port
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_p1.png", 0.76, 0.76);
				}
				if ("V".indexOf(lastChar) >= 0) { // open vertical switch
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_sv1.png", 0.76, 0.76);
				}
				if ("v".indexOf(lastChar) >= 0) { // closed vertical switch
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_sv0.png", 0.76, 0.76);
				}
				if ("H".indexOf(lastChar) >= 0) { // open horizontal switch
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_sh1.png", 0.76, 0.76);
				}
				if ("h".indexOf(lastChar) >= 0) { // closed horizontal switch
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_sh0.png", 0.76, 0.76);
				}
				if ("U".indexOf(lastChar) >= 0) { // vertical up mover
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_uv.png", 0.76, 0.76);
				}
				if ("D".indexOf(lastChar) >= 0) { // vertical down mover
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_dv.png", 0.76, 0.76);
				}
				if ("L".indexOf(lastChar) >= 0) { // vertical left mover
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_lv.png", 0.76, 0.76);
				}
				if ("R".indexOf(lastChar) >= 0) { // vertical right mover
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_rv.png", 0.76, 0.76);
				}
				if ("u".indexOf(lastChar) >= 0) { // horizontal up mover
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_uh.png", 0.76, 0.76);
				}
				if ("d".indexOf(lastChar) >= 0) { // horizontal down mover
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_dh.png", 0.76, 0.76);
				}
				if ("l".indexOf(lastChar) >= 0) { // horizontal left mover
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_lh.png", 0.76, 0.76);
				}
				if ("r".indexOf(lastChar) >= 0) { // horizontal right mover
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_rh.png", 0.76, 0.76);
				}
				if (("y".indexOf(lastChar) >= 0)
						|| ("Y".indexOf(lastChar) >= 0)) { // horizontal right
															// mover
					StdDraw.picture((c + 0.5), (rowCount - r - 0.5),
							"images/tvl_s.png", 0.76, 0.76);
				}
			}
		}

	}

	/**
	 * 
	 * @param b
	 */

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		In boardFile = new In(args[0]);
		boardFile.readLine(); // read name of board
		rowCount = boardFile.readInt();
		colCount = boardFile.readInt();
		board = new String[rowCount][colCount];
		boolean gameOver = false;
		String message = "";
		String lostChars = "xXphvudlrUDLR"; // any obstacle that will cause you to lose
		String target = "tT"; // the target

		if (args.length == 2) { // TEXT MODE
			for (int r = 0; r < rowCount; r++) {// read the moves file into a string:
				boardFile.readChar(); // read new line
				for (int c = 0; c < colCount; c++) {
					char obs = boardFile.readChar();
					if ('s' == obs || 'S' == obs) {
						curRow = r; // start row
						curCol = c;// start column
						board[r][c] = ".";
					} else {
						board[r][c] = String.valueOf(obs);
					}
				}
			}
			In movesFile = new In(args[1]);
			String moves = movesFile.readString();

			for (int m = 0; m < moves.length(); m++) {
				switch (moves.charAt(m)) { // key inputs and subsequent moves and actions

				case 'h': // left move
					if (curCol > 0) { // check that the player is not on the left side of the board
						moveHorMovers();
						board[curRow][curCol] = removeChar(board[curRow][curCol], 'Y');
						curCol = curCol - 1; // update position
						board[curRow][curCol] = addChar(board[curRow][curCol], 'Y');
						// check what is in the string to the left
						if (board[curRow][curCol].matches(".*[" + target + "].*")) { // reached target
							message = "You won!";
							System.out.println(message);
							gameOver = true;
						} else if (board[curRow][curCol].matches(".*[" + lostChars + "].*")) { // hit an obstacle
							message = "You lost!";
							System.out.println(message);
							gameOver = true;
						}
					}
					break;
				case 'l': // right move
					if (curCol < (colCount - 1)) { // check that the player is not on the right side of the board
						moveHorMovers();
						board[curRow][curCol] = removeChar(board[curRow][curCol], 'Y');
						curCol = curCol + 1; // update position
						board[curRow][curCol] = addChar(board[curRow][curCol], 'Y');
						// check what is in the string to the right
						if (board[curRow][curCol].matches(".*[" + target
								+ "].*")) { // reached target
							message = "You won!";
							System.out.println(message);
							gameOver = true;
						} else if (board[curRow][curCol].matches(".*[" + lostChars + "].*")) { // hit an obstacle
							message = "You lost!";
							System.out.println(message);
							gameOver = true;
						}
					}
					break;
				case 'j': // down move
					moveVerMovers();
					// check what is in the string below
					if ((curRow < (rowCount - 1))) { // check that the player is not at the bottom of the board
						board[curRow][curCol] = removeChar(board[curRow][curCol], 'Y');
						curRow = curRow + 1; // update position
						board[curRow][curCol] = addChar(board[curRow][curCol], 'Y');
						if (board[curRow][curCol].matches(".*[" + target + "].*")) { // reached target
							message = "You won!";
							System.out.println(message);
							gameOver = true;
						} else if (board[curRow][curCol].matches(".*[" + lostChars + "].*")) { // hit an obstacle
							message = "You lost!";
							System.out.println(message);
							gameOver = true;
						}
					} else { // the player is at bottom of the board, now wrap to the top
						board[curRow][curCol] = removeChar(board[curRow][curCol], 'Y');
						curRow = 0; // update position
						board[curRow][curCol] = addChar(board[curRow][curCol], 'Y');
						if (board[curRow][curCol].matches(".*[" + target + "].*")) { // reached target
							message = "You won!";
							gameOver = true;
							System.out.println(message);
						} else if (board[curRow][curCol].matches(".*[" + lostChars + "].*")) { // hit an obstacle
							message = "You lost!";
							gameOver = true;
							System.out.println(message);
						}
					}
					break;
				case 'k': // up move
					moveVerMovers();
					// check what is in the string above
					if ((curRow > 0)) { // check that the player is not at the top of the board
						board[curRow][curCol] = removeChar(board[curRow][curCol], 'Y');
						curRow = curRow - 1; // update position
						board[curRow][curCol] = addChar(board[curRow][curCol], 'Y');
						if (board[curRow][curCol].matches(".*[" + target + "].*")) { // reached target
							message = "You won!";
							System.out.println(message);
							gameOver = true;
						} else if (board[curRow][curCol].matches(".*[" + lostChars + "].*")) { // hit an obstacle
							message = "You lost!";
							System.out.println(message);
							gameOver = true;
						}
					} else { // the player is at the top of board, now wrap to the bottom
						board[curRow][curCol] = removeChar(board[curRow][curCol], 'Y');
						curRow = (rowCount - 1); // update position
						board[curRow][curCol] = addChar(board[curRow][curCol], 'Y');
						if (board[curRow][curCol].matches(".*[" + target + "].*")) { // reached target
							message = "You won!";
							gameOver = true;
							System.out.println(message);
						} else if (board[curRow][curCol].matches(".*[" + lostChars + "].*")) { // hit an obstacle
							message = "You lost!";
							gameOver = true;
							System.out.println(message);
						}
					}
					break;
				case 'x': // player quits game
					gameOver = true;
					break;
				default: // player presses invalid key
					message = "Incorrect move";
					System.out.println(message);
					gameOver = true;
					break;

				}

				// if current string contains a key, move ports
				if (board[curRow][curCol].contains("k")
						|| board[curRow][curCol].contains("K")) {
					updatePorts();
					board[curRow][curCol] = board[curRow][curCol].replace("k",
							"g").replace("K", "g"); // once the player has touched a key, the key becomes unavailable
					if (board[curRow][curCol].isEmpty()) {
						board[curRow][curCol] = ".";
					}
				}
				
				if (gameOver) {
					break;

				}
			}
			

			// update player position
			board[curRow][curCol] = addChar(board[curRow][curCol], 'Y');
			

			// print out board, changing characters to correct output characters
			String movers = "UDLRudlr";
			String wall = "xX";
			String closedSwitch = "hv";
			String openSwitch = "HV";
			String key = "kKg";
			for (int r = 0; r < rowCount; r++) {
				for (int c = 0; c < colCount; c++) {
					char lastChar = board[r][c]
							.charAt(board[r][c].length() - 1);
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

		else if (args.length == 1) { // GRAPHICS MODE

			for (int r = 0; r < rowCount; r++) {
				boardFile.readChar(); // read new line
				for (int c = 0; c < colCount; c++) {
					char obs = boardFile.readChar();
					if ('s' == obs || 'S' == obs) {
						curRow = r; // start row
						curCol = c;
						// start column
						board[r][c] = "Y";
					} else {
						board[r][c] = String.valueOf(obs);
					}
				}
			}
			
			drawBoard(colCount, rowCount);
			updateElements();
			gameOver = false;
			lostChars = "xXpHVudlrUDLR";

			while (gameOver == false) {
				char keyPress = get_next_key();
				switch (keyPress) { // key inputs and subsequent moves and actions

				case 'h': // left move

					if (curCol > 0) { // check that the player is not on the left side of the board
						moveHorMovers();
						board[curRow][curCol] = removeChar(board[curRow][curCol], 'Y');
						curCol = curCol - 1; // update position
						board[curRow][curCol] = addChar(board[curRow][curCol], 'Y');
						// check what is in the string to the left
						if (board[curRow][curCol].matches(".*[" + target + "].*")) { // reached target
							message = "You won!";
							gameOver = true;
							System.out.println(message);
						} else if (board[curRow][curCol].contains(".*[" + lostChars + "].*")) { // hit an obstacle
							message = "You lost!";
							gameOver = true;
							System.out.println(message);
						}
					}
					break;
				case 'l': // right move
					if (curCol < (colCount - 1)) { // check that the player is not on the right side of the board
						moveHorMovers();
						board[curRow][curCol] = removeChar(board[curRow][curCol], 'Y');
						curCol = curCol + 1; // update position
						board[curRow][curCol] = addChar(board[curRow][curCol], 'Y');
						// check what is in the string to the right
						if (board[curRow][curCol].matches(".*[" + target + "].*")) { // reached target
							message = "You won!";
							gameOver = true;
							System.out.println(message);
						} else if (board[curRow][curCol].matches(".*[" + lostChars + "].*")) { // hit an obstacle
							message = "You lost!";
							gameOver = true;
							System.out.println(message);
						}
					}
					break;
				case 'j': // down move
					moveVerMovers();
					// check what is in the string below
					if ((curRow < (rowCount - 1))) { // check that the player is not at the bottom of the board
						board[curRow][curCol] = removeChar(board[curRow][curCol], 'Y');
						curRow = curRow + 1; // update position
						board[curRow][curCol] = addChar(board[curRow][curCol], 'Y');
						if (board[curRow][curCol].matches(".*[" + target + "].*")) { // reached target
							message = "You won!";
							gameOver = true;
							System.out.println(message);
						} else if (board[curRow][curCol].matches(".*[" + lostChars + "].*")) { // hit an obstacle
							message = "You lost!";
							gameOver = true;
							System.out.println(message);
						}
					} else { // the player is at bottom of the board, now wrap to the top
						board[curRow][curCol] = removeChar(board[curRow][curCol], 'Y');
						curRow = 0; // update position
						board[curRow][curCol] = addChar(board[curRow][curCol], 'Y');
						if (board[curRow][curCol].matches(".*[" + target + "].*")) { // reached target
							message = "You won!";
							gameOver = true;
							System.out.println(message);
						} else if (board[curRow][curCol].matches(".*[" + lostChars + "].*")) { // hit an obstacle
							message = "You lost!";
							gameOver = true;
							System.out.println(message);
						}
					}
					break;
				case 'k': // up move
					moveVerMovers();
					// check what is in the string above
					if ((curRow > 0)) { // check that the player is not at the top of the board
						board[curRow][curCol] = removeChar(board[curRow][curCol], 'Y');
						curRow = curRow - 1; // update position
						board[curRow][curCol] = addChar(board[curRow][curCol], 'Y');
						if (board[curRow][curCol].matches(".*[" + target + "].*")) { // reached target
							message = "You won!";
							gameOver = true;
							System.out.println(message);
						} else if (board[curRow][curCol].matches(".*[" + lostChars + "].*")) { // hit an obstacle
							message = "You lost!";
							gameOver = true;
							System.out.println(message);
						}
						
					} else { // the player is at the top of board, now wrap to the bottom
						board[curRow][curCol] = removeChar(board[curRow][curCol], 'Y');
						curRow = (rowCount - 1); // update position
						board[curRow][curCol] = addChar(board[curRow][curCol], 'Y');
						if (board[curRow][curCol].matches(".*[" + target + "].*")) { // reached target
							message = "You won!";
							gameOver = true;
							System.out.println(message);
						} else if (board[curRow][curCol].matches(".*[" + lostChars + "].*")) { // hit an obstacle
							message = "You lost!";
							gameOver = true;
							System.out.println(message);
						}
					}
					break;
				case 'q': // player quits game
					gameOver = true;
					message = "You quit the game";
					break;
				default: // player presses invalid key, program completely ignores this
					break;
				}

				// if current string contains a key, move ports
				if (board[curRow][curCol].contains("k") || board[curRow][curCol].contains("K")) {
					updatePorts();
					board[curRow][curCol] = board[curRow][curCol].replace("k", "g").replace("K", "g"); // once the player has touched a key, the key becomes unavailable
				}

				updateElements();

				if (gameOver == true) { // fade out
					for (int s = 204; s >= 0; s--) {
						StdDraw.setPenColor(s, s, s);
						StdDraw.filledRectangle(((double) (colCount) / 2), ((double) rowCount) / 2, ((double) (colCount) / 2), ((double) rowCount) / 2);
						StdDraw.show(6);
					}
					System.exit(0);
				}
			}
		}
	}
}