public class Flight{

private String name;

private Integer number;

private String startingFrom;

private String departTo;

private Double distance;

private Double amount;

public void setName(String name){

this.name=name

}

public String getName(){

return this.name

}

public void setNumber(Integer number){

this.number=number;

}

public Integer getNumber(){

return this.number;

}

public void setStartingFrom(String startingFrom){

this.startingFrom=startingFrom;

}

public String getStartingFrom(){

retrun this.startingFrom;

}

public void setDepartTo(String departTo){

this.departTo=departTo;

}

public String getDepartTo(){

return this.departTo;

}

public void setDistance(Double distance){

this.distance=distance;

}

public Double getDistance(){

return this.distance;

}

public void setAmount(Double amount){

this.amount=amount;

}

public Double getAmount(){

return this.amount;

}

}//DAO ends here

//Main class Starts here

public class Filghts throws Exception{

public static List<Flight>flights=new ArrayList();

public static void main(String[] args){

Filghts flightsObj=new Filghts();

flightsObj.readFilghts();

flightsObj.printFlights();

flightsObj.printFlightsFrom();

flightsObj.findHighestDistanceToPriceratio();

}

public List<Flight> readFilghts(){

String filePath="/home/hundava/flights.csv";

File file=new File(filePath);

FileInputStream fis=new FileInputStream(file);

BufferInputStream bis=new BufferInputStream(fis);

String line=null;

while((line=bis.readLine())!=null){

Array arr[]=line.splits(",");//Split the word with special character

Flight flight=new Flight();

flight.setName(arr[0]);

flight.setNumber(arr[1]);

flight.setStartingFrom(arr[2]);

flight.setDepartTo(arr[3]);

flight.setDistance(arr[4]);

flight.setAmount(arr[5]);

flights.add(flight);

} }//readFilghts end

public Integer printFlights(){

retun flights.size();

}//PrintFlights method end

public List<Flight>printFlightsFrom(){

List<Flight> similarFlights=new ArrayList<Flight>();

Integer length=printFlights();

Scanner sc=new Scanner(System.in);

String searchBoarding=sc.nextLine();

for(Flight f :flights){

if(f.getStartingFrom().equalsIgnoresCase(searchBoarding)){

similarFlights.add(f);

}

return similarFlights;

}//end of printFlightsFrom

}

public Double findHighestDistanceToPriceratio(){

Double maxDistance=flights.get(0);

for(Flight f:flights){

if(maxDistance<f.getDistance()){

maxDistance=f.getDistance();

}

}

retun maxDistance;

}

}