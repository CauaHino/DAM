package controlador;

import java.io.IOException;
import java.util.Date;
import java.util.function.Consumer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductoDAO;
import modelo.Carrito;
import modelo.Producto;

/**
 * Servlet implementation class CarritoControlador
 */
@WebServlet("/CarritoControlador")
public class CarritoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String opcion = request.getParameter("opcion");
		
		HttpSession session = request.getSession();
		Carrito carrito = (Carrito)session.getAttribute("carrito");
		
		if(carrito == null) {
			carrito = new Carrito();
		}
		
		if(opcion.equalsIgnoreCase("agregar")) {
			int idProducto = Integer.parseInt(request.getParameter("idProducto"));
			ProductoDAO productoDAO = new ProductoDAO();
			Producto p = productoDAO.consultarProducto(idProducto);
			p.setCantidad(1);
			carrito.agregar(p);
			productoDAO.getConexion().cerrarConexion();
			session.setAttribute("carrito", carrito);
		} else if(opcion.equalsIgnoreCase("eliminar")) {
			int idProducto = Integer.parseInt(request.getParameter("idProducto"));
			carrito.eliminar(idProducto);
			session.setAttribute("carrito", carrito);
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/index.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
