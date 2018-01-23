/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adam.atg.kruskalovalgoritmus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adam
 */
public class KruskalovAlgoritmus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Vrchol> vrcholyPomoc = new ArrayList<>();
        ArrayList<OrientovanaHrana> hranyPomoc = new ArrayList<>();
        
        File subor = new File("vrcholyAHranyKruskal.txt");
        Scanner citac = null;
        try {
            citac = new Scanner(subor);
            boolean koniecZadavaniaVrcholov = false;
            while (!koniecZadavaniaVrcholov) {            
                String menoVrchola = citac.next();
                if (!menoVrchola.equals("koniec")) {
                    vrcholyPomoc.add(new Vrchol(menoVrchola.charAt(0)));
                } else {
                    koniecZadavaniaVrcholov = true;
                }
            }
            boolean koniecZadavaniaHran = false;
            Vrchol prvyVrchol = null;
            Vrchol druhyVrchol = null;
            while (!koniecZadavaniaHran) {
                String hranaString = citac.next();
                if (!hranaString.equals("koniec")) {

                    for (Vrchol vrchol : vrcholyPomoc) {
                        if (vrchol.getMeno() == hranaString.charAt(0)) {
                            prvyVrchol = vrchol;
                        }
                    }
                    for (Vrchol vrchol : vrcholyPomoc) {
                        if (vrchol.getMeno() == hranaString.charAt(1)) {
                            druhyVrchol = vrchol;
                        }
                    }

                    hranyPomoc.add(new OrientovanaHrana(prvyVrchol, druhyVrchol, citac.nextInt()));
                } else {
                    koniecZadavaniaHran = true;
                }
            }
        } catch (FileNotFoundException e) {
            
        } finally {
            if (citac != null) {
                citac.close();
            }
        }
        
        
        
//        System.out.println("Zadaj postupne nazvy vrcholov (oddelene enterom)\n"
//                            + "na konci napis \"koniec\":");
        
        
        
          
        Vrchol[] zoznamVrcholov = new Vrchol[vrcholyPomoc.size()];
        for (int i = 0; i < zoznamVrcholov.length; i++) {
            zoznamVrcholov[i] = vrcholyPomoc.get(i);
            //priradi kazdemu vrcholu cislo [inicializacia]
            zoznamVrcholov[i].setCislo(i + 1);
            //System.out.println(zoznamVrcholov[i].getMeno());
        }
        
//        System.out.println("Zadaj \"hrana_medzera_cena\" (napr. ab 3), na konci napis \"koniec\":");
        
        
        
        OrientovanaHrana[] zoznamHran = new OrientovanaHrana[hranyPomoc.size()];
        for (int i = 0; i < zoznamHran.length; i++) {
            zoznamHran[i] = hranyPomoc.get(i);
        }
        
        VykonavacAlgoritmu alg = new VykonavacAlgoritmu(zoznamVrcholov, zoznamHran);
        alg.vykonajVzostupne();
        alg.vykonajZostupne();
    }
    
}
