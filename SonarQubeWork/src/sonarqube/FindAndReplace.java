package ExcelRead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FindAndReplace {
	
	private static String author, mentor, college, major, title, abstracts,path = null;
	private static ToLaTeX mylu = null;
	public FindAndReplace(ToLaTeX myLua) {
		// TODO Auto-generated constructor stub
		mylu = myLua;
	}
	public String setAuthor(String auth) {
		author = auth;
		
		return author;
	}
	public String setMentor(String ment) {
		mentor = ment;
		return mentor;
	}
	public  String setCollege(String colleg) {
		college = colleg;
		return college;
	}
	public  String setMajor(String maj) {
		major = maj;
		return major;
	}
	public  String setTitle(String titles) {
		title = titles;
		return title;
	}
	public String setAbstracts(String abst) {
		abstracts = abst;
		return abstracts;
	}
	public void replaceVals(String directory) {
  

        {
         try
             {
             File file = new File("C://Users//b0c//Documents//Test.tex");
             BufferedReader reader = new BufferedReader(new FileReader(file));
             String line = "", oldtext = "";
             while((line = reader.readLine()) != null)
                 {
                 oldtext += line + "\r\n";
             }
             reader.close();
             String replacedtext  = oldtext.replaceAll("AUTHOR!!!", "" + author);
             replacedtext = replacedtext.replaceAll("TITLE!!!", "" + title);
             replacedtext = replacedtext.replaceAll("MENTOR!!!", "" + mentor);
             replacedtext = replacedtext.replaceAll("MAJOR!!!", "" + major);
             replacedtext = replacedtext.replaceAll("DEPARTMENT!!!", "" + college);
             replacedtext = replacedtext.replaceAll("ABSTRACT!!!", "" + abstracts);
             //replacedtext = replacedtext.replaceAll("%", "/%");
             author = author.replaceAll(" ", "_");
             
  
             path = directory + "//"+  author + ".tex";
             FileWriter writer = new FileWriter(path);
             writer.write(replacedtext);
             
             
             writer.close();
             mylu.setVars(directory, author);
             mylu.commandPrompt();
         }
         catch (IOException ioe)
             {
             ioe.printStackTrace();
         }
     }
	}
}
