/*10. Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным 
 * знаком. Определить количество предложений в строке X.*/

package by.jonline.string.stringstringbuilder;

public class Task10 {
	public static void main(String[] args) {
		String text = "What is Lorem Ipsum?"
				+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
				+ " when an unknown printer took a galley of type and scrambled it to make a type specimen book. "
				+ "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged! "
				+ "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, "
				+ "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
		int counter = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '.' || text.charAt(i) == '!' || text.charAt(i) == '?') {
				counter++;
			}
		}
		System.out.println("Number of sentences: " + counter);
	}
}
