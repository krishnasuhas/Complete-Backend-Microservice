package com.hasi.batch.reader;

import com.hasi.data.postgres.entity.Lawsuit;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.PostgresPagingQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class PagingItemReader extends JdbcPagingItemReader<Lawsuit> {

    @Autowired
    public DataSource dataSource;

    public PagingItemReader() {
        this.setDataSource(dataSource);
        this.setFetchSize(2);
        this.setRowMapper(new LawsuitRowMapper());

        PostgresPagingQueryProvider queryProvider = new PostgresPagingQueryProvider();
        queryProvider.setSelectClause("lawsuitId, clientId, lawyerId, creationDate");
        queryProvider.setFromClause("from lawsuit");

        Map<String, Order> sortKeys = new HashMap<>();
        sortKeys.put("lawsuitId", Order.ASCENDING);
        queryProvider.setSortKeys(sortKeys);
        this.setQueryProvider(queryProvider);
    }
}
