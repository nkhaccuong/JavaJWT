package com.example.EmployeeServiceRedis.reponsitory;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.EmployeeServiceRedis.entity.*;

@Repository
public class EmployeeRepository {
	private HashOperations hashOperations;
	private RedisTemplate redisTemplate;


	public EmployeeRepository(RedisTemplate redisTemplate) {
		super();
		this.hashOperations = redisTemplate.opsForHash();
		this.redisTemplate = redisTemplate;
	}

	public void save(Employee employee) {
		hashOperations.put("EMPLOYEE", employee.getId(), employee);
	}

	public List<Employee> findAll() {
		return hashOperations.values("EMPLOYEE");
	}

	public Employee findById(int id) {
		return (Employee) hashOperations.get("EMPLOYEE", id);
	}

	public void update(Employee employee) {
		save(employee);
	}

	public void delete(int id) {
		hashOperations.delete("EMPLOYEE", id);
	}
}
