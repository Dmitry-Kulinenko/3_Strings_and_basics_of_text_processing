/*6. Из заданной строки получить новую, повторив каждый символ дважды.*/

package by.jonline.string.stringAndStringBuilder;

public class Task6 {
	public static void main(String[] args) {
		String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < 2; j++) {
				output.append(input.charAt(i));
			}
		}
		System.out.println(output);
	}
}
