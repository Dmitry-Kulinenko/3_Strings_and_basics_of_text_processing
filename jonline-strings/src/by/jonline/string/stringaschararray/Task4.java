/*4. С помощью функции копирования и операции конкатенации 
 * составить из частей слова “информатика” слово “торт”.*/

package by.jonline.string.stringaschararray;

public class Task4 {
	public static void main(String[] args) {
		String input = "информатика";
		String output = new String();
		output = input.substring(7, 8).concat(input.substring(3, 5)).concat(input.substring(7, 8));
		System.out.println(output);
	}

}
