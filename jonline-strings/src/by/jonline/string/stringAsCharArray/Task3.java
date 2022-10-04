/*3. В строке найти количество цифр.*/

package by.jonline.string.stringAsCharArray;

public class Task3 {
	public static void main(String[] args) {
		String input = "123a aa3ff-0";
		char[] inputCharArray = input.toCharArray();
		char[] number = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		int counter = 0;
		for (char c : inputCharArray) {
			for (char d : number) {
				if (d == c) {
					counter++;
				}
			}
		}
		System.out.println(counter);
	}
}
