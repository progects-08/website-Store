package ru.websiteStore.servlets.filter;

import ru.websiteStore.dao.UserDAO;
import ru.websiteStore.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)

            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        @SuppressWarnings("unchecked")
        final AtomicReference<UserDAO> dao = (AtomicReference<UserDAO>) req.getServletContext().getAttribute("dao");

        	if (dao.get().userIsExist(login, password)) {

            final User.ROLE role = dao.get().getRoleByLoginPassword(login, password);

            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);

            redirectPage(req, res, role);

        } else {

            redirectPage(req, res, User.ROLE.UNKNOWN);
        }
    }

    private void redirectPage(final HttpServletRequest req,
                            final HttpServletResponse res,
                            final User.ROLE role)
            throws ServletException, IOException {


        if (role.equals(User.ROLE.ADMIN)) 
        	 res.sendRedirect("/websiteStore/admin");
        else 
        	if (role.equals(User.ROLE.USER)) 
        	    res.sendRedirect("/websiteStore/user");
             else 
                  if (role.equals(User.ROLE.MANAGER)) 
    	              res.sendRedirect("/websiteStore/manager");
                  else 
                       req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
    }


    @Override
    public void destroy() {
    }

}
