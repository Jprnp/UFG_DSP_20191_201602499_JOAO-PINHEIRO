package br.com.jprnp.dsp20191.aulas1316.ap.persistencia.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriaConexao {

    //JDBC driver name
    public static final String JDBC_DRIVER = "org.h2.Driver";

    //Database file URL
    public static final String DB_FILE_URL = "jdbc:h2:~/lotacao";

    //Database Credentials
    public static final String USER = "sa";
    public static final String PASS = "";

    private Connection conn = null;

    public Connection getConnection() {
        try {
            //STEP 1: Register JDBC Driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_FILE_URL, USER, PASS);
        }catch (SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch (Exception e){
            //Handle errors for Class.forName.
            e.printStackTrace();
        } //end try
        return conn;
    }
}
