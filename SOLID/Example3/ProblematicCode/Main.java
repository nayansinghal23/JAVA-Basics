// By creating castle function in abstract class, other classes (like Knight) have to forcefully implement it, hence violating LSP.

package SOLID.Example3.ProblematicCode;

public class Main {
    public static void main(String[] args) {
        ChessPiece king = new King(1, 1, PieceColor.WHITE);
        ChessPiece knight = new Knight(1, 1, PieceColor.BLACK);

        king.move();
        knight.move();

        king.castle();
        knight.castle(); // But Knight cannot castle, hence violating LSP.
    }
}
