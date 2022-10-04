/*5. Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
Крайние пробелы в строке удалить.*/

package by.jonline.string.stringAsCharArray;

public class Task5 {
	public static void main(String[] args) {
		String input = "      aaa       aa  aa       aa  aa";
		char[] inputCharArray = input.toCharArray();

		int counter1 = 0;

		for (int i = 0; i < inputCharArray.length - 1; i++) {
			if (inputCharArray[i] == ' ' && inputCharArray[i + 1] != ' ') {
				if (counter1 > 0) {
					for (int j = i + 1; j < inputCharArray.length; j++) {
						inputCharArray[j - counter1] = inputCharArray[j];
						inputCharArray[j] = ' ';
					}
					i -= counter1;
				}
				counter1 = 0;
				continue;
			}
			if (inputCharArray[i] == ' ') {
				counter1++;
			}

		}

		System.out.println(new String(inputCharArray));
		char[] output = strip(inputCharArray);
		System.out.println(new String(output));
	}

	static char[] strip(char[] input) {
		int i = 0;
		int j = input.length - 1;
		int k = 0;

		if (input[0] == ' ') {
			i = 1;

		}
		while (input[j] == ' ') {
			j--;
		}
		char[] output = new char[j - i + 1];

		while (i <= j) {
			output[k] = input[i];
			i++;
			k++;
		}

		return output;
	}
}
