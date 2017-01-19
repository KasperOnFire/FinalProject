package UI;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "addalbum", urlPatterns = {"/addalbum"})
public class addalbum extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            
            if (session.getAttribute("loggedIn") != null) {
                if ((boolean) session.getAttribute("loggedIn")) {
                    System.out.println("User is logged in!");
                } else {
                    response.sendRedirect("index");
                }
            }else{
                response.sendRedirect("index");
            }
            
            out.println("<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "\n"
                    + "<head>\n"
                    + "    <meta charset=\"utf-8\">\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n"
                    + "    <meta name=\"description\" content=\"Final Project\">\n"
                    + "    <meta name=\"author\" content=\" Tjalfe Møller, David Carl & Kasper Ravn Breindal\">\n"
                    + "    <link rel=\"icon\" href=\"img/favicon.png\">\n"
                    + "    <title>MusicProject</title>\n"
                    + "    <!-- Bootstrap core CSS -->\n"
                    + "    <link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\">\n"
                    + "    <link href=\"css/main.css\" rel=\"stylesheet\">\n"
                    + "    <link href=\"css/navbar.css\" rel=\"stylesheet\">\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <div class=\"container main-div\">\n"
                    + "        <div class=\"top-div\">\n"
                    + "            <h1 class=\"text-center main-header\">YourMusic!</h1>\n"
                    + "            <h2 class=\"text-center\"> for managing anything!</h2>\n"
                    + "        </div>\n"
                    + "        <div class=\"addAlbum\">\n"
                    + "            <form action=\"addmusic\" method=\"POST\">\n"
                    + "                <p class=\"text-center\">Artist</p>\n"
                    + "                <input type=\"text\" required=\"required\" name=\"artist\" placeholder=\"Guns n' Roses'\" class=\"center-block\"><br>\n"
                    + "                <p class=\"text-center\">Album</p>\n"
                    + "                <input type=\"text\" required=\"required\" name=\"album\" placeholder=\"Appetite for Destruction\" class=\"center-block\"><br>\n"
                    + "                <button class=\"btn-default center-block\">Add!</button>\n"
                    + "            </form>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "    <div class=\"navbar\">\n"
                    + "        <ul>\n"
                    + "            <li><a href=\"addalbum\">Add Album</a></li>\n"
                    + "            <li><a href=\"delete\">Remove Album</a></li>\n"
                    + "            <li><a href=\"collection\">Collection</a></li>\n"
                    + "            <li style=\"float:right\"><a href=\"logout\">Logout</a></li>\n"
                    + "        </ul>\n"
                    + "    </div>\n"
                    + "    <script src=\"js/main.js\"></script>\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>");
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
