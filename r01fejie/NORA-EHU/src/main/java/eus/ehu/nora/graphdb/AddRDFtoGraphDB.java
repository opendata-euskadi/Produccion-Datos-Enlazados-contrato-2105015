package eus.ehu.nora.graphdb;

import org.eclipse.rdf4j.repository.RepositoryConnection;

public interface AddRDFtoGraphDB {
	void add(RepositoryConnection connection, String namedGraph);

}
