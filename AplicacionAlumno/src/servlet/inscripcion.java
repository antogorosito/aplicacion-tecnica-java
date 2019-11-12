package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AppDataException;
import negocio.*;
import entidades.*;

/**
 * Servlet implementation class inscripcion
 */
@WebServlet("/inscripcion")
public class inscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inscripcion() {
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
			int legajo=Integer.parseInt(request.getParameter("legajo"));
			int curso=Integer.parseInt(request.getParameter("sel1"));
			CtrlAlumno ca= new CtrlAlumno();
			Alumno al=ca.getOneAl(legajo);
			CtrlInscripcionCarrera ccc=new CtrlInscripcionCarrera();
			InscripcionCarrera rtaCarrera=ccc.validarCarreraCurso(al.getIdAlumno(),curso);
			CtrlInscripcionCurso cic=new CtrlInscripcionCurso();
			boolean rtaInscriptos=cic.verificarInscripcion(al.getIdAlumno(),curso);
			boolean rtaCupo=cic.validarCupo(curso);
			CtrlCurso cc=new CtrlCurso();
			Curso c=cc.getOne(curso);
			cic.add(al,c);
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('Se ha registrado con exito una nueva inscripcion al curso');");
			out.println(" location.href='inscripcion.jsp';");
			out.println("</script>");
		}
		catch (AppDataException | ParseException ape) 
		{
			// TODO Auto-generated catch block
			PrintWriter out=response.getWriter();
			out.println("<script>");
		     out.println("alert('" + ape.getMessage() + "');");
			out.println(" location.href='inscripcion.jsp';");
			out.println("</script>");	
			
		}
		
	}

}
