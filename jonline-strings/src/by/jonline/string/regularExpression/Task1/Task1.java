/*1. Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных операции:
 * отсортировать абзацы по количеству предложений;
 * в каждом предложении отсортировать слова по длине;
 * отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.*/

package by.jonline.string.regularexpression.Task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
	public static void main(String[] args) {
		String example = new String(
				"What is Lorem Ipsum? Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
						+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s. "
						+ "When an unknown printer took a galley of type and scrambled it to make a type specimen book. "
						+ "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. "
						+ "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently "
						+ "with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
						+ "\nWhy do we use it? It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. "
						+ "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, "
						+ "as opposed to using 'Content here, content here', making it look like readable English. "
						+ "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, "
						+ "and a search for 'lorem ipsum' will uncover many web sites still in their infancy. "
						+ "Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."
						+ "\nWhere does it come from? Contrary to popular belief, Lorem Ipsum is not simply random text. "
						+ "It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. "
						+ "Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, "
						+ "consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. "
						+ "Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. "
						+ "This book is a treatise on the theory of ethics, very popular during the Renaissance. "
						+ "The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n");

		System.out.println("Сортировка абзацев по количеству предложений\n" + paragraphSort(example));
		System.out.println("Сортировка слов по длине\n" + wordLenthSort(example));
		System.out.println("Сортировка лексем в предложении\n" + lexemeSort(example, 'i'));

	}

	public static String paragraphSort(String input) {
		String[] paragraph = input.split("\n");
		int counter = 0;
		StringBuilder output = new StringBuilder();
		Pattern pattern = Pattern.compile("([A-Z]|\\d).*?[.!?](\\s|$)");// паттерн предложения
		Node[] sentenceCount = new Node[paragraph.length];
		Node[] auxSentenceCount = new Node[sentenceCount.length];

		for (int i = 0; i < paragraph.length; i++) {
			Matcher matcher = pattern.matcher(paragraph[i]);
			while (matcher.find()) {
				counter++;
			}
			sentenceCount[i] = new Node(i, counter);
			counter = 0;
		}
		sort(sentenceCount, auxSentenceCount, 0, sentenceCount.length);
		for (Node node : sentenceCount) {
			output.append(paragraph[node.getInitialIndex()]).append("\n ");
		}
		return output.toString();
	}

	public static String wordLenthSort(String input) {
		String[] word = input.replaceAll("[[^']&&\\p{Punct}]", "").split("\\p{Space}");// выделение слов.
																						// ^' для выделения it's
		Node[] wordCount = new Node[word.length];
		Node[] auxWordCount = new Node[wordCount.length];
		StringBuilder output = new StringBuilder();

		for (int i = 0; i < wordCount.length; i++) {
			wordCount[i] = new Node(i, word[i].length());
		}
		sort(wordCount, auxWordCount, 0, wordCount.length);
		for (Node node : wordCount) {
			output.append(word[node.getInitialIndex()]).append(" ");
		}
		return output.toString();
	}

	public static String lexemeSort(String input, char sortChar) {
		Pattern pattern = Pattern.compile("([A-Z]|\\d).*?[.!?](\\s|$)");
		Matcher matcher = pattern.matcher(input);
		StringBuilder output = new StringBuilder();

		while (matcher.find()) {
			String s = input.substring(matcher.start(), matcher.end());
			String[] word = s.replaceAll("[[^']&&\\p{Punct}]", "").split("\\s");
			String[] auxWord = new String[word.length];
			Node[] charCount = new Node[word.length];
			Node[] auxCharCount = new Node[word.length];
			int counter = 0;
			for (int i = 0; i < word.length; i++) {
				for (int j = 0; j < word[i].length(); j++) {
					if (word[i].charAt(j) == sortChar) {
						counter++;
					}
				}
				charCount[i] = new Node(i, counter);
				counter = 0;
			}
			sort(charCount, auxCharCount, 0, charCount.length);
			for (int i = 0; i < charCount.length; i++) {
				auxWord[i] = word[charCount[i].getInitialIndex()];
			}
			for (int i = 0; i < word.length; i++) {// располагаем в порядке убывания читсла вхождения символа
				word[i] = auxWord[word.length - i - 1];
			}

			int start = 0;
			int end = 0;
			int count = 0;
			for (int i = 0; i < auxWord.length - 1; i++) {// ищем слова с одинаковым кол-вом заданного символа и
															// сортируем их по алфавиту
				if ((charCount[i].getValiue() == charCount[i + 1].getValiue()) && (charCount[i].getValiue() > 0)) {
					if (start == 0) {
						start = i;
					}
					count++;
				} else if (count != 0) {
					end = start + count + 1;
					alphabeticalSort(word, auxWord, start, end);
					start = 0;
					end = 0;
					count = 0;
				}
			}

			for (String w : word) {
				output.append(w).append(" ");
			}
			output.append("\n");
		}
		return output.toString();
	}

	static void sort(Node[] a, Node[] aux, int lo, int hi) {
		if (hi - lo <= 1)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid, hi);
		int i = lo, j = mid;

		for (int k = lo; k < hi; k++) {
			if (i == mid) {
				aux[k] = a[j++];
			} else if (j == hi) {
				aux[k] = a[i++];
			} else if (a[j].getValiue() < a[i].getValiue()) {
				aux[k] = a[j++];
			} else {
				aux[k] = a[i++];
			}
		}
		for (int k = lo; k < hi; k++)
			a[k] = aux[k];
	}

	static void alphabeticalSort(String[] a, String[] aux, int lo, int hi) {
		if (hi - lo <= 1)
			return;
		int mid = lo + (hi - lo) / 2;
		alphabeticalSort(a, aux, lo, mid);
		alphabeticalSort(a, aux, mid, hi);
		int i = lo, j = mid;

		for (int k = lo; k < hi; k++) {
			if (i == mid) {
				aux[k] = a[j++];
			} else if (j == hi) {
				aux[k] = a[i++];
			} else if (a[i].compareTo(a[j]) > 0) {
				aux[k] = a[j++];
			} else {
				aux[k] = a[i++];
			}
		}
		for (int k = lo; k < hi; k++)
			a[k] = aux[k];
	}

}