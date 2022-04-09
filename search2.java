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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "student", urlPatterns = {"/student"})
public class search2 extends HttpServlet {

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
           Connection conn=null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
                 conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-3JDRGG3:1521/xe","oracle","abc");
        PreparedStatement ps=conn.prepareStatement("select * from addstudent");
        ResultSet rs=ps.executeQuery();
         out.print("<html><head>");
        out.println("<style> body {background:linear-gradient(#9D50BB,#6e48aa); height:200vh;} tr{height:40px;}  tr,table,td{ border : 1px solid black;}td:hover,th:hover{background-color:white;color:green;} td{text-align:center;}td{color:red;} th{ height:30px;background-color:cyan; }   </style>  </head>");
       out.println("<body ");
       out.println("<h1 style='text-align:center;position:relative; top:20px; color:white;font-size:30px; ' Student details  are:</h1>");
         out.println("<table style='margin:auto; width:80vw;height:100vh; top:50px;  left:70px;position:relative;background-color:yellow ;color:red'>");
          out.print("<div style='background-color:yellow'>");
         out.println("<tr><th>Name</th><th>Class</th><th>Roll No</th></tr>");
        while(rs.next())
        {
               out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(2)+"</td></tr>");
               
         
            
        }
        out.println("</div></table>");
        out.print("<h2 style=' position:absolute; top:-45px; left:600px; margin-bottom:30px'>Student details</h2>'");
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
