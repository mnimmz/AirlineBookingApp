package pbia;

import java.io.*;
import java.util.Scanner;

public class BookFlight {
	
//	Create user account variables
	private String firstname;
	private String lastname;
	private String emailaddress;
	private String yourusername;
	private String dateofbirth;
	private long phonenumber;
	private String userpassword;
	private int passAge;
	
	
//	Booking tickets variables
	private String to;
	private String from;
	private String onway;
	private String roundtrip;
	
	
//	Flight availability variables
	private static String trip;
	
//	private String storeFlightNumber;
	private String storeFlightNumberToRT;
//	private String storeFlightNumberReturnRT;
	private int roundtrippart2;
	
	
	private String ticketnumber;
	
	
	//	One way
	String [] onewayfromtime = new String[3];
	String [] onewaytotime = new String[3];
	String [] onewayflightname = new String[3];
	String [] fromcity = new String[3];
	String [] tocity = new String[3];
	String [] onewayprice = new String[3];
	int onewayflag = -1;
	int destinationflag = -1;
	
	
	//	Round trip
		//		To destination
	String [] roundtripflightname = new String[3];
	String [] roundtripfromtime = new String[3];
	String [] roundtriptotime = new String[3];
	String [] rountriptocity = new String[3];
	String [] rountripfromcity = new String[3];
	String [] roundtriptoprice = new String[3];
	int roundtripflag = -1;
	
		//	Home/From destination
	String [] roundtripflightnameHome = new String[3];
	String [] roundtripfromtimeHome = new String[3];
	String [] roundtriptotimeHome = new String[3];
	String [] rountriptocityHome = new String[3];
	String [] rountripfromcityHome = new String[3];
	String [] roundtripfrompriceHome = new String[3];
	String [] totalroundtripprice = new String[3];
	int roundtripflag2 = -1;
	

	

	public static void main(String[] args) {
		
		
		
		System.out.println("Palm Beach International Airport");
		System.out.println(" ");
		
		BookFlight PBIAFlights = new BookFlight();
		
		PBIAFlights.createUserAccount();
		
		PBIAFlights.bookflight();
		
		PBIAFlights.flightOneWay();
		
		PBIAFlights.flightRoundTripTo();
		PBIAFlights.flightRoundTripToHome();

		PBIAFlights.flightdetails();
		
		PBIAFlights.itinerary();
		
		System.out.println(" ");
		System.out.println(" ");
		
		
		//	File writer object
		

		
	}
	
	
	
//	User Account
	public void createUserAccount(){
		
		System.out.println("Create user account");
		System.out.println(" ");
		Scanner pbia = new Scanner(System.in);
		System.out.print("Enter first name: ");
		String fname = pbia.next();
		
		firstname = fname;
		
		System.out.println(" ");
		System.out.print("Enter last name: ");
		String lname = pbia.next();
		
		lastname = lname;
		
		//		email
		System.out.println(" ");
		System.out.print("Enter email address: ");
		String email = pbia.next();
		
		emailaddress = email;
		
		if (email.contains("@")){
			System.out.println("**Email is valid.**");
		}
		
		else {
			System.out.println("**Email is invalid.**");
		}
		
		
		System.out.println(" ");
		System.out.print("Enter your date of birth (format: 00/00/0000): ");
		String dob = pbia.next();
		
		dateofbirth = dob;
		
		System.out.println(" ");
		System.out.print("Enter phone number (without parenthesis or dashes): ");
		long number = pbia.nextLong();
		
		phonenumber = number;
		
		
		//		username & password
		System.out.println(" ");
		System.out.print("Create a username (should be a maximum of 10 characters and start with a 'U'): ");
		String username = pbia.next();
		
		yourusername = username;
		
		
		if (username.length() > 10){
			System.out.println("Username should be 10 characters or less.");
		}
				
		System.out.println(" ");
		System.out.print("Create a password (should be a maximum of 10 characters): ");
		String password = pbia.next();
		
		if (password.length() > 10){
			System.out.println("Password should be less than 10 characters: ");
		}
		
		if (username.startsWith("U")){
			System.out.println("*Your account has been created*");
		}
		
		else {
			System.out.println("Create a username that starts with 'U':");
		}
	}
	
	
//	Book flight
	public void bookflight(){ 
		System.out.println(" ");
		Scanner pbia = new Scanner(System.in);
		System.out.print("Please enter where you're flying TO (Philadelphia, Detroit, or Atlanta): ");
		String todestination = pbia.next();
		
		to = todestination;
		
		String [] toArray = {"Philadelphia", "Detroit", "Atlanta"};
		
		for (int t = 0; t < toArray.length; t++){
			fromcity[t] = toArray[t];
			destinationflag++;
			if(todestination.equals(toArray[t])){
				
				System.out.println("*valid destination*");
				break;
			}
			
			else{
				
			}
			
		}
		
		System.out.println(" ");
		System.out.print("Enter where you're flying FROM (NewYork, Miami, or Chicago): ");
		String fromdestination = pbia.next();
		
		from = fromdestination;
		
		String [] fromArray = {"NewYork", "Miami", "Chicago"};
		
		for (int f = 0; f < fromArray.length; f++){
			tocity[f] = toArray[f];
			destinationflag++;
			if(fromdestination.equals(fromArray[f])){
				System.out.println("*valid destination*");
				break;
			}
			
			else{
				
			}
			
		}
		
		System.out.println(" ");
		System.out.println("Enter trip type (oneway or roundtrip): ");
		String triptype = pbia.next();
		
		trip = triptype;
		
		//		Destination exceptions
		try{
			if (!triptype.equalsIgnoreCase("one way") || (!triptype.equalsIgnoreCase("oneway")) || (!triptype.equalsIgnoreCase("roundtrip")) || (!triptype.equalsIgnoreCase("round trip"))){
				
			}
		}
		catch(StringIndexOutOfBoundsException e){
			System.out.println("Please, enter either one way or roundtrip for trip type.");
		}
		
		try{
			if (!triptype.equalsIgnoreCase("round trip") || (!triptype.equalsIgnoreCase("roundtrip")) || (!triptype.equalsIgnoreCase("roundtrip")) || (!triptype.equalsIgnoreCase("round trip"))){
				
			}
		}
		catch(StringIndexOutOfBoundsException e){
			System.out.println("Please, enter either one way or roundtrip for trip type.");
		}
		
		System.out.println(" ");
		System.out.print("Enter the number of passengers: ");
		int passengers = pbia.nextInt();
		
		
		//		Passengers array & exception
		int [] passengerarray = new int [6];
		
		try{
			System.out.println(passengerarray[passengers]);
		}
		
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("We cannot seat more than 5 passengers.");
		}
		
		
		//		Age
		if(passengers == 1){
			System.out.println(" ");
			System.out.print("Enter your age: ");
			int age1 = pbia.nextInt();
		}
		
