package com.videodemons.javacert;

import java.util.stream.Stream;

class Parser {

	public boolean isBalanced(String query) {
		if (query.length() == 0) {
			return true;
		}
		char[] chars = query.toCharArray();
		if (chars[0] == '}') {
			return false;
		}
		if (chars[0] == ')') {
			return false;
		}
		if (chars[0] == '{') {
			return innerIsBalanced('{', '}', chars, query);
		}
		if (chars[0] == '(') {
			return innerIsBalanced('(', ')', chars, query);
		}
		return false;
	}

	private boolean innerIsBalanced(char open, char close, char[] chars, String query) {
		int openBrackets = 1;
		int splitIndex = 0;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == open) {
				openBrackets++;
			}
			if (chars[i] == close) {
				openBrackets--;
			}
			if (openBrackets == 0) {
				splitIndex = i + 1;
				break;
			}
		}
		if (openBrackets == 0) {
			if (splitIndex == chars.length) {
				return isBalanced(query.substring(1, splitIndex - 1));
			} else {
				return isBalanced(query.substring(0, splitIndex)) && isBalanced(query.substring(splitIndex));
			}
		} else {
			return false;
		}
	}
}

public class IsBracesBalanced {
	public static void main(String[] args) {
		Parser p = new Parser();
		Stream.of("((()))", "({}{})", "({)})", "}{", ")(", ")()", "({)}")
				.forEach(s -> System.out.println(p.isBalanced(s)));
	}
}
