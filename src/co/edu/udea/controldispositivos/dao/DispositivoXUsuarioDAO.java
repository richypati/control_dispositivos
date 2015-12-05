package co.edu.udea.controldispositivos.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import co.edu.udea.controldispositivos.daoi.IDispositivoXUsuarioDAO;
import co.edu.udea.controldispositivos.dominio.DispositivoXUsuario;

public class DispositivoXUsuarioDAO implements IDispositivoXUsuarioDAO{
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session;

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<DispositivoXUsuario> obtenerDispositivosXUsuario(String emailUsuario) {
		
		ArrayList<DispositivoXUsuario> dispositivosXUsuario = null;
		try{
			session = sessionFactory.openSession();
			dispositivosXUsuario = (ArrayList<DispositivoXUsuario>) session
					.createCriteria(DispositivoXUsuario.class)
					.createCriteria("usuario")
					.add(Restrictions.eq("email", emailUsuario)).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return dispositivosXUsuario;
	}

	@Override
	public void asignarDispositivoAUsuario(DispositivoXUsuario dispositivoXUsuario) throws ConstraintViolationException{
		Transaction transaction = null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(dispositivoXUsuario);
			transaction.commit();
		}catch(ConstraintViolationException e){
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
