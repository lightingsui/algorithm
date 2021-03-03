package designmode.command;

import designmode.command.entity.Fan;

public class FanHighSpeedCommand implements Command {
    private Fan fan;
    private int lastSpeed;

    public FanHighSpeedCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        lastSpeed = fan.getSpeed();
        fan.setHighSpeed();
    }

    @Override
    public void undo() {
        switch (lastSpeed) {
            case Fan.HIGH_SPEED:
                fan.setHighSpeed();
                break;
            case Fan.MEDIUM_SPEED:
                fan.setMediumSpeed();
                break;
            case Fan.LOW_SPEED:
                fan.setLowSpeed();
                break;
            case Fan.POWER_OFF:
                fan.powerOff();
            default:
                // fall through
        }
    }
}
