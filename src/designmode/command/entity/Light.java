package designmode.command.entity;

/**
 * 电灯
 */
public class Light {
    /**
     * 电灯的位置信息
     */
    private String location;

    /**
     * 电灯的状态，false代表关闭，true代表打开
     */
    private boolean status;

    public Light(String location) {
        this.location = location;
        this.status = false;
    }

    public void lightOn() {
        System.out.println(location + " light is on");
        this.status = true;
    }

    public void lightOff() {
        System.out.println(location + " light is off");
        this.status = false;
    }
}
