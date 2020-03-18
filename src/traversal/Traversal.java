package traversal;

import princeton.In;

public class Traversal {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 2) {
			// Text mode
			In in = new In(args[0]);
			System.out.println(in.readLine());
			int R = in.readInt();
			int C = in.readInt();
			for (int r = 0; r < R; r++) {
				char dummy = in.readChar();
				for (int c = 0; c < C; c++) {
					char obs = in.readChar();
					System.out.println("r == " + r + " c == " + c + " obs == "
							+ obs);
				}
			}
		} else {
			System.out.println("Usage: java Keys [boardfile] [commandfile]");
		}
	}

}
