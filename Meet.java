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
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Caitlyn
 */
public class Meet {
    private String meet_name;
private String datestart;
private String dateend;
private String pool;
private boolean champs;
private int days;
private String id;

public Meet() {
	meet_name = null;
	datestart = null;
	dateend = null;
	pool = null;
	champs = false;
	days = 0;
	id = null;
}

public Meet(String my_meet_name, String my_date1,String my_date2, String my_pool, boolean my_champs, int my_days) {
	meet_name = my_meet_name;
	datestart = my_date1;
	dateend = my_date2;
	pool = my_pool;
	champs = my_champs;
	days = my_days;
	id = my_meet_name+my_date1;
}

public String get_id() {
	return id;
}

public void add_meet(String username) throws IOException {
	BufferedReader reader = new BufferedReader(new FileReader("src/myswimapp/"+username+"/"+"meets.txt"));
	String line;
	HashMap<String,String> my_meets = new HashMap<String,String>();
	while((line = reader.readLine() )!= null){
		String [] meet = line.split(",");
		String content = meet[0]+","+meet[1]+","+meet[2]+","+meet[3]+","+meet[4]+","+meet[5]+","+meet[6];
		my_meets.put(meet[0], content);
		}
	String new_meet = id+","+meet_name+","+datestart+","+dateend+","+pool+","+champs+","+days;
	my_meets.put(id,new_meet);
	Iterator<String> it = my_meets.keySet().iterator();
	BufferedWriter bw = null;
	FileWriter fw = null;
	PrintWriter pw = null;
	fw = new FileWriter("src/myswimapp/"+username+"/"+"meets.txt");
	bw = new BufferedWriter(fw);
	pw = new PrintWriter(bw);
	while(it.hasNext()){
		String k = it.next();
		String v = my_meets.get(k);
		pw.println(v);
		pw.flush();
	}
	pw.close();
	
	
	
}

public HashMap<String,Meet> get_meets(String username) throws IOException {
	BufferedReader reader = new BufferedReader(new FileReader("src/myswimapp/"+username+"/"+"meets.txt"));
	String line;
	HashMap<String,Meet> my_meets = new HashMap<String,Meet>();
	while((line = reader.readLine() )!= null){
		String [] meet = line.split(",");
		//String content = meet[0]+","+meet[1]+","+meet[2]+","+meet[3]+meet[4]+","+meet[5]+","+meet[6];
		boolean x = false;
		if(meet[4] == "true") {
			x = true;
		}
		Meet m1 = new Meet(meet[1],meet[3],meet[4],meet[5],x,Integer.parseInt(meet[6]));
		my_meets.put(meet[0], m1);
		}
	return my_meets;
}
}
