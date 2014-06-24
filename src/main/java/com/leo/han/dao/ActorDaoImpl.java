package com.leo.han.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.leo.han.beans.Actor;


@Repository
public class ActorDaoImpl implements ActorDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private final static String GET_ACTORS = "SELECT * FROM ACTOR";
	private final static String GET_ACTOR_BY_ID = "SELECT * FROM ACTOR WHERE actor_id  = :actor_id";
	private final static String CREATE_ACTOR = "INSERT INTO ACTOR (first_name, last_name, last_update) VALUES (:first_name, :last_name, :last_update)";
	private final static String DELETE_ACTOR = "DELETE FROM ACTOR WHERE actor_id  = :actor_id";
	private final static String UPDATE_ACTOR = "UPDATE ACTOR SET first_name = :first_name, last_name = :last_name , last_update = :last_update WHERE actor_id = :actor_id";

	@Override
	public List<Actor> getActors() {
		// TODO Auto-generated method stub
		
		List<Actor> actors = jdbcTemplate.query(GET_ACTORS, new RowMapper<Actor>() {

			@Override
			public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Actor actor = new Actor();
				
				actor.setActor_id(rs.getInt("actor_id"));
				actor.setFirst_name(rs.getString("first_name"));
				actor.setLast_name(rs.getString("last_name"));
				actor.setLast_update(rs.getTimestamp("last_update"));

				return actor;
			}
		});
		
		return actors;
	}
	
	@Override
	public Actor getActorById(Integer id) {
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("actor_id", id);
		
		Actor actor = (Actor)jdbcTemplate.queryForObject(GET_ACTOR_BY_ID, param, new BeanPropertyRowMapper(Actor.class));
		
		
		return actor;
	}

	
	

	@Override
	public Integer createActor(Actor actor) {
		// TODO Auto-generated method stub
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(actor);
		
		
		return jdbcTemplate.update(CREATE_ACTOR, param);
		
	}

	@Override
	public Integer deleteActor(Actor actor) {
		// TODO Auto-generated method stub
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(actor);
		
		return jdbcTemplate.update(DELETE_ACTOR, param);
	}

	@Override
	public Integer updateActor(Actor actor) {
		// TODO Auto-generated method stub
		
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(actor);
		
		return jdbcTemplate.update(UPDATE_ACTOR, param);
	}

	@Override
	public void createActorList(List<Actor> actorList) {
		// TODO Auto-generated method stub
		
		
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(actorList.toArray());
		
		 jdbcTemplate.batchUpdate(CREATE_ACTOR, batchArgs);
		

	}




}
