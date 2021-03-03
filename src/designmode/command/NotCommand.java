package designmode.command;

public class NotCommand implements Command{
    @Override
    public void execute() {
        System.out.println("not command");
    }

    @Override
    public void undo() {

    }
}
