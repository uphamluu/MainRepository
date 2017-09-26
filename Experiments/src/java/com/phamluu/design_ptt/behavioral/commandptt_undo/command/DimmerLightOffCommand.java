package com.phamluu.design_ptt.behavioral.commandptt_undo.command;

import com.phamluu.design_ptt.behavioral.commandptt_undo.reciever.Light;

public class DimmerLightOffCommand implements Command {
	Light light;
	int prevLevel;

	public DimmerLightOffCommand(Light light) {
		this.light = light;
		prevLevel = 100;
	}

	public void execute() {
		prevLevel = light.getLevel();
		light.off();
	}

	public void undo() {
		light.dim(prevLevel);
	}
}
