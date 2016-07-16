package jp.co.werewolf.dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DaoUtil {

	public static final <T> List<T> recordToDto(Class<T> clazz, List<Map<String,Object>> list){
    	List<T> result = new ArrayList<T>();

		for(Map<String, Object> rec : list){

			T obj = null;
			try {
				obj = clazz.newInstance();
			} catch (InstantiationException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			for(String key : rec.keySet()){
				String keyCamel = DaoUtil.snakeToCamel(key);
				DaoUtil.setProp(UserTableDto.class, obj, keyCamel, rec.get(key));
			}

			result.add(obj);
		}

		return result;
	}

	public static final <T> void setProp(Class<T> clazz, Object ojb, String entry, Object value){
		PropertyDescriptor dtoProp = null;
		try {
			dtoProp = new PropertyDescriptor(entry, clazz);
		} catch (IntrospectionException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		Method setterMethod = dtoProp.getWriteMethod();
		try {
			setterMethod.invoke(ojb, value);
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

    public static final String snakeToCamel(final String snake) {
        if (snake == null || snake.length() == 0) {
            return snake;
        }
        final StringBuilder sb = new StringBuilder(snake.length() + snake.length());
        for (int i = 0; i < snake.length(); i++) {
            final char c = snake.charAt(i);
            if (c == '_') {
                sb.append((i + 1) < snake.length() ? Character.toUpperCase(snake.charAt(++i)) : "");
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
