package codeHamming;

import java.lang.*;
import java.util.Scanner;

public class Reception {
    private String msg;
    public int[] msgRecu;
    private int msgRecuLength;
    private int nbBitsControle;
    private int[] bitsControle; // on parle des bits de contrôle d'envoie

    public Reception(String message) {
        this.msg = message;
        completterMessage();
        nbBitsControle = nbBitsControle();
        msgRecuLength = (int) (Math.pow(2, nbBitsControle) - 1);
        msgRecu = new int[msgRecuLength];
        bitsControle = getBitsControle();
        setMsgRecu();
    }

    private void completterMessage() {
        int pow = 0;

        while (msg.length() > (int) (Math.pow(2, pow) - 1)) {

            pow++;
        }
        if (Math.pow(2, pow) - 1 == msg.length()) {

        } else {
            int marge = (int) Math.pow(2, pow + 1) - 1 - msg.length();
            String s = "";
            for (int i = 0; i < marge; i++) {
                s += '0';
            }
            msg = s + msg;
        }

    }

    public void setMsgRecu() {
        int index = 0; // va parcourir msg
        int pow = 0;
        for (int i = 0; i < msgRecuLength; i++) {
            while (i == (int) (Math.pow(2, pow) - 1)) { // pour qu'on saute les bits de controle qui ont les indices
                // 2^pow -1
                pow++;
                i++;
            }
            msgRecu[index] = (int) msg.charAt(msg.length() - i - 1) - 48;
            index++;
        }
    }

    public int[] getMsgRecu() {
        return msgRecu;
    }

    public int nbBitsControle() {
        int i = 0;
        while (((int) (Math.pow(2, i) - 1)) != msg.length()) {
            i++;
        }
        return i;
    }

    public int[] getBitsControle() {
        int bits[] = new int[nbBitsControle];
        for (int i = 0; i < bits.length; i++) {
            bits[i] = msgRecu[(int) Math.pow(2, i) - 1];
        }
        return bits;
    }

    // bits de contrôle de réception
    private int[] getBitsControleReception() {
        int errPos[] = new int[nbBitsControle];

        int index = msg.length() - 1;
        int nbBitsSignif = 1;
        int iter = 1;
        int set = 1;
        for (int i = 0; i < nbBitsControle; i++) {
            set = 1;
            iter = 1;
            index = msg.length() - 1;
            String addBinStr = "0";
            while (index >= 0) {
                // addition binaire (String)
                addBinStr = Integer
                        .toBinaryString(
                                (addBinStr.charAt(addBinStr.length() - 1) - 48) + (msg.charAt(index) - 48) * set);
                int add = (int) addBinStr.charAt(addBinStr.length() - 1) - 48;

                errPos[i] = add;
                if (iter % nbBitsSignif == 0) {
                    set = Math.abs(set - 1);
                    iter = 0;
                }
                index--;
                iter++;
            }
            nbBitsSignif *= 2;

        }
        return errPos;
    }

    public int getErrorPosition() {

        int errPos[] = new int[nbBitsControle];

        errPos = getBitsControleReception();

        String s = "";
        for (int i = errPos.length - 1; i >= 0; i--) {
            s += errPos[i];
        }

        // System.out.println(Arrays.toString(errPos));
        int errorPosition = Integer.parseInt(s, 2);
        return errorPosition;

    }

    public boolean SignalError() {
        return getErrorPosition() != 0;
    }

    public void correctBitError() {
        if (SignalError()) {
            int position = getErrorPosition() - 1;
            char newChar = (this.msg.charAt(position) == '0') ? '1' : '0';
            newChar = (this.msg.charAt(position) == '1') ? '0' : '1';
            StringBuffer buffer = new StringBuffer(this.msg);
            buffer.setCharAt(position, newChar);
            this.msg = buffer.toString();
            bitsControle = getBitsControle();
            setMsgRecu();
        }

    }

    public void correctMessage() {
        while (SignalError()) {
            correctBitError();
        }
    }

    public String toString() {
        if (msgRecuLength == 0) {
            return "message Vide !";
        }
        String s = "";
        for (int i = msgRecu.length - 1; i >= 0; i--) {
            s += msgRecu[i];
        }
        return s;
    }

    public static void main(String[] args) {

        System.out.println("101101111011011 cela est le message correct  : exemple du TD");

        System.out.println("message net (sans bits de controle) : 10110111010");
        System.out.println(
                "en modifiant le bit à la position 2  (1 => 0) \n On verra si le programme pourra détecter l'erreur et la corriger ensuite ! \n");
        Reception t = new Reception("101101111011001");
        System.out.println("message reçu : 101101111011011");
        System.out.println("message net reçu(Sans bits de controle) : " + t);
        // System.out.println("Error position : " + t.getErrorPosition());
        System.out.println("Etat : " + ((t.SignalError()) ? "There is an error" : "Signal Correct"));

        t.correctMessage();

        System.out.println("message net corrigé (Sans bits de controle): " + t);
        System.out.println("Error position : " + t.getErrorPosition());
        System.out.println("Alors : " + ((t.SignalError()) ? "There is an error" : "Signal Correct"));

        System.out.println("\n\n-*-*-*-* à votre tour ! *-*-*-*-*-*-\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("entrez la trame (essayez 101101111011011(juste) ou (101101111011001 irroné) ):");
        String trame = scanner.next();
        Reception t2 = new Reception(trame);
        System.out.println("message reçu : 101101111011011");
        System.out.println("message net reçu(Sans bits de controle) : " + t);
        System.out.println("Error position : " + t.getErrorPosition());
        System.out.println("Etat : " + ((t.SignalError()) ? "There is an error" : "Signal Correct"));

        t.correctMessage();

        System.out.println("message net corrigé (Sans bits de controle): " + t);
        System.out.println("Error position : " + t.getErrorPosition());
        System.out.println("Alors : " + ((t.SignalError()) ? "There is an error" : "Signal Correct"));



    }

}

