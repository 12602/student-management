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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class addresult extends HttpServlet {

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
          String roll=request.getParameter("roll");
          Integer roll1=Integer.parseInt(roll);
          
           String physics=request.getParameter("physics");
          Integer physics1=Integer.parseInt(physics);
          
           String chemistry=request.getParameter("chemistry");
          Integer chemistry1=Integer.parseInt(chemistry);
          
           String maths=request.getParameter("math");
          Integer maths1=Integer.parseInt(maths);
          
           String english=request.getParameter("english");
          Integer english1=Integer.parseInt(english);
          
           String hindi=request.getParameter("hindi");
          Integer hindi1=Integer.parseInt(hindi);
          
          Connection conn=null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
                 conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-3JDRGG3:1521/xe","oracle","abc");
                 PreparedStatement ps=conn.prepareStatement("insert into result values(?,?,?,?,?,?,?,?)");
                 ps.setString(1, name);
                 ps.setString(2, class1);
                 ps.setInt(3, roll1);
                 ps.setInt(4, physics1);
                 ps.setInt(5, chemistry1);
                 ps.setInt(6, maths1);
                 ps.setInt(7, english1);
                 ps.setInt(8, hindi1);
                 ps.executeUpdate();
                  out.print("<html><head>");
       out.println("<style>body {background:linear-gradient(#9D50BB,#6e48aa); height:100vh;}    tr,th,td{font-size:40px; height:70px;width:300px}    </style>  </head>");
       out.println("<body>");
       out.println("<h1 style='text-align:center;position:relative;top:230px;color:white'> Student Result  added succesfully ! Student details  are:</h1>");
          out.println("<table style='width:100vw; display:flex; align-items:center; justify-content:center; height:100vh; color:white'>");
         out.println("<tr><td>Name</td><td>Class</td><td>Roll No</td><td>Physics</td><td>Chemistry</td><td>Maths</td><td>English</td><td>Hindi</td></tr>");
          out.println("<tr><td>"+name+"</td><td>"+class1+"</td><td>"+roll+"</td><td>"+physics1+"</td><td>"+chemistry1+"</td><td>"+maths1+"</td><td>"+english1+"</td><td>"+hindi1+"</td></tr>");
          
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
