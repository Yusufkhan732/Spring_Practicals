package com.rays.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

	public UserDTO findBypk(long id) {

		Session session = sessionFactory.getCurrentSession();
		UserDTO dto = session.get(UserDTO.class, id);
		return dto;
	}

	public UserDTO findBylogin(String login) {
		UserDTO dto = null;

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(UserDTO.class);

		criteria.add(Restrictions.eq("login", login));

		List list = criteria.list();

		if (list.size() == 1) {
			dto = (UserDTO) list.get(0);

		}
		return dto;
	}
}
