#include<iostream>
#include<iomanip>
#include<fstream>
#include<string>
using namespace std;

struct Flight {
   string fromCity;
   string toCity;
   int price;
   int distance;
   };

struct Ratio {
   int numerator;
   int denominator;
};

int gcd(int x, int y) {
   if(x==1 || y==1) return 1;
   if(x%y == 0) return y;
   if(y>x) return gcd(y,x);
   return (y,x%y);
}

void printFlights(Flight flightArr[], int sz) {
   cout<<left;
   for (int i=0;i<sz;++i) {
       cout<<setw(20)<<flightArr[i].fromCity;
       cout<<setw(20)<<flightArr[i].toCity;
       cout<<setw(6)<<flightArr[i].price;
       cout<<setw(6)<<flightArr[i].distance<<endl;
   }
}

void printFlightsFrom(Flight flightArr[], int sz, string city) {
   fflush(stdin);
   cout<<left;
   for (int i=0;i<sz;++i) {
      if (flightArr[i].fromCity.compare(city) == 0){
       cout<<setw(20)<<flightArr[i].fromCity;
       cout<<setw(20)<<flightArr[i].toCity;
       cout<<setw(6)<<flightArr[i].price;
       cout<<setw(6)<<flightArr[i].distance<<'\n';
      }
   }
}

struct Ratio findHighestDistanceToPriceRatio(Flight flightArr[], int sz, int* flightIndex) {
   struct Ratio ret;
   int g = gcd(flightArr[0].distance,flightArr[0].price);
   int x1=flightArr[0].distance/g,y1=flightArr[0].price/g;
   int n=1,d=1,x2,y2;
   double r1=x1/y1;
   *flightIndex=0;
   for (int i=1;i<sz;++i) {
       g = gcd(flightArr[i].distance,flightArr[i].price);
       x2=flightArr[i].distance/g,y2=flightArr[i].price/g;
       double r2 = x2/y2;
       if(r2>r1) {
           *flightIndex=i;
           n=flightArr[i].distance,d=flightArr[i].price;
       }
   }
   ret.numerator=n;
   ret.denominator=d;
   return ret;
}

void printMenu() {
   fflush(stdin);
   cout<<"\nSelect the action:\n";
   cout<<"1) Display all the flights\n";
   cout<<"2) Show the flights that depart from a given city\n";
   cout<<"3) Find a flight with the best distance to price ratio\n";
   cout<<"4) Exit the program\n";
}

//main function
int main() {
  
   Flight flightArr[100];
   ifstream flightsFile ("flights.csv");
   string record;
   //struct Flight fl;
   string priceStr,distStr;
   int sz=0;
  
   if(flightsFile.is_open()) {
       while(getline(flightsFile,record)) {
           stringstream lineStream (record);
          
           getline(lineStream,flightArr[sz].fromCity,',');
          
           getline(lineStream,flightArr[sz].toCity,',');
          
           getline(lineStream,priceStr,',');
           flightArr[sz].price = stoi(priceStr);
          
           getline(lineStream,distStr,',');
           flightArr[sz].distance = stoi(distStr);
           ++sz;
       }
       flightsFile.close();
   }
  
   int choice, flightIndex;
   string city;
   do {
       printMenu();
       cin>>choice;
       switch(choice) {
           case 1:
               printFlights(flightArr, sz);
               break;
           case 2:
               cout<<"Please enter the city of departure:\n";
               fflush(stdin);
               getline(cin,city);
               printFlightsFrom(flightArr,sz,city);
               break;
           case 3:
              
               struct Ratio ratio=findHighestDistanceToPriceRatio(flightArr,sz, &flightIndex);
               cout<<"The best distance to price ratio is "<<ratio.numerator/ratio.denominator<<" km/$.\n";
               cout<<setw(20)<<flightArr[flightIndex].fromCity;
               cout<<setw(20)<<flightArr[flightIndex].toCity;
               cout<<setw(6)<<flightArr[flightIndex].price;
               cout<<setw(6)<<flightArr[flightIndex].distance<<endl;
               break;
           case 4: goto end;
           default: goto end;
               }
      
   }while(true);
   end:
   cout<<"Exiting the program.";
   return 0;
}