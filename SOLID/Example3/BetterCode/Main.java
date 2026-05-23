package SOLID.Example3.BetterCode;

public class Main {
    public static void main(String[] args) {
        King king = new King(1, 1, PieceColor.WHITE);
        ChessPiece knight = new Knight(1, 1, PieceColor.BLACK);

        king.move();
        knight.move();

        king.castle();
    }
}
