/*	Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml- документа и его тип
 *  (открывающий тег, закрывающий тег, содержимое тега, тег без тела)
 *  Пользоваться готовыми парсерами XML для решения данной задачи нельзя*/

package by.jonline.string.regularExpression.Task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

	static String openTag = "(?:<[^\\/]).*?[^\\/]>";
	static String tegContent = "(?<=>).+?(?=<)";
	static String noBodyTag = "<.+?/>";
	static String closingTag = "</.+?>";

	public static void printOpenTag(String text) {
		Pattern p = Pattern.compile(openTag);
		Matcher m = p.matcher(text);
		if (m.find()) {
			System.out.println("открывающий тег: " + m.group());
		}
	}

	public static void printTegContent(String text) {
		Pattern p = Pattern.compile(tegContent);
		Matcher m = p.matcher(text);
		if (m.find()) {
			System.out.println("содержимое тега: " + m.group());
		}
	}

	public static void printClosingTag(String text) {
		Pattern p = Pattern.compile(closingTag);
		Matcher m = p.matcher(text);
		if (m.find()) {
			System.out.println("закрывающий тег: " + m.group());
		}
	}

	public static void printNoBodyTeg(String text) {
		Pattern p = Pattern.compile(noBodyTag);
		Matcher m = p.matcher(text);
		if (m.find()) {
			System.out.println("тег без тела: " + m.group());
		}
	}

	public static void main(String[] args) {

		String input = "<notes>\r\n" + "<note id = \"1\">\r\n" + "<to>Вася</to>\r\n" + "<from>Света</from>\r\n"
				+ "<heading>Напоминание</heading>\r\n" + "<body>Позвони мне завтра!</body>\r\n" + "</note>\r\n"
				+ "<note id = \"2\">\r\n" + "<to>Петя</to>\r\n" + "<from>Маша</from>\r\n"
				+ "<heading>Важное напоминание</heading>\r\n" + "<body/>\r\n" + "</note>\r\n" + "</notes>";
		String[] arr = input.split("\r\n");

		for (String s : arr) {
			printOpenTag(s);
			printTegContent(s);
			printClosingTag(s);
			printNoBodyTeg(s);
		}

	}
}
