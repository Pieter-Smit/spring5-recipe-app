package guru.springframework.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	
	Category category;

	@Before
	public void setUp() {
		category = new Category();
	}
	
	@Test
	public void test() {
		Long id = 41L;
		category.setId(id);
		assertEquals(id, category.getId());
	}

}
