package UI;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Collection.AddMusic;
import User.RegUser;

@WebServlet(name = "registeruser", urlPatterns = {"/registeruser"})
public class registeruser extends HttpServlet {

    RegUser reguser = new RegUser();
    AddMusic am = new AddMusic();
    
    private boolean userAdded;
    private String username;
    private String password;
    private String email;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            try{
                username = request.getParameter("username");
                password = request.getParameter("password");
                email = request.getParameter("email");
                if(true){ //reguser.usernameTaken(username) == true
                    System.out.println("add user");
                    reguser.addUser(username, password, email);
                    //am.addMusic(1, "hej", "nej", "3", 2017, "blin", 1000);
                }
//                }else{
//                    if(regUser.usernameTaken(username) == true){
//                        regUser.addUser(username, password1, email, phoneNo);
//                        userAdded = true;
//                    }else{
//                        userAdded = false;    
//                    }
            }catch(Exception e){
                out.println("Somethings wrong! : " + e);
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registeruser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Username: " + username);
            out.println("<h1>Servlet registeruser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
