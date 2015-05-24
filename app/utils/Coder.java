package utils;

public class Coder {
	private static int charLength = CodeGenerator.chars.size();

	public static String encode(long input) {
		StringBuffer sb = new StringBuffer();
		do {
			sb.append(CodeGenerator.chars.get((int) (input % charLength)));
			input = input / charLength;
		} while (input != 0);
		return sb.toString();
	}

	public static Long decode(String input) {
		if (input == null) {
			return null;
		}
		long result = 0;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			int indexOf = CodeGenerator.chars.indexOf(ch);
			if (indexOf == -1) {
				return null;
			}
			result += (long) Math.pow(charLength, i) * indexOf;
		}
		return result;
	}
}
