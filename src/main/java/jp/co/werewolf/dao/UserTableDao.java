package jp.co.werewolf.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.werewolf.dao.UserTableDto;

@Repository
public class UserTableDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserTableDto> selectAll(){

    	List<Map<String, Object>>  list = jdbcTemplate.queryForList("select * from USER");

    	List<UserTableDto> resDtoList = new ArrayList<UserTableDto>();
		for(Map<String, Object> rec : list){

			UserTableDto dto = new UserTableDto();

			dto.setUserId(rec.get("USER_ID").toString());
			dto.setUserName(rec.get("USER_NAME").toString());

			resDtoList.add(dto);
		}

		return resDtoList;
    }

}
