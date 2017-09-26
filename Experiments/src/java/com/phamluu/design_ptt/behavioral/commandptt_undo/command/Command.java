package com.phamluu.design_ptt.behavioral.commandptt_undo.command;

public interface Command {
	public void execute();
	public void undo();
}
