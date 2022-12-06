package com.lockedme;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {
		FileUtil util=new FileUtil();
		int ch;
		Scanner sc =new Scanner(System.in);
		do {
			System.out.println("1.Create and add File");
			System.out.println("2.Delete File");
			System.out.println("3.Display the list of File");
			System.out.println("4.Search File");
			System.out.println("5.Exit");
			System.out.println("Enter the Choise:");
			ch=sc.nextInt();
			switch(ch) {
			case 1:
				String fileName;
				System.out.println("Enter the new filename");
				fileName=sc.next();
				try {
					if(util.addFile(fileName))
					{
						System.out.println("Successfully added a File: \"" + fileName + "\"");
					}
					else
					{
						System.out.println("File already Exist try to add the file with different name");
					}
				}
				catch(IOException e) {
					System.out.println("IOException caught while adding a file: \""  + e.getMessage() + "\"");
				}
				catch(Exception e)
				{
					System.out.println("Unknown exception caught while adding a file: \""  + e.getMessage() + "\"");
				}
				
				break;
			case 2:
				String fileName1;
				System.out.println("Enter the filename");
				fileName1=sc.next();
				try
				{
					if(util.deleteFile(fileName1))
					{
						System.out.println("File successfuly deleted: \"" + fileName1 + "\"");
					}
					else
					{
						System.out.println("File is not delete");
					}
				}
				catch (IOException e)

				{
					System.out.println("IOException caught while deleting a file: \"" + e.getMessage() + "\"");
					break;
				}
				
				catch (Exception e)
				{
					System.out.println("Unknown exception while deleting a file: \"" + e.getMessage() + "\"");
					break;
				}
				
				break;
			case 3:
				List<MyFile>files=util.getFiles();
				for(MyFile f:files)
					System.out.println(f.getId() + "\t" + f.getFilename());
				break;
			case 4:
				String fileName2;
				System.out.println("Enter the filename");
				fileName2=sc.next();
				if(util.search(fileName2))
					System.out.println("File is Existed:\"" + fileName2 + "\"");
				else
					System.out.println("File not Existed:\"" + fileName2 + "\"");
				break;
			}
		}
			while(ch < 5);
	}

}
