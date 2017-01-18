package UI;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Collection.ManageMusic;
import User.RegUser;
import User.User;
import User.ManageUser;
import javax.servlet.http.HttpSession;

@WebServlet(name = "registeruser", urlPatterns = {"/registeruser"})
public class registeruser extends HttpServlet {

    ManageUser validate = new ManageUser();
    RegUser reguser = new RegUser();
    ManageMusic am = new ManageMusic();

    private boolean userAdded;
    private String username;
    private String password;
    private String email;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();

            try {
                username = request.getParameter("username");
                password = request.getParameter("pw");
                email = request.getParameter("email");
                if (reguser.usernameTaken(username)) {
                    reguser.addUser(username, password, email);
                    
                    User user = validate.login(username, password);
                    if (user != null) {
                        session.setAttribute("loggedIn", true);
                        session.setAttribute("userLoggedIn", user.getUserString());
                    }
                    
                    response.sendRedirect("collection.html");
                } else {
                    out.println("<h1>Username already taken! Fix this with javascript!</h1>");
                }
            } catch (Exception e) {
                out.println("Somethings wrong! : " + e);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
