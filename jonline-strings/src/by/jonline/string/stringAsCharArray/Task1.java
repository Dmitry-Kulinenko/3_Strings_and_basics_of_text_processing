/*1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.*/

package by.jonline.string.stringAsCharArray;

public class Task1 {
	public static void main(String[] args) {
		String[] input = { "aAbBcCdDeE", "jeffersonAirplane", "whiteRabbit", "theMamas&ThePapas", "californiaDreamin" };

		for (int i = 0; i < input.length; i++) {

			int shift = 0;
			for (int j = 1; j < input[i].length(); j++) {
				if (Character.isUpperCase(input[i].charAt(j)))
					shift++;
			}
			char[] result = new char[input[i].length() + shift];

			shift = 0;

			for (int k = 0; k < input[i].length(); k++) {
				if (Character.isUpperCase(input[i].charAt(k))) {
					result[k + shift++] = '_';
					result[k + shift] = Character.toLowerCase(input[i].charAt(k));
				} else {
					result[k + shift] = input[i].charAt(k);
				}
			}
			String output = new String(result);

			System.out.println(output);
		}
	}

}
