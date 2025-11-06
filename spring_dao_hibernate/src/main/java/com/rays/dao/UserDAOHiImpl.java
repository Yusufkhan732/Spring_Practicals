package com.rays.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOHiImpl implements UserDAOInt {

	@Autowired
	private SessionFactory sessionFactory = null;

	public long add(UserDTO dto) {

		Session session = sessionFactory.getCurrentSession();
		long pk = (Long) session.save(dto);

		return pk;
	}

	public void update(UserDTO dto) {

		Session session = sessionFactory.getCurrentSession();
		session.update(dto);
		System.out.println("Data Updated Successfully! :");
	}

	public void delete(long id) {

		Session session = sessionFactory.getCurrentSession();
		UserDTO dto = session.get(UserDTO.class, id);

		session.delete(dto);
		System.out.println("Data Deleted Successfully! :" + id);

	}

}
