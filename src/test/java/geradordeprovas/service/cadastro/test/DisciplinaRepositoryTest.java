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

import geradordeprovas.modelo.Disciplina;
import geradordeprovas.modelo.dao.GeralDAO;
import geradordeprovas.repository.DisciplinaRepository;
import geradordeprovas.test.util.DbUnitHelper;

public class DisciplinaRepositoryTest {

	private static DbUnitHelper dbUnitHelper;
	private static EntityManagerFactory factory;

	private EntityManager manager;
	private DisciplinaRepository repository;
	private GeralDAO<Disciplina> dao;

	@BeforeClass
	public static void initClass() {
		dbUnitHelper = new DbUnitHelper("DbUnitXml");
		factory = Persistence.createEntityManagerFactory("LMSPUTEST");
	}

	@Before
	public void init() {
		dbUnitHelper.execute(DatabaseOperation.DELETE_ALL, "Disciplina.xml");

		dbUnitHelper.execute(DatabaseOperation.INSERT, "Disciplina.xml");

		manager = factory.createEntityManager();
		this.repository = new DisciplinaRepository(manager);
		this.dao = new GeralDAO<Disciplina>(manager);
	}

	@After
	public void end() {
		this.manager.close();
	}

	@Test
	public void deveRetornarDuasDisciplinas() {
		List<Disciplina> resultado = repository.listarTodos();
		Assert.assertEquals("resultado", 2, resultado.size());
	}

	@Test
	public void deveRetornarDisciplinaMatematica() {
		List<Disciplina> resultado = repository.buscarPorDescricao("disciplina", "MATEMÁTICA");
		Assert.assertEquals("resultado", 1, resultado.size());
	}

	@Test
	public void deveCadastrarDisciplina() {
		Disciplina historia = new Disciplina();
		historia.setDisciplina("HISTORIA");
		historia.setCargaHoraria(120);
		historia.setCodMec("003");
		dao.salvar(historia);

		Assert.assertEquals("resultado", 0, repository.buscarPorDescricao("disciplina", "HISTORIA").size());
	}

	@Test
	public void deveRemoverDisciplina() {
		Disciplina biologia = new Disciplina();
		biologia.setPkdisciplina(2);
		biologia.setDisciplina("BIOLOGIA");
		biologia.setCargaHoraria(120);
		biologia.setCodMec("004");
		dao.salvar(biologia);
		dao.remover(repository.obterPorID(biologia.getPkdisciplina()));
		Assert.assertEquals("resultado", 0, repository.buscarPorDescricao("disciplina", "BIOLOGIA").size());
	}

	@Test
	public void deveRetornarPorID() {
		Disciplina disciplina = new Disciplina();
		disciplina.setPkdisciplina(1);
		Assert.assertEquals("resultado", disciplina, repository.obterPorID(1));
	}

}
