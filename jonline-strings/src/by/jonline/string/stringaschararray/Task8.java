/*8. Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. 
 * Случай, когда самых длинных слов может быть несколько, не обрабатывать.*/

package by.jonline.string.stringaschararray;

public class Task8 {
	public static void main(String[] args) {
		String input = "Вводится строка слов разделенных пробелами Найти самое длинное слово и вывести его на экран";
		String[] inputSplit = input.split(" ");
		int maxLength = 0;
		int maxLengthIndex = 0;
		for (int i = 0; i < inputSplit.length; i++) {
			if (inputSplit[i].length() > maxLength) {
				maxLength = inputSplit[i].length();
				maxLengthIndex = i;
			}
		}
		System.out.println(inputSplit[maxLengthIndex]);
	}
}
