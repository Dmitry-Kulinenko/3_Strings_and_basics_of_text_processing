/*5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.*/

package by.jonline.string.stringaschararray;

public class Task5 {
	public static void main(String[] args) {
		String input = "software as a service";
		int counter = 0;
		char search = 'a';
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == search) {
				counter++;
			}
		}
		System.out.println(counter);
	}
}
