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

	public void delete(long pk) {

		Session session = sessionFactory.getCurrentSession();
		UserDTO dto = session.get(UserDTO.class, pk);

		session.delete(dto);
		System.out.println("Data Deleted Successfully! :" + pk);

	}

	public UserDTO findByPk(long pk) {

		UserDTO dto = sessionFactory.getCurrentSession().get(UserDTO.class, pk);
		return dto;
	}

	public UserDTO findBylogin(String login) {
		UserDTO dto = null;
		List list = null;
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(UserDTO.class);

		criteria.add(Restrictions.eq("login", login));

		list = criteria.list();

		if (list.size() == 1) {
			dto = (UserDTO) list.get(0);

		}
		return dto;
	}

	public UserDTO authenticate(String login, String password) {
		UserDTO dto = null;
		List list = null;

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eqOrIsNull("login", login));
		criteria.add(Restrictions.eq("password", password));
		list = criteria.list();
		if (list.size() == 1) {
			dto = (UserDTO) list.get(0);

		}
		return dto;
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {

		List list = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);

		if (dto != null) {

			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));

			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.ilike("firstName", dto.getFirstName()));

			}
			if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				criteria.add(Restrictions.ilike("login", dto.getLogin()));

			}

		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);

		}
		list = criteria.list();
		return list;
	}
}
