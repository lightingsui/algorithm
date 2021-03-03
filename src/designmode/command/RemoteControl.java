package designmode.command;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoteControl {

    private static final int UNDO_COMMAND_STACK_EMPTY = 0;

    private Command[] onCommands;
    private Command[] offCommands;

    private List<Command> lastCommand;

    public RemoteControl() {
        lastCommand = new ArrayList<>();

        onCommands = new Command[7];
        offCommands = new Command[7];

        NotCommand notCommand = new NotCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = notCommand;
            offCommands[i] = notCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonClick(int slot) {
        lastCommand.add(onCommands[slot]);
        onCommands[slot].execute();
    }

    public void offButtonClick(int slot) {
        lastCommand.add(onCommands[slot]);
        offCommands[slot].execute();
    }

    public void undoButtonClick() {
        if (lastCommand.size() != UNDO_COMMAND_STACK_EMPTY) {
            Command undoCommand = lastCommand.remove(lastCommand.size() - 1);
            undoCommand.undo();
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("--------- Remote Control ---------\r");

        for (int i = 0; i < 7; i++) {
            stringBuilder.append("[ slot ").append(i).append(" ] ")
                    .append(onCommands[i].getClass().getName()).append("\t").append(offCommands[i].getClass()
                    .getName()).append("\r");
        }

        return stringBuilder.toString();
    }
}
