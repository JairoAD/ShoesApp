/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CartModule;

import CartDatabaseModule.DataBaseHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jairo
 */

/*{

CREATE database ShoesDB;
USE ShoesDB;

CREATE TABLE cart(
	sku int,
    name varchar(255),
    brand varchar(255),
    price double
);

INSERT INTO cart (sku, name, brand, price)
VALUES (006, 'New Balance 960', 'New Balance', 90000);

*/
public class test extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            DataBaseHelper dt = new DataBaseHelper();
            ResultSet resultSet = dt.getShoe();
            System.out.println("Retrieved ResultSet.");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Shopping Cart</title>");
            out.println("<link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container mt-5'>");
            out.println("<h1>Your Shopping Cart</h1>");
            out.println("<div class='row'>");
            System.out.println("Connected to the database successfully.");

            while (resultSet.next()) {
                int id = resultSet.getInt("sku");
                String name = resultSet.getString("name"); 
                double price = resultSet.getDouble("price");

                out.println("    <div class='col-md-4'>");
                out.println("        <div class='card mb-4'>");
                out.println("            <div class='card-body'>");
                out.println("                <h5 class='card-title'>" + name + "</h5>");
                out.println("                <p class='card-text'>Price: $" + price + "</p>");
                out.println("                <p class='card-text'>SKU: " + id + "</p>");
                out.println("            </div>");
                out.println("        </div>");
                out.println("    </div>");
            }

            out.println("</div>"); 
            out.println("</div>"); 
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
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
