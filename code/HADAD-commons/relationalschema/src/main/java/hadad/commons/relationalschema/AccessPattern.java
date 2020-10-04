package hadad.commons.relationalschema;

public class AccessPattern implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pattern;
	public AccessPattern(String pat){
		if(pat==null){
			throw new IllegalArgumentException("Cannot have an empty access pattern");
		}
		for(int i=0;i<pat.length();i++){
			if(pat.charAt(i)!='i' && pat.charAt(i)!='o'){
				throw new IllegalArgumentException("An access pattern is a string from the alphabet {i,o}");
			}
		}
		this.pattern = pat;
	}
	
	public boolean isAccessible(int index){
		if(index<0 || index>pattern.length()){
			throw new IndexOutOfBoundsException();
		}
		if(pattern.charAt(index)=='i'){
			return false;
		}else{
			return true;
		}
	}
	
	@Override
	public int hashCode(){
		return 31*pattern.hashCode();
		
	}
	
	@Override
	public boolean equals(Object other){
		if(!(other instanceof AccessPattern))
			return false;
		AccessPattern o = (AccessPattern) other;
		
		return this.pattern.equals(o.pattern);
	}
	
	@Override
	public String toString(){
		return pattern;
	}
}
