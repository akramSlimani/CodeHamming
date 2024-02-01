package codeHamming;

import java.util.Scanner;

public class Hamming {



    public static int paritebits(String trame) {
        int r = 0;////// calculer le nombre de bits de patites

        while (Math.pow(2, r) <= trame.length())
            r++;

        return r;
    }

    public static int taille(String trame) {// returner la taille de notre tableau

        return (int) Math.pow(2, paritebits(trame)) - 1;

    }

    public static String parite(String trame) {//calule la parité
        int s = 0;
        for (int i = 0; i < trame.length(); i++) {
            if (trame.charAt(i) == '1')
                s++;
        }
        if (s % 2 == 0)
            return "0";
        else
            return "1";
    }


    public static void emission(String trame) {

        String tableau[] = new String[taille(trame)];
        System.out.println("La trame = " + trame);

        if (taille(trame) == 7) {
            int j = 0;
            for (int i = 0; i < taille(trame); i++) {

                switch (i) {
                    case 3:
                        tableau[3] = null;
                        break;
                    case 5:
                        tableau[5] = null;
                        break;
                    case 6:
                        tableau[6] = null;
                        break;
                    default: {
                        char c = trame.charAt(j);
                        tableau[i] = Character.toString(c);
                        j++;
                    }

                }
            } // fin switch

            String s6 = tableau[0] + tableau[2] + tableau[4];
            tableau[6] = parite(s6);
            System.out.println("C0 =   " + tableau[0] + "  +  " + tableau[2] + "  +  " + tableau[4] + " = " + tableau[6]);

            String s5 = tableau[0] + tableau[1] + tableau[4];
            tableau[5] = parite(s5);
            System.out.println("C1 =   " + tableau[0] + "  +  " + tableau[1] + "  +  " + tableau[4] + " = " + tableau[5]);

            String s3 = tableau[0] + tableau[1] + tableau[2];
            tableau[3] = parite(s3);
            System.out.println("C2 =   " + tableau[0] + "  +  " + tableau[1] + "  +  " + tableau[2] + " = " + tableau[3]);

        } // fin if

        if (taille(trame) == 15) {//// tableau de 15

            int j = 0;
            for (int i = 0; i < taille(trame); i++) {

                switch (i) {
                    case 7:
                        tableau[7] = null;
                        break;
                    case 11:
                        tableau[11] = null;
                        break;
                    case 13:
                        tableau[13] = null;
                        break;
                    case 14:
                        tableau[14] = null;
                        break;
                    default: {
                        char c = trame.charAt(j);
                        tableau[i] = Character.toString(c);
                        j++;
                    }

                }
            } // fin switch

            String s14 = tableau[0] + tableau[2] + tableau[4] + tableau[6] + tableau[8] + tableau[10] + tableau[12];
            System.out.println("C0 =   " + tableau[0] + "  +  " + tableau[2] + "  +  " + tableau[4] + " = " + tableau[6] +
                    tableau[8] + "  +  " + tableau[10] + " = " + tableau[12]);
            tableau[14] = parite(s14);

            String s13 = tableau[0] + tableau[1] + tableau[4] + tableau[5] + tableau[8] + tableau[9] + tableau[12];
            System.out.println("C0 =   " + tableau[0] + "  +  " + tableau[1] + "  +  " + tableau[4] + " = " + tableau[5] +
                    tableau[8] + "  +  " + tableau[9] + " = " + tableau[12]);
            tableau[13] = parite(s13);

            String s11 = tableau[0] + tableau[1] + tableau[2] + tableau[3] + tableau[8] + tableau[9] + tableau[10];
            System.out.println("C0 =   "+tableau[0]+"  +  "+tableau[1] + "  +  " + tableau[2] + "  +  " + tableau[3] + " = " + tableau[8] +
                    tableau[9] + "  +  " + tableau[10] );
            tableau[11] = parite(s11);

            String s7 = tableau[0] + tableau[1] + tableau[2] + tableau[3] + tableau[4] + tableau[5] + tableau[6];
            System.out.println("C0 =   "+tableau[0]+"  +  "+tableau[1] + "  +  " + tableau[2] + "  +  " + tableau[3] + " = " + tableau[4] +
                    tableau[5] + "  +  " + tableau[6] );
            tableau[7] = parite(s7);
        } // fin if 15

        if (taille(trame) == 31) {//// tableau de 31

            int j = 0;
            for (int i = 0; i < taille(trame); i++) {

                switch (i) {
                    case 15:
                        tableau[15] = null;
                        break;
                    case 29:
                        tableau[29] = null;
                        break;
                    case 27:
                        tableau[27] = null;
                        break;
                    case 23:
                        tableau[23] = null;
                        break;
                    case 30:
                        tableau[30] = null;
                        break;
                    default: {
                        char c = trame.charAt(j);
                        tableau[i] = Character.toString(c);
                        j++;
                    }

                }
            } // fin switch

            String s30 = tableau[0] + tableau[2] + tableau[4] + tableau[6] + tableau[8] + tableau[10] + tableau[12]
                    + tableau[14] + tableau[16] + tableau[18] + tableau[18] + tableau[20] + tableau[22] + tableau[24]
                    + tableau[26] + tableau[28];

            System.out.println("C0 =   "+tableau[0]+"  +  "+tableau[2] + "  +  " + tableau[4] + "  +  " + tableau[6] + " = " + tableau[8] +
                    tableau[10] + "  +  " + tableau[12]+"  +  "+tableau[14] + "  +  " + tableau[16] + "  +  " + tableau[18] + " + " + tableau[20]
                    + "  +  " + tableau[22] + " + " + tableau[24]+ "  +  " + tableau[26] + " = " + tableau[28]	);
            tableau[30] = parite(s30);

            String s29 = tableau[0] + tableau[1] + tableau[4] + tableau[5] + tableau[8] + tableau[9] + tableau[12]
                    + tableau[13] + tableau[16] + tableau[17] + tableau[20] + tableau[21] + tableau[24] + tableau[25]
                    + tableau[28];
            System.out.println("C0 =   "+tableau[0]+"  +  "+tableau[1] + "  +  " + tableau[4] + "  +  " + tableau[5] + " = " + tableau[8] +
                    tableau[9] + "  +  " + tableau[12]+"  +  "+tableau[13] + "  +  " + tableau[16] + "  +  " + tableau[17] + " + " + tableau[20]
                    + "  +  " + tableau[21] + " + " + tableau[24]+ "  +  " + tableau[25] + " = " + tableau[28]	);
            tableau[29] = parite(s29);

            String s27 = tableau[0] + tableau[1] + tableau[2] + tableau[3] + tableau[8] + tableau[9] + tableau[10]
                    + tableau[11] + tableau[16] + tableau[17] + tableau[18] + tableau[19] + tableau[24] + tableau[25]
                    + tableau[26];
            System.out.println("C0 =   "+tableau[0]+"  +  "+tableau[1] + "  +  " + tableau[2] + "  +  " + tableau[3] + " = " + tableau[8] +
                    tableau[9] + "  +  " + tableau[10]+"  +  "+tableau[11] + "  +  " + tableau[16] + "  +  " + tableau[17] + " + " + tableau[18]
                    + "  +  " + tableau[19] + " + " + tableau[24]+ "  +  " + tableau[25] + " = " + tableau[26]	);
            tableau[27] = parite(s27);

            String s23 = tableau[0] + tableau[1] + tableau[2] + tableau[3] + tableau[4] + tableau[5] + tableau[6]
                    + tableau[7] + tableau[16] + tableau[17] + tableau[18] + tableau[19] + tableau[20] + tableau[21]
                    + tableau[22];
            System.out.println("C0 =   "+tableau[0]+"  +  "+tableau[1] + "  +  " + tableau[2] + "  +  " + tableau[3] + " = " + tableau[4] +
                    tableau[5] + "  +  " + tableau[6]+ "  +  " + tableau[7] +"  +  "+tableau[16] + "  +  " + tableau[17] + "  +  " + tableau[18] + " = " + tableau[19]
                    + "  +  " + tableau[20] + " = " + tableau[21]+ " = " + tableau[22]	);
            tableau[23] = parite(s23);

            String s15 = tableau[0] + tableau[1] + tableau[2] + tableau[3] + tableau[4] + tableau[5] + tableau[6]
                    + tableau[7] + tableau[8] + tableau[9] + tableau[10] + tableau[11] + tableau[12] + tableau[13]
                    + tableau[14];
            System.out.println("C0 =   "+tableau[0]+"  +  "+tableau[1] + "  +  " + tableau[2] + "  +  " + tableau[3] + " = " + tableau[4] +
                    tableau[5] + "  +  " + tableau[6]+ "  +  " + tableau[7] +"  +  "+tableau[8] + "  +  " + tableau[9] + "  +  " + tableau[10] + " = " + tableau[11]
                    + "  +  " + tableau[12] + " = " + tableau[13]+ " = " + tableau[14]	);
            tableau[15] = parite(s15);
        } // fin if 31

        System.out.print("le message a emettre =   ");
        for (int i = 0; i < taille(trame); i++)
            System.out.print(tableau[i]);

    }// fin methode