		else if (passengers == 2){
			System.out.println(" ");
			System.out.print("Enter first passenger's age: ");
			int age2First = pbia.nextInt();
			
			System.out.println(" ");
			System.out.print("Enter second passenger's age: ");
			int age2Second = pbia.nextInt();

		}
		
		else if (passengers == 3){
			System.out.println(" ");
			System.out.print("Enter first passenger's age: ");
			int age3First = pbia.nextInt();
			
			System.out.println(" ");
			System.out.print("Enter second passenger's age: ");
			int age3Second = pbia.nextInt();
			
			System.out.println(" ");
			System.out.print("Enter third passenger's age: ");
			int age3Third = pbia.nextInt();

		}
		
		else if (passengers == 4){
			System.out.println(" ");
			System.out.print("Enter first passenger's age: ");
			int age4First = pbia.nextInt();
			
			System.out.println(" ");
			System.out.print("Enter second passenger's age: ");
			int age4Second = pbia.nextInt();
			
			System.out.println(" ");
			System.out.print("Enter third passenger's age: ");
			int age4Third = pbia.nextInt();
			
			System.out.println(" ");
			System.out.print("Enter fourth passenger's age: ");
			int age4Fourth = pbia.nextInt();
		}
		
		else if (passengers == 5){
			System.out.println(" ");
			System.out.print("Enter first passenger's age: ");
			int age5First = pbia.nextInt();
			
			System.out.println(" ");
			System.out.print("Enter second passenger's age: ");
			int age5Second = pbia.nextInt();
			
			System.out.println(" ");
			System.out.print("Enter third passenger's age: ");
			int age5Third = pbia.nextInt();
			
			System.out.println(" ");
			System.out.print("Enter fourth passenger's age: ");
			int age5Fourth = pbia.nextInt();
			
			System.out.println(" ");
			System.out.print("Enter fifth passenger's age: ");
			int age5Fifth = pbia.nextInt();
		}
	}
	
