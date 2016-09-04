package geradordeprovas.service.cadastro.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	DisciplinaRepositoryTest.class,
	TurmaRepositoryTest.class,
	AutenticacaoTest.class
	})
public class AllTests {

}
