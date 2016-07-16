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

	/**
	 * 第1引数は取得結果を保持したいDtoのクラス
	 * 　SQL取得結果は引数に指定したクラスのメンバ変数と名前が一致するものを
	 * 　自動的にセットしてくれる（ジェネリックメソッドというjavaの仕組みを利用）
	 *　 ただし、SQLはスネーク、Dto側はキャメルで変数を記載する
	 * 第2引数は取得するテーブルの名前。
	 */
    public <T> List<T>  selectAll(Class<T> clazz, String tableName) {

    	// レコードを取得
    	List<Map<String, Object>>  list = jdbcTemplate.queryForList("select * from " + tableName);

    	// レコード情報をDtoにセットする
    	return DaoUtil.recordToDto(clazz, list);
    }

}
