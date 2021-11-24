/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meres_11_2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Soma
 */
public class Meres_11_2021 {

    /**
     * @param args the command line arguments
     */
    static Random rnd1=new Random();
    
    public static void main(String[] args)
    {
        //Meseország_Soma();System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        Veletlenek_Soma();System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    private static void Meseország_Soma() 
    {
        String[] EladokTMB={"Hófehérke","Csipkerózsika","Herceg","Mostoha","Morgó","Hamupipőke","Vadász"};
        int[] IngatlanMereteTMB=new int[7];
        Double[] HirdetesiArTMB={52.6,32.7,64.2,48.5,22.3,55.7,28.4};
        for (int i = 0; i < 7; i++)
        {
           IngatlanMereteTMB[i]=rnd1.nextInt(15)+43;
        }
        for (int i = 0; i < EladokTMB.length; i++)
        {
            System.out.println("\t"+EladokTMB[i]+":\t"+IngatlanMereteTMB[i]+"nM\t"+HirdetesiArTMB[i]+"MFT");
        }
        System.out.println("\n----------------------------------------------------------------------\n");
        double Osszbevetel=0;
        for (int i = 0; i < HirdetesiArTMB.length; i++)
        {
            Osszbevetel+=HirdetesiArTMB[i];
        }
        System.out.println("A várható bevétel összege: "+Osszbevetel+"MFt");
        System.out.println("\n----------------------------------------------------------------------\n");
        int db=0;
        for (int i = 0; i < IngatlanMereteTMB.length; i++)
        {
            if(IngatlanMereteTMB[i]>55)
            {db++;}
        }
        System.out.println("Az 55nM-nél nagyobb ingatlanok száma: "+db);
        System.out.println("\n----------------------------------------------------------------------\n");
        int MinMeret=Integer.MAX_VALUE;
        String MinElado="";
        for (int i = 0; i < IngatlanMereteTMB.length; i++) {
            if(IngatlanMereteTMB[i]<MinMeret)
            {
                MinMeret=IngatlanMereteTMB[i];
                MinElado=EladokTMB[i];
            }
        }
        System.out.println("A legkisebb ingatlan mérete: "+MinMeret+"nM\tEladó neve: "+MinElado);
        System.out.println("\n----------------------------------------------------------------------\n");
        int Szamalalo=0;
        String Keres="Herceg";
        while(Szamalalo<EladokTMB.length && !EladokTMB[Szamalalo].contains(Keres))
        {
            Szamalalo++;
        }
        if(Szamalalo==EladokTMB.length){System.out.println("Nincs ilyen ingatlan");}
        else{System.out.println("A Herceg irodájának mérete: "+IngatlanMereteTMB[Szamalalo]);}
    }

    private static void Veletlenek_Soma()
    {   Scanner be =new Scanner(System.in);       
        System.out.print("Kérem adja meg hány számot szeretne tárolni: ");
        int N=Integer.parseInt(be.next());
        int[] VeletlenTMB=new int[N];
        System.out.print("Kérem adja meg minimum értéketi: ");        
        int Min=Integer.parseInt(be.next());
        System.out.print("Kérem adja meg minimum értéketi: ");        
        int Max=Integer.parseInt(be.next());
        for (int i = 0; i < N; i++)
        {
            VeletlenTMB[i]=rnd1.nextInt(Max-Min)+Min;
        }
        for (int i = 0; i < VeletlenTMB.length; i++)
        {
            System.out.print("\t"+VeletlenTMB[i]+" ,");
        }
        System.out.println("\n----------------------------------------------------------------------\n");
        int Szamlalo=0;
        while(Szamlalo<N && VeletlenTMB[Szamlalo]%15!=0)
        {Szamlalo++;}
        if(Szamlalo==N){System.out.println("\tNincs 15-el osztható elem a tömbben");}
        else{System.out.println("\tA tömb "+Szamlalo+"-edik eleme osztható 15-el elsőnek");}
        System.out.println("\n----------------------------------------------------------------------\n");
        System.out.println("A páratlan elemek a listában:\n");
        List<Integer> ParatlanList= new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            if(VeletlenTMB[i]%2==1)
            {ParatlanList.add(VeletlenTMB[i]);}
        }
        for (int i = 0; i < ParatlanList.size(); i++) {
            System.out.print("\t"+ParatlanList.get(i)+" , ");
        }
    }
    
}
