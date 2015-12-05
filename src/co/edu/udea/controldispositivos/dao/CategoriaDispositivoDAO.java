package co.edu.udea.controldispositivos.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.udea.controldispositivos.daoi.ICategoriaDispositivoDAO;
import co.edu.udea.controldispositivos.dominio.CategoriaDispositivo;

public class CategoriaDispositivoDAO implements ICategoriaDispositivoDAO {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session;

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<CategoriaDispositivo> obtenerCategoriasDispositivo(){

		ArrayList<CategoriaDispositivo> categoriasDispositivo = null;
		try{
			session = sessionFactory.openSession();
			categoriasDispositivo = (ArrayList<CategoriaDispositivo>) session.createCriteria(CategoriaDispositivo.class).list();
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			if (null != session){
				if (session.isOpen()){
					session.close();
				}
			}
		}
		return categoriasDispositivo;
	}

}