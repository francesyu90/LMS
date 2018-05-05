package com.francesyu90.lms;

/**
 */
public class App {
	
    public static void main(String[] args) {
    	getUserInput();
    }
    
    private static void getUserInput() {
    	
    	boolean next = false;
    	
    	do {
    		System.out.println("Menu:");
	        System.out.println("list: displays all libraries");
	        System.out.println("create: creates a library");
	        System.out.println("delete: deletes  a library");
	        System.out.println("quit: closes the app");
	        System.out.print("Command: ");
	        next = true;
    	} while(!next);
       
    }
}
