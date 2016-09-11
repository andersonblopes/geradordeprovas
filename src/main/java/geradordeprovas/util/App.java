package geradordeprovas.util;

import org.flywaydb.core.Flyway;
import org.junit.Test;

public class App {

	@Test
	public void limpaAmbiente() {
		Flyway flyway = new Flyway();

		// flyway.setDataSource("jdbc:postgresql://192.168.0.200:5432/geradordeprovas",
		// "postgres", "st97ch19");
		flyway.setDataSource("jdbc:postgresql://192.168.0.200:5432/geradordeprovasTEST", "postgres", "st97ch19");
		// System.out.println(flyway.getDataSource());

		/* Limpa base de dados */
		flyway.clean();

		/* Executa migrations pendentes */
		// flyway.migrate();

		/* Valida migrations na base de dados */
		// flyway.validate();

		/* Gera o schema para controle de versões */
		// flyway.baseline();

	}

}
