abstract class Statement implements Robol {

    Robot r;

    public abstract void interpret();
    
    public void setRobot(Robot r) {
        this.r = r;
    }
}