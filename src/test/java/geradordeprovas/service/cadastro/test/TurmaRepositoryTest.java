package geradordeprovas.service.cadastro.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import geradordeprovas.modelo.Turma;
import geradordeprovas.modelo.dao.GeralDAO;
import geradordeprovas.repository.TurmaRepository;
import geradordeprovas.test.util.DbUnitHelper;

public class TurmaRepositoryTest {

	private static DbUnitHelper dbUnitHelper;
	private static EntityManagerFactory factory;

	private EntityManager manager;
	private TurmaRepository repository;
	private GeralDAO<Turma> dao;

	@BeforeClass
	public static void initClass() {
		dbUnitHelper = new DbUnitHelper("DbUnitXml");
		factory = Persistence.createEntityManagerFactory("LMSPUTEST");
	}

	@Before
	public void init() {
		dbUnitHelper.execute(DatabaseOperation.DELETE_ALL, "Turma.xml");

		dbUnitHelper.execute(DatabaseOperation.INSERT, "Turma.xml");

		manager = factory.createEntityManager();
		this.repository = new TurmaRepository(manager);
		this.dao = new GeralDAO<Turma>(manager);
	}

	@After
	public void end() {
		this.manager.close();
	}

	@Test
	public void deveRetornarDuasTurmas() {
		List<Turma> resultado = repository.listarTodos();
		Assert.assertEquals("resultado", 2, resultado.size());
	}

	@Test
	public void deveRetornarPrimeiraSerie() {
		List<Turma> resultado = repository.buscarPorDescricao("turma", "1ª SERIE");
		Assert.assertEquals("resultado", 1, resultado.size());
	}

	@Test
	public void deveCadastrarDisciplina() {
		Turma serie1 = new Turma();
		serie1.setPkturma(2);
		serie1.setCodmec("004");
		serie1.setHoraInicial("07:00");
		serie1.setHoraFinal("12:30");
		serie1.setMaisEducacao(true);
		serie1.setTurma("!ª SÉRIE");
		dao.salvar(serie1);

		Assert.assertEquals("resultado", 0, repository.buscarPorDescricao("codmec", "004").size());
	}

	@Test
	public void deveRetornarPorID() {
		Turma turma = new Turma();
		turma.setPkturma(1);
		Assert.assertEquals("resultado", turma, repository.obterPorID(1));
	}

}
