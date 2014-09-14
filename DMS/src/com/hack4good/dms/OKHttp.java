package com.hack4good.dms;

import java.util.ArrayList;
import java.util.HashMap;



public class OKHttp {
final static String ipAddress ="192.168.137.254";
final static int port = 8084;
final static String app = "Geekli";
	public static ArrayList<String> getNamesFromDateAndName(String date,String name) {
		
		String url ="http://"+ipAddress+":"+port+"/"+app+"/peopleSearch?PersonName="+name+"&Age="+Integer.parseInt(date.equals("")?"0":date);
		ArrayList<String> list = new ArrayList<>();
		String response = null;
		try {
			response = CustomHttpClient.executeHttpGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] split = response.split("#");
		for(int i=0;i<split.length-1;i++)
		{
			System.out.println("->"+split[i]+" .. "+split.length);
			if(!split[i].split(":")[2].trim().equals(""))
			list.add(split[i].split(":")[2].trim());
		}
		return list;
	}

	public static ArrayList<String> getIdsFromDateAndName(String date,String name, ArrayList<String> results) {

		String url ="http://"+ipAddress+":"+port+"/"+app+"/peopleSearch?PersonName="+name+"&Age="+Integer.parseInt(date.equals("")?"0":date);
		ArrayList<String> list = new ArrayList<>();
		String response = null;
		try {
			response = CustomHttpClient.executeHttpGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] split = response.split("#");
		for(int i=0;i<split.length-1;i++)
		{
			System.out.println("->"+split[i]+" .. "+split.length);
			if(!split[i].split(":")[0].trim().equals(""))
			list.add(split[i].split(":")[0].trim());
		}
		return list;
	}

	public static ArrayList<String> getNamesFromName(String name) {

		String url ="http://"+ipAddress+":"+port+"/"+app+"/peopleSearch?PersonName="+name+"&Age="+Integer.parseInt("0");
		ArrayList<String> list = new ArrayList<>();
		String response = null;
		try {
			response = CustomHttpClient.executeHttpGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] split = response.split("#");
		for(int i=0;i<split.length-1;i++)
		{
			System.out.println("->"+split[i]+" .. "+split.length);
			if(!split[i].split(":")[2].trim().equals(""))
			list.add(split[i].split(":")[2].trim());
		}
		return list;
	}

	public static ArrayList<String> getIdsFromName(String name,
			ArrayList<String> results) {

		String url ="http://"+ipAddress+":"+port+"/"+app+"/peopleSearch?PersonName="+name+"&Age="+Integer.parseInt("0");
		ArrayList<String> list = new ArrayList<>();
		String response = null;
		try {
			response = CustomHttpClient.executeHttpGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] split = response.split("#");
		for(int i=0;i<split.length-1;i++)
		{
			System.out.println("->"+split[i]+" .. "+split.length);
			if(!split[i].split(":")[0].trim().equals(""))
			list.add(split[i].split(":")[0].trim());
		}
		return list;
	}

	public static boolean login(String username, String password) {
		String url = "http://"+ipAddress+":"+port+"/"+app+"/MobileLogin?username="+username+"&pwd="+password;
		String response = null;
		try {
			response = CustomHttpClient.executeHttpGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Integer.parseInt(response.trim())==1;
	}

	public static void submitReliefCampDetails(String disaster_name,
			String volunteers_Requirement, String food, String water,
			String medical, String relief_Camp_Address, String relief_camp_ph) {
		String urlEnd="/RcampDetails?disaster_Name=xxxx&relief_Camp_ID=xxxx&relief_Ph=xxxx&relief_addrs=xxxx&volunteers_Req=xxxx&total_foodpacks_Required=xxxx&medicalKits_required=xxxx";
		String url = "http://"+ipAddress+":"+port+"/"+app+urlEnd;
	}

	public static void submitSurvivalInfo(String disaster_name,
			String person_Name, String age, String sex,
			String rescued_Location, String current_Location,
			String contact_number) {
String url ="http://"+ipAddress+":"+port+"/"+app+"/survivorDetails?disaster_name="+disaster_name+"&survivor_name="+person_Name+"&age="+age+"&sex="+sex+"&rescued_location="+rescued_Location+"&tel="+contact_number;
try {
	String response = CustomHttpClient.executeHttpGet(url);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

	public static void submitDeathDetails(String disaster_name,
			String person_Name, String age, String sex,
			String rescued_Location, String current_Location,
			String contact_number) {
		String url ="http://"+ipAddress+":"+port+"/"+app+"/deadDetails?disaster_name="+disaster_name+"&survivor_name="+person_Name+"&age="+age+"&sex="+sex+"&rescued_location="+rescued_Location+"&tel="+contact_number;
		try {
			String response = CustomHttpClient.executeHttpGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	
	public static ArrayList<String> getDisasters() {
		
		String	url = "http://"+ipAddress+":"+port+"/"+app+"/DisplayAllDisasters";
		
		String response = null;
		try {
			response = CustomHttpClient.executeHttpGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] split = response.split(":");
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<split.length;i++)
		{
			System.out.println("->"+split[i]+" .. "+split.length);
			if(!split[i].trim().equals(""))
			list.add(split[i].trim());
		}
		return list;
	}

	public static void uploadPhoto() {
		// TODO Auto-generated method stub
		
	}

	public static HashMap<String, String> getPerson(String pname, String pid) {
		String url ="http://"+ipAddress+":"+port+"/"+app+"/peopleSearch?PersonName="+pname+"&Age="+Integer.parseInt("0");
		HashMap<String, String> map = new HashMap<>();
String response = null;
		try {
			response = CustomHttpClient.executeHttpGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] split = response.split("#");
		for(int i=0;i<split.length-1;i++)
		{
			System.out.println("->"+split[i]+" .. "+split.length);
			if(!split[i].split(":")[2].trim().equals(""))
			{
				if(split[i].split(":")[0].trim().equals(pid))
				{
					map.put("name", split[i].split(":")[2].trim());
					map.put("clocation", split[i].split(":")[6].trim());
					map.put("contact", split[i].split(":")[7].trim());
				}
			}
		}
		return map;
	}

}
