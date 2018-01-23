/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adam.atg.monotonneocislovanie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adam
 */
public class MonotonneOcislovanie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Vrchol> vrcholyPomoc = new ArrayList<>();
        ArrayList<OrientovanaHrana> hranyPomoc = new ArrayList<>();
        
        File subor = new File("vrcholyAHranyMonotonneOcislovanie.txt");
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
                            //druhemu vrcholu sa nastavi predchodca - prvy vrchol
                            vrchol.nastavPredchodcu(prvyVrchol);
                            druhyVrchol = vrchol;
                        }
                    }

                    hranyPomoc.add(new OrientovanaHrana(prvyVrchol, druhyVrchol));
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
        
        VykonavacAlgoritmu alg = new VykonavacAlgoritmu(vrcholyPomoc, hranyPomoc);
        alg.vykonaj();
    }
    
}
