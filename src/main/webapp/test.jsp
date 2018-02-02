<%@ page import="java.sql.*" %>
<%
  // Read RDS connection information from the environment  
  String userName = "shoppingadmin";
  String password = "Abcdef456";  
  String jdbcUrl = "jdbc:oracle:thin:shoppingadmin/Abcdef456@shoppingdb.cwkio6kcud3i.ap-south-1.rds.amazonaws.com:1521:ORCL"; 
  
  
  //String jdbcUrl = "jdbc:oracle:thin:john/JMaug2017@localhost:1521:xe";
  
  // Load the JDBC driver
  try {
    System.out.println("Loading driver...");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    System.out.println("Driver loaded!");
  } catch (ClassNotFoundException e) {
    throw new RuntimeException("Cannot find the driver in the classpath!", e);
  }

  Connection conn = null;
  Statement setupStatement = null;
  Statement readStatement = null;
  ResultSet resultSet = null;
  String results = "";
  int numresults = 0;
  String statement = null;

  
  try {
    conn = DriverManager.getConnection(jdbcUrl);
    
    readStatement = conn.createStatement();
    resultSet = readStatement.executeQuery("SELECT LOGIN_ID FROM USERS");

    while (resultSet.next()) {
    	results = results +", " + resultSet.getString("LOGIN_ID");
    }
    
    
    
    out.println(results);
    
    resultSet.close();
    readStatement.close();
    conn.close();

  } catch (SQLException ex) {
    // Handle any errors
    out.println("SQLException: " + ex.getMessage());
    out.println("SQLState: " + ex.getSQLState());
    out.println("VendorError: " + ex.getErrorCode());
  } finally {
       out.println("Closing the connection.");
      if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
  }
%>

<p>Established connection to RDS. Read first two rows: <%= results %></p>