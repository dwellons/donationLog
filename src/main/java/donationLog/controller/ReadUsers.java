package donationLog.controller;


import donationLog.persistence.UsersDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A Servlet to Search Users
 * @author Darin Wellons
 */
@WebServlet(
        urlPatterns = {"/readUsers"}
)

public class ReadUsers extends HttpServlet {

    // Instantiate Logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        logger.debug("TEST In Search Users Before DAO call" + request.getAttribute("submit"));

        // Instantiate a new DonationDAO.
        UsersDAO usersDAO = new UsersDAO();

        // If submit attribute = Submit, search.
        if (request.getParameter("submit").equals("Submit")) {

            // Get my Users, call usersDAO method, pass in the donation.
            request.setAttribute("users", usersDAO.getByPropertyEqual(request.getParameter("searchType"), request.getParameter("searchTerm")));
        } else {
            // Get all entries.
            request.setAttribute("users", usersDAO.getAll());
        }

        /*
         * The servlet will forward the request and response
         * to the Results JSP page.
         */
        RequestDispatcher dispatcher = request.getRequestDispatcher("/UserSearchResults.jsp");
        dispatcher.forward(request,response);
    }
}