package ExcelRead;

public class ReplaceIt {
	private static String abstracts = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(abstracts);
		StringBuilder replacers = new StringBuilder().append("\\").append("\"");
		StringBuilder quotes = new StringBuilder().append("\"");
		System.out.println(quotes);
		StringBuilder replaced = new StringBuilder().append("\\").append("%");
		System.out.println(quotes);
		System.out.println(replacers);
		System.out.println(replaced);
		String sum = "Skill"+ replacers + "s";
		System.out.println(sum);
		//abstracts = abstracts.replace('"', (char) ('\\' + '\"'));
		//abstracts = abstracts.replace("%", replaced);
		System.out.println(abstracts);
	}

}
