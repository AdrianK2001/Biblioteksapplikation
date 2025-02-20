import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Loan {
    public static void borrowBook(int bookId, String userName) {
        String query = "UPDATE books SET available = FALSE WHERE id = ? AND available = TRUE";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, bookId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                try (PreparedStatement loanStmt = conn.prepareStatement("INSERT INTO loans (user_name, book_id) VALUES (?, ?)")) {
                    loanStmt.setString(1, userName);
                    loanStmt.setInt(2, bookId);
                    loanStmt.executeUpdate();
                }
                System.out.println("Book borrowed!");
            } else {
                System.out.println("Book is not available or does not exist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void returnBook(int bookId) {
        String query = "UPDATE books SET available = TRUE WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, bookId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                try (PreparedStatement loanStmt = conn.prepareStatement("DELETE FROM loans WHERE book_id = ?")) {
                    loanStmt.setInt(1, bookId);
                    loanStmt.executeUpdate();
                }
                System.out.println("Book returned!");
            } else {
                System.out.println("Book was not borrowed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
