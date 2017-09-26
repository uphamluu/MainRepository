package com.phamluu.design_ptt.behavioral.commandptt_undo.command;

import com.phamluu.design_ptt.behavioral.commandptt_undo.reciever.Light;

public class DimmerLightOnCommand implements Command {
	Light light;
	int prevLevel;

	public DimmerLightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		prevLevel = light.getLevel();
		light.dim(75);
	}

	public void undo() {
		light.dim(prevLevel);
	}
}
