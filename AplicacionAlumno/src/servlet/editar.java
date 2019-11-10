package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.*;
import negocio.*;

/**
 * Servlet implementation class editar
 */
@WebServlet("/editar")
public class editar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try 
		{
			String nombre=request.getParameter("nombre");
			String apellido=request.getParameter("apellido");
			String tipodoc=request.getParameter("tipodoc");
			String direccion=request.getParameter("direccion");
			int legajo=Integer.parseInt(request.getParameter("legajo"));
			int ida=Integer.parseInt(request.getParameter("ida"));
			int idp=Integer.parseInt(request.getParameter("idp"));
			long nrodoc=Long.parseLong(request.getParameter("nrodoc"));
			String strDate=request.getParameter("fechanac");
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			Date fechanac=sdf.parse(strDate);
			CtrlPersona cp= new CtrlPersona();
			CtrlAlumno ca=new CtrlAlumno();
			Persona p=new Persona(idp,tipodoc,nrodoc,nombre,apellido,fechanac,direccion);
			cp.update(p);
			Alumno a=new Alumno(ida,p,legajo);
			ca.update(a);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
