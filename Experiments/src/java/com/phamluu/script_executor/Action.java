package com.phamluu.script_executor;

import java.awt.AWTException;
import java.awt.Robot;

public abstract class Action {
	String description;
	int x;
	int y;
	Integer afterActionPause;
	static Robot robot;

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Integer getAfterActionPause() {
		return afterActionPause;
	}
	public void setAfterActionPause(Integer afterActionPause) {
		this.afterActionPause = afterActionPause;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	void initRobot(){
		synchronized (this) {
			if(robot == null){
				try {
					robot = new Robot();
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public abstract void doAction();

}
