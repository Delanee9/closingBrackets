package com.delaney.closingbrackets;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Logger;

public class Application {
    private static final Logger logger = Logger.getLogger(Application.class.getName());
    public static HashMap<Character, Character> openingBracket = new HashMap<>();
    private static LinkedList<Character> stack = new LinkedList<>();

    public static void main(String[] args) {
        logger.info("Starting application with input -- " + args[0]);
        openingBracket.put('}', '{');
        openingBracket.put(']', '[');
        openingBracket.put(')', '(');
        boolean result = hasClosingBrackets(args[0].toCharArray());
        logger.info("Stopping application with result -- " + result);
    }

    public static boolean hasClosingBrackets(char[] input) {
        try {
            for (char brace : input) {
                switch (brace) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(brace);
                        break;
                    case ')':
                    case ']':
                    case '}':
                        if (stack.isEmpty()) {
                            return false;
                        } else if (stack.peek().equals(openingBracket.get(brace))) {
                            stack.pop();
                            break;
                        } else {
                            return false;
                        }
                }
            }
        } catch (Exception e) {
            logger.severe("Error in hasClosingBrackets -- " + e);
            return false;
        }
        return stack.isEmpty();
    }
}
