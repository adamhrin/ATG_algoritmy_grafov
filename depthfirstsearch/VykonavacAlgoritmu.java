/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adam.atg.depthfirstsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Adam
 */
class VykonavacAlgoritmu {
    private ArrayList<Vrchol> zoznamVrcholov;
    private ArrayList<Vrchol> vysledok;
    private ArrayList<Vrchol> stack;

    VykonavacAlgoritmu(ArrayList<Vrchol> vrcholyPomoc, ArrayList<OrientovanaHrana> hranyPomoc) {
        this.vysledok = new ArrayList<>();
        this.stack = new ArrayList<>();
        this.zoznamVrcholov = vrcholyPomoc;
        this.usporiadajZoznamySusedovPodlaAbecedy();
    }

    void vykonajPre(Vrchol vrchol) {
        
        if (!vrchol.jeNavstiveny()) {
            vrchol.oznacNavstiveny();
            this.vysledok.add(vrchol);
            this.stack.add(vrchol);
        }

        for (int i = 0; i < vrchol.getVelkostZoznamuSusedov(); i++) {
            if (!vrchol.getSused(i).jeNavstiveny()) {
                Vrchol nasledujuciVrchol = vrchol.getSused(i);
                if (!nasledujuciVrchol.jeNavstiveny()) {
                    this.vykonajPre(nasledujuciVrchol);
                    return;
                }
            }
        }
        
        if (!this.vsetkyVrcholySuNavstivene()) {
            this.stack.remove(vrchol);
            this.vykonajPre(this.stack.get(this.stack.size() - 1));
            return;
        } else {
            System.out.println("Výsledok prehľadávania do hĺbky: ");
            for (Vrchol vrchol1 : this.vysledok) {
                System.out.println(vrchol1.getMeno());
            } 
        }      
    }

    private void usporiadajZoznamySusedovPodlaAbecedy() {
        for (Vrchol vrchol : this.zoznamVrcholov) {
            Collections.sort(vrchol.getZoznamSusedov(), new Comparator<Vrchol>() {
                @Override
                public int compare(Vrchol v1, Vrchol v2) {
                    return (int)v1.getMeno() - (int)v2.getMeno(); // Vzostupne
                }
            });
        }
    }

    private boolean vsetkyVrcholySuNavstivene() {
        for (Vrchol vrchol : this.zoznamVrcholov) {
            if (!vrchol.jeNavstiveny()) {
                return false;
            }
        }
        return true;
    }
    
}
