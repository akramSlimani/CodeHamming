package codeHamming;
import java.lang.*;

public class Transmission {


    private String msg;
    public int[] msgToSend;
    private int msgSendLength;
    private int nbBitsParity;

    public Transmission(String message) {
        this.msg = message;
        nbBitsParity = nbBitsParity();
        msgSendLength = (int) (Math.pow(2, nbBitsParity) - 1);
        msgToSend = new int[msgSendLength];
    }

    public void setMsgToSend() {
        initBitsParity(-1);
        int index = 0; // va parcourir msg
        for (int i = 0; i < msgSendLength; i++) {
            while (msgToSend[i] == -1) {
                i++;
            }
            msgToSend[i] = (int) msg.charAt(msg.length() - index - 1) - 48;
            index++;
        }
        setBitsParity();
    }

    public int[] getMsgToSend() {
        return msgToSend;
    }

    public int nbBitsParity() {
        int i = 0;
        while (((int) (Math.pow(2, i) - 1 - i)) != msg.length()) {
            i++;
        }
        return i;
    }

    private void initBitsParity(int x) {
        int index = 0;
        for (int i = 0; i < nbBitsParity; i++) {
            index = (int) Math.pow(2, i) - 1;
            msgToSend[index] = x;
        }
    }

    public int[] getBitsParity() {
        int bits[] = new int[nbBitsParity];
        for (int i = 0; i < bits.length; i++) {
            bits[i] = msgToSend[(int) Math.pow(2, i) - 1];
        }
        return bits;
    }

    private void setBitsParity() {
        int index = msgToSend.length - 1;
        int positionP = 0;
        int iter = 1;
        int set = 1;
        initBitsParity(0);
        for (int i = nbBitsParity - 1; i >= 0; i--) {
            set = 1;
            iter = 1;
            positionP = (int) Math.pow(2, i) - 1;
            index = msgToSend.length - 1;
            while (index > positionP) {
                // convertir en nb binaire
                String addBinStr = Integer.toBinaryString(msgToSend[positionP] + msgToSend[index] * set);
                int add = (int) addBinStr.charAt(addBinStr.length() - 1) - 48;
                msgToSend[positionP] = add;
                if (iter % (i + 1) == 0) {
                    set = Math.abs(set - 1);
                }
                index--;
                iter++;
            }

        }
    }

    public String toString() {
        if (msgSendLength == 0) {
            return "message Vide !";
        }
        String s = "";
        for (int i = msgToSend.length - 1; i >= 0; i--) {
            s += msgToSend[i];
        }
        return s;
    }

    public static void main(String[] args) {
        Transmission t = new Transmission("10110111010");
        t.setMsgToSend();
        System.out.print(t);

    }

}

