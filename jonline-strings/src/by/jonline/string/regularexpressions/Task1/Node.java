//Класс служит для хранения начального индекса при сортировке
//прим. Нужно отсортировать слова по длине. Создаем массив [] Node,
//value-длина слова, initialIndex-изначальный индекс, чтобы достать
//слово из изначального массива после сортировки по длине

package by.jonline.string.regularexpressions.Task1;

public class Node {
	private final int initialIndex;
	private final int valiue;

	public Node(int initialIndex, int value) {
		this.initialIndex = initialIndex;
		this.valiue = value;
	}

	public int getInitialIndex() {
		return initialIndex;
	}

	public int getValiue() {
		return valiue;
	}

	@Override
	public String toString() {
		return "[" + initialIndex + " " + valiue + "]";
	}

}
