package org.piecs.InfraEstrutura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDados {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = "rm558274";
    private static final String PASS = "150805";



    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER, PASS);

    }
}
