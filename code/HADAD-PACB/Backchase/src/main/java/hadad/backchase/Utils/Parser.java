package hadad.backchase.Utils;
import java.util.ArrayList;

public class Parser 
{
	private ArrayList<ArrayList<String>> m_relationals;
	private ArrayList<String[]> m_equalities;
	int m_pos;
	
	public Parser()
	{
		m_relationals = new ArrayList<ArrayList<String>>();
		m_equalities = new ArrayList<String[]>();
		m_pos=0;
	}
	
	public void flush()
	{
		m_pos = 0;
		m_relationals.clear();
		m_equalities.clear();
	}
	
	public boolean charIsValidForRelation(char c)
	{
		return ((c>='A' && c<='Z') || 
			    (c>='0' && c<='9') ||
			    (c>='a' && c<='z') ||
			    (c=='_'));
	}
	
	public boolean charIsValidForTerm(char c)
	{
		return ((c>='a' && c<='z') || 
				(c>='A' && c<='Z') ||
			    (c>='0' && c<='9') ||
			    (c=='_') ||
			    (c=='$') ||
			    (c=='.') );
	}
	
	public ArrayList<String> parseAtom(String line)
	{
		//System.out.println("LINEATOM"+line);
		ArrayList<String> list = new ArrayList<String>();
		String relation="";
		while (m_pos<line.length())
		{
			if (charIsValidForRelation(line.charAt(m_pos)))
			{
				relation+=line.charAt(m_pos);
				m_pos++;
			}
			else if (line.charAt(m_pos)=='(')
			{
				m_pos++;
				list.add(relation);
				//System.out.println("RELATION"+relation);
				parseTerms(line, list);
				return list;
			}
			else
			{
				m_pos++;
			}
		}
		return null;
	}
	
	public void parseTerms(String line, ArrayList<String> list)
	{
		while (m_pos<line.length())
		{
			if (line.charAt(m_pos) == ')')
			{
				m_pos++;
				return;
			}
			else if (!charIsValidForTerm(line.charAt(m_pos)))
				m_pos++;
			else 
			{
				String term=parseSingleTerm(line);
				list.add(term);
			}
		}
	}
	
	public String parseSingleTerm(String line)
	{
		String term="";
		while (m_pos<line.length() && charIsValidForTerm(line.charAt(m_pos)))
		{
			term+=line.charAt(m_pos);
			m_pos++;
		}
		return term;
	}
	
	public void parseRelationals(String line)
	{
		m_pos = 0;
		while (m_pos<line.length())
		{
			if ((line.charAt(m_pos)<'A' || line.charAt(m_pos)>'Z') && (line.charAt(m_pos)<'a' || line.charAt(m_pos)>'z')) 
				m_pos++;
			else 
			{
				ArrayList<String> relStr = parseAtom(line);
				m_relationals.add(relStr);
			}
		}
	}
	
	public void parseEqualities(String line)
	{
		m_pos = 0;
		while (m_pos<line.length())
		{
			if (!charIsValidForTerm(line.charAt(m_pos)))
				m_pos++;
			else parseEquality(line);
		}
	}
	
	public void parseEquality(String line)
	{
		String[] terms=new String[2];
		terms[0] = parseSingleTerm(line);
		
		while (m_pos<line.length() && !charIsValidForTerm(line.charAt(m_pos)))
				m_pos++;
		
		terms[1] = parseSingleTerm(line);
		m_equalities.add(terms);
	}
	
	public ArrayList<String[]> getEqualities()
	{
		return m_equalities;
	}
	
	public ArrayList<ArrayList<String>> getRelationals()
	{
		return m_relationals;
	}
	
	public ArrayList<String> parseProvenance(String line)
	{
		ArrayList<String> provList = new ArrayList<String>();
		while (m_pos < line.length())
		{
			while (!charIsValidForTerm(line.charAt(m_pos)))
				m_pos++;
			String term = parseSingleTerm(line);
			if (!(term.equals("")))
			{
				provList.add(term);
			}
		}
		return provList;
	}
}
