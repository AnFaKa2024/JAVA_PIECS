package org.piecs.InfraEstrutura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConexaoBancoDados {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USUARIO = "rm558274";
    private static final String SENHA = "150805";

    private static final Logger logger = LogManager.getLogger(ConexaoBancoDados.class);

    public static Connection getConnection() {
        Connection conexao = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            logger.info("Conexão estabelecida com sucesso!");
        } catch (ClassNotFoundException e) {
            logger.error("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            logger.error("Erro ao conectar com o banco de dados: " + e.getMessage());
        }
        return conexao;
    }
}
