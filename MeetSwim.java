/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myswimapp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Caitlyn
 */
public class MeetSwim {
    private Event event;
	private Meet meet;
	private String time;
	boolean finals;
	
	public MeetSwim(Event e, Meet m, String t,boolean b) {
		event = e;
		meet = m;
		time = t;
		finals = b;
	}
	
	public ArrayList<String> get_meetswims(String username) throws IOException{
		ArrayList<String> meet_swims = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader("src/Caitlyn/"+username+"/"+"meet_swims.txt"));
		String line;
		while((line = reader.readLine() )!= null){
			String [] swim = line.split(",");
			String content = swim[0]+","+swim[1]+","+swim[2]+","+swim[3];
			meet_swims.add(content);
			}
		return meet_swims;
	}
	
public void add_meetswim(String username) throws IOException {
		ArrayList<String> meet_swims = get_meetswims(username);
		String new_meetswim = event.get_id()+","+meet.get_id()+","+time+","+finals;
		meet_swims.add(new_meetswim);
		BufferedWriter bw = null;
		FileWriter fw = null;
		PrintWriter pw = null;
		fw = new FileWriter("src/Caitlyn/"+username+"/"+"meet_swims.txt");
		bw = new BufferedWriter(fw);
		pw = new PrintWriter(bw);
		for(int i = 0; i<meet_swims.size(); i++) {
			String v = meet_swims.get(i);
			pw.println(v);
			pw.flush();
		}
		pw.close();
		
	}
}
