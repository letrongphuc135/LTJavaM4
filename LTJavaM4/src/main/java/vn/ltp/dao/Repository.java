package vn.ltp.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public abstract class Repository {
	final protected JdbcTemplate jdbc;

	public Repository() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/MiniShop2");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		jdbc = new JdbcTemplate(dataSource);
	}
}
