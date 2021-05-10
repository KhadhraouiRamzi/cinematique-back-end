package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entite.films;

@Repository
public interface FilmsRepository extends JpaRepository<films, Integer> {

	@Query("select u from films u") // ==> JPQL, nom de la classe ou entité
	List<films> listfilms();

	@Query(nativeQuery = true, value = "select * from films u") // ==> JPQL, nom de la classe ou entité
	List<films> listfilm();

	@Query(nativeQuery = true, value = "select u.realisateur from films u where u.id = id") // ==> JPQL, nom de la classe ou entité
	List<films> getrealise(@Param(value = "id") Integer id);

	@Query(nativeQuery = true, value = "delete from films u where u.id = id") // ==> nativeQuery
	public void delfilms(@Param(value = "id") Integer id);

	@Modifying
	@Query("update films u set u.title = :title where u.id = :id")
	public void editer(@Param(value = "id") films u);

}
