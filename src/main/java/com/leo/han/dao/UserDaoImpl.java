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
import org.springframework.transaction.annotation.Transactional;

import com.leo.han.beans.Actor;
import com.leo.han.beans.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	private final static String GET_USERS = "select u.username, u.password, u.enabled, a.authority from han_user u, han_authorities a where u.username = a.username order by u.username";

	private final static String IS_USER_EXIST = "select count(*) from han_user u, han_authorities a where u.username = a.username and u.username = :username";

	private final static String ADD_USER = "insert into han_user (username, password, enabled)values(:username, :password, :enabled)";

	private final static String ADD_AUTHORITY = "insert into han_authorities (username, authority)values(:username, :authority)";

	@Transactional
	@Override
	public List<User> getUsers() {

		List<User> users = jdbcTemplate.query(GET_USERS,
				new BeanPropertyRowMapper(User.class));
		return users;
	}

	@Transactional
	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(
				user);

		jdbcTemplate.update(ADD_USER, param);
		jdbcTemplate.update(ADD_AUTHORITY, param);
	}

	@Transactional
	@Override
	public boolean isUserExist(User user) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("username", user.getUsername());
		Integer count = jdbcTemplate.queryForObject(IS_USER_EXIST, paramSource,
				Integer.class);
		if (count > 0)
			return true;
		return false;
	}

}
