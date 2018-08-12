package geradordeprovas.service.cadastro.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import geradordeprovas.test.util.App;

@RunWith(Suite.class)
@SuiteClasses({ 
	App.class,
	DisciplinaRepositoryTest.class,
	TurmaRepositoryTest.class,
	AutenticacaoTest.class
	})
public class AllTests {

}
