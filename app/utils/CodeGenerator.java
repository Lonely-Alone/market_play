package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回值为6位以内的字符（包含数字和大小写字母）
 * 
 * @author mayan
 * 
 */
public abstract class CodeGenerator {

	protected static final List<Character> chars = new ArrayList<Character>();
	static {
		for (int i = 97; i < 123; i++) {
			chars.add((char) i);
		}
		for (int i = 65; i < 91; i++) {
			chars.add((char) i);
		}
		for (int i = 49; i < 58; i++) {
			chars.add((char) i);
		}
	}

	public String generateCode() {
		String initStr = getInputString();
		long mixedNewTime = Long.valueOf(getMixedStr(initStr));
		return convertCode(mixedNewTime);
	}

	protected abstract String getInputString();

	// 转换编码
	protected String convertCode(long inputMixedNewTime) {
		long mixedNewTime = inputMixedNewTime;
		StringBuffer result = new StringBuffer();
		int charsSize = chars.size();
		do {
			result.append(Character.valueOf(chars.get((char) mixedNewTime
					% charsSize)));
			mixedNewTime = mixedNewTime / charsSize;
		} while (mixedNewTime != 0);
		while (result.length() < 6) {
			result.append('0');
		}
		return result.toString();
	}

	/**
	 * Math.pow(chars.size(),6)=51520374361L<br>
	 * 为了方便混淆，因此将最大值设为49999999999L
	 * 
	 * @return
	 */
	protected long getMaxValue() {
		return 49999999999L;
	}

	/**
	 * 规则如下：<br>
	 * 1.第一位保持不变（因为第一位最大支持4）<br>
	 * 2.按正向顺序添加质数位的字符 <br>
	 * 3.按反向顺序添加合数位的字符
	 **/
	protected String getMixedStr(String inputString) {
		StringBuffer sb = new StringBuffer(inputString.charAt(0));
		sb.append(inputString.charAt(1)).append(inputString.charAt(2))
				.append(inputString.charAt(4)).append(inputString.charAt(6))
				.append(inputString.charAt(10));
		sb.append(inputString.charAt(9)).append(inputString.charAt(8))
				.append(inputString.charAt(7)).append(inputString.charAt(5))
				.append(inputString.charAt(3));
		return sb.toString();
	}
}
