package vn.t3h.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vn.t3h.domain.Author;

public class AuthorMapper implements RowMapper<Author>{

	@Override
	public Author mapRow(ResultSet rs, int arg1) throws SQLException {
		return  new Author(rs.getInt("AuthorId"), rs.getString("AuthorName"));
	}

}
