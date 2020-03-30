package com.decode;

import java.util.LinkedList;

public class Decoder {

    public String toShortCode(int number) {
        int input = number;
        int index = 1;
        StringBuffer code = new StringBuffer();
        while (input >= 0 && index < 8) {
            code.append((byte) (input % 2));
            input = input / 2;
            index++;
        }
        code.reverse();
        code.insert(0,0);
        return code.toString();
    }

    public String toLongCode(int number) {
        int inputData = number;
        int numBits = (int) Math.ceil((Math.log(inputData)/ Math.log(2.)));
        int numOctets = (int)Math.ceil(numBits/8.);
        LinkedList<String> hexCode = new LinkedList<>();
        int mask = 255;
        int octet = 0;
        for (int i = 0; i < numOctets; i ++){
            octet = inputData & mask;
            inputData >>= 8;
            hexCode.addFirst(Integer.toHexString(octet));
        }
        int headOctet = 0;
        mask = 1 << 7;
        headOctet = mask | numOctets;
        hexCode.addFirst(Integer.toHexString(headOctet));
        return String.join(" ", hexCode);
    }

    public String decodeFromShort(String code) {
        int intDecodeValue = 0;
        String stringDecodeValue;
        try {
            intDecodeValue = Integer.parseInt(code,2);
            stringDecodeValue = Integer.toString(intDecodeValue);
        }
        catch (NumberFormatException e) {
            stringDecodeValue = "Error. Wrong code.";
        }
        return stringDecodeValue;
    }

    public String decodeFromLong (String code){
        String[] arrayOctets = code.split(" ");
        StringBuffer decodeValue = new StringBuffer();
        String binaryString = "";
        for (int i = 1; i < arrayOctets.length; i++){
            if(arrayOctets[i].length() != 2){
                return "Error, wrong code";
            }
            try {
                binaryString = Integer.toBinaryString(Integer.parseInt(arrayOctets[i],16));
            }
            catch (NumberFormatException e) {
                return "Error, wrong code";
            }
            decodeValue.append(String.format("%8s", binaryString).replace(' ', '0'));
        }
        int decodeInt = Integer.parseInt(decodeValue.toString(),2);
        return Integer.toString(decodeInt);
    }
}
