package test;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.street.dao.LightDAO;
import com.street.model.LightPole;

public class LightTest {
	
	
	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.street");
		context.refresh();
		LightDAO lightDAO = (LightDAO)  context.getBean("lightDAO");
	
	LightPole c =(LightPole)	  context.getBean("lightPole");
	
	c.setId(001);
	c.setDate("2016-12-22");
	c.setStatus("true");
	c.setTime("2:2:20");
	lightDAO.saveOrUpdate(c);
	c.setId(002);
	c.setDate("2016-10-22");
	c.setStatus("true");
	c.setTime("4:2:20");
	lightDAO.saveOrUpdate(c);
	
	
	lightDAO.saveOrUpdate(c);

	List<LightPole>  list =    lightDAO.list();

	for(LightPole cat : list)
	{
		System.out.println(cat.getId()  + ":" +  cat.getId()  + ":"+  cat.getDate());
	}
		
		
	}

	
	}

