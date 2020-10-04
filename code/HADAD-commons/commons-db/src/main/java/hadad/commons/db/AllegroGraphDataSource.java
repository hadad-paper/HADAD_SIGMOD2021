package hadad.commons.db;

import org.openrdf.repository.RepositoryException;

import com.franz.agraph.repository.AGCatalog;
import com.franz.agraph.repository.AGRepository;
import com.franz.agraph.repository.AGRepositoryConnection;
import com.franz.agraph.repository.AGServer;

/**
 * AllegroGraph datasource implementation
 */
public class AllegroGraphDataSource {
	public final DatabaseEngine engine;
	private final String serverName;
	private final int portNumber;
	private final String catalogId;
	private final String repositoryId;
	private final String user;
	private final String password;

	/**
	 * Default constructor.
	 *
	 * @param serverName
	 * @param portNumber
	 * @param catalogId
	 * @param repositoryId
	 * @param user
	 * @param password
	 */
	public AllegroGraphDataSource(final String serverName,
			final int portNumber, final String catalogId,
			final String repositoryId, final String user, final String password) {
		this.engine = DatabaseEngine.ALLEGRO_GRAPH;
		this.serverName = serverName;
		this.portNumber = portNumber;
		this.catalogId = catalogId;
		this.repositoryId = repositoryId;
		this.user = user;
		this.password = password;
	}

	/**
	 * Attempts to establish a connection to this datasource.
	 *
	 * @return a new connection to this datasource.
	 * @throws RepositoryException
	 */
	public AGRepositoryConnection getConnection() throws RepositoryException {
		final String serverUrl = "http://" + serverName + ":" + portNumber;
		final AGServer server = new AGServer(serverUrl, user, password);
		final AGCatalog catalog = server.getCatalog(catalogId);
		final AGRepository repository = catalog.createRepository(repositoryId);
		repository.initialize();
		final AGRepositoryConnection conn = repository.getConnection();
		return conn;
	}
}
