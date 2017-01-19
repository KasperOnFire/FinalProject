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

@WebServlet(name = "collection", urlPatterns = {"/collection"})
public class collection extends HttpServlet {

    ManageMusic manageM = new ManageMusic();
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
                    + "    <meta name=\"author\" content=\"Tjalfe Møller, David Carl & Kasper Ravn Breindal\">\n"
                    + "    <link rel=\"icon\" href=\"img/favicon.png\">\n"
                    + "    <title>MusicProject</title>\n"
                    + "    <link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\">\n"
                    + "    <link href=\"css/main.css\" rel=\"stylesheet\">\n"
                    + "    <link rel=\"stylesheet\" href=\"css/collection.css\">\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <div class=\"container main-div\">\n"
                    + "        <div class=\"top-div\">\n"
                    + "            <h1 class=\"text-center main-header\">YourMusic!</h1>\n"
                    + "            <h2 class=\"text-center\"> for managing anything!</h2>\n"
                    + "        </div>\n"
                    + "        <div class=\"gallery\">\n"
                    + "            <h3><small class=\"totalAlbums\">##</small> albums in your collection.</h3>\n");
            try {
                ArrayList<Music> music = manageM.getAlbums(manageU.getUID((String) session.getAttribute("userLoggedIn")));
                for (Music object : music) {
                    out.println("            <div class=\"img\">\n"
                            + "                <a target=\"_blank\" href=\"\" target=\"_blank\"><img src=\"img/placeholder.png\" class=\"albumImg\">\n"
                            + "                    <span class=\"albumSongs\"><span></span></span>\n"
                            + "                </a>\n"
                            + "                <div class=\"desc\">\n"
                            + "                    <a class=\"artistName\" href=\"error.html\" target=\"_blank\"><span class=\"artistSpan\">" + object.getArtist() + "</span></a><br>\n"
                            + "                    <a class=\"albumName\" href=\"\" target=\"_blank\"><span class=\"albumSpan\">" + object.getAlbum() + "</span></a><br>\n"
                            + "                </div>\n"
                            + "            </div>\n");
                }
            } catch (Exception e) {
            }
                    out.println("    <div class=\"navbar\">\n"
                    + "        <ul>\n"
                    + "            <li><a href=\"addalbum.html\">Add Album</a></li>\n"
                    + "            <li><a href=\"delete\">Remove Album</a></li>\n"
                    + "            <li style=\"float:right\"><a href=\"logout\">Logout</a></li>\n"
                    + "        </ul>\n"
                    + "    </div>\n"
                    + "    <script src=\"js/jquery-3.1.1.min.js\"></script>\n"
                    + "    <script src=\"bootstrap/js/bootstrap.min.js\"></script>\n"
                    + "    <script src=\"js/main.js\"></script>\n"
                    + "    <script>\n"
                    + "        var currentColor;\n"
                    + "\n"
                    + "        function changeColor() {\n"
                    + "            var colors = ['#F44336', '#E91E63', '#9C27B0', '#673AB7', '#3F51B5', '#2196F3', '#03A9F4', '#00BCD4',\n"
                    + "                '#009688', '#4CAF50', '#8BC34A', '#FF9800', '#FF5722'\n"
                    + "            ];\n"
                    + "            var randNumb = Math.floor(Math.random() * colors.length);\n"
                    + "            currentColor = colors[randNumb];\n"
                    + "            document.getElementsByClassName(\"main-header\").style[\"color\"] = currentColor;\n"
                    + "        }\n"
                    + "    </script>\n"
                    + "    <script>\n"
                    + "        var modal = document.getElementById('myModal');\n"
                    + "        var btn = document.getElementsByClassName(\"tracklist\")[0];\n"
                    + "        var span = document.getElementsByClassName(\"close\")[0];\n"
                    + "        btn.onclick = function () {\n"
                    + "            modal.style.display = \"block\";\n"
                    + "        }\n"
                    + "        span.onclick = function () {\n"
                    + "            modal.style.display = \"none\";\n"
                    + "        }\n"
                    + "        window.onclick = function (event) {\n"
                    + "            if (event.target == modal) {\n"
                    + "                modal.style.display = \"none\";\n"
                    + "            }\n"
                    + "        }\n"
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
