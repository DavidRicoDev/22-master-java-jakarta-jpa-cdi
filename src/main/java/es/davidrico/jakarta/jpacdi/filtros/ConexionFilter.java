package es.davidrico.jakarta.jpacdi.filtros;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import es.davidrico.jakarta.jpacdi.configuracion.MysqlConn;
import es.davidrico.jakarta.jpacdi.servicios.ServiceJdbcException;

import java.io.IOException;

@WebFilter("/*")
public class ConexionFilter implements Filter {

    /*@Inject
    @MysqlConn
    private Connection conn;*/

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        /*try  {
            Connection connRequest = this.conn;

            if (connRequest.getAutoCommit()) {
                connRequest.setAutoCommit(false);
            }
*/
            try {
//                request.setAttribute("conn", connRequest);
                chain.doFilter(request, response);
                //connRequest.commit();
            } catch (ServiceJdbcException e) {
                //connRequest.rollback();
                ((HttpServletResponse)response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace();
            }
  /*      } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
    }
}
