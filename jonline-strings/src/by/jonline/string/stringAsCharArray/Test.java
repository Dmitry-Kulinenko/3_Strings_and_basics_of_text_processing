package by.jonline.string.stringaschararray;

public class Test {
	public static void main(String[] args) {
		int i = 10;
		while (i > 0) {
			System.out.println(1);
			while (i > 0) {
				System.out.println(2);
				while (i > 8) {
					System.out.println(3);
					if (true)
						break;
				}
			}
		}
	}
}
