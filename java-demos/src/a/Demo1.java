package a;

import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {
		try (

				Scanner sc = new Scanner("aaa bbb ccc");

				Window window = new Window();

		) {
			System.out.println(sc.next());
			System.out.println(sc.next());
			if (Math.random() < 0.5) {
				throw new RuntimeException("Error");
			}
			System.out.println(sc.next());
		}

	}

}

class Window implements AutoCloseable {

	{
		System.out.println("Window opens");
	}

	@Override
	public void close() {
		System.out.println("Window closed");

	}

}
