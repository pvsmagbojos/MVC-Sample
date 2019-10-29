package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
	private static BufferedReader getReader() {
		return new BufferedReader(new InputStreamReader(System.in));
	}

	public static String readString(String message) throws IOException {
		//reads string inputs
		System.out.print(message);
		return getReader().readLine();
	}

	public static int readInt(String message) throws IOException {
		//reads string inputs and converted to int primitive value
		System.out.print(message);
		return Integer.parseInt(getReader().readLine());
	}

	public static double readDouble(String message) throws IOException {
		//reads string inputs and converted to double primitive value
		System.out.print(message);
		return Double.parseDouble(getReader().readLine());
	}
}
