package com.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	static int count=0;
	List<MyFile>files =new ArrayList<>();
	public FileUtil() {
		File f=new File("e://java");
		String[] fs=f.list();
		for(String file:fs)
		{
			count++;
			files.add(new MyFile(count,file));
		}
	}
	public List<MyFile> getFiles()
	{
		File f=new File("e://java");
		String[] fs=f.list();
		for(String file:fs)
		{
			count++;
			files.add(new MyFile(count,file));
		}
		return files;
		
	}
	public boolean addFile(String filename) throws IOException
	{
		File f=new File("E://java//"+filename+".txt");
		return f.createNewFile();
	}
	
	public boolean deleteFile(String fileName) throws IOException
	{
		boolean isDeleted=false;
		boolean isfilefound=false;
		files=getFiles();
		for(MyFile file:files)
		{
			if(file.getFilename().startsWith(fileName))
			{
				isfilefound=true;
				File f=new File("E://java/"+file.getFilename());
				try
				{
					if(f.delete())
					{
						isDeleted=true;
						
					}	
				}
				catch (SecurityException e)
				{
					System.out.println("Exception called while deleting a file: \"" +e.getMessage() + "\"");
					break;
				}
			}			
		}
			if(!isfilefound)
			{
				System.out.println("File \"" + fileName + "\" not found");
			}
		return isDeleted;
	}
		public boolean search(String fileName)
		{
			boolean isIdentified=false;
			files=getFiles();
			for(MyFile file:files)
			{	
				if(file.getFilename().startsWith(fileName))
				{
					isIdentified=true;
					break;
				}
			}
			return isIdentified;
		}
}
