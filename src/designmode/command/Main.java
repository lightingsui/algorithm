package designmode.command;

import designmode.command.entity.Fan;
import designmode.command.entity.Light;

/**
 * 场景：<br/>
 * 实现一个遥控器，遥控器自带7对按钮另加一个undo按钮
 * 7对按钮为开关功能，undo按钮撤销上一操作
 */
public class Main {
    public static void main(String[] args) {
        Light light = new Light("living room");
        Fan fan = new Fan("bed room");

        Command fanHighSpeedCommand = new FanHighSpeedCommand(fan);
        Command fanLowSpeedCommand = new FanLowSpeedCommand(fan);
        Command fanMediumSpeedCommand = new FanMediumSpeedCommand(fan);
        Command fanOffSpeedCommand = new FanOffSpeedCommand(fan);


        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        // 前三个打开按钮为：
        // 高速风扇
        // 中速风扇
        // 低速风扇
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, fanHighSpeedCommand, fanOffSpeedCommand);
        remoteControl.setCommand(1, fanLowSpeedCommand, fanOffSpeedCommand);
        remoteControl.setCommand(2, fanMediumSpeedCommand, fanOffSpeedCommand);

        remoteControl.setCommand(4, lightOnCommand, lightOffCommand);

        System.out.println(remoteControl);

        // Run
        remoteControl.onButtonClick(2);
        remoteControl.offButtonClick(2);

        remoteControl.onButtonClick(4);

        remoteControl.undoButtonClick();
        remoteControl.undoButtonClick();
        remoteControl.undoButtonClick();

        remoteControl.onButtonClick(0);
        remoteControl.undoButtonClick();

    }
}
