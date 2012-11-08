/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Site;
import at.sks.scada.dal.entities.Technician;
import at.sks.scada.dal.repositories.RepositoryInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
    //TODO: this ejb does not work in CustomerService class... WHY?
    @EJB(beanName = "CustomerDbRepo")
    private RepositoryInterface<Customer> customerRepository;
    @EJB(beanName = "TechnicianDbRepo")
    private RepositoryInterface<Technician> technicianRepo;
    @EJB(beanName = "SiteDbRepo")
    private RepositoryInterface<Site> siteRepo;
    
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
            
            List<Customer> customersForTechnician = new ArrayList<Customer>();
            List<Site> sitesForCustomer = new ArrayList<Site>();
            CustomerService cs = new CustomerService(customerRepository);
            SiteService ss = new SiteService(siteRepo);
            TechnicianService ts = new TechnicianService(technicianRepo);
            
            String technicianID = "1";
            String customerID = "1";
            try {
                customersForTechnician = cs.getCustomers(ts.getTechnician(technicianID));
                sitesForCustomer = ss.getSites(cs.getCustomer(customerID));
            } catch(BusinessLayerException e) {
                log.log(Level.SEVERE, e.getMessage(), e);
            }
            
            out.println("List of customers for technician with id: " + technicianID);
            for(Customer c : customersForTechnician) {
                out.println("<div> " + c.toString() + "</div>");
            }
            out.println("<br>");
            
            out.println("Customer Statistic for Customer with id: " + customerID);
            for(Site s : sitesForCustomer) {
                out.println("<div> " + s.toString() + "</div>");
            }
            
            out.println("</body>");
            out.println("</html>");
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
