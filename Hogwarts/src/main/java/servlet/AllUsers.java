/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.mycompany.hogwarts.service.HogwartsClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author root
 */
public class AllUsers extends HttpServlet {

    @Inject
    @RestClient
    HogwartsClient hogwartsClient;
    List<Object[]> users;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AllUsers</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AllUsers at " + request.getContextPath() + "</h1>");
//            try {
//                users = hogwartsClient.getUsers();
//                for (Object[] user : users) {
//                    out.println(user[1]);
//                }
//            } catch (Exception e) {
//                out.println(e);
//            }
            out.println("<table width='100%'><tr><td align='left'><a href='LogoutServlet'>Log Out</a></td></tr></table><br/><br/>");

            out.println("<table border ='1'>");
            out.println("<tr><td>UserID</td><td>Username</td><td>Email</td>");
            try {
                users = hogwartsClient.getUsers();
                for (Object[] user : users) {
                    out.println("<tr><td>" + user[0] + "</td><td>" + user[1] + "</td><td>" + user[4] + "</td></tr>");
                }
                out.println("</table>");

            } catch (Exception e) {
                out.println("<tr><td colspan='3'> You are not Authorized to view the Users</td><tr>");
            }

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
