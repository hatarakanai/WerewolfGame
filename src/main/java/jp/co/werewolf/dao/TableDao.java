package jp.co.werewolf.dao;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TableDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public <T> List<T>  selectAll(Class<T> clazz, String tableName) {

    	// レコードを取得
    	List<Map<String, Object>>  list = jdbcTemplate.queryForList("select * from " + tableName);

    	// レコード情報をDtoにセットする
    	return DaoUtil.recordToDto(clazz, list);
    }

}
