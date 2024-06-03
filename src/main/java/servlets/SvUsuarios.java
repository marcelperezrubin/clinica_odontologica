package servlets;

import com.marcelperezrubin.clinicaodontologica.logica.Controladora;
import com.marcelperezrubin.clinicaodontologica.logica.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marcelrubin
 */
@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {
    

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        
        listaUsuarios = control.getUsuarios();
        
        HttpSession mysession = request.getSession();
        mysession.setAttribute("listaUsuarios", listaUsuarios);
        
        response.sendRedirect("verUsuarios.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String nombreUsuario = request.getParameter("nombreusu");
        String contra = request.getParameter("contrasenia");
        String rol = request.getParameter("rol");
        
        control.crearUsuario(nombreUsuario, contra, rol);
        
        
        //System.out.println("El nombre de Usuario es: " + nombreUsuario);
        
        response.sendRedirect("index.jsp");
        
        
        
    }
    
    

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
