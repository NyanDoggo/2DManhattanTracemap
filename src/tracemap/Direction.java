package tracemap;

public class Direction {
    //Matrix indexing: top left (0,0), bottom right (i,j)
    //Check whether current direction is horizontal direction or vertical direction
    public boolean horizontalDirection;
    public boolean verticalDirection;
    //i.e direction to move in 2d array (changes in position)
    private int DistanceHorizontalDirection = 0; //current position + DistanceHorizontalDirection
    private int DistanceVerticalDirection = 0; //current position + DistanceVerticalDirection
    private int distance;
    private String direction;

    public Direction(String direction, int distance){
        initDirection(direction, distance);
    }

    public int getDistanceHorizontalDirection() {
        return DistanceHorizontalDirection;
    }

    public int getDistanceVerticalDirection() {
        return DistanceVerticalDirection;
    }

    public void setDistance(int distance){
        this.distance = distance;
        initDirection(this.direction, distance);
    }

    private void initDirection(String direction, int distance){
        this.distance = distance;
        this.direction = direction;
        if (direction.equalsIgnoreCase("right")){ //indexVerticalDirection = 0
            this.horizontalDirection = true;
            this.DistanceHorizontalDirection = distance;
        }

        if (direction.equalsIgnoreCase("left")){
            this.horizontalDirection = true;
            this.DistanceHorizontalDirection = -distance;
        }

        if (direction.equalsIgnoreCase("down")){
            this.verticalDirection = true;
            this.DistanceVerticalDirection = distance;
        }

        if (direction.equalsIgnoreCase("up")){
            this.verticalDirection = true;
            this.DistanceVerticalDirection = -distance;
        }
    }

    private boolean isInBoundVertical(int verticalCoordinate, int maxLengthVertical){
        return ((verticalCoordinate + DistanceVerticalDirection < maxLengthVertical) && (verticalCoordinate + DistanceVerticalDirection >= 0));
    }

    private boolean isInBoundHorizontal(int horizontalCoordinate, int maxLengthHorizontal){
        return ((horizontalCoordinate + DistanceHorizontalDirection < maxLengthHorizontal) && (horizontalCoordinate + DistanceHorizontalDirection >= 0));
    }

    //isInboundVertical && isInBoundHorizontal
    public boolean checkInBound(int currentVerticalCoordinate, int currentHorizontalCoordinate, int maxLengthVertical, int maxLengthHorizontal){
        if (this.horizontalDirection){
            return isInBoundHorizontal(currentHorizontalCoordinate, maxLengthHorizontal);
        }
        if (this.verticalDirection) {
            return isInBoundVertical(currentVerticalCoordinate, maxLengthVertical);
        }

        else{
            System.out.println("ERROR DIRECTION");
            return false;
        }
    }
}
