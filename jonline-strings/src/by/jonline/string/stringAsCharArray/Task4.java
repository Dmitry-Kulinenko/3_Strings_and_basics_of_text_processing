/*4. В строке найти количество чисел.*/

package by.jonline.string.stringaschararray;

public class Task4 {
	public static void main(String[] args) {
		String input = "01d323 023 3 3033 dd303f03f330 504";
		char[] inputCharArray = input.toCharArray();
		char[] number = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		int counter1 = 0;

		int counter2 = 0;

		boolean isANumber = false;
		boolean startsWithZero = false;
		for (int i = 0; i < inputCharArray.length; i++) {
			if (counter1 == 0 && inputCharArray[i] == number[0]) {
				startsWithZero = true;
			}

			for (int j = 0; j < number.length; j++) {
				if (inputCharArray[i] == number[j]) {
					counter1++;
					isANumber = true;
					break;
				} else {
					isANumber = false;
				}
			}

			if (!isANumber && counter1 < 2) {// случай когда сначала цифра, потом буква
				counter1 = 0;
				continue;
			}

			if (startsWithZero && !isANumber) { // случай когда число начинается с 0 и надо сбросить счётчик
				counter1 = 0;
				startsWithZero = false;
			}

			if (counter1 > 1 && i + 1 == inputCharArray.length && !startsWithZero) {
				counter2++;
				counter1 = 0;
			} else if (counter1 > 1 && !isANumber) {
				counter2++;
				counter1 = 0;
			}
		}
		System.out.println(counter2);
	}

}
