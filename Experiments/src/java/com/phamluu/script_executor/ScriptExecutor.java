package com.phamluu.script_executor;

public class ScriptExecutor {

	public static void main(String[] args) {
		ActionScript actionscript = ActionScriptFactory.parseScripts(args[0]);
		actionscript.doActions();
	}

}
