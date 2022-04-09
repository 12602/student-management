/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class addstudent extends HttpServlet {

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
           String name=request.getParameter("name");
           String class1=request.getParameter("class");
          String  roll=request.getParameter("roll");
          Integer rollno=Integer.parseInt(roll);
          
        try
        {
          Class.forName("oracle.jdbc.OracleDriver");
               Connection  conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-3JDRGG3:1521/xe","oracle","abc");
                   Statement st=conn.createStatement();
        PreparedStatement ps=conn.prepareStatement("insert into addstudent values(?,?,?)");
         ps.setInt(2, rollno);
          ps.setString(1, name);
          ps.setString(3,class1);
         ps.executeUpdate();
       out.print("<html><head>");
       out.println("<style> body {background:linear-gradient(#9D50BB,#6e48aa); height:100vh;} tr,th,td{font-size:40px; height:70px;width:300px}    </style>  </head>");
       out.println("<body> ");
       out.println("<h1 style='text-align:center;position:relative;top:230px;color:yellow'> Student added succesfully ! Student details  are:</h1>");
          out.println("<table style='width:100vw; display:flex; align-items:center; justify-content:center; height:100vh; color:white'>");
         out.println("<tr><td>Name</td><td>Class</td><td>Roll No</td></tr>");
          out.println("<tr><td>"+name+"</td><td>"+class1+"</td><td>"+roll+"</td></tr>");
          out.println("</table>");
         
          out.println("</body>");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
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
