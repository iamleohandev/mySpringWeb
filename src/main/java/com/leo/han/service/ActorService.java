package com.leo.han.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.han.beans.Actor;
import com.leo.han.dao.ActorDao;

@Service
public class ActorService {

	@Autowired
	private ActorDao actorDao;

	public List<Actor> retrieveAll() {

		List<Actor> actors = actorDao.getActors();

		return actors;
	}
	
	
	public void retrieveById(Integer id) {

		Actor a = actorDao.getActorById(id);

		System.out.println("start retrieveById----------------");


			System.out.println(a.getActor_id() + "  " + a.getFirst_name()
					+ "  " + a.getLast_name() + "  " + a.getLast_update());
		
		System.out.println("finished retrieveById-------------");

	}
	
	
	public void addActor(Actor actor){
		
		actor.setLast_update(new Timestamp((new Date()).getTime()));
		
		actorDao.createActor(actor);
	}

}
