package com.mql.gestionventes.Dao;

import java.util.List;

/**
 * Interface general qui contient les methodes CRUD, 
 * @param <T> : type générique chaque classe qui implemente de cette Interface
 * va utiliser l'objet correspondant
 */

public interface DAO<T> {
	
	public T find(int T);
	public boolean create(T object);
	public boolean update (T object);
	public boolean delete (T object);
	public List<T> getAll();
	
}
