package com.emergentes.DAO;

import com.emergentes.modelo.Posts;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDAOimp extends ConexionDB implements PostDAO {

    @Override
    public void insert(Posts posts) throws Exception {
        String sql = "Insert into posts(fecha,titulo,contenido) values(?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, posts.getFecha());
        ps.setString(2, posts.getTitulo());
        ps.setString(3, posts.getContenido());
        ps.executeUpdate();
        this.desconectar();

       }

    @Override
    public void update(Posts posts) throws Exception {
        String sql="UPDATE posts set fecha=?,titulo=?,contenido=? where id=?";
        this.conectar();
        PreparedStatement ps= this.conn.prepareStatement(sql);
        ps.setString(1, posts.getFecha());
        ps.setString(2,posts.getTitulo());
        ps.setString(3,posts.getContenido());
        ps.setInt(4, posts.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql= "delete from posts where id= ?";
        this.conectar();
        PreparedStatement ps= this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<Posts> getAll() throws Exception {
        List<Posts> lista = null;
        String sql = "select * from posts order by fecha asc";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        
        lista = new ArrayList<Posts>();
        while(rs.next()){
            Posts et = new Posts();
            
            et.setId(rs.getInt("id"));
            et.setFecha(rs.getString("fecha"));
            et.setTitulo(rs.getString("titulo"));
            et.setContenido(rs.getString("contenido"));

            lista.add(et);
        }
        this.desconectar();
        return lista;
        
    }

    @Override
    public Posts getById(int id) throws Exception {
        Posts et = new Posts();
        String sql = "select * from posts where id =?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            
            et.setId(rs.getInt("id"));
            et.setFecha(rs.getString("fecha"));
            et.setTitulo(rs.getString("titulo"));
            et.setContenido(rs.getString("contenido"));
            
        }
        this.desconectar();
        return et;
    
    }
    
}
