package UI;

import User.User;
import User.ManageUser;
import exception.errorException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    ManageUser validate = new ManageUser();

    private String username;
    private String password;
    private String errorCode;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        try {
            username = request.getParameter("username");
            password = request.getParameter("pw");
        } catch (Exception e) {
            System.out.println("ERROR Login 1:");
            e.printStackTrace();
        }

        try (PrintWriter out = response.getWriter()) {
            if (session.getAttribute("loggedIn") == null) {
                session.setAttribute("loggedIn", false);
            }

            if ((boolean) session.getAttribute("loggedIn")) {
                response.sendRedirect("collection");
            } else {
                try {
                    User user = validate.login(username, password);
                    if (user != null) {
                        session.setAttribute("loggedIn", true);
                        session.setAttribute("userLoggedIn", user.getUserString());
                        response.sendRedirect("collection");
                    } else {
                        throw new errorException("Wrong username or password!");
                    }
                } catch (errorException e) {
                    System.out.println("ERROR Login 2:");
                    e.printStackTrace();
                    errorCode = e.getMessage();
                    request.setAttribute("errorCode", errorCode);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
