package core;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SQLiteDatabaseActions {
    public List<String> words = new ArrayList<>();

    public Connection connector() {
        String url = "jdbc:sqlite:F:/pr/TCDictionary/src/dict_hh.db";
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
        Connection conn = this.connector();
        conn.setAutoCommit(false);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        conn.commit();

        while (resultSet.next()) {
            words.add(resultSet.getString("word"));
        }
        statement.close();
        conn.close();
        Collections.sort(words);
    }
    public String queryforHtml(String toFind) throws SQLException {
        String sql = "SELECT word, html FROM av";
        Connection connection = this.connector();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        connection.commit();
        while (resultSet.next()) {
            if (resultSet.getString("word").equals(toFind)) return resultSet.getString("html");
        }
        statement.close();
        connection.close();
        return "not found";
    }
    public void insertWord(String word, String def) throws SQLException {
        String htmltext = "<h1>"+ word + "</h1><ul><li>" + def + "</li></ul>";
        String pron = "???";
        String sql = "INSERT INTO av(word, description, html, pronounce) VALUES('" + word + "','" + def + "','" + htmltext + "','" + pron +"')";
        System.out.println(sql);
           Connection connection = this.connector();
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.execute(sql);
            //connection.commit();
            statement.close();
            connection.close();

    }
    public void deleteWord(String word) {
        String sql = "DELETE FROM av WHERE word = '" + word + "/'";

        try {
            Connection connection = this.connector();
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.execute(sql);
            connection.commit();
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
//    public List<String> getHint (String preprocessed) {
//
//    }
}
