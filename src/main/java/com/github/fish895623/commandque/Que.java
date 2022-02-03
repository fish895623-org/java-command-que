package com.github.fish895623.commandque;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class Que {
  private final static Logger logger = LogManager.getLogger(Que.class);

  static {
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private final String dbFileName;

  public Que(Builder builder) {
    this.dbFileName = builder.dbFileName;
  }

  public static String te() {
    return "asdf";
  }

  public static void main(String[] args) throws SQLException {
    Que a = new Builder()
            .setDBFileName("asdf.db")
            .build();

    a.insert();

    ResultSet ab = a.select();
    while (ab.next()) {
      String id = ab.getString("ID");
      String user = ab.getString("USER");
      System.out.printf("%s %s \n", id, user);
    }
  }

  public ResultSet select() throws SQLException {
    String sql = "SELECT ID, USER FROM User";
    ResultSet resultSet;

    Connection conn = this.connect();
    Statement statement = conn.createStatement();
    resultSet = statement.executeQuery(sql);
    return resultSet;
  }

  public void insert() {
    String sql = "INSERT INTO User(ID, USER) VALUES(?, ?)";

    try (Connection connection = this.connect()) {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setInt(1, 13);
      preparedStatement.setInt(2, 2);
      preparedStatement.executeUpdate();

      logger.info("Update data");
    } catch (SQLException e) {
      logger.error(e.getMessage());
    }
  }

  // NOTE Test 1
  // TODO Check Table exists
  // TODO Delete Data https://www.sqlitetutorial.net/sqlite-java/delete/

  public Connection connect() throws SQLException {
    String url = "jdbc:sqlite:" + this.dbFileName;
    Connection connection = null;

    try {
      connection = DriverManager.getConnection(url);

      logger.info("Connect to db DriverManager");
    } catch (SQLException e) {
      logger.error(e.getMessage());
    }

    return connection;
  }

  /*
   * DB builder
   */
  public static class Builder {
    private String dbFileName;

    public Builder setDBFileName(String val) {
      this.dbFileName = val;
      return this;
    }

    public Que build() {
      return new Que(this);
    }
  }

}
