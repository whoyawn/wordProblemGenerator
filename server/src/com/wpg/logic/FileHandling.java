package com.wpg.logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {
		
		public static void storeInTextFile(ArrayList<String> storeList, String fileName)
		{
			/* ********** Writhing in a file ********** */
			BufferedWriter out = null;
			try 
			{
				    FileWriter fstream = new FileWriter(fileName, false); //true tells to append data.
					out = new BufferedWriter(fstream);
					
					for(String s : storeList)
					{	
						//Please change the "\n" to any token that you are comfortable with.
						out.write(s + "\n");
					}
			} 
			catch (Exception e) 
			{
				System.out.println(e.toString());
			} 
			finally 
			{
				if (out != null)
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
