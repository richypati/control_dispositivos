package co.edu.udea.controldispositivos.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.controldispositivos.daoi.IDispositivoDAO;
import co.edu.udea.controldispositivos.dominio.Dispositivo;

public class DispositivoDAO implements IDispositivoDAO {

	SessionFactory sessionFactory = new Configuration().configure()
			.buildSessionFactory();
	Session session;

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Dispositivo> obtenerDispositivosPorCategoria(int idCategoriaDispositivo) {

		ArrayList<Dispositivo> dispositivos = null;
		try {
			session = sessionFactory.openSession();
			dispositivos = (ArrayList<Dispositivo>) session
					.createCriteria(Dispositivo.class)
					.createCriteria("categoriaDispositivo")
					.add(Restrictions.eq("idCategoriaDispositivo",idCategoriaDispositivo))
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				if (session.isOpen()) {
					session.close();
				}
			}
		}
		return dispositivos;
	}
}
