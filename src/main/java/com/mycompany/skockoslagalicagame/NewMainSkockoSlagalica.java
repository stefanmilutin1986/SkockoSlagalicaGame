package com.mycompany.skockoslagalicagame;

import java.util.Arrays;
import java.util.Scanner;

public class NewMainSkockoSlagalica {
    
    static  String   igracevaKombinacija;
    static  String[] dobitniBrojevi = new String[4];
    static  String[] igraceviBrojevi = new String[4];
    static Scanner s = new Scanner(System.in);
    static int a0;
    static int a1;
    static int a2;
    static int a3;
    static int t1;
    static int t2;
//    mora da se kreira static jer su a0-a3 dobitni brojevi kreirani pre pocetka igre 
//    koji moraju da se koriste u drugim metodama osim u metodi koja pravi dobitnu kombinaciju
//    gde se oni pune sa slucajnim vrednostima
    public static void main(String[] args) {
        boolean gameoverAll=false;
        while(!gameoverAll){
        kreiranjeDobitnogBroja(dobitniBrojevi);
        String[] temporaryDobitni=dobitniBrojevi.clone();
        System.out.println(Arrays.toString(temporaryDobitni));
        boolean gameover=false;
        int brojacPoteza=0;
        int ukupnoPotezaBrojac=0;
        int ukupnoPoena=20;
        
        while(!gameover){
        int brojacPogodakNaPravomMestu=0;
        int brojacUkupnihPogodaka=0;        
        igracevaKombinacija(igraceviBrojevi);
        
            if(Arrays.equals(dobitniBrojevi, igraceviBrojevi)){
                System.out.println("Pobedili ste, imate sva 4 pogodtka");
                System.out.println("Osvojili ste " + ukupnoPoena + " poena.");
                gameover=true;
            }               
                else{
                for(int i = 0; i<4; i++){
                    if(dobitniBrojevi[i].equals(igraceviBrojevi[i])){
                    brojacPogodakNaPravomMestu++;
                    }
                }
                System.out.println("Imate " + brojacPogodakNaPravomMestu + " pogodjenih znakova na pravom mestu.");
                                              
                for(int i = 0; i<4; i++){
                for(int j = 0; j<4; j++){
                    if(dobitniBrojevi[i].equals(igraceviBrojevi[j])) {    
                            brojacUkupnihPogodaka++;
                            t1= i;
                            t2= j;
                            break; 
                    }
                    dobitniBrojevi[t1]="99";
                    igraceviBrojevi[t2]="88";
                }
                }
                dobitniBrojevi=temporaryDobitni.clone();
                
                System.out.println("Imate " + brojacUkupnihPogodaka + " pogodaka.");
                brojacPoteza++;
                int ostaloPoteza= 6-brojacPoteza;
                System.out.println("Odigrali ste " + brojacPoteza + ". potez, ostalo vam je jos " + ostaloPoteza + " poteza." );               
                ukupnoPotezaBrojac++;
                
                if(ukupnoPotezaBrojac==0){
                    ukupnoPoena=20;
                }
                else if(ukupnoPotezaBrojac>0 && ukupnoPotezaBrojac<5){
                    ukupnoPoena=10;
                }else{
                    ukupnoPoena=5;
                }
                
                if(ukupnoPotezaBrojac>5){
                    gameover=true;
                    System.out.println("Igra je zavrsena, niste pobedili");
                }
                }
        }
        System.out.println(" -  -  -  -");
        System.out.println("|"+a0+"|"+"|"+a1+"|"+"|"+a2+"|"+"|"+a3+"|"+"je dobitna kombinacija");
        System.out.println(" -  -  -  -");
        
            System.out.println("Dali zelite opet da nastavite da igrate: Da/Ne" );
            String odgovor=s.next();
            if(odgovor.equalsIgnoreCase("Ne")){
                gameoverAll=true;
            }
        }
        }
    
    
    public static int getRandomNumber1To6() {
    return (int) ((double)Math.random()*(double)5 + (double)1);
    }
//    formula za dobijanje slucajne vrednosti od 1 do 6
    public static void kreiranjeDobitnogBroja(String[] dobitniBrojevi){    
            a0=1;
            a1=2;
            a2=2;
            a3=1;
            dobitniBrojevi[0]=Integer.toString(a0);
            dobitniBrojevi[1]=Integer.toString(a1);
            dobitniBrojevi[2]=Integer.toString(a2);
            dobitniBrojevi[3]=Integer.toString(a3);        
    }
    
    public static void igracevaKombinacija(String[] igraceviBrojevi){
        while(true){
        System.out.println("Unesite kombinaciju od 4 broja, od 1 do 6 je dozvoljeno:");
        igracevaKombinacija=s.next();
        int igracevBroja0=Integer.parseInt(igracevaKombinacija.substring(0, 1));       
        int igracevBroja1=Integer.parseInt(igracevaKombinacija.substring(1, 2));       
        int igracevBroja2=Integer.parseInt(igracevaKombinacija.substring(2, 3));     
        int igracevBroja3=Integer.parseInt(igracevaKombinacija.substring(3, 4));
        String igracevBroj0=Integer.toString(igracevBroja0);
        String igracevBroj1=Integer.toString(igracevBroja1);
        String igracevBroj2=Integer.toString(igracevBroja2);
        String igracevBroj3=Integer.toString(igracevBroja3);        
        igraceviBrojevi[0]=igracevBroj0;
        igraceviBrojevi[1]=igracevBroj1;
        igraceviBrojevi[2]=igracevBroj2;
        igraceviBrojevi[3]=igracevBroj3;
            
        System.out.println(" -  -  -  -");
        System.out.println("|"+igracevBroja0+"|"+"|"+igracevBroja1+"|"+"|"+igracevBroja2+"|"+"|"+igracevBroja3+"|");
        System.out.println(" -  -  -  -");
        if(igracevBroja0<=0 || igracevBroja0>6 || igracevBroja1<=0 || igracevBroja1>6 || igracevBroja2<=0 || igracevBroja2>6 || igracevBroja3<=0 || igracevBroja3>6){
            System.out.println("Ne mozete uneti broj van okvira 1-6");
        }else if(igracevaKombinacija.length()!=4){
            System.out.println("Morate uneti tacno 4 znaka");
        }else{
            break;
        }        
        }               
    }
}
