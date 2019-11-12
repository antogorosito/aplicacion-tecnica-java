package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import database.*;
/**
 * Servlet implementation class registrar
 */
@WebServlet("/registrar")
public class registrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrar() {
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
		try {
			String nombre=request.getParameter("nombre");
			String apellido=request.getParameter("apellido");
			int tipodoc=Integer.parseInt(request.getParameter("tipodoc"));
			TipoDoc tipodocs=null;
			if(tipodoc==1)
			{
				 tipodocs=TipoDoc.DNI;
			}
			else
			{
				 tipodocs=TipoDoc.LC;
			}
			String direccion=request.getParameter("direccion");
			int legajo=Integer.parseInt(request.getParameter("legajo"));
			long nrodoc=Long.parseLong(request.getParameter("nrodoc"));
			String strDate=request.getParameter("fechanac");
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			Date fechanac=sdf.parse(strDate);
			CtrlPersona cp= new CtrlPersona();
			CtrlAlumno ca=new CtrlAlumno();
			cp.existe(nrodoc);		
			ca.existe(legajo);
			int idPer=cp.seleccionarUltId()+1; 
			int idAl=ca.seleccionarUltId()+1;
			Persona per=new Persona(idPer,tipodocs,nrodoc,nombre,apellido,fechanac,direccion);
			cp.add(per); 
			Alumno al=new Alumno(idAl,per,legajo);
			ca.add(al);
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('Se ha registrado con exito un nuevo alumno');");
			out.println(" location.href='registrar.jsp';");
			out.println("</script>");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AppDataException ape) {
			// TODO Auto-generated catch block
			PrintWriter out=response.getWriter();
			out.println("<script>");
		     out.println("alert('" + ape.getMessage() + "');");
			out.println(" location.href='registrar.jsp';");
			out.println("</script>");	
		}
	}

}
