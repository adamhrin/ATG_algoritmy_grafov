/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adam.atg.kruskalovalgoritmus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Adam
 */
class VykonavacAlgoritmu {
    private final Vrchol[] zoznamVrcholov;
    private final OrientovanaHrana[] zoznamHran;
    private ArrayList<OrientovanaHrana> zoznamHranZoradeny;
    private ArrayList<OrientovanaHrana> hranyNajlacnejsejKostry;
    private ArrayList<OrientovanaHrana> hranyNajdrahsejKostry;
    private ArrayList<Vrchol> vrcholyCakajuceNaZmenuCisla;

    public VykonavacAlgoritmu(Vrchol[] zoznamVrcholov, OrientovanaHrana[] zoznamHran) {
        this.vrcholyCakajuceNaZmenuCisla = new ArrayList<>();
        this.hranyNajlacnejsejKostry = new ArrayList<>();
        this.hranyNajdrahsejKostry = new ArrayList<>();
        this.zoznamHranZoradeny = new ArrayList<>();
        this.zoznamVrcholov = zoznamVrcholov;
        this.zoznamHran = zoznamHran;
        for (OrientovanaHrana orientovanaHrana : this.zoznamHran) {
            this.zoznamHranZoradeny.add(orientovanaHrana);
        }
    }

    void vykonajVzostupne() {
        //najprv vypocita najlacnejsiu kostru
        this.zoradHrany("vzostupne");
//        for (OrientovanaHrana hrana : this.zoznamHranZoradeny) {
//            System.out.println("" + hrana.getPrvyVrchol().getMeno() + hrana.getDruhyVrchol().getMeno() + " " + hrana.getCena());
//        }
        int pocitadlo = 0;
        while (pocitadlo < this.zoznamVrcholov.length - 1) {
            for (int i = 0; i < this.zoznamHranZoradeny.size(); i++) {
                Vrchol prvyVrchol = this.zoznamHranZoradeny.get(i).getPrvyVrchol();
                Vrchol druhyVrchol = this.zoznamHranZoradeny.get(i).getDruhyVrchol();
            
                if (prvyVrchol.getCislo() != druhyVrchol.getCislo()) {
                    int mensieCislo = Math.min(prvyVrchol.getCislo(), druhyVrchol.getCislo());
                    if (prvyVrchol.getCislo() == mensieCislo) {
                        for (Vrchol vrchol : this.zoznamVrcholov) {
                            if (vrchol.getCislo() == druhyVrchol.getCislo()) {
                                this.vrcholyCakajuceNaZmenuCisla.add(vrchol);
                                //vrchol.setCislo(mensieCislo);
                            }
                        }
                        for (Vrchol vrchol1 : this.vrcholyCakajuceNaZmenuCisla) {
                            vrchol1.setCislo(mensieCislo);
                        }
                        this.vrcholyCakajuceNaZmenuCisla = new ArrayList<>();
                    } else if (druhyVrchol.getCislo() == mensieCislo) {
                        for (Vrchol vrchol : this.zoznamVrcholov) {
                            if (vrchol.getCislo() == prvyVrchol.getCislo()) {
                                this.vrcholyCakajuceNaZmenuCisla.add(vrchol);
                            } 
                        }
                        for (Vrchol vrchol1 : this.vrcholyCakajuceNaZmenuCisla) {
                            vrchol1.setCislo(mensieCislo);
                        }
                        this.vrcholyCakajuceNaZmenuCisla = new ArrayList<>();
                    }
                    this.hranyNajlacnejsejKostry.add(this.zoznamHranZoradeny.get(i));
                    pocitadlo++;
                }
            }
        }
        int sucetCien = 0;
        System.out.println("Hrany najlacnejsej kostry: ");
        for (OrientovanaHrana hrana : this.hranyNajlacnejsejKostry) {
            sucetCien += hrana.getCena();
            System.out.println("" + hrana.getPrvyVrchol().getMeno() + hrana.getDruhyVrchol().getMeno() + " " + hrana.getCena());
        }
        
        System.out.println("Cena najlacnejsej kostry:" + sucetCien);
        
    }
    
    public void zoradHrany(String ako) {
        if (ako.equals("vzostupne")) {
            Collections.sort(this.zoznamHranZoradeny, new Comparator<OrientovanaHrana>() {
                @Override public int compare(OrientovanaHrana h1, OrientovanaHrana h2) {
                    return h1.getCena() - h2.getCena(); // Vzostupne
                }
            });
        } else if (ako.equals("zostupne")) {
            Collections.sort(this.zoznamHranZoradeny, new Comparator<OrientovanaHrana>() {
                @Override public int compare(OrientovanaHrana h1, OrientovanaHrana h2) {
                    return h2.getCena() - h1.getCena(); // Zostupne
                }
            });
        }
    }

    void vykonajZostupne() {
        this.zoradHrany("zostupne");
        for (int i = 0; i < this.zoznamVrcholov.length; i++) {
            this.zoznamVrcholov[i].setCislo(i + 1);
        }
        int pocitadlo = 0;
        while (pocitadlo < this.zoznamVrcholov.length - 1) {
            for (int i = 0; i < this.zoznamHranZoradeny.size(); i++) {
                Vrchol prvyVrchol = this.zoznamHranZoradeny.get(i).getPrvyVrchol();
                Vrchol druhyVrchol = this.zoznamHranZoradeny.get(i).getDruhyVrchol();
            
                if (prvyVrchol.getCislo() != druhyVrchol.getCislo()) {
                    int mensieCislo = Math.min(prvyVrchol.getCislo(), druhyVrchol.getCislo());
                    if (prvyVrchol.getCislo() == mensieCislo) {
                        for (Vrchol vrchol : this.zoznamVrcholov) {
                            if (vrchol.getCislo() == druhyVrchol.getCislo()) {
                                this.vrcholyCakajuceNaZmenuCisla.add(vrchol);
                                //vrchol.setCislo(mensieCislo);
                            }
                        }
                        for (Vrchol vrchol1 : this.vrcholyCakajuceNaZmenuCisla) {
                            vrchol1.setCislo(mensieCislo);
                        }
                        this.vrcholyCakajuceNaZmenuCisla = new ArrayList<>();
                    } else if (druhyVrchol.getCislo() == mensieCislo) {
                        for (Vrchol vrchol : this.zoznamVrcholov) {
                            if (vrchol.getCislo() == prvyVrchol.getCislo()) {
                                this.vrcholyCakajuceNaZmenuCisla.add(vrchol);
                            } 
                        }
                        for (Vrchol vrchol1 : this.vrcholyCakajuceNaZmenuCisla) {
                            vrchol1.setCislo(mensieCislo);
                        }
                        this.vrcholyCakajuceNaZmenuCisla = new ArrayList<>();
                    }
                    this.hranyNajdrahsejKostry.add(this.zoznamHranZoradeny.get(i));
                    pocitadlo++;
                }
            }
        }
        int sucetCien = 0;
        System.out.println("Hrany najdrahsej kostry: ");
        for (OrientovanaHrana hrana : this.hranyNajdrahsejKostry) {
            sucetCien += hrana.getCena();
            System.out.println("" + hrana.getPrvyVrchol().getMeno() + hrana.getDruhyVrchol().getMeno() + " " + hrana.getCena());
        }
        
        System.out.println("Cena najdrahsej kostry:" + sucetCien);
       
    }
    
}
