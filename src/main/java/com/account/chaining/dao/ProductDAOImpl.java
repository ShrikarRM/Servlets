package com.account.chaining.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.account.chaining.dto.ProductDTO;

public class ProductDAOImpl implements ProductDAO {
	public ProductDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	public void saveProductDetails(ProductDTO dto) {

		SessionFactory factory = null;
		Session session = null;
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(ProductDTO.class);
			factory = configuration.buildSessionFactory();
			session = factory.openSession();
			Transaction tc = session.beginTransaction();
			session.save(dto);
			tc.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
			if (factory != null)
				factory.close();
		}

	}

}
