package fileio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CountriesTextFileApp {
	 static Scanner scnr = new Scanner(System.in);
		
	static Path filePath = Paths.get("Countries.txt");
	public static <population> void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		
		if (Files.notExists(filePath) ) {
			Files.createFile(filePath);
		}
		
		
		List<String> cl = Arrays.asList("India:1339",
				"Canada:36.71",
				"USA:309.3",
				"Australia:24.6");
		
		Files.write(filePath, cl, StandardOpenOption.TRUNCATE_EXISTING);
		System.out.println("Welcome to the countries Maintenance App");
		System.out.println("1- See list of countries\n2-Add a country\n3-Alphabetical order\n4-Highest to lowest Population in millions\n5-Exit");
		
		int choice = scnr.nextInt();
		switch(choice)
		{
			case 1 :
				System.out.println(readFile()); break;
				
			case 2:
				System.out.println("Which country  do you want to add?");
			    String country = scnr.next();
			    System.out.println("Enter population in millions");
			    double population=scnr.nextDouble();
			    String s1= country+ " "+population;
			     appendToFile(s1);
			     System.out.println("This country have been saved : "+country);
			     System.out.println( readFile() );
			     break;
				
			case 5:
				System.out.println("Buh-bye!");
				System.exit(0);
			case 3:
				System.out.println("Alphabetical order");
				Listalpha();
				break;
			case 4:
				System.out.println("Population from highest to lowest in millions ");
				Listpopulation();
				break;
				
		}
		    
		
		scnr.close();
	}
	public static List<String>Listpopulation() throws IOException
	{
		List<String>population = new ArrayList<>();
		String[] country;
		List<String> alpha = Files.readAllLines(filePath);
		for(String Items : alpha)
		{
			country =Items.split(":");
			population.add(country[1].substring(0));
			
			//System.out.println(country[0].substring(0)+ "\t"+ country[1].substring(0));		
		}
		Collections.sort(population);
		System.out.println(population);
		
				return alpha;
	}
	private static List<String> Listalpha() throws IOException
	{
		List<String>ol = new ArrayList<>();
		String[] country;
		List<String> alpha = Files.readAllLines(filePath);
		for(String Items : alpha)
		{
			country =Items.split(":");
			ol.add(country[0].substring(0));
			
			//System.out.println(country[0].substring(0)+ "\t"+ country[1].substring(0));		
		}
		Collections.sort(ol);
		System.out.println(ol);
		
		
		return alpha;
	}
	
	private static List<String> readFile() {
		
		try {
			List<String> lines = Files.readAllLines(filePath);
			return lines;
		} catch (FileNotFoundException ex) {
			return new ArrayList<>();
		} catch (IOException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}
	private static void appendToFile(String item) throws IOException {
		if ( Files.notExists(filePath) ) {
			Files.createFile(filePath);
		}
		
		
		List<String> linesToAdd = Arrays.asList(item);
		Files.write(filePath, linesToAdd, StandardOpenOption.APPEND);
    }

}