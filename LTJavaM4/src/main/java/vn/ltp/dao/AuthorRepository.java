package vn.ltp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import vn.ltp.domain.Author;

public class AuthorRepository extends Repository{
	public List<Author> getAuthors() {
		return jdbc.query("SELECT * FROM Author", new RowMapper<Author>() {
			@Override
			public Author mapRow(ResultSet rs, int numRow) throws SQLException {
				return new Author(rs.getInt("AuthorId"), rs.getString("AuthorName"));
			}
		});
	}
}
