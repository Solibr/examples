import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/*")
public class Filter implements jakarta.servlet.Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("SOMEOMOEMRORFEHKHVBVJKHFVHGWEVEBRKLJGERYHF");

        PrintWriter pw = response.getWriter();
        pw.println("SSOMEODBSBVKHKG");
        request.setAttribute("Some", "SOMESHIT");

        if (((HttpServletRequest) request).getPathInfo().equals("/test")) {
            //((HttpServletRequest) request).getHttpServletMapping().
        }

        chain.doFilter(request, response);
        chain.
    }
}
