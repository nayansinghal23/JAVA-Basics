package SOLID.Example3.ProblematicCode;

public class King extends ChessPiece {
    public King(int xCoordinate, int yCoordinate, PieceColor color) {
        super(xCoordinate, yCoordinate, color);
    }

    @Override
    public void castle() {
        System.out.println("King castled");
    }
    
    @Override
    public void move() {
        System.out.println("King moved");
    }
}
