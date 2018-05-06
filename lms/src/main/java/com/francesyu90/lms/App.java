package com.francesyu90.lms;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.DataSource;

import com.francesyu90.lms.configuration.DBConfig;
import com.francesyu90.lms.configuration.PicoConfig;
import com.francesyu90.lms.repository.impl.BookRepository;
import com.francesyu90.lms.repository.impl.LibraryRepository;
import com.francesyu90.lms.service.IGeneralService;
import com.francesyu90.lms.service.impl.GeneralService;

/**
 */
public class App {
	
    public static void main(String[] args) throws SQLException {
    	
    	Scanner scanner = new Scanner(System.in);
    	IGeneralService generalService = getGeneralService();
    	
    	do {
    	
			 String cmd = getUserInput(scanner);
			 performTask(cmd, generalService);
    		
    	} while(true);
    	
    }
    
    private static void performTask(
    		String op, IGeneralService generalService) throws SQLException {
    	
    	switch(op) {
	    	case "list": 
	    		generalService.listLibraries();
	    		break;
	    	case "create": 
	    		generalService.addLibrary();
	    		break;
	    	case "delete": 
	    		generalService.removeLibraryById();
	    		break;
	    	case "quit": 
	    		System.out.println("Bye!");
	    		System.exit(0);
	    	default: 
	    		System.out.println("Unknown command");
	    		break;
    	}
    }
    
    private static IGeneralService getGeneralService() throws SQLException {
    	DataSource dataSource = DBConfig.setUpPool();
		PicoConfig pico = new PicoConfig();
		pico.addPicoComponent(new LibraryRepository(dataSource));
		pico.addPicoComponent(new BookRepository(dataSource));
		pico.addPicoComponent(GeneralService.class);
		return (IGeneralService) pico.getPicoComponent(GeneralService.class);
    }
    
    private static String getUserInput(Scanner scanner) {
    	
		System.out.println("Menu:");
        System.out.println("list: displays all libraries");
        System.out.println("create: creates a library");
        System.out.println("delete: deletes  a library");
        System.out.println("quit: closes the app");
        System.out.print("Command: ");
        
        return scanner.nextLine();
    }
    
}
