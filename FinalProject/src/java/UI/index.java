package UI;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "index", urlPatterns = {"/index"})
public class index extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            
            if(session.getAttribute("loggedIn") == null){
                session.setAttribute("loggedIn", false);
            }else{
                if((boolean)session.getAttribute("loggedIn")){
                    response.sendRedirect("collection");
                }
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
                    + "    <!-- Bootstrap core CSS -->\n"
                    + "    <link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\">\n"
                    + "    <link href=\"css/main.css\" rel=\"stylesheet\">\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <div class=\"container main-div\">\n"
                    + "        <div class=\"top-div\">\n"
                    + "            <h1 class=\"text-center main-header\">YourMusic!</h1>\n"
                    + "            <h2 class=\"text-center\"> for managing anything!</h2>\n"
                    + "        </div>\n"
                    + "        <div class=\"fancy\">\n"
                    + "            <p class=\"fancylead\">Manage your <span class=\"typer\"></span> collection.</p>\n"
                    + "        </div>\n"
                    + "        <div class=\"login\">\n"
                    + "            <form action=\"login\" method=\"POST\">\n"
                    + "                <p class=\"text-center\">Username</p>\n"
                    + "                <input type=\"text\" name=\"username\" placeholder=\"coolguy112\" class=\"center-block\"><br>\n"
                    + "                <p class=\"text-center\">Password</p>\n"
                    + "                <input type=\"password\" name=\"pw\" placeholder=\"********\" class=\"center-block\"><br>\n"
                    + "                <input type=\"submit\" name=\"Login!\" value=\"login\" class=\"btn btn-default center-block\">\n"
                    + "            </form>\n"
                    + "            <a href=\"Register.html\" class=\"text-center register\">Not a user? Register here!</a>\n"
                    + "            <a href=\"forgot.html\" class=\"text-center forgot\">Forgot your password?</a>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "    <script src=\"bootstrap/js/bootstrap.min.js\"></script>\n"
                    + "    <script src=\"js/jquery-3.1.1.min.js\"></script>\n"
                    + "    <script src=\"js\\typed.js\\js\\typed.js\"></script>\n"
                    + "    <script src=\"js/main.js\">\n"
                    + "    </script>\n"
                    + "    <script>\n"
                    + "        $(function () {\n"
                    + "            $(\".typer\").typed({\n"
                    + "                strings: [\"cd\", \"movie\", \"vinyl\", \"anything\"],\n"
                    + "                typeSpeed: 50,\n"
                    + "                showCursor: 1,\n"
                    + "                startDelay: 500,\n"
                    + "                backDelay: 1000\n"
                    + "            });\n"
                    + "        });\n"
                    + "    </script>\n"
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
