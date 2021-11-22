package com.springboot.crud;

import com.springboot.crud.CrudApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrudApplicationTests {
	@Test
	public void applicationContextLoaded() {
	}
	@Test
	public void main() {
		CrudApplication.main(new String[] {});
	}
}
