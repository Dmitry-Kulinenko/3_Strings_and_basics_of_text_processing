/*9. Посчитать количество строчных (маленьких) и прописных (больших) букв 
 * в введенной строке. Учитывать только английские буквы.*/

package by.jonline.string.stringandstringbuilder;

public class Task9 {
	public static void main(String[] args) {
		String input = "World of Warcraft (WoW; с англ. — «Мир военного ремесла»)";
		int lowerCase = 0;
		int upperCase = 0;
		char[] inputAsACharArray = input.toCharArray();

		for (int i = 0; i < inputAsACharArray.length; i++) {
			if (inputAsACharArray[i] >= 'a' && inputAsACharArray[i] <= 'z') {
				lowerCase++;
			}
			if (inputAsACharArray[i] >= 'A' && inputAsACharArray[i] <= 'Z') {
				upperCase++;
			}
		}
		System.out.println("Upper case: " + upperCase);
		System.out.println("Lower case: " + lowerCase);
	}
}
