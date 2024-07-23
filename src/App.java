import java.awt.event.MouseAdapter;

import javax.swing.SwingUtilities;

import Controller.SignUpController;
import Model.SignUpModel;
import View.SignUpView;

public class App extends MouseAdapter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SignUpController(new SignUpView(), new SignUpModel());
        });
        // new DashboardView();
        // new Test();
        // Database db = new Database();

        // Example usage: SELECT query
        // String selectQuery = "SELECT * FROM users WHERE id = ?";
        // try {
        // PreparedStatement selectStatement =
        // db.getConnection().prepareStatement(selectQuery);
        // selectStatement.setInt(1, 1); // Example parameter
        // ResultSet resultSet = db.select(selectQuery, null); // Null for params in
        // this case

        // // Process ResultSet
        // while (resultSet.next()) {
        // // Retrieve data
        // int id = resultSet.getInt("id");
        // String name = resultSet.getString("name");
        // String email = resultSet.getString("email");

        // // Process data...
        // System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
        // }
        // } catch (SQLException e) {
        // e.printStackTrace();
        // }

        // Example usage: INSERT query
        // String insertQuery = "INSERT INTO student (username, password, name,
        // phone_number, gender) VALUES (?, ?, ?)";
        // Map<Integer, Object> insertParams = Map.of(
        // 1, "roshan",
        // 2, "a",
        // 3, "Roshan Ghimire");
        // int rowsInserted = db.insert(insertQuery, insertParams);
        // System.out.println("Rows inserted: " + rowsInserted);
        // }

        // Example usage: UPDATE query
        // String updateQuery = "UPDATE users SET email = ? WHERE id = ?";
        // try {
        // Map<Integer, Object> updateParams = Map.of(
        // 1, "new.email@example.com", // Example parameter for new email
        // 2, 1 // Example parameter for user id
        // );
        // int rowsUpdated = db.update(updateQuery, updateParams);
        // System.out.println("Rows updated: " + rowsUpdated);
        // } catch (SQLException e) {
        // e.printStackTrace();
        // }

        // // Example usage: DELETE query
        // String deleteQuery = "DELETE FROM users WHERE id = ?";
        // try {
        // Map<Integer, Object> deleteParams = Map.of(
        // 1, 1 // Example parameter for user id
        // );
        // int rowsDeleted = db.delete(deleteQuery, deleteParams);
        // System.out.println("Rows deleted: " + rowsDeleted);
        // } catch (SQLException e) {
        // e.printStackTrace();
        // }

        // db.close();
    }

}
