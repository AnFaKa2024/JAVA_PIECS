package org.piecs.InfraEstrutura;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class CorsFilter implements Filter {

    private Connection conexao;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialização do filtro, se necessário
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        // Configuração dos cabeçalhos CORS
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        
        // Permitir que a requisição prossiga
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        
        if (conexao != null) {
            try {
                conexao.close(); 
            } catch (SQLException e) {
                e.printStackTrace(); 
            }
        }
       
    }
}