//Flight availability
	
	public void flightOneWay(){
		System.out.println(" ");
		Scanner pbia = new Scanner(System.in);
		
		if ((trip.equalsIgnoreCase("one way") || (trip.equalsIgnoreCase("oneway")))){
			
			String [] fromTime = {"10:00AM", "2:00PM", "5:00PM"};
			String [] toTime = {"12:00AM", "4:00PM", "6:20PM"};
			String [] flightName = {"US Airways", "American Airlines", "Southwest Airlines"};
			String [] flightLength = {"2HRS", "2HRS", "1HR 20MINS"};
			String [] price = {"$300", "$430", "$100"};
			String [] flightNumber = {"101", "105", "150"};
			
				for(int i = 0; i < fromTime.length; i++){
					System.out.println("Available FROM time: ");
					System.out.println(fromTime[i]);
					System.out.println(" ");
					System.out.println("Available TO times: ");
					System.out.println(toTime[i]);
					System.out.println(" ");
					System.out.println("Available flights: ");
					System.out.println(flightName[i]);
					System.out.println(" ");
					System.out.println("Flight Duration: ");
					System.out.println(flightLength[i]);
					System.out.println(" ");
					System.out.println("Price: ");
					System.out.println(price[i]);
					System.out.println(" ");
					System.out.println("Flight Number: ");
					System.out.println(flightNumber[i]);
					System.out.println(" ");
					
					onewayfromtime[i] = fromTime[i];
					onewaytotime[i] = toTime[i];
					onewayflightname[i] = flightName[i];
					onewayprice[i] = price[i];
			}

			
			System.out.println(" ");
			System.out.println("Please enter flight number that you want to take:");
			String flightnumberOW = pbia.next();
			

			
			
			for (int o = 0; o < flightNumber.length; o++){
				onewayflag++;
				
				System.out.println(flightNumber[o]);
				if(flightnumberOW.equals(flightNumber[o])){
					System.out.println("*Flight Booked*");
					
					break;
				}
				
				else{
					
				}
			}
		}
	}
	
	public void flightRoundTripTo(){
		
		System.out.println(" ");
		Scanner pbia = new Scanner(System.in);
		
		if ((trip.equalsIgnoreCase("round trip") || (trip.equalsIgnoreCase("roundtrip")))){
			
//			Departure to destination
			String [] fromTime = {"9:00AM", "12:00PM", "5:00PM"};
			String [] toTime = {"11:00AM", "3:00PM", "6:20PM"};
			String [] flightName = {"US Airways", "American Airlines", "Southwest Airlines"};
			String [] flightLength = {"2HRS", "3HRS", "1HR 20MINS"};
			String [] price = {"$300", "$430", "$100"};
			String [] flightNumber = {"201", "205", "250"};
			
			for(int i = 0; i < fromTime.length; i++){
			
				System.out.println("Available FROM time: ");
				System.out.println(fromTime[i]);
				System.out.println(" ");
				System.out.println("Available TO times: ");
				System.out.println(toTime[i]);
				System.out.println(" ");
				System.out.println("Available flights: ");
				System.out.println(flightName[i]);
				System.out.println(" ");
				System.out.println("Flight Duration: ");
				System.out.println(flightLength[i]);
				System.out.println(" ");
				System.out.println("Price: ");
				System.out.println(price[i]);
				System.out.println(" ");
				System.out.println("Flight Number: ");
				System.out.println(flightNumber[i]);
				System.out.println(" ");
				
				roundtripflightname[i] = flightName[i];
				roundtripfromtime[i] = fromTime[i];
				roundtriptotime[i] = toTime[i];
				roundtriptoprice[i] = price[i];
				
			}
			
			System.out.println(" ");
			System.out.println("Please enter flight number that you want to take to destination:");
			String flightnumberRT1 = pbia.next();
			
			
			for (int r = 0; r < flightNumber.length; r++){
				roundtripflag++;
		
				System.out.println(flightNumber[r]);
				if(flightnumberRT1.equals(flightNumber[r])){
					System.out.println("*Select FROM destination flight*");
					
					break;
					
					
				}
				
				else{
					
				}
			
			}
			roundtrippart2 = 2;
		}
		
	}
	
	public void flightRoundTripToHome(){
		
//		Departure from destination
		System.out.println(" ");
		Scanner pbia = new Scanner(System.in);
		
		if ((roundtrippart2 == 2)){

			String [] fromTimeHome = {"9:00AM", "12:00PM", "5:00PM"};
			String [] toTimeHome = {"11:00AM", "3:00PM", "6:20PM"};
			String [] flightNameHome = {"Jet Blue", "Virgin Airlines", "Spirit Airlines"};
			String [] flightLengthHome = {"2HRS", "3HRS", "1HR 20MINS"};
			String [] priceHome = {"$200", "$130", "$110"};
			String [] flightNumberHome = {"401", "405", "450"};
		
			for(int i = 0; i < fromTimeHome.length; i++){
				System.out.println("Available FROM time: ");
				System.out.println(fromTimeHome[i]);
				System.out.println(" ");
				System.out.println("Available TO times: ");
				System.out.println(toTimeHome[i]);
				System.out.println(" ");
				System.out.println("Available flights: ");
				System.out.println(flightNameHome[i]);
				System.out.println(" ");
				System.out.println("Flight Duration: ");
				System.out.println(flightLengthHome[i]);
				System.out.println(" ");
				System.out.println("Price: ");
				System.out.println(priceHome[i]);
				System.out.println(" ");
				System.out.println("Flight Number: ");
				System.out.println(flightNumberHome[i]);
				System.out.println(" ");
				
				roundtripflightnameHome[i] = flightNameHome[i];
				roundtripfromtimeHome[i] = fromTimeHome [i];
				roundtriptotimeHome[i] = toTimeHome[i];
				roundtripfrompriceHome[i] = priceHome[i];
				}
		

			System.out.println(" ");
			System.out.println("Please enter flight number that you want to take from destination:");
			String flightnumberRT2 = pbia.next();
			
			
			for (int rr = 0; rr < flightNumberHome.length; rr++){
				roundtripflag2++;
				
				System.out.println(flightNumberHome[rr]);
				if(flightnumberRT2.equals(flightNumberHome[rr])){
					System.out.println("*Flight Booked*");
					
					break;
				}
				
				else{
					
				}
			
			}
		}
	}
	
	
	public void flightdetails(){
		
		ticketnumber = yourusername.concat(dateofbirth);
		
		System.out.println("**Ticket successfully booked!**");
		System.out.println(" ");
		
		System.out.println("Itinerary:");
		System.out.println(" ");
		
//		One way details
		if (trip.equalsIgnoreCase("oneway") || (trip.equalsIgnoreCase("one way"))){
			System.out.println("DESTINATION FLIGHT SUMMARY");
			System.out.println("Airline: " + onewayflightname[onewayflag]);
			System.out.println("Departure: " + onewayfromtime[onewayflag]);
			System.out.println("Arrival: " + onewaytotime[onewayflag]);
			System.out.println("To destination city: " + to);
			System.out.println("From destination city: " + from);
			System.out.println("Price: " + onewayprice[onewayflag]);
		}
		
		
//		Round trip details
		else if (trip.equalsIgnoreCase("round trip") || (trip.equalsIgnoreCase("roundtrip"))){
			System.out.println("DESTINATION FLIGHT SUMMARY");
			
//			System.out.println(roundtripflag);
			System.out.println("Airline: " + roundtripflightname[roundtripflag]);
			System.out.println("Departure: " + roundtripfromtime[roundtripflag]);
			System.out.println("Arrival: " + roundtriptotime[roundtripflag]);
			System.out.println("To destination city: " + to);
			System.out.println("From destination city: " + from);
			System.out.println("Price: " + roundtriptoprice[roundtripflag]);
			
			System.out.println("  ");
			System.out.println("RETURN FLIGHT SUMMARY");
			System.out.println("Airline: " + roundtripflightnameHome[roundtripflag2]);
			System.out.println("Departure: " + roundtripfromtimeHome[roundtripflag2]);
			System.out.println("Arrival: " + roundtriptotimeHome[roundtripflag2]);
			System.out.println("To destination city: " + from);
			System.out.println("From destination city: " + to);
			System.out.println("Price: " + roundtripfrompriceHome[roundtripflag2]);
			
		}
		
		System.out.println(" ");
		System.out.println("//////////////////////////////////////");
		System.out.println(" ");
		System.out.println("Full Name: " + firstname + " " + lastname);
		System.out.println("Email Address: " + emailaddress);
		System.out.println("Date of birth: " + dateofbirth);
		System.out.println("Ticket number: " + ticketnumber);
		System.out.println("Trip Type: " + trip);
	
	}
	
	public void itinerary(){
		
//		One way details
		if (trip.equalsIgnoreCase("oneway") || (trip.equalsIgnoreCase("one way"))){
			try {
				FileWriter file = new FileWriter("C:/Users/gmb_1/Desktop/TK2/GitHubAcct/AirlineBookingApplication/AirlineBookingApp/printItinerary");
				BufferedWriter printitinerary = new BufferedWriter(file);
				printitinerary.write("Itinerary:");
				printitinerary.newLine(); // new line of code
				printitinerary.newLine();
				printitinerary.write("DESTINATION FLIGHT SUMMARY");
				printitinerary.newLine();
				printitinerary.write("Airline: " + onewayflightname[onewayflag]);
				printitinerary.newLine();
				printitinerary.write("Departure: " + onewayfromtime[onewayflag]);
				printitinerary.newLine();
				printitinerary.write("Arrival: " + onewaytotime[onewayflag]);
				printitinerary.newLine();
				printitinerary.write("To destination city: " + to);
				printitinerary.newLine();
				printitinerary.write("To destination city: " + from);
				printitinerary.newLine();
				printitinerary.write("Price: " + onewayprice[onewayflag]);
				printitinerary.newLine();
				printitinerary.newLine();
				printitinerary.write("//////////////////////////////////////");
				printitinerary.newLine();
				printitinerary.newLine();
				printitinerary.write("Full Name: " + firstname + " " + lastname);
				printitinerary.newLine();
				printitinerary.write("Email Address: " + emailaddress);
				printitinerary.newLine();
				printitinerary.write("Date of birth: " + dateofbirth);
				printitinerary.newLine();
				printitinerary.write("Ticket number: " + ticketnumber);
				printitinerary.newLine();
				printitinerary.write("Trip Type: " + trip);
				
				printitinerary.close();
			} 
			
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}
		
//		Round trip details
		else if (trip.equalsIgnoreCase("round trip") || (trip.equalsIgnoreCase("roundtrip"))){
			
			try {
				FileWriter file = new FileWriter("C:/Users/gmb_1/Desktop/TK2/GitHubAcct/AirlineBookingApplication/AirlineBookingApp/printItinerary");
				BufferedWriter printitinerary = new BufferedWriter(file);
				printitinerary.newLine();
				printitinerary.write("DESTINATION FLIGHT SUMMARY");
				printitinerary.newLine();
				printitinerary.write("Airline: " + roundtripflightname[roundtripflag]);
				printitinerary.newLine();
				printitinerary.write("Departure: " + roundtripfromtime[roundtripflag]);
				printitinerary.newLine();
				printitinerary.write("To destination city: " + to);
				printitinerary.newLine();
				printitinerary.write("To destination city: " + from);
				printitinerary.newLine();
				printitinerary.write("Price: " + roundtriptoprice[roundtripflag]);
				
				printitinerary.newLine();
				printitinerary.newLine();
				printitinerary.write("RETURN FLIGHT SUMMARY");
				printitinerary.newLine();
				printitinerary.write("Airline: " + roundtripflightnameHome[roundtripflag2]);
				printitinerary.newLine();
				printitinerary.write("Departure: " + roundtripfromtimeHome[roundtripflag2]);
				printitinerary.newLine();
				printitinerary.write("Arrival: " + roundtriptotimeHome[roundtripflag2]);
				printitinerary.newLine();
				printitinerary.write("To destination city: " + from);
				printitinerary.newLine();
				printitinerary.write("To destination city: " + to);
				printitinerary.newLine();
				printitinerary.write("Price: " + roundtripfrompriceHome[roundtripflag2]);
				printitinerary.newLine();
				printitinerary.newLine();
				printitinerary.write("//////////////////////////////////////");
				printitinerary.newLine();
				printitinerary.newLine();
				printitinerary.write("Full Name: " + firstname + " " + lastname);
				printitinerary.newLine();
				printitinerary.write("Email Address: " + emailaddress);
				printitinerary.newLine();
				printitinerary.write("Date of birth: " + dateofbirth);
				printitinerary.newLine();
				printitinerary.write("Ticket number: " + ticketnumber);
				printitinerary.newLine();
				printitinerary.write("Trip Type: " + trip);
				
				printitinerary.close();
				
			} 
			
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	
	

}
