package com.phamluu.script_executor;

import java.util.ArrayList;
import java.util.List;

public class ActionScript {
    String description;
    private List<Action> actionList;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }

    ActionScript() {
        actionList = new ArrayList<>();
    }

    public void doActions() {
        for (Action action : actionList) {
            action.doAction();
            if (action.afterActionPause != null) {
                Action.robot.delay(action.afterActionPause);
            } else {
                // boolean cont = true;
                // while (cont) {
                //
                // }

            }

        }

    }

}
