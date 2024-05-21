
package com.emergentes.controlador;

import com.emergentes.DAO.PostDAOimp;
import com.emergentes.DAO.PostDAO;
import com.emergentes.modelo.Posts;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            PostDAO dao= new PostDAOimp();
            int id;
            Posts pos = new Posts();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    request.setAttribute("posts",pos);
                    request.getRequestDispatcher("frmPost.jsp").forward(request, response);

                    break;
                case "edit":
                    id= Integer.parseInt(request.getParameter("id"));
                    pos=dao.getById(id);
                    System.out.println(pos);
                    request.setAttribute("posts",pos);
                    request.getRequestDispatcher("frmPost.jsp").forward(request, response);
                    
                    break;
                case "delete":
                    id=Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Inicio");
                case "view":
                     List<Posts> lista= dao.getAll();
                     
                    request.setAttribute(("posts"), lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                default:
                    break;
                    
            }
            
            
        }catch(Exception ex){
            System.out.println("ERROR"+ex.getMessage());
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
            int id= Integer.parseInt(request.getParameter("id"));
            String fecha = request.getParameter("fecha");
            String titulo = request.getParameter("titulo");
            String contenido = request.getParameter("contenido");
            
            Posts pos= new Posts();
            pos.setId(id);
            pos.setFecha(fecha);
            pos.setTitulo(titulo);
            pos.setContenido(contenido);
            
            if (id==0) {
            try{
                PostDAO dao= new PostDAOimp();
                dao.insert(pos);
                response.sendRedirect(request.getContextPath()+"/Inicio"); 
                
                
                
            }catch(Exception ex){
                System.out.println("ERRROR:"+ex.getMessage());
            }
        }else{
                try{
                    PostDAO dao= new PostDAOimp();
                    dao.update(pos);
                    response.sendRedirect(request.getContextPath()+"/Inicio");
                    
                    
                    
                }catch(Exception ex){
                    System.out.println("ERROR:"+ex.getMessage());
                }
            }
            
            
            
      
    }

}
