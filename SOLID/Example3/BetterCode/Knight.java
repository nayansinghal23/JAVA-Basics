package SOLID.Example3.BetterCode;

public class Knight extends ChessPiece {
    public Knight(int xCoordinate, int yCoordinate, PieceColor color) {
        super(xCoordinate, yCoordinate, color);
    }

    @Override
    public void move() {
        System.out.println("Knight moved");
    }
}
