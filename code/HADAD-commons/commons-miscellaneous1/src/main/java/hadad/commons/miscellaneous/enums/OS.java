package hadad.commons.miscellaneous.enums;

/**
 * Enum representing different operating systems
 *
 *  Alessandro Solimando
 */

public enum OS {
	WIN("Windows"), 
	LINUX("Linux"), 
	MACOS("MacOS"),
	UNKNOWN("Unknown OS");
	
	private String descr;
	
	private OS(String descr){
		this.descr = descr;
	}
	
	public String toString(){
		return descr;
	}
}
