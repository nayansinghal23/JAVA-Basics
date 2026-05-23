package SOLID.Example3.BetterCode;

public class King extends ChessPiece {
    public King(int xCoordinate, int yCoordinate, PieceColor color) {
        super(xCoordinate, yCoordinate, color);
    }

    @Override
    public void move() {
        System.out.println("King moved");
    }

    public void castle() {
        System.out.println("King castled");
    }
}
