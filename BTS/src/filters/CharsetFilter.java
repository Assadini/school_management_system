package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")
public class CharsetFilter implements Filter {

    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("requestEncoding");
        if (encoding == null) encoding = "UTF-8";
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {
 
        request.setCharacterEncoding("UTF-8");
        //System.out.println("Changement de l'encodage de caractères en UTF-8 ... ");
        next.doFilter(request, response);
        response.setContentType("text/html; charset=UTF-8");
    }

    public void destroy() {
    }
}
