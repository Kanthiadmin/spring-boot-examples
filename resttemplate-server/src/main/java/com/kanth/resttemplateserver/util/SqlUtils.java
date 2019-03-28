package com.kanth.resttemplateserver.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kanth.resttemplateserver.bo.SqlParaBean;

/**
 * 
 * @author ramakanth.b
 *21/03/2019
 */
public class SqlUtils {

	/**
	 * used generally for http patch request
	 * 
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 *
	 */
	public static SqlParaBean getQueryonBeanValues(Object po) throws IllegalAccessException {

		StringBuilder updateQuery = new StringBuilder();
		StringBuilder setQuery = new StringBuilder();
		StringBuilder whereQuery = new StringBuilder();
		List<Object> idParams = new ArrayList<>();
		List<Object> colParams = new ArrayList<>();
		updateQuery.append(" update " + getTableName(po.getClass()) + " set  ");
		Field[] fields = po.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			Object value = field.get(po);
			if (value == null) {
				continue;
			}

			String columnName = "";
			Id idAnno = field.getAnnotation(Id.class);
			if (idAnno != null) {
				Column columnAnno = field.getAnnotation(Column.class);
				columnName = getColumnName(field, columnAnno);
				if (whereQuery.length() > 0) {
					whereQuery.append(" and ");
				}
				whereQuery.append(" " + columnName + " = ? ");
				idParams.add(value);
				continue;
			}
			Column columnAnno = field.getAnnotation(Column.class);
			columnName = getColumnName(field, columnAnno);
			if (setQuery.length() > 0) {
				setQuery.append(" , ");
			}
			setQuery.append(" " + columnName + " = ? ");
			colParams.add(value);
		}
		updateQuery.append(setQuery).append(" where ").append(whereQuery);
		colParams.addAll(idParams);
		return new SqlParaBean(updateQuery.toString(), colParams.toArray());
	}

	private static String getColumnName(Field f, Column columnAnno) {
		String columnName;
		if (columnAnno != null) {
			columnName = columnAnno.name();
		} else {
			columnName = f.getName();
		}
		return columnName;
	}

	public static <T> String getTableName(Class<T> clazz) {
		Table tableAnno = clazz.getAnnotation(Table.class);
		if (tableAnno != null) {
			return tableAnno.name();
		}
		return clazz.getSimpleName();
	}

}
