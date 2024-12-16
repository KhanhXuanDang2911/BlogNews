package filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Set;

public class NotFoundFilter implements Filter {
    private static final Set<String> VALID_URLS = Set.of(
            "/Images",
            "/Admin",
            "/ChangePassword",
            "/Login",
            "/Register",
            "/Logout",
            "/CreateCategory",
            "/DeleteCategory",
            "/ListCategories",
            "/UpdateCategory",
            "/AddComment",
            "/DeleteComment",
            "/UpdateComment",
            "/homepage",
            "/CreateNews",
            "/CreateNewsForUser",
            "/DeleteNews",
            "/ListNews",
            "/NewsHistory",
            "/UpdateNews",
            "/UpdateNewsForUser",
            "/NewsDetail",
            "/CreateUser",
            "/DeleteUser",
            "/ListUser",
            "/UpdateAvatar",
            "/UpdateProfile",
            "/UpdateUser",
            "/Css",
            "/Javascript",
            "/lib"
    );

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        String path = requestURI.substring(httpRequest.getContextPath().length());

        boolean isValid = VALID_URLS.stream().anyMatch(path::contains);

        if (!isValid) {
            request.getRequestDispatcher("/ERROR404/index.jsp").forward(request, response);
            return;
        }

        chain.doFilter(request, response);
    }
}
