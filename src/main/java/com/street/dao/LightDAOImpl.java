package com.street.dao;




import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.street.model.LightPole;

@Repository("lightDAO")
public class LightDAOImpl implements LightDAO {
	

	@Autowired
	private SessionFactory sessionFactory;
	


	public LightDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public List<LightPole> list() {
		
		List<LightPole> listLightPole = (List<LightPole>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(LightPole.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listLightPole;
	}


	@Transactional
	public void saveOrUpdate(LightPole lightpole) {
			
		sessionFactory.getCurrentSession().saveOrUpdate(lightpole);
	}

	@Transactional
	public void delete(int id) {
		LightPole LightPoleToDelete = new LightPole();
		LightPoleToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(LightPoleToDelete);
	}
	
	
	
LightDAO lightDAO;
	@Transactional
	public LightPole putOn(int id) {
		String hql = "from LightPole where id=" +"'"+ id +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<LightPole> listLightPole = (List<LightPole>) query.list();
		
		if (listLightPole != null && !listLightPole.isEmpty()) {
			for (LightPole c: listLightPole ) {
	            c.setStatus("OFF");
	            lightDAO.saveOrUpdate(c);
	        }		}
		System.out.println("in dao impl");
		return null;
	}


	public LightPole get(int id) {
		// TODO Auto-generated method stub
		String hql = "from Category where id=" + "'"+ id +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<LightPole> listlightpole = (List<LightPole>) query.list();
		
		if (listlightpole != null && !listlightpole.isEmpty()) {
			return listlightpole.get(0);
		}
		return null;
	}

	

//	@Transactional
//	public Category get(String id) {
//		String hql = "from Category where id=" + "'"+ id +"'";
//		Query query = sessionFactory.getCurrentSession().createQuery(hql);
//		
//		@SuppressWarnings("unchecked")
//		List<Category> listCategory = (List<Category>) query.list();
//		
//		if (listCategory != null && !listCategory.isEmpty()) {
//			return listCategory.get(0);
//		}
//		
//		return null;
//	}

	public void putON(int id, String status) {
		// TODO Auto-generated method stub
		
	}
	

}
