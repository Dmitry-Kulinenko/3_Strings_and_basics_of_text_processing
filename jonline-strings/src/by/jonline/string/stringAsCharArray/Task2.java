/*2. Замените в строке все вхождения 'word' на 'letter'.*/

package by.jonline.string.stringAsCharArray;

public class Task2 {
	public static void main(String[] args) {
		String input = "www    w ordooorrrrddddddwordwordwordwordword";
		char[] inputCharArray = input.toCharArray();
		char[] word = "word".toCharArray();
		char[] letter = "letter".toCharArray();
		int shift = 0;
		int startIndex = 0;
		int nextIndex = findIndex(inputCharArray, word, startIndex);
		if (nextIndex > 0) {
			System.out.println(input);

			while (nextIndex >= 0) {
				shift++;
				startIndex = nextIndex + word.length;
				nextIndex = findIndex(inputCharArray, word, startIndex);
			}

			System.out.println("Заменить " + shift + " слов");

			char[] output = new char[inputCharArray.length + (letter.length - word.length) * shift];
			startIndex = 0;
			nextIndex = 0;
			shift = 0;
			int i = 0;
			int j = 0;
			while (j < output.length) {// за одну итерацию добавляем символы до word и 1 раз letter
				nextIndex = findIndex(inputCharArray, word, startIndex);
				while (j < nextIndex + letter.length + shift) {
					if (i < nextIndex) {// добавляем всё, что не word
						output[j] = inputCharArray[i];
						i++;
						j++;
					} else {// меняем word на letter
						for (int k = 0; k < letter.length; k++) {
							output[j] = letter[k];
							j++;
						}
					}
				}
				shift += letter.length - word.length;
				startIndex = nextIndex + word.length;
				i += word.length;

			}

			System.out.println(new String(output));
		}
	}

	static int findIndex(char[] input, char[] word, int start) {
		for (int i = start, j = 0; i < input.length; i++) {
			if (input[i] != word[j]) {
				j = 0;
			}
			if (input[i] == word[j]) {
				j++;
			}
			if (j == word.length) {
				return i - word.length + 1;
			}

		}
		return -1;
	}
}
