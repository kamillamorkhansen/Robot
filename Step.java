public class Step extends Statement{

    private Expression distance;

    public Step (Expression distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return r.evaluate(distance);
    }

    @Override
    public void interpret() {
        r.evaluate(distance);
  
        switch (r.getDirection()) { 
            case "north":
            if (r.getYpos() + getDistance() >= r.getGrid().getWid()) {
                System.out.println("Obs Obs! This is too far!");
            } else { 
                r.moveVertically(getDistance());
            }
            break;
            case "east":
            if (r.getXpos() + getDistance() >= r.getGrid().getLen()) {
                System.out.println("Obs Obs! This is too far!");
            } else { 
                r.moveHorizontally(getDistance());
            }
            break;
            case "south":
            if (r.getYpos() - getDistance() < 0) {
                System.out.println("Obs Obs! This is too far!");
            } else { 
                r.moveVertically(-getDistance());
            }
            break;
            case "west":
            if (r.getXpos() - getDistance() < 0) {
                System.out.println("Obs Obs! This is too far!");
            } else {
                r.moveHorizontally(-getDistance());
            }
            break;
        }
        
    }
}
