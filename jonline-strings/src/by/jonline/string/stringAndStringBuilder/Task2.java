/*2. В строке вставить после каждого символа 'a' символ 'b'*/

package by.jonline.string.stringandstringbuilder;

public class Task2 {
	public static void main(String[] args) {
		String input = "aa xyz uauaua baba";
		StringBuilder output = new StringBuilder();
		char inputChar = 0;
		for (int i = 0; i < input.length(); i++) {
			inputChar = input.charAt(i);
			if (inputChar == 'a') {
				output.append(inputChar);
				output.append('b');
			} else {
				output.append(inputChar);
			}
		}
		System.out.println(output.toString());
	}
}
