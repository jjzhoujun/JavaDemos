package reflect;

public class AutoDrive {
    public enum Color {
        WHITE,
        RED,
        BLUE
    }

    private String vendor;
    private Color color;

    public AutoDrive(String vendor, Color color) {
        super();
        this.vendor = vendor;
        this.color = color;
    }

    public AutoDrive() {
        vendor = "Nissan";
        color = Color.WHITE;
    }

    public void drive() {
        boot();
        turnLeftLight();
        treadClutch();
        release();
        tips();
    }

    private void tips() {
        System.out.println("您正在驾驶" + color + " " + vendor + " 汽车，请小心驾驶。");
    }
    private void boot() {
        System.out.println("点火");
    }
    private void turnLeftLight() {
        System.out.println("打灯");
    }
    private void treadClutch() {
        System.out.println("踩离合");
    }
    private void release() {
        System.out.println("松手刹");
    }
}
