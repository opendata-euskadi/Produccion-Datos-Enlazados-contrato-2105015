package eus.ehu.directorio.uris;

public enum DIRECTORIOBaseURIs {
	
    PERSON ("person/"),
    ENTITY ("organization/"),
    EQUIPMENT ("equipment/")
    ; 

	private final String uri_name;
	private final String base = "https://id.euskadi.eus/public-sector/directory/";

    private DIRECTORIOBaseURIs(String uri_name) {
        this.uri_name = base+uri_name;
    }
    
    public String getURI () {
    	return this.uri_name;
    }

}
