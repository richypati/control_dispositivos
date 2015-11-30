package co.edu.udea.controldispositivos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import co.edu.udea.controldispositivos.dominio.Usuario;

public class UsuarioDAO implements IUsuarioDAO{
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session;

	@Override
	public Usuario obtenerUsuarioPorEmail(String email) {
		Usuario usuario = null;
		try{
			session = sessionFactory.openSession();
			usuario = (Usuario) session.get(Usuario.class, email);
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			if (null != session){
				if (session.isOpen()){
					session.close();
				}
			}
		}
		return usuario;
	}

	@Override
	public void crearUsuario(Usuario usuario) throws ConstraintViolationException{
		Transaction transaction = null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(usuario);
			transaction.commit();
		}catch(ConstraintViolationException e){
			if (null != transaction){
				transaction.rollback();
			}
			throw e;
		}finally {
			if (null != session){
				if (session.isOpen()){
					session.close();
				}
			}
		}
	}

}