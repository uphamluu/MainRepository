package com.phamluu.design_ptt.behavioral.commandptt_undo.command;

import com.phamluu.design_ptt.behavioral.commandptt_undo.reciever.Light;

public class LightOffCommand implements Command {
	Light light;
	int level;
	public LightOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
        level = light.getLevel();
		light.off();
	}

	public void undo() {
		light.dim(level);
	}
}
