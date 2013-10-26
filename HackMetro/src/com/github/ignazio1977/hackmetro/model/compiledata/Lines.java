//package com.github.ignazio1977.hackmetro.model.compiledata;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import com.github.ignazio1977.hackmetro.model.enums.Stops;
//import com.github.ignazio1977.hackmetro.model.lines.Route;
//import com.github.ignazio1977.hackmetro.model.lines.Routes;
//
//public class Lines {
//	private static List<String> getLines(String fileName,
//			Set<String> grep) throws Exception {
//		List<String> toReturn = new ArrayList<String>();
//
//		BufferedReader r = new BufferedReader(new InputStreamReader(
//				new FileInputStream(new File(fileName))));
//		String line = r.readLine();
//		while (line != null) {
//			String[] split=line.split(",");
//			
//			for (String s : split) {
//				if (grep.contains(s)) {
//					toReturn.add(line);
//					break;
//				}
//			}
//			line = r.readLine();
//		}
//		return toReturn;
//
//	}
//
//	public static void main(String[] args) throws Exception {
//		// get MET lines from trips
//		// get stop times from stop_times
//		// get days active from calendar.txt
//		// get exceptions from calendar_dates.txt
//		Routes routes = new Routes();
//		
//	
//		List<String> routeList = getLines("datafiles/trips.txt",
//				new HashSet<String>(Arrays.asList(	"MET:MET1:I:",
//						"MET:MET1:O:",
//						"MET:MET2:I:",
//						"MET:MET2:O:",
//						"MET:MET3:I:",
//						"MET:MET3:O:",
//						"MET:MET5:I:",
//						"MET:MET5:O:",
//						"MET:MET4:I:",
//						"MET:MET4:O:")));
//		for (String line : routeList) {
//			String[] split = line.split(",");
//			Route route = routes.get(split[0]);
//			if (route == null) {
//				route = new Route(split[0]);
//				routes.addRoute( route);
//			}
//			route.addService(split[1]);
//			route.addTrip(split[2], split[3]);
//			// route_id,service_id,trip_id,trip_headsign
//			// MET:MET1:I:,Serv000001,Trip000001,"Bury, Bury Interchange (Manchester Metrolink)"
//		}
////		Set<String> usedTrips = new HashSet<String>();
////		for (Route route : routes.getRoutes()) {
////			usedTrips.addAll(route.usedTrips());
////		}
////		List<String> triptimes = getLines("datafiles/stop_times.txt", usedTrips);
////		Set<String> usedStops=new HashSet<String>();
////	//	Map<String, Stop> stops=new HashMap<String, Stop>();
////		for (String s : triptimes) {
////			// trip_id,arrival_time,departure_time,stop_id,stop_sequence,pickup_type,drop_off_type
////			// Trip000001,05:37:00,05:37:00,9400ZZMAABM1,0001,0,1
////			String[] split=s.split(",");
////			Trip t=routes.getTrip(split[0]);
////			Stops withId = Stops.fromStopCode(split[3]);
////	//		stops.put(withId.getId(), withId);
////			t.addStopTime(withId, split[1]);
////			usedStops.add(split[3]);
////		}
//		
//
////		List<String> stopList = getLines("datafiles/stops.txt", usedStops);
////		for(String s:stopList) {
//////			stop_id,stop_code,stop_name,stop_lat,stop_lon,stop_url
//////			0600MA0001,chegptg,"Broken Cross, Fallibroome Road (cnr)",53.25954,-2.16171,http:
////			String[] split=s.split(",");
////			Stop stop=stops.get(split[0]);
////			int index=s.indexOf(",");
////			index=s.indexOf(",", index+1);
////			int end=s.indexOf("\",", index+1);
////			
////			stop.setName(s.substring(index+1, end+1));
////			split=s.substring(end+2).split(",");
////			stop.setLatitude(Double.parseDouble(split[0]));
////			stop.setLongitude(Double.parseDouble(split[1]));
////		}
//		
////		List<String> tripsExpressions=new ArrayList<String>();
////		Map<String, Integer> stopsExpressions=new HashMap<String, Integer>();
////		
////		for(Route route:routes.getRoutes()) {
////			for(Trip t:route.getTrips()) {
////				String stopsExpression=t.entrySTOPS();
////				int i=0;
////				if(stopsExpressions.containsKey(stopsExpression)) {
////					i=stopsExpressions.get(stopsExpression);
////									}
////				else {
////					stopsExpressions.put(stopsExpression, stopsExpressions.size());
////					i=stopsExpressions.get(stopsExpression);
////				}
////				tripsExpressions.add(t.entry(i));
////				
////			}
////			
////		}
////		for(Map.Entry<String, Integer> e:stopsExpressions.entrySet()) {
////			System.out.println("public static Stops[] STOPS"+e.getValue()+" = new Stops[]{ "+e.getKey()+"};");
////		}
////		for(String s:tripsExpressions) {
////			System.out.println(s);
////		}
//System.out.println(routes.toString());
////for(Stop stop:stops.values()) {
////	System.out.println(stop.entry());
////}
//
//	}
//}
