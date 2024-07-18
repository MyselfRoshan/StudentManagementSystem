package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class Database {
    // Load environment variables from .env file using EnvLoader
    Map<String, String> env = Dotenv.loadEnv();

    // Retrieve environment variables
    private String username = env.get("POSTGRES_USER");
    private String password = env.get("POSTGRES_PASSWORD");
    private String db = env.get("POSTGRES_DB");
    private String url = "jdbc:postgresql://localhost:5432/" + db;
    // private String url = "jdbc:postgresql://0.0.0.0:5432/" + db;

    // Connection
    private Connection connection;

    public Database() {
        try {
            // Establishing connection
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to database.");
        }
    }

    /**
     * Method to execute a SELECT query with parameters
     */
    public ResultSet select(String sql, Map<Integer, Object> params) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);

            // Bind parameters if provided
            if (params != null) {
                for (Map.Entry<Integer, Object> param : params.entrySet()) {
                    statement.setObject(param.getKey(), param.getValue());
                }
            }
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            resultSet = null;
        }
        return resultSet;
    }

    /**
     * Method to execute an INSERT query with parameters
     */
    public int insert(String sql, Map<Integer, Object> params) throws SQLException {
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        int rowsInserted = 0;
        try {
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // Bind parameters if provided
            if (params != null) {
                for (Map.Entry<Integer, Object> param : params.entrySet()) {
                    statement.setObject(param.getKey(), param.getValue());
                }
            }
            rowsInserted = statement.executeUpdate();
            // Retrieve auto-generated keys if any
            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                System.out.println("Inserted ID: " + generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        } finally {
            // Ensure resources are properly closed
            closeResultSet(generatedKeys);
            closeStatement(statement);
            close();
        }
        return rowsInserted;
    }

    /**
     * Method to execute an UPDATE query with parameters
     */
    public int update(String sql, Map<Integer, Object> params) throws SQLException {
        PreparedStatement statement = null;
        int rowsUpdated = 0;
        try {
            statement = connection.prepareStatement(sql);
            // Bind parameters if provided
            if (params != null) {
                for (Map.Entry<Integer, Object> param : params.entrySet()) {
                    statement.setObject(param.getKey(), param.getValue());
                }
            }
            rowsUpdated = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        } finally {
            // Ensure resources are properly closed
            closeStatement(statement);
        }
        return rowsUpdated;
    }

    /**
     * Method to execute a DELETE query with parameters
     */
    public int delete(String sql, Map<Integer, Object> params) throws SQLException {
        PreparedStatement statement = null;
        int rowsDeleted = 0;
        try {
            statement = connection.prepareStatement(sql);
            // Bind parameters if provided
            if (params != null) {
                for (Map.Entry<Integer, Object> param : params.entrySet()) {
                    statement.setObject(param.getKey(), param.getValue());
                }
            }
            rowsDeleted = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        } finally {
            // Ensure resources are properly closed
            closeStatement(statement);
        }
        return rowsDeleted;
    }

    /**
     * Close the database connection
     */
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper method to close PreparedStatement
    private void closeStatement(PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper method to close ResultSet
    private void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
