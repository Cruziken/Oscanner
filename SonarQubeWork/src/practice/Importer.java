package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Importer {
	//public void impToSq() {
	public static void main (String[] args){
		Variables myVari = new Variables();
		myVari.sonarVars();
		//myVari.fileVars("project");
		String commands = myVari.getStartCommand();
		String directory = myVari.getStartDirectory();
		//String commands = myVari.getSendCommand();
		//String directory = myVari.getFileSendDirectory();
		System.out.println(commands);
		// public void importIt(){
		// String filena= "CruzCaliber.txt";
		// AbsolutePather myAbsPather = new AbsolutePather();
		// if (filena!=null){
		// String abspath= myAbsPather.getAbsPath(filena);
		// System.out.println(abspath);
		//String dir = myAbsPather.getAbsPath(filena);
		 //Directory if you want to analyze a project must be C://...project
		System.out.println(directory);
		String[] command = { "CMD", "/C", commands };
		ProcessBuilder probuilder = new ProcessBuilder(command);
		probuilder.redirectErrorStream(true);
		// You can set up your work directory
		// How to get path from working directory
		probuilder.directory(new File(directory));
		Process process = null;
		try {
			process = probuilder.start();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		// Read out dir output
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		System.out.printf("Output of running %s is:\n", Arrays.toString(command));
		try {
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Wait to get exit value
		try {
			int exitValue = process.waitFor();
			System.out.println("\n\nExit Value is " + exitValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// }
		/*
		 * try { PrintWriter out = new PrintWriter("StartSonar.bat"); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace();
		 * */
		 }
}
