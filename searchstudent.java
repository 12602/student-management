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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class searchstudent extends HttpServlet {

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
      String  roll=request.getParameter("roll");
          Integer rollno=Integer.parseInt(roll);
          Connection conn=null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
                 conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-3JDRGG3:1521/xe","oracle","abc");
                 PreparedStatement ps1=conn.prepareStatement("select * from addstudent where ROLL=?");
                 ps1.setInt(1, rollno);
                 ResultSet rs=ps1.executeQuery();
                    out.print("<html><head>");
                    
       out.println("<style> body {background:linear-gradient(#9D50BB,#6e48aa); height:100vh;} table{background:white; color:red; width:80vw;  position:absolute ;  top:50px;}td:hover,th:hover{background:red;color:white;}  td,th{text-align:center} td,th{border:1px solid black;  }         </style>  </head>");
       
       out.println("<body >");
       out.println("<h1 style='text-align:center;color:white'>Record of Roll No." + rollno + " are:</h1>");
           out.println("<table>");
           out.println("<tr><th>Name</th><th>Class</th><th>Roll No</th></tr>");
       
       out.println("<br>");
                 while(rs.next())
                 {
                        out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getInt(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
                        out.println("<br>");
                        break;
                 }
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
