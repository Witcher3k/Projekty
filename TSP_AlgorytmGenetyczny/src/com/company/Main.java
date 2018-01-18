package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException {
        String plik_miasta = "C:\\Users\\Kamil\\Dropbox\\TSP\\berlin52.txt";
        //String plik_miasta = "C:\\Users\\Kamil\\Dropbox\\TSP\\a280.txt";
        //String plik_miasta = "C:\\Users\\Kamil\\Dropbox\\TSP\\eil76.txt";
        // String plik_miasta = "C:\\Users\\k-mil\\Dropbox\\TSP\\berlin52.txt";
       // String plik_miasta = "C:\\Users\\k-mil\\Dropbox\\TSP\\att48.txt";
        //String plik_miasta = "C:\\Users\\k-mil\\Dropbox\\TSP\\eil51.txt";
         //String plik_miasta = "C:\\Users\\k-mil\\Dropbox\\TSP\\a280.txt";
       // String plik_miasta = "C:\\Users\\k-mil\\Dropbox\\TSP\\pr76.txt";
        // String plik_miasta = "C:\\Users\\k-mil\\Dropbox\\TSP\\ulysses16.txt";

        long start = System.currentTimeMillis();
        try {
            //region pierwotny plik z miastami
            FileReader fr = new FileReader(plik_miasta);
            BufferedReader br = new BufferedReader(fr);
            String linia = "";
            linia = br.readLine();//pierwsza linia liczba miast
            int liczbamiast = Integer.parseInt(linia);
            System.out.printf("Liczba miast: %s %n", liczbamiast);

            int tab_odl[][] = new int[liczbamiast][liczbamiast];

            for (int i = 0; i < liczbamiast; i++) {
                if (linia != null) {
                    linia = br.readLine();
                    String[] tmp = linia.trim().split(" ");
                    for (int j = 0; j < tmp.length; j++) {
                        tab_odl[i][j] = Integer.parseInt(tmp[j]);
                        tab_odl[j][i] = Integer.parseInt(tmp[j]);
                    }
                }
            }

            for (int i = 0; i < tab_odl.length; i++) {        //wyswietl tablice z odleglosciami miast
                for (int j = 0; j < tab_odl[i].length; j++) {
                    //  System.out.printf("%s ",tab_odl[i][j]);
                }
                // System.out.println();
            }
            //endregion

            //region tworzymy pierwsza populacje
            int populacja[][] = populacja1(liczbamiast, 40);
            wyswietl_pop(populacja, tab_odl);
            //endregion


            for (int p = 0; p < 50000; p++) {
                Random r = new Random();



                //region selekcja turniejowa

                if(true) {
                    {
                        int ile_losujemy = 4;
                        int[] temp = new int[ile_losujemy];
                        int[] najlepsi_index = new int[populacja.length];
                        for (int i = 0; i < populacja.length; i++) { //losujemy tyle ile wynosi populacja po 4


                            for (int j = 0; j < ile_losujemy; j++) {
                                int wylosowany = r.nextInt(populacja.length);
                                temp[j] = wylosowany;
                                // System.out.printf("WYLOSOWALEM ID %S DLUGOSC %S",temp[j],droga_osobnika(populacja[temp[j]],tab_odl));
                                // System.out.println();
                            }


                            int min = droga_osobnika(populacja[temp[0]], tab_odl);
                            int index = temp[0];
                            for (int j = 0; j < temp.length; j++) {
                                if (droga_osobnika(populacja[temp[j]], tab_odl) < min) {
                                    min = droga_osobnika(populacja[temp[j]], tab_odl);
                                    index = temp[j];
                                }
                            }
                            najlepsi_index[i] = index;

                        }

            /*
            System.out.println("TEST");
            for (int i = 0; i <najlepsi_index.length ; i++) {
                System.out.println(najlepsi_index[i]);
            }
            */


                        int populacja_temp[][] = new int[populacja.length][liczbamiast];
                        populacja_temp = populacja.clone();
                        // System.out.println("ENTER TURNIEJ:");
                        for (int i = 0; i < populacja.length; i++) {
                            populacja[i] = populacja_temp[najlepsi_index[i]].clone();
                        }
                        //wyswietl_pop(populacja, tab_odl);

                    }

                }
                //endregion



                //region selekcjaruletki




               if(false)  {

                    int[] najlepsi_r_index = new int[populacja.length];
                    int[] dlugosc_drog = new int[populacja.length];

                    for (int i = 0; i < dlugosc_drog.length; i++) {
                        dlugosc_drog[i] = droga_osobnika(populacja[i], tab_odl);
                    }

                    int max = dlugosc_drog[0];

                    for (int i = 0; i < populacja.length; i++) {  //szukamy maxa
                        if (max < dlugosc_drog[i]) {
                            max = dlugosc_drog[i];
                        }
                    }

                    int suma_ocen = 0;
                    //(Wartość najgorszego osobnika-Wartość danego osobnika+1)-- ocena problem min

                    int[] tab_oceny_r = new int[dlugosc_drog.length];


                    for (int i = 0; i < tab_oceny_r.length; i++) {
                        int ocena = (max - dlugosc_drog[i] + 1);
                        suma_ocen += ocena;                       //zliczamy wszyskie oceny potem uzywamy ich do randoma
                        tab_oceny_r[i] = ocena;                   //tablica ocen index tej tablicy wskazuje osobnika
                    }


                    for (int i = 0; i < tab_oceny_r.length; i++) {

                        int suma_temp = 0;
                        int index = 0;
                        int los = r.nextInt(suma_ocen);
                        suma_temp += tab_oceny_r[index];
                        while (suma_temp <= los) {
                            index++;
                            suma_temp += tab_oceny_r[index];
                        }
                        najlepsi_r_index[i] = index;
                    }

                    int populacja_temp2[][] = new int[populacja.length][liczbamiast];
                    populacja_temp2 = populacja.clone();


                    for (int i = 0; i < populacja.length; i++) {
                        populacja[i] = populacja_temp2[najlepsi_r_index[i]].clone();
                    }

                     /*
                     for (int i = 0; i <najlepsi_r_index.length ; i++) {
                         System.out.printf("%s ",najlepsi_r_index[i]);
                     }
                     System.out.println();
                     Arrays.sort(najlepsi_r_index);
                     for (int i = 0; i <najlepsi_r_index.length ; i++) {
                         System.out.printf("%s ",najlepsi_r_index[i]);
                     }
                     System.out.println();
                    wyswietl_pop(populacja,tab_odl);
                     */

                }

                //endregion

                //region krzyżowanie
                int pkt_podzialu_1;
                int pkt_podzialu_2;
                int dziecko[] = new int[populacja[0].length];
                int dziecko2[] = new int[populacja[1].length];
                int temp2 = -1;


                for (int i = 0; i < populacja.length; i += 2) { //petla co 2 osobników


                    if (r.nextInt(100) + 1 >70) { //prawdopodobieństwo krzyzowania r.nextInt(100)+1>60

                        for (int k = 0; k < dziecko.length; k++) {
                            dziecko[k] = -1;
                            dziecko2[k] = -1;
                        }

                        do {
                            pkt_podzialu_1 = r.nextInt(dziecko.length); //losujemy punkty podzialu
                            pkt_podzialu_2 = r.nextInt(dziecko.length);

                        } while (pkt_podzialu_1 == pkt_podzialu_2); //nie moga byc takie same

                        if (pkt_podzialu_1 > pkt_podzialu_2) {  //1 punkt musi byc mniejszy od 2
                            int foo = pkt_podzialu_1;
                            pkt_podzialu_1 = pkt_podzialu_2;
                            pkt_podzialu_2 = foo;
                        }

                        if (i == populacja.length - 1) { //zabezpieczenie przed wyjsciem poza zasieg tablicy ostatni krzyzuje sie z 1


                            //region wyplenianie srodka
                            for (int j = pkt_podzialu_1; j < pkt_podzialu_2; j++) {
                                dziecko[j] = populacja[0][j];
                                dziecko2[j] = populacja[i][j];
                            }
                            //endregion

                            //region dla dziecka1
                            for (int j = 0; j < pkt_podzialu_1; j++) {
                                int war = populacja[i][j];
                                temp2 = findindex(dziecko, war);

                                while (temp2 != -1) {
                                    war = populacja[i][temp2];
                                    temp2 = findindex(dziecko, war);
                                }
                                dziecko[j] = war;
                            }
                            for (int j = pkt_podzialu_2; j < populacja[i].length; j++) {
                                int war = populacja[i][j];
                                temp2 = findindex(dziecko, war);

                                while (temp2 != -1) {
                                    war = populacja[i][temp2];
                                    temp2 = findindex(dziecko, war);
                                }
                                dziecko[j] = war;
                            }
                            //endregion

                            //region dla dziecka2
                            for (int j = 0; j < pkt_podzialu_1; j++) {
                                int war = populacja[0][j];
                                temp2 = findindex(dziecko2, war);

                                while (temp2 != -1) {
                                    war = populacja[0][temp2];
                                    temp2 = findindex(dziecko2, war);
                                }
                                dziecko2[j] = war;
                            }
                            for (int j = pkt_podzialu_2; j < populacja[i].length; j++) {
                                int war = populacja[0][j];
                                temp2 = findindex(dziecko2, war);

                                while (temp2 != -1) {
                                    war = populacja[0][temp2];
                                    temp2 = findindex(dziecko2, war);
                                }
                                dziecko2[j] = war;
                            }
                            //endregion


                            populacja[i] = dziecko.clone();
                            populacja[0] = dziecko2.clone();
                        } else {

                            //region wypełnienie pomiedzy pkt przeciecia
                            for (int j = pkt_podzialu_1; j < pkt_podzialu_2; j++) {
                                dziecko[j] = populacja[i + 1][j];
                                dziecko2[j] = populacja[i][j];
                            }

                            //endregion

                            //region dla 1 dziecka

                            for (int j = 0; j < pkt_podzialu_1; j++) {
                                int war = populacja[i][j];
                                temp2 = findindex(dziecko, war);

                                while (temp2 != -1) {
                                    war = populacja[i][temp2];
                                    temp2 = findindex(dziecko, war);
                                }
                                dziecko[j] = war;
                            }
                            for (int j = pkt_podzialu_2; j < populacja[i].length; j++) {
                                int war = populacja[i][j];
                                temp2 = findindex(dziecko, war);

                                while (temp2 != -1) {
                                    war = populacja[i][temp2];
                                    temp2 = findindex(dziecko, war);
                                }
                                dziecko[j] = war;
                            }
                            //endregion

                            //region dla 2 dziecka


                            for (int j = 0; j < pkt_podzialu_1; j++) {
                                int war = populacja[i + 1][j];
                                temp2 = findindex(dziecko2, war);

                                while (temp2 != -1) {
                                    war = populacja[i + 1][temp2];
                                    temp2 = findindex(dziecko2, war);
                                }
                                dziecko2[j] = war;
                            }
                            for (int j = pkt_podzialu_2; j < populacja[i].length; j++) {
                                int war = populacja[i + 1][j];
                                temp2 = findindex(dziecko2, war);

                                while (temp2 != -1) {
                                    war = populacja[i + 1][temp2];
                                    temp2 = findindex(dziecko2, war);
                                }
                                dziecko2[j] = war;
                            }
                            //endregion

                            populacja[i] = dziecko.clone();
                            populacja[i + 1] = dziecko2.clone();
                        }
                        // System.out.printf("%s ,%s ,%s %n", pkt_podzialu_1, pkt_podzialu_2, i);


                    }


                }


                //System.out.println("ENTER PO krzyżowaniu");
                //wyswietl_pop(populacja, tab_odl);
                //endregion
                // System.out.println("ENTER PO sortowanie");

                //region mutacja

                for (int i = 0; i < populacja.length; i++) {

                    if (r.nextInt(100) + 1 >40) {
                        do {
                            pkt_podzialu_1 = r.nextInt(dziecko.length); //losujemy punkty podzialu
                            pkt_podzialu_2 = r.nextInt(dziecko.length);

                        } while (pkt_podzialu_1 == pkt_podzialu_2); //nie moga byc takie same

                        if (pkt_podzialu_1 > pkt_podzialu_2) {  //1 punkt musi byc mniejszy od 2
                            int foo = pkt_podzialu_1;
                            pkt_podzialu_1 = pkt_podzialu_2;
                            pkt_podzialu_2 = foo;
                        }


                        for (int j = pkt_podzialu_1, k = pkt_podzialu_2; j < k; j++, k--) {
                            int tmp = populacja[i][j];
                            populacja[i][j] = populacja[i][k];
                            populacja[i][k] = tmp;
                        }
                        // System.out.printf("%s, %s, %s %n", pkt_podzialu_1, pkt_podzialu_2, i);
                    }

                }

                // System.out.println("ENTER PO mutacji");
                //  wyswietl_pop(populacja, tab_odl);
                //endregion

            }
            System.out.println("Populacja po wszystkim");
            wyswietl_pop(populacja, tab_odl);


            int thebestone = 0;
            int indexbestone = 0;
            thebestone = droga_osobnika(populacja[0], tab_odl);

            for (int i = 0; i < populacja.length; i++) {
                if (thebestone > droga_osobnika(populacja[i], tab_odl)) {
                    thebestone = droga_osobnika(populacja[i], tab_odl);
                    indexbestone = i;
                }
            }

            for (int i = 0; i < populacja[indexbestone].length; i++) {
                System.out.printf("%s-", populacja[indexbestone][i]);
            }
            System.out.println(thebestone);
            long time = System.currentTimeMillis() - start;
            System.out.printf("Czas: %s",time/1000);

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    public static int[][] populacja1(int liczbamiast, int ilosc_osobnikow) { //funkcja od tworzenia populacji

        int populacja[][] = new int[ilosc_osobnikow][liczbamiast];
        for (int k = 0; k < ilosc_osobnikow; k++) {
            for (int j = 0; j < liczbamiast; j++) {
                populacja[k][j] = j;
            }

            List<Integer> list = Arrays.stream(populacja[k]).boxed().collect(Collectors.toList()); //convert int[] to list
            Collections.shuffle(list);
            populacja[k] = list.stream().mapToInt(i -> i).toArray(); //list to primitive array int

        }
        return populacja;
    }

    public static void wyswietl_pop(int[][] populacja, int[][] drogi) {
        for (int i = 0; i < populacja.length; i++) {
            for (int j = 0; j < populacja[i].length; j++) {
                System.out.printf("%s ", populacja[i][j]);
            }
            System.out.printf(" Długosc drogi:%s", droga_osobnika(populacja[i], drogi));
            System.out.println();
        }
    }

    public static int droga_osobnika(int tab[], int miasta[][]) {
        int dlugosc = 0;
        for (int i = 0; i < tab.length; i++) {
            if (i < tab.length - 1) {
                dlugosc += miasta[tab[i]][tab[i + 1]];
            } else {
                dlugosc += miasta[tab[i]][tab[0]];
            }
        }

        return dlugosc;
    }  //funkcja do liczenia dlugosci drogi  osobnika

    public static int[][] PMX_potomek(int pkt_podzialu, int pkt_podzialu2, int[] rodzic1, int[] rodzic2) {
        int[][] potomek = new int[2][rodzic1.length];

        for (int i = pkt_podzialu; i <= pkt_podzialu2; i++) {
            potomek[0][i] = rodzic2[i];
            potomek[1][i] = rodzic1[i];
        }

        return potomek;
    }

    public static boolean check_duplicates(int array[], int element) {
        boolean duplicates = false;
        int check = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                check++;
            }
        }
        if (check > 1) {
            duplicates = true;
        }
        return duplicates;
    }

    public static int findindex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
