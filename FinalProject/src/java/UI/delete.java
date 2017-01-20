package UI;

import Collection.ManageMusic;
import Collection.Music;
import User.ManageUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "delete", urlPatterns = {"/delete"})
public class delete extends HttpServlet {

    ManageMusic manage = new ManageMusic();
    ManageUser manageU = new ManageUser();

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
            } else {
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
                    + "    <link rel=\"stylesheet\" href=\"css/deleteTable.css\">\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <div class=\"container main-div\">\n"
                    + "        <div class=\"top-div\">\n"
                    + "            <h1 class=\"text-center main-header changecolor\">YourMusic!</h1>\n"
                    + "            <h2 class=\"text-center changecolor\"> for managing anything!</h2>\n"
                    + "        </div>\n"
                    + "        <div class=\"mainTable\">\n"
                    + "            <table class=\"table table-bordered\">\n"
                    + "                <thead>\n"
                    + "                    <tr>\n"
                    + "                        <th>Album</th>\n"
                    + "                        <th>Artist</th>\n"
                    + "                        <th>Delete</th>\n"
                    + "                    </tr>\n"
                    + "                </thead>\n"
                    + "                <tbody>\n");

            try {
                ArrayList<Music> music = manage.getAlbums(manageU.getUID((String) session.getAttribute("userLoggedIn")));
                for (Music object : music) {

                    out.println("<tr>\n"
                            + "<td>" + object.getAlbum() + "</td>\n"
                            + "<td>" + object.getArtist() + "</td>\n"
                            + "<td>\n"
                            + "<form action=\"removemusic\" method=\"POST\"><input type=\"hidden\" name=\"identifier\" value=" + object.getIdentifier() + "><button class=\"btn-danger\">Delete?</button></form>\n"
                            + "</td>\n");
                }
            } catch (Exception e) {
                System.out.println("ERROR Delete:");
                e.printStackTrace();
            }
            out.println("                </tbody>\n"
                    + "            </table>\n"
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
                    + "    <script>\n"
                    + "        changeColor();\n"
                    + "    </script>\n"
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
