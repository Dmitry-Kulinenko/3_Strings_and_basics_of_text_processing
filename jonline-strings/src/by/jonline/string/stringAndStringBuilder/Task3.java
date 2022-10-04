/*3. Проверить, является ли заданное слово палиндромом.*/

package by.jonline.string.stringAndStringBuilder;

public class Task3 {
	public static void main(String[] args) {
		String input = "racecar";
		StringBuilder reverse = new StringBuilder(input);
		reverse.reverse();
		System.out.println(input.equals(new String(reverse)));
	}
}
