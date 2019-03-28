package com.kanth.resttemplateserver.bo;

import java.util.Arrays;

public class SqlParaBean {

	private String  sqlquery;

	private Object[] params;

	public String getSqlquery() {
		return sqlquery;
	}

	@Override
	public String toString() {
		return "SqlParaBean [sqlquery=" + sqlquery + ", params=" + Arrays.toString(params) + "]";
	}

	public void setSqlquery(String sqlquery) {
		this.sqlquery = sqlquery;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public SqlParaBean(String sqlquery, Object[] params) {
		super();
		this.sqlquery = sqlquery;
		this.params = params;
	}

}
