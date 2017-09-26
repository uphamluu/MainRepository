package com.phamluu.design_ptt.behavioral.commandptt_undo.command;

import com.phamluu.design_ptt.behavioral.commandptt_undo.reciever.Light;

public class LightOnCommand implements Command {
	Light light;
	int level;
	public LightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
        level = light.getLevel();
		light.on();
	}

	public void undo() {
		light.dim(level);
	}
}
