package com.hasi.batch.reader;

import com.hasi.data.postgres.entity.Lawsuit;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LawsuitRowMapper implements RowMapper<Lawsuit> {
    @Override
    public Lawsuit mapRow(ResultSet resultSet, int i) throws SQLException {
        return Lawsuit.builder()
                .lawyerId(resultSet.getString("lawyerId"))
                .clientId(resultSet.getString("clientId"))
                .lawsuitId(resultSet.getString("lawsuitId"))
                .creationDate(resultSet.getString("creationDate"))
                .build();
    }
}
