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
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Caitlyn
 */
public class Event {
    private String id;
private int dist;
private String meas;
private String stroke;


public Event() {
	String id;
	dist = 0;
	meas = null;
	stroke = null;
}

public Event(String id1,int dist1, String meas1, String stroke1) {
	id = id1;
	dist = dist1;
	meas = meas1;
	stroke = stroke1;
}
public HashMap<String,Event> get_events(String username) throws IOException {
	BufferedReader reader = new BufferedReader(new FileReader("src/Caitlyn/"+username+"/"+"events.txt"));
	String line;
	HashMap<String,Event> my_events = new HashMap<String,Event>();
	while((line = reader.readLine() )!= null){
		String [] event = line.split(",");
		//String content = event[0]+","+event[1]+","+event[2]+","+event[3];
		Event e1 = new Event(event[0],Integer.parseInt(event[1]),event[2],event[3]);
		my_events.put(event[0], e1);
		}
	return my_events;
}

public String get_id() {
	return((id));
}

public String get_string() {
	return dist+","+meas+","+stroke;
}



	
}
