package UI;

import Collection.ManageMusic;
import User.ManageUser;
import User.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "addmusic", urlPatterns = {"/addmusic"})
public class addmusic extends HttpServlet {

    ManageMusic manageM = new ManageMusic();
    ManageUser manageU = new ManageUser();
    private String artist;
    private String album;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        if (session.getAttribute("loggedIn") != null) {
            if ((boolean) session.getAttribute("loggedIn")) {
                System.out.println("User is logged in!");
            } else {
                response.sendRedirect("index");
            }
        } else {
            response.sendRedirect("index");
        }

        try (PrintWriter out = response.getWriter()) {

            try {
                artist = request.getParameter("artist");
                album = request.getParameter("album");
                System.out.println("artist : " + artist + " : album : " + album);
            } catch (Exception e) {
                System.out.println("ERROR AddMusic 2:");
                e.printStackTrace();
            }

            try {
                manageM.addAlbum(manageU.getUID((String) session.getAttribute("userLoggedIn")), artist, album);
                response.sendRedirect("collection");
            } catch (Exception e) {
                System.out.println("ERROR AddMusic 1:");
                e.printStackTrace();
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
