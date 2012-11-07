/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.MeasurementType;
import at.sks.scada.dal.repositories.RepositoryInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author patrick
 */
@WebServlet(name = "ScadaServlet", urlPatterns = {"/ScadaServlet"})
public class ScadaServlet extends HttpServlet {
    @EJB(beanName="MeasurementTypeDbRepo")
     private RepositoryInterface<MeasurementType> measurementTypeRepo;
    @EJB(beanName="MeasurementDbRepo")
     private RepositoryInterface<MeasurementType> measurementRepo;
    
    private static final Logger log = Logger.getLogger(ScadaServlet.class.getName());
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ScadaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ScadaServlet at " + request.getContextPath() + "</h1>");
            
            if(measurementTypeRepo.get("1") != null) {
                MeasurementType mt = measurementTypeRepo.get("1");
                out.println("<div>" + mt.getUnit()+ "</div>");
            }
            
            MeasurementType mt = new MeasurementType();
            mt.setMaximum(123);
            mt.setMeasurementTypeID(4);
            mt.setMinimum(1);
            mt.setUnit("ST");
            measurementTypeRepo.add(mt);
            measurementTypeRepo.commitChanges();
            measurementTypeRepo.delete(mt.getMeasurementTypeID().toString());
            
            out.println("</body>");
            out.println("</html>");
        } catch(DataAccessLayerException ex) {
            log.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
