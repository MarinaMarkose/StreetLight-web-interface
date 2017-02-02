package com.street.dao;

import java.util.List;

import com.street.model.LightPole;

public interface LightDAO {
	public List<LightPole> list();

	public LightPole get(int id);

	public void saveOrUpdate(LightPole lightpole);

	public void delete(int id);

	public void putON(int id, String status);
}

