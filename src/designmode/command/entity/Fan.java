package designmode.command.entity;

/**
 * 风扇
 */
public class Fan {
    public static final int HIGH_SPEED = 100;
    public static final int MEDIUM_SPEED = 50;
    public static final int LOW_SPEED = 10;
    public static final int POWER_OFF = 0;

    /**
     * 风扇的转速
     * <p>
     * high —> 100
     * medium -> 50
     * low ->10
     */
    private int speed;
    private String location;

    public Fan(String location) {
        this.location = location;
    }

    public void setHighSpeed() {
        this.speed = HIGH_SPEED;
        System.out.println(location + " fan is high speed");
    }

    public void setMediumSpeed() {
        this.speed = MEDIUM_SPEED;
        System.out.println(location + " fan is medium speed");
    }

    public void setLowSpeed() {
        this.speed = LOW_SPEED;
        System.out.println(location + " fan is low speed");
    }

    public void powerOff() {
        this.speed = POWER_OFF;
        System.out.println(location + " fan is power-off");
    }


    public int getSpeed() {
        return speed;
    }
}
