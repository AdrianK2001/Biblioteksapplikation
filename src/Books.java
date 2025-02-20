import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Books {
    //Lists all books with the availabilty status
    public static void listBooks() {
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM books")) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("title") + " - " + rs.getString("author") +
                        " (" + (rs.getBoolean("available") ? "Available" : "Borrowed") + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Adds book to the database
    public static void addBook(String title, String author) {
        String query = "INSERT INTO books (title, author) VALUES (?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.executeUpdate();
            System.out.println("Book added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Remove book from database
    public static void removeBook(int bookId) {
        String query = "DELETE FROM books WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, bookId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book removed!");
            } else {
                System.out.println("Book not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


