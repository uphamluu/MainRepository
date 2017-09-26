package com.phamluu.script_executor;

import java.awt.event.InputEvent;

public class MouseClick extends Action{


	@Override
	public void doAction() {
		initRobot();
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

}
