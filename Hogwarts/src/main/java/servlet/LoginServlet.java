/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    String message;

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
            HttpSession session = request.getSession();
            /* TODO output your page here. You may use following sample code. */

            if (session.getAttribute("status") != null) {
                if (session.getAttribute("status").toString().equals("Login_Success")) {

                    RequestDispatcher rd = request.getRequestDispatcher("/IndexServlet");
                    rd.forward(request, response);
                } else if (session.getAttribute("status").toString().equals("Login_Failed")) {
                    message = session.getAttribute("statusmessage").toString();
                }
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(" <form method=\"POST\">\n"
                    + "            <table>\n"
                    + "                <tr>\n"
                    + "                    <td colspan=\"2\">Login:</td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>User Name:</td>\n"
                    + "                    <td><input type=\"text\" name=\"username\"/></td>\n"
                    + "                </tr>\n"
                    + "\n"
                    + "                <tr>\n"
                    + "                    <td>Password:</td>\n"
                    + "                    <td><input type=\"password\" name=\"password\"/></td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td><input type=\"submit\" name=\"submit\" value=\"submit\"/></td>\n"
                    + "                    <td><input type=\"reset\"/></td>\n"
                    + "                </tr>\n"
                    + "            </table>\n"
                    + "        </form>\n"
                    + "        <br/>\n"
                    + "        ");
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