    public static void correction(String trame) {
        String tableau[] = new String[taille(trame)];// tableau qui contient la trame
        int j = 0;// index de notre trame
        for (int i = 0; i < trame.length(); i++) {// remplissage du tableau
            char c = trame.charAt(j);
            tableau[i] = Character.toString(c);
            j++;
        }

        System.out.print("Le message de Hamming =  ");
        for (int i = 0; i < trame.length(); i++) {
            System.out.print(tableau[i]);
        }

        System.out.println();
        switch (tableau.length) {
            case 7: {

                String s6 = parite(tableau[0] + tableau[2] + tableau[4] + tableau[6]);
                System.out.println("C0 =   " + tableau[0] + "  +  " + tableau[2] + "  +  " + tableau[4] +"  +  " + tableau[6] + " = " + s6);

                String s5 = parite(tableau[0] + tableau[1] + tableau[4] + tableau[5]);
                System.out.println("C1 =   " + tableau[0] + "  +  " + tableau[1] + "  +  " + tableau[4] +"  +  " + tableau[5] + " = " + s5);

                String s3 = parite(tableau[0] + tableau[1] + tableau[2] + tableau[3]);
                System.out.println("C0 =   " + tableau[0] + "  +  " + tableau[1] + "  +  " + tableau[2] +"  +  " + tableau[3] + " = " + s3);

                System.out.println("les bits de controle  =  "+s6+s5+s3);


                if (s3 != "0" || s5 != "0" || s6 != "0") {
                    String s = s3 + s5 + s6;
                    // int a=Integer.parseInt(s);//convertir entier to integer

                    int b = Integer.parseInt(s, 2);
                    int zz = tableau.length - b;
                    System.out.println(" donc la faute a corriger est dans la case =  "+Integer.parseInt(s, 2));
                    System.out.println("Dans notre tableau c'est l'index  "+zz);




                    if (tableau[zz] == "0")// correction de l erreur
                        tableau[zz] = "1";
                    else
                        tableau[zz] = "0";

                } // fin if 7

                System.out.println();

                System.out.print("Le message de hamming  corrigé = ");
                for (int i = 0; i < tableau.length; i++)
                    System.out.print(tableau[i]);
                System.out.println();
                break;
            } // fin case 7

            case 15: {
                String s14 = parite(tableau[0] + tableau[2] + tableau[4] + tableau[6] + tableau[8] + tableau[10]
                        + tableau[12] + tableau[14]);
                System.out.println("C0 =   " + tableau[0] + "  +  " + tableau[2] + "  +  " + tableau[4] + "  + " + tableau[6] +
                        "  +  " +tableau[8] + "  +  " + tableau[10] +  "  +  " + tableau[14]+" = " + s14);


                String s13 = parite(tableau[0] + tableau[1] + tableau[4] + tableau[5] + tableau[8] + tableau[9]
                        + tableau[12] + tableau[13]);
                System.out.println("C1 =   " + tableau[0] + "  +  " + tableau[1] + "  +  " + tableau[4] + "  + " + tableau[5] +
                        "  +  "+tableau[8] + "  +  " + tableau[9] + "  +  " + tableau[12]+" = " + s13);



                String s11 = parite(tableau[0] + tableau[1] + tableau[2] + tableau[3] + tableau[8] + tableau[9]
                        + tableau[10] + tableau[11]);
                System.out.println("C2 =   "+tableau[0]+"  +  "+tableau[1] + "  +  " + tableau[2] + "  +  " + tableau[3] + " + " + tableau[8] +
                        "  +  "+tableau[9] + "  +  " + tableau[10]+ "  +  " + tableau[11]+" = " + s11 );



                String s7 = parite(tableau[0] + tableau[1] + tableau[2] + tableau[3] + tableau[4] + tableau[5] + tableau[6]
                        + tableau[7]);
                System.out.println("C3 =   "+tableau[0]+"  +  "+tableau[1] + "  +  " + tableau[2] + "  +  " + tableau[3] + " + " + tableau[4] +
                        "  +  "+tableau[5] + "  +  " + tableau[6]+ " + " + tableau[7]+" = " + s7 );


                if (s7 != "0" || s11 != "0" || s13 != "0" || s14 != "0") {
                    String s = s7 + s11 + s13 + s14;

                    int b = Integer.parseInt(s, 2);
                    int zz = tableau.length - b;

                    if (tableau[zz] == "0")// correction de l erreur
                        tableau[zz] = "1";
                    else
                        tableau[zz] = "0";

                } // fin if 15
                System.out.println();

                System.out.print("Le message de hamming  corrigé = ");
                for (int i = 0; i < tableau.length; i++)
                    System.out.print(tableau[i]);
                System.out.println();
                break;
            } // fin switch 15

            case 31: {
                String s30 = parite(tableau[0] + tableau[2] + tableau[4] + tableau[6] + tableau[8] + tableau[10]
                        + tableau[12] + tableau[14] + tableau[16] + tableau[18] + tableau[18] + tableau[20] + tableau[22]
                        + tableau[24] + tableau[26] + tableau[28] + tableau[30]);

                String s29 = parite(tableau[0] + tableau[1] + tableau[4] + tableau[5] + tableau[8] + tableau[9]
                        + tableau[12] + tableau[13] + tableau[16] + tableau[17] + tableau[20] + tableau[21] + tableau[24]
                        + tableau[25] + tableau[28] + tableau[29]);

                String s27 = parite(tableau[0] + tableau[1] + tableau[2] + tableau[3] + tableau[8] + tableau[9]
                        + tableau[10] + tableau[11] + tableau[16] + tableau[17] + tableau[18] + tableau[19] + tableau[24]
                        + tableau[25] + tableau[26] + tableau[27]);

                String s23 = parite(tableau[0] + tableau[1] + tableau[2] + tableau[3] + tableau[4] + tableau[5] + tableau[6]
                        + tableau[7] + tableau[16] + tableau[17] + tableau[18] + tableau[19] + tableau[20] + tableau[21]
                        + tableau[22] + tableau[23]);

                String s15 = parite(tableau[0] + tableau[1] + tableau[2] + tableau[3] + tableau[4] + tableau[5] + tableau[6]
                        + tableau[7] + tableau[8] + tableau[9] + tableau[10] + tableau[11] + tableau[12] + tableau[13]
                        + tableau[14] + tableau[15]);

                if (s15 != "0" || s23 != "0" || s27 != "0" || s29 != "0" || s30 != "0") {

                    String s = s15 + s23 + s27 + s29 + s30;

                    int b = Integer.parseInt(s, 2);
                    int zz = tableau.length - b;

                    if (tableau[zz] == "0")// correction de l erreur
                        tableau[zz] = "1";
                    else
                        tableau[zz] = "0";
                } // fin if 31
                break;
            }//fin case 31



        }// fin switch

    }// fin correction

