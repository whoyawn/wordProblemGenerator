package com.wpg.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {
		
		public static void storeInTextFile(ArrayList<String> storeList, String fileName)
		{
			/* ********** Writhing in a file ********** */
			
			PrintWriter out = null;
			try 
			{
					out = new PrintWriter(fileName);
					
					for(String s : storeList)
					{	
						//Please change the "\n" to any token that you are comfortable with.
						out.format(s + "\n");
					}
			} 
			catch (Exception e) 
			{
				System.out.println(e.toString());
			} 
			finally 
			{
				if (out != null) 
					out.close();
			}
		}
		
		public static ArrayList<String> readFromFile(String fileName)
		{
			
			Scanner inFile = null;
			
			try 
			{
				inFile = new Scanner(new File(fileName));
			} 
			catch (FileNotFoundException e) 
			{
						System.out.println(e);
			}
			
			ArrayList<String> list = new ArrayList<String>();
			
			// Get the entire line one-at-a-time
			while (inFile.hasNextLine()) 
			{
				list.add(inFile.nextLine());
			}
			
			if (inFile != null)
				inFile.close();
			
			return list;
			
		}

		
		


}
