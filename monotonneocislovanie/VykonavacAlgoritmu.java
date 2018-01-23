/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adam.atg.monotonneocislovanie;

import java.util.ArrayList;

/**
 *
 * @author Adam
 */
public class VykonavacAlgoritmu {
    private ArrayList<Vrchol> zoznamVrcholov;
    private ArrayList<OrientovanaHrana> zoznamHran;

    public VykonavacAlgoritmu(ArrayList<Vrchol> zoznamVrcholov, ArrayList<OrientovanaHrana> zoznamHran) {
        this.zoznamVrcholov = zoznamVrcholov;
        this.zoznamHran = zoznamHran;
    }
    

    void vykonaj() {
        int pocetVrcholovSIdeg0 = 0;
        int cislo = 1;
        while (pocetVrcholovSIdeg0 < this.zoznamVrcholov.size()) {
            boolean existujeVrcholSIdeg0 = false;
            for (Vrchol vrchol : this.zoznamVrcholov) {
                if (vrchol.maIdeg0() && !vrchol.maKonecnuZnacku()) {
                    existujeVrcholSIdeg0 = true;
                    pocetVrcholovSIdeg0++;
                    vrchol.setCislo(cislo);
                    cislo++;
                    for (Vrchol vrcholKtoremuVymazavamPredchodcu : this.zoznamVrcholov) {
                        vrcholKtoremuVymazavamPredchodcu.vymazPredchodcu(vrchol);
                    }
                    vrchol.nastavKonecnuZnacku();
                }
            }
            if (!existujeVrcholSIdeg0) {
                System.out.println("V digrafe sa nachádza cyklus, nie je možné monotónne očíslovať vrcholy");
                return;
            }
        }
        System.out.println("Monotonne ocislovanie vrcholov:");
        for (Vrchol vrchol : this.zoznamVrcholov) {
            System.out.println(vrchol.getMeno() + " -> " + vrchol.getCislo());
        }
    }
    
}
