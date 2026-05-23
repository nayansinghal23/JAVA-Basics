package SOLID.Example3.ProblematicCode;

public class Knight extends ChessPiece {
    public Knight(int xCoordinate, int yCoordinate, PieceColor color) {
        super(xCoordinate, yCoordinate, color);
    }

    @Override
    public void castle() {
        throw new Error("Knight cannot castle");
    }

    @Override
    public void move() {
        System.out.println("Knight moved");
    }
}
