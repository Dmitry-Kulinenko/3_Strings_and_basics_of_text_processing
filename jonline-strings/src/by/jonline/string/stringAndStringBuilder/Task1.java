/*1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.*/

package by.jonline.string.stringAndStringBuilder;

public class Task1 {
	public static void main(String[] args) {
		String input = "aaa aaa  aaaa     a   aaa          a";
		int fitstOccurence = input.indexOf(" ");
		int nextOccurence = input.indexOf(" ", fitstOccurence + 1);
		int max = 0;
		int oldMax = 0;
		for (int i = fitstOccurence; i < input.length(); i++) {
			if (nextOccurence - fitstOccurence == 1) {
				max++;
			} else {
				if (max > oldMax) {
					oldMax = max;
				}
				max = 0;
			}
			fitstOccurence = input.indexOf(" ");
			nextOccurence = input.indexOf(" ", fitstOccurence + 1);
		}
	}
}
