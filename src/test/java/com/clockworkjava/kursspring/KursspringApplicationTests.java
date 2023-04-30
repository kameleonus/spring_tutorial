package com.clockworkjava.kursspring;


import com.clockworkjava.kursspring.domain.Knight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class KursspringApplicationTests {
	@Autowired
	Knight knight;

	@Test
	void contextLoads() {
	}
	@Test
	public void testCastle(){
		String exept ="Znajduje się zamek tu o nazwie: Wesst Watch sRycerz o imienie Lancelot (26). Zadanie: .Save " +
				"the kong";
	}


}
