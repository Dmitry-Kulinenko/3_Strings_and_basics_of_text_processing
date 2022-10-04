/*7. Вводится строка. Требуется удалить из нее повторяющиеся символы
 * и все пробелы. Например, если было введено "abc cdedef", 
 * то должно быть выведено "abcdef".*/

package by.jonline.string.stringaschararray;

public class Task7 {
	public static void main(String[] args) {
		String input = "abc cdedef";
		int counter = 0;
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != ' ') {
				for (int j = i; j < input.length(); j++) {
					if (input.charAt(i) == input.charAt(j)) {
						counter++;
					}
				}
				if (counter == 1) {
					output.append(input.charAt(i));
				}
				counter = 0;
			}
		}
		System.out.println(output);
	}
}
