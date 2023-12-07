package Day07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day07 {
	private int solution1 = 0;
	private int solution2 = 0;
	static Scanner in;

	public static void main(String[] args) {
		Day07 day07 = new Day07();
		Day07.solution(day07);
		System.out.println("Solution 1: " + day07.getSolution1());
		System.out.println("Solution 2: " + day07.getSolution2());
	}

	private static void solution(Day07 day07) {

		StringBuilder sb = new StringBuilder();
		try {
			in = new Scanner(new FileReader("./src/Day05/Day05.txt"));
			while (in.hasNext()) {
				sb = new StringBuilder().append(in.next());
				day07.setSolution1(day07.getSolution1() + solution1(sb.toString()));
				day07.setSolution2(day07.getSolution2() + solution2(sb.toString()));
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
		} finally {
			in.close();
		}
	}

	private static int solution1(String string) {
		return 0;
	}

	private static int solution2(String string) {
		return 0; 
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
