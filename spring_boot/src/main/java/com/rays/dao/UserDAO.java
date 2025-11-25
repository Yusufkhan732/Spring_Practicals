package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.AttachmentDTO;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;
import com.rays.service.AttachmentService;

@Repository
public class UserDAO {

	@PersistenceContext
	public EntityManager entityManager;

	@Autowired
	public RoleDAO roleDao;

	@Autowired
	AttachmentService attachmentService;

	public void populate(UserDTO dto) {
		RoleDTO roleDto = roleDao.findByPk(dto.getRoleId());
		dto.setRoleName(roleDto.getName());

		/*
		 * if (dto.getId() != null && dto.getId() > 0) { UserDTO userData =
		 * findByPk(dto.getId()); }
		 */
	}

	public long add(UserDTO dto) {
		populate(dto);
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(UserDTO dto) {
		populate(dto);
		entityManager.merge(dto);
	}

	public void delete(UserDTO dto) {

		AttachmentDTO adto = attachmentService.findById(dto.getImageId());

		if (adto != null) {
			attachmentService.delete(adto.getId());

		}

		entityManager.remove(dto);
	}

	public UserDTO findByPk(long pk) {
		UserDTO dto = entityManager.find(UserDTO.class, pk);
		return dto;
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);

		Root<UserDTO> qrRoot = cq.from(UserDTO.class);

		List<Predicate> predicatesList = new ArrayList<Predicate>();

		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				predicatesList.add(builder.like(qrRoot.get("firstName"), dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				predicatesList.add(builder.like(qrRoot.get("lastName"), dto.getLastName() + "%"));
			}
			if (dto.getLoginId() != null && dto.getLoginId().length() > 0) {
				predicatesList.add(builder.like(qrRoot.get("loginId"), dto.getLoginId() + "%"));
			}

		}

		cq.where(predicatesList.toArray(new Predicate[predicatesList.size()]));

		TypedQuery<UserDTO> tq = entityManager.createQuery(cq);

		if (pageSize > 0) {
			tq.setFirstResult(pageNo * pageSize);
			tq.setMaxResults(pageSize);

		}
		List<UserDTO> list = tq.getResultList();
		return list;
	}

	public UserDTO findByUniqueKey(String attribute, String value) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<UserDTO> criteria = builder.createQuery(UserDTO.class);

		Root<UserDTO> root = criteria.from(UserDTO.class);

		Predicate condition = builder.equal(root.get(attribute), value);

		criteria.where(condition);

		TypedQuery<UserDTO> typedQuery = entityManager.createQuery(criteria);

		List<UserDTO> list = typedQuery.getResultList();

		UserDTO dto = null;

		if (list.size() > 0) {

			dto = list.get(0);

		}
		return dto;
	}
}
