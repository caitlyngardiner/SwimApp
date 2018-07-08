/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myswimapp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *
 * @author Caitlyn
 */
public class PracSwim {
    private Event event;
	private String time;
	private String date;

	public PracSwim(Event e, String t,String d) {
		event = e;
		time = t;
		date = d;
	}
	
	public ArrayList<String> get_pracswims(String username) throws IOException{
		ArrayList<String> prac_swims = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader("src/Caitlyn/"+username+"/"+"prac_swims.txt"));
		String line;
		while((line = reader.readLine() )!= null){
			String [] swim = line.split(",");
			String content = swim[0]+","+swim[1]+","+swim[2];
			prac_swims.add(content);
			}
		return prac_swims;
	}
	
	public void add_pracswim(String username) throws IOException {
		ArrayList<String> prac_swims = get_pracswims(username);
		String new_pracswim = event.get_id()+","+time+","+date;
		prac_swims.add(new_pracswim);
		BufferedWriter bw = null;
		FileWriter fw = null;
		PrintWriter pw = null;
		fw = new FileWriter("src/Caitlyn/"+username+"/"+"prac_swims.txt");
		bw = new BufferedWriter(fw);
		pw = new PrintWriter(bw);
		for(int i = 0; i<prac_swims.size(); i++) {
			String v = prac_swims.get(i);
			pw.println(v);
			pw.flush();
		}
		pw.close();
		
	}
	

}
