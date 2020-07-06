package tracemap;

import java.util.ArrayList;
import java.util.List;

public class Tracemap {
    private static boolean isInBound(int index, int maxLength){
        boolean tmp = (index >= 0) && (index < maxLength);
        return tmp;
    }

    private static boolean isMoveValid(char[][] board, char obstacleRepresentation, String moveDirection, int i, int j){
        if (moveDirection.equalsIgnoreCase("right")){
            return isInBound(j + 1, board[i].length) && board[i][j + 1] != obstacleRepresentation;
        }else if (moveDirection.equalsIgnoreCase("left")){
            return isInBound(j - 1, board[i].length) && board[i][j - 1] != obstacleRepresentation;
        }else if (moveDirection.equalsIgnoreCase("up")){
            return isInBound(i - 1, board.length) && board[i - 1][j] != obstacleRepresentation;
        }else if (moveDirection.equalsIgnoreCase("down")){
            return isInBound(i + 1, board.length) && board[i + 1][j] != obstacleRepresentation;
        }
        return false;
    }

    private static boolean isPathValid(char[][] board, char obstacleRepresentation, List<String> path, int i, int j){
        for (String s : path){
            if (s.equalsIgnoreCase("right")){
                if (!isMoveValid(board, obstacleRepresentation, s, i, j)){
                    return false;
                }else {
                    j += 1;
                }
            }else if (s.equalsIgnoreCase("left")){
                if (!isMoveValid(board, obstacleRepresentation, s, i, j)){
                    return false;
                }else {
                    j -= 1;
                }
            }else if (s.equalsIgnoreCase("up")){
                if (!isMoveValid(board, obstacleRepresentation, s, i, j)){
                    return false;
                }else {
                    i -= 1;
                }
            }else if (s.equalsIgnoreCase("down")){
                if (!isMoveValid(board, obstacleRepresentation, s, i, j)){
                    return false;
                }else {
                    i += 1;
                }
            }

        }
        return true;
    }

    public static List<Coordinate> findPotentialLocation(char[][] board, char obstacleRepresentation, List<String> path){
        List<Coordinate> potentialLocation = new ArrayList<>();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] != obstacleRepresentation && isPathValid(board, obstacleRepresentation, path, i, j)){
                    potentialLocation.add(findLocationGivenPathAndOrigin(path, new Coordinate(i, j)));
                }
            }
        }
        return potentialLocation;
    }

    private static Coordinate findLocationGivenPathAndOrigin(List<String> path, Coordinate startingLocation){
        for (String s : path){
            if (s.equalsIgnoreCase("right")){
                Direction d = new Direction("right", 1);
                startingLocation.i += d.getDistanceVerticalDirection();
                startingLocation.j += d.getDistanceHorizontalDirection();
            }else if (s.equalsIgnoreCase("left")){
                Direction d = new Direction("left", 1);
                startingLocation.i += d.getDistanceVerticalDirection();
                startingLocation.j += d.getDistanceHorizontalDirection();
            }else if (s.equalsIgnoreCase("up")){
                Direction d = new Direction("up", 1);
                startingLocation.i += d.getDistanceVerticalDirection();
                startingLocation.j += d.getDistanceHorizontalDirection();
            }else if (s.equalsIgnoreCase("down")){
                Direction d = new Direction("down", 1);
                startingLocation.i += d.getDistanceVerticalDirection();
                startingLocation.j += d.getDistanceHorizontalDirection();
            }
        }
        return startingLocation;
    }

}
