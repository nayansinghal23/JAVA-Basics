package SOLID.Example3.ProblematicCode;

public abstract class ChessPiece {
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor color;

    public ChessPiece(int xCoordinate, int yCoordinate, PieceColor color) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.color = color;
    }

    public abstract void move();

    public abstract void castle();

    public int getXCoordinate() {
        return this.xCoordinate;
    }

    public int getYCoordinate() {
        return this.yCoordinate;
    }

    public PieceColor getColor() {
        return this.color;
    }
}
