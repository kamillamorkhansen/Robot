public class Turn extends Statement {

    private Direction direction;

    public Turn(Direction direction) {
        this.direction = direction;
    }

    public Direction getDir() {
        return direction;
    }

    @Override
    public void interpret() {
                
        switch (getDir()) {
            case clockwise:
                switch (r.getDirection()) {
                    case "north":
                        r.setDirection("east"); System.out.println("Robot turned clockwise to EAST\n");
                    break;
                    case "east":
                        r.setDirection("south"); System.out.println("Robot turned clockwise to SOUTH\n");
                    break;
                    case "south":
                        r.setDirection("west"); System.out.println("Robot turned clockwise to WEST\n");
                    break;
                    case "west":
                        r.setDirection("north"); System.out.println("Robot turned clockwise to NORTH\n");
                    break;
                }
            break;
            case counterclockwise:
                switch (r.getDirection()) {
                    case "north":
                        r.setDirection("west"); System.out.println("Robot turned counterclockwise to WEST\n");
                    break;
                    case "east":
                        r.setDirection("north"); System.out.println("Robot turned counterclockwise to NORTH\n");
                    break;
                    case "south":
                        r.setDirection("east"); System.out.println("Robot turned counterclockwise to EAST\n");
                    break;
                    case "west":
                        r.setDirection("south"); System.out.println("Robot turned counterclockwise to SOUTH\n");
                    break;
                }
            break;
        }   
    }
    
}
