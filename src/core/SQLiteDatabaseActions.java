package core;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SQLiteDatabaseActions {
    public List<String> words = new ArrayList<>();

    public Connection connector() {
<<<<<<< HEAD
            String url = "jdbc:sqlite:D:/Dictionary/src/dict_hh.db";
=======
        String url = "jdbc:sqlite:D:/Dictionary/src/dict_hh.db";
>>>>>>> d7ca74b07159cdf0d02c5053ffa21c74a7ec4553
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    public void insertFromSQLiteDatabase() throws SQLException {
        String sql = "SELECT word FROM av";
        Statement statement = this.connector().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            words.add(resultSet.getString("word"));
        }
        Collections.sort(words);
    }
    public String queryforHtml(String toFind) throws SQLException {
        String sql = "SELECT word, html FROM av";
            Statement statement = this.connector().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (resultSet.getString("word").equals(toFind)) return resultSet.getString("html");
            }
        return "not found";
    }
    public void insertWord(String word, String def) {
        String sql = "INSERT INTO av(word, description, html) VALUES(?,?,?)";

        try {
            Connection connection = this.connector();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, word);
            preparedStatement.setString(2, def);
            String htmltext = "<h1>"+ word + "</h1<ul><li>" + def + "</li></ul>";
            preparedStatement.setString(3, htmltext);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteWord(String word) {
        String sql = "DELETE FROM av WHERE word = ?";
        try {
            PreparedStatement preparedStatement = this.connector().prepareStatement(sql);
            preparedStatement.setString(1, word);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
