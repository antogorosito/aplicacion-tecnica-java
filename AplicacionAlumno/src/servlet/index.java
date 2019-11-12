package servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;




/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
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
		String op = request.getParameter("op");	
		if(op.equals("registrar"))
		{
			request.getRequestDispatcher("/registrar.jsp").forward(request, response);
		}
		else if(op.equals("editar"))
		{			
			request.getRequestDispatcher("/editar.jsp").forward(request, response);
		}
		else if(op.equals("reportesEstado"))
		{
			request.getRequestDispatcher("/reportesEstado.jsp").forward(request, response);
		
		}
		else if(op.equals("reportesCurso"))
		{
			request.getRequestDispatcher("/reportesCurso.jsp").forward(request, response);
		}
		else if(op.equals("inscripcion"))
		{
			request.getRequestDispatcher("/inscripcion.jsp").forward(request, response);
		}
	}
}
