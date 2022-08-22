package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CommentDao;
import com.example.demo.entity.Comment;

public class CommentDaoTest {
	@Autowired
	private CommentDao commentDao;
	
	//save 테스트
	@Test
	private void saveTest() {
	assertEquals(1, commentDao.save(Comment.builder().content("aaa").writer("winter").build()));
	}
	//findbyBno 테스트
	@Test
	public void findByBnoTest() {
		assertEquals(0, commentDao.findByBno(1).size());
		assertNotEquals(2, commentDao.findByBno(2).size());
	}
	//findWriterByBno 테스트
	@Test
	public void findWirterByBnoTest() {
		assertEquals(true, commentDao.findWriterById(1500).isEmpty());
		assertEquals(true, commentDao.findWriterById(2).isPresent());
	}
	//deleteByCno 테스트
	@Transactional
	@Test
	public void deleteByCnoTest() {
		assertEquals(1, commentDao.deleteByCno(61));
		assertEquals(0, commentDao.deleteByCno(1500));
	}
	
	//deleteByBno 테스트
	@Transactional
	@Test
	public void deleteByBnoTest() {
		assertNotEquals(0, commentDao.deleteByBno(2));
		assertEquals(0, commentDao.deleteByBno(1500));
	}
}