    public static void main(String[] args) {

        Scanner zz=new Scanner(System.in);
        System.out.print("entrer votre trame ");
        String trame=zz.nextLine();

        Scanner ss=new Scanner(System.in);
        System.out.println(" pour verifier si un code est correct tapez 1");
        System.out.println(" pour coder une trame avec le hamming code  tapez 2");
        int choix=ss.nextInt();




        boolean a=false;int c=0;
        for (int i=0;i < trame.length() ;i++)
            if (trame.charAt(i)=='1'||trame.charAt(i)=='0')//pour verifie si notre trame contient que des 1 et 0
                c++;

        if(c==trame.length()) {

            if(trame.length()==11 || trame.length()==15) {
                switch (choix) {

                    case 1:
                        if(trame.length()==15)
                            correction(trame);
                        else System.out.println(" trame érronée");
                        break;

                    case 2:
                        if(trame.length()==11)
                            emission(trame);
                        else System.out.println(" trame érronée");
                        break;

                    default:
                        break;
                }
            }



            if(trame.length()==7 || trame.length()==4) {
                switch (choix) {

                    case 1:
                        if(trame.length()==7)
                            correction(trame);
                        else System.out.println(" trame érronée");
                        break;

                    case 2:
                        if(trame.length()==4)
                            emission(trame);
                        else System.out.println(" trame érronée");
                        break;

                    default:
                        System.out.println("Trame erronée");
                        break;
                }
            }

        }else System.out.println("entrer une trame qui contient des 0 et 1 seulement");

    }
}