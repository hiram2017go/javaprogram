package com.zyy.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.zyy.bean.User;
import com.zyy.dao.UserDao;

public class UserDaoImpl implements UserDao {

	DataSourceTransactionManager tx;
	
	public void setTx(DataSourceTransactionManager tx) {
		this.tx = tx;
	}

	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		System.out.println("---------------"+u.getUsername()+u.getAge());
		String sql = "insert into usertbl (username,age) values (?,? )";
		jdbcTemplate.update(sql, new Object[]{u.getUsername(), u.getAge()}); //��Ҫ����Spring-tx.jar��
	}

	//��ǰ����ΪAOP �� APIʵ�ַ�ʽ
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		DefaultTransactionDefinition td = new DefaultTransactionDefinition();
		td.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus ts = tx.getTransaction(td);
		
		try {
			String sql1 = "delete from usertbl where id = ? ";
			String sql2 = "delete from usertbls where id = ? ";
			jdbcTemplate.update(sql1, new Object[] {2});
			jdbcTemplate.update(sql2, new Object[] {3});
			
			tx.commit(ts);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����ˣ��ع�"+e.getMessage());
			tx.rollback(ts);
		}
	}

	@Override
	public void update(User u) {
	}

	@Override
	public List list() {
		// TODO Auto-generated method stub
		return null;
	}

	//��ǰ����Ϊxml��ʵ������ʽ
	@Override
	public void deleteforxml() {

		String sql1 = "delete from usertbl where id = ? ";
		String sql2 = "delete from usertbsl where id = ? ";
		jdbcTemplate.update(sql1, new Object[] {9});
		jdbcTemplate.update(sql2, new Object[] {8});
	}

	//��ǰΪע�������ʵ�ַ�ʽ
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteforanno() {

		String sql1 = "delete from usertbl where id = ? ";
		String sql2 = "delete from usertbl where id = ? ";
		jdbcTemplate.update(sql1, new Object[] {9});
		jdbcTemplate.update(sql2, new Object[] {8});
	}

}
