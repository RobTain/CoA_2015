package Day06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Day06 {
	private int solution1 = 0;
	private int solution2 = 0;
	static Scanner in;

	public static void main(String[] args) {
		Day06 day06 = new Day06();
		Day06.solution(day06);
		System.out.println("Solution 1: " + day06.getSolution1());
		System.out.println("Solution 2: " + day06.getSolution2());
	}

	private static void solution(Day06 day06) {
		LinkedList<String> input = new LinkedList<>();
		try {
			in = new Scanner(new FileReader("./src/Day06/Day06.txt"));
			while (in.hasNext()) {
				input.add(in.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
		} finally {
			in.close();
		}
		day06.setSolution1(day06.getSolution1() + solution1(input));
		day06.setSolution2(day06.getSolution2() + solution2(input));
	}

	private static int solution1(LinkedList<String> input) {
		boolean[][] grid = new boolean[1000][1000];
		
		for (String s : input) {

			if (s.contains("toogle")) {
				s = s.replace("toggle ", "").replace(" through ", "-");
				
				int startPositionI = Integer.parseInt(s.split("-")[0].split(",")[0]);
				int startPositionJ = Integer.parseInt(s.split("-")[0].split(",")[1]);
				int endPositionI = Integer.parseInt(s.split("-")[1].split(",")[0]);
				int endPositionJ = Integer.parseInt(s.split("-")[1].split(",")[1]);
				for (int i = startPositionI; i <= endPositionI; i++) {
					for (int j = startPositionJ; j <= endPositionJ; j++) {
						grid[i][j] = !grid[i][j];
					}
				}
			}
			
			if (s.contains("turn off")) {
				s = s.replace("turn off ", "").replace(" through ", "-");
				
				int startPositionI = Integer.parseInt(s.split("-")[0].split(",")[0]);
				int startPositionJ = Integer.parseInt(s.split("-")[0].split(",")[1]);
				int endPositionI = Integer.parseInt(s.split("-")[1].split(",")[0]);
				int endPositionJ = Integer.parseInt(s.split("-")[1].split(",")[1]);
				for (int i = startPositionI; i <= endPositionI; i++) {
					for (int j = startPositionJ; j <= endPositionJ; j++) {
						grid[i][j] = false;
					}
				}
			}
			
			if (s.contains("turn on")) {
				s = s.replace("turn on ", "").replace(" through ", "-");
				
				int startPositionI = Integer.parseInt(s.split("-")[0].split(",")[0]);
				int startPositionJ = Integer.parseInt(s.split("-")[0].split(",")[1]);
				int endPositionI = Integer.parseInt(s.split("-")[1].split(",")[0]);
				int endPositionJ = Integer.parseInt(s.split("-")[1].split(",")[1]);
				for (int i = startPositionI; i <= endPositionI; i++) {
					for (int j = startPositionJ; j <= endPositionJ; j++) {
						grid[i][j] = true;
					}
				}
			}	
		}
		
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j]) {
					result++;
				}
			}
		}
		return result;
	}

	private static int solution2(LinkedList<String> input) {

		
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
