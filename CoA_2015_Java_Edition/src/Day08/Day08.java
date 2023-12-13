package Day08;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day08 {
	private int solution1 = 0;
	private int solution2 = 0;
	static Scanner in;

	public static void main(String[] args) {
		Day08 day08 = new Day08();
		Day08.solution(day08);
		System.out.println("Solution 1: " + day08.getSolution1());
		System.out.println("Solution 2: " + day08.getSolution2());
	}

	private static void solution(Day08 day08) {

		StringBuilder sb = new StringBuilder();
		try {
			in = new Scanner(new FileReader("./src/Day08/Day08.txt"));
			while (in.hasNext()) {
				sb = new StringBuilder().append(in.nextLine());
				day08.setSolution1(day08.getSolution1() + solution1(sb.toString()));
				day08.setSolution2(day08.getSolution2() + solution2(sb.toString()));
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
		} finally {
			in.close();
		}

	}

	private static int solution1(String string) {

		StringBuilder result = new StringBuilder();

		for (int i = 1; i < string.length() - 1; i++) {
			char currentChar = string.charAt(i);

			if (currentChar == '\\' && i + 1 < string.length() - 1) {
				char nextChar = string.charAt(i + 1);

				if (nextChar == '\"' || nextChar == '\\') {
					result.append("'");
					i++;
				} else if (nextChar == 'x' && i + 3 < string.length() - 1) {
					result.append((char) Integer.parseInt(string.substring(i + 2, i + 4), 16));
					i += 3;
				} else {
					result.append(currentChar);
				}
			} else {
				result.append(currentChar);
			}
		}

		return string.length() - result.toString().length();

	}

	private static int solution2(String string) {
		
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < string.length(); i++) {
			char currentChar = string.charAt(i);

			if (currentChar == '"') {
				result.append('\\');
				result.append('"');	
			}else if (currentChar == '\\') {
				result.append('\\');
				result.append('\\');
				
			} else {
				result.append(currentChar);
			}
		}
		result.append('"');
		result.insert(0, '"');
		System.out.println(string);
		System.out.println(result.toString());

		return result.toString().length() - string.length();
	}

	public int getSolution1() {
		return solution1;
	}

	public void setSolution1(int solution1) {
		this.solution1 = solution1;
	}

	public int getSolution2() {
		return solution2;
	}

	public void setSolution2(int solution2) {
		this.solution2 = solution2;
	}

}
