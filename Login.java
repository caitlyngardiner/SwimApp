/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myswimapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


/**
 *
 * @author Caitlyn
 */
public class Login {
     public static String username;
     public static String password;
     public static Mainpage mp;
	
	public Login() {
            username = "";
            password = "";
            mp = new Mainpage(this);
	}
        String get_username(){
            return username;
        }
        String get_password(){
            return password;
        }
        
        void set_username(String u){
            username = u;
        }
        void set_password(String p){
            password= p;
        }
        
	void show_page(){
            mp.setVisible(true);
        }
	boolean get_login() throws IOException{
            System.out.println("HERE");
		boolean success = false;
		BufferedReader reader = new BufferedReader(new FileReader("src/myswimapp/users.txt"));
		String line;
		boolean check_username_exists = false;
		boolean check_password_correct = false;
		while((line = reader.readLine() )!= null){
			String [] user = line.split(",");
			String the_username = user[0];
			if(the_username.equals(username)){
				check_username_exists = true;
				if(user[1].equals(password)){
					check_password_correct = true;
				}
			}
		}
		if(check_username_exists == true){
			if(check_password_correct == true){
				System.out.println("You have logged in");
				success = true;
			}else{
				System.out.println("Password incorrect");
				success = true;
			}
		}else{
			System.out.println("Username does not exist");
                        return false;
                        
		}
		return success;
	}
	
	static void create_events_file() throws IOException {
            System.out.println(" I am here  "+username);
		String filename = "src/myswimapp/"+username+"/"+"events.txt";
		BufferedWriter bw = null;
		FileWriter fw = null;
		PrintWriter pw = null;
		fw = new FileWriter(filename);
		bw = new BufferedWriter(fw);
		pw = new PrintWriter(bw);
		ArrayList<Integer> dist = new ArrayList<Integer>();
		int num = 25;
		while (num<=200) {
			dist.add(num);
			num+=25;
		}
		num = 300;
		while (num<=1000) {
			dist.add(num);
			num+=100;
		}
		dist.add(1650);
		ArrayList<String> strokes = new ArrayList<String>();
		strokes.add("freestyle");
		strokes.add("backstroke");
		strokes.add("butterfly");
		strokes.add("breaststroke");
		strokes.add("IM");
	ArrayList<String> measure = new ArrayList<String>();
	measure.add("yard");
	measure.add("meter");
	int id = 1;
	for(int a = 0; a<dist.size(); a++) {
		for(int b = 0; b<measure.size(); b++) {
			for(int c = 0; c<strokes.size(); c++) {
				String entry = "";
				entry+=Integer.toString(id)+","+Integer.toString(dist.get(a))+","+measure.get(b)+","+strokes.get(c);
				pw.println(entry);
                                System.out.println(" I am printing to the file");
				pw.flush();
				id++;
			}
		}
	}
	pw.close();
	}
	
	@SuppressWarnings("resource") String create_account(String filename,HashMap<String,String>all_users,BufferedWriter bw,FileWriter fw,PrintWriter pw,String new_username, String new_password, String confirm_new_password) throws IOException{
			if(new_password.equals(confirm_new_password)){
				System.out.println("Success!");
                                BufferedReader reader = new BufferedReader(new FileReader("src/myswimapp/users.txt"));
			String line;
			while((line = reader.readLine() )!= null){
				String [] u = line.split(",");
				String the_username = u[0];
				String the_password = u[1];
				all_users.put(the_username, the_password);
			}
				all_users.put(new_username, new_password);
				
				fw = new FileWriter(filename);
				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw);
					Iterator<String> it = all_users.keySet().iterator();
					while(it.hasNext()){
						String u_name = it.next();
                                                System.out.println(u_name);
						String pass = all_users.get(u_name);
						String content = "";
						content+=u_name+","+pass;
						pw.println(content);		
				}
				pw.flush();
				pw.close();
				Path path = Paths.get("src/myswimapp");
				Files.createDirectories(path.getParent());
				boolean success = (new File("src/myswimapp/"+new_username)).mkdirs();
				if(success ==false) {
					System.out.println("It failed");
				}
				String meet_swims_file = "meet_swims.txt";
				String prac_swims_file = "prac_swims.txt";
				String meets_file = "meets.txt";
				String events_file = "events.txt";
				
				Path path5 = Paths.get("src/myswimapp/"+new_username+"/"+events_file);
                                Files.createFile(path5);
				create_events_file();
				
				Path path4 = Paths.get("src/myswimapp/"+new_username+"/"+meets_file);
					Files.createFile(path4);
				
				Path path3 = Paths.get("src/myswimapp/"+new_username+"/"+meet_swims_file);
					Files.createFile(path3);
				Path path2 = Paths.get("src/myswimapp/"+new_username+"/"+prac_swims_file);
					Files.createFile(path2);
				
				return new_username;
				
				
				
			}else{
				System.out.println("Incorrect confirmation of password");
				System.exit(0);
			}
	return("error");		
        
}
}
