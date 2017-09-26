package com.phamluu.script_executor;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.KeyStroke;

public class EnterText extends Action {

	String StringValue;

	public String getStringValue() {
		return StringValue;
	}

	public void setStringValue(String stringValue) {
		StringValue = stringValue;
	}

	@Override
	public void doAction() {
		initRobot();
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);

		stringPress(StringValue);

	}

	private void stringPress(String input) {
		char[] allchars = input.toCharArray();
		for (char ch : allchars) {
			pressKey(ch, 10);
		}
	}

	private static void pressKey(final char ch, final Integer pause) {
		Integer keyCode = (KeyStroke.getKeyStroke(Character.toUpperCase(ch), 0).getKeyCode());
		ArrayList<Integer> keysInCombination = new ArrayList<Integer>();
		if (Character.isUpperCase(ch)) {
			keysInCombination.add(KeyEvent.VK_SHIFT);
			keysInCombination.add(keyCode);
		} else {
			if (Character.compare(ch, ':') == 0) {
				keysInCombination.add(KeyEvent.VK_SHIFT);
				keysInCombination.add(KeyEvent.VK_PERIOD); 
			} else if (Character.compare(ch, '/') == 0) {
				keysInCombination.add(KeyEvent.VK_DIVIDE);
			} else if (Character.compare(ch, '$') == 0) {
				keysInCombination.add(KeyEvent.VK_SHIFT);
				keysInCombination.add(KeyEvent.VK_4); 
			} else {
				keysInCombination.add(keyCode);
			}
		}
		pressKeysInCombination(keysInCombination);
		if (pause != null) {
			try {

				Thread.sleep(pause);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void pressKeysInCombination(final ArrayList<Integer> keyCodes) {
		for (int ke : keyCodes) {
			robot.keyPress(ke);
		}
		for (int ke : keyCodes) {
			robot.keyRelease(ke);
		}

	}

}
