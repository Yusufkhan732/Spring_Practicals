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
public class UserDAOHibImpl implements UserDAOInt {

	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public long add(UserDTO dto) {
		long pk = (long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	@Override
	public void update(UserDTO dto) {
		sessionFactory.getCurrentSession().update(dto);

	}

	@Override
	public UserDTO delete(long id) {
		UserDTO dto = findByPk(id);
		sessionFactory.getCurrentSession().delete(dto);
		return dto;
	}

	@Override
	public UserDTO findByPk(long pk) {
		UserDTO dto = null;
		dto = sessionFactory.getCurrentSession().get(UserDTO.class, pk);
		return dto;
	}

	@Override
	public UserDTO authenticate(String login, String password) {
		UserDTO dto = null;

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserDTO.class);

		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", password));
		List list = criteria.list();
		if (list.size() == 1) {
			dto = (UserDTO) list.get(0);

		}
		return dto;
	}

	@Override
	public UserDTO findByLogin(String login) {
		UserDTO dto = null;

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));
		List list = criteria.list();

		if (list.size() == 1) {
			dto = (UserDTO) list.get(0);

		}

		return dto;
	}

	@Override
	public List search(UserDTO dto, int pageNo, int pageSize) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		if (dto != null) {
			if (dto.getId() != null && dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		List list = criteria.list();
		return list;
	}

}
