package com.kanth.resttemplateserver;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kanth.resttemplateserver.bo.Person;
import com.kanth.resttemplateserver.bo.SqlParaBean;
import com.kanth.resttemplateserver.util.SqlUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResttemplateServerApplicationTests {

	@Autowired
	private PatchRequestCheck patchRequestCheck;

	@Test
	public void contextLoads() throws IllegalArgumentException, IllegalAccessException, InstantiationException {
		Person person = patchRequestCheck.getPersonBean();

		SqlParaBean sqlbean;
		try {
			sqlbean = SqlUtils.getQueryonBeanValues(person);
			System.out.println(sqlbean.getSqlquery());
			Arrays.asList(sqlbean.getParams()).stream().forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
