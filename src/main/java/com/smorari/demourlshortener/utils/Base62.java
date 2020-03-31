package com.smorari.demourlshortener.utils;

import lombok.Data;

@Data
public class Base62 {
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int BASE = ALPHABET.length();

    StringBuilder result = new StringBuilder();

    //from base 10 to base 62
    public String toBase62(long id) {
        if (id == 0) {
            return "0";
        }

        while (id > 0) {
            Long index = id % BASE;

            result.append(ALPHABET.charAt(Integer.parseInt(index.toString())));
            id = (long) Math.floor(id/BASE);
        }

        return result.reverse().toString();
    }

    //from base 62 to base 10
    public long toBase10(String base62) {
        int length = base62.length();
        StringBuilder sb = new StringBuilder(base62);
        String string = sb.reverse().toString();
        long base10Num = 0;

        for (int i = 0; i < length; i++) {
            long num = ALPHABET.indexOf(string.getBytes()[i]);
            base10Num += num * Math.pow(BASE, i);
        }

        return base10Num;
    }




    public static void main(String[] args) {
        System.out.println(BASE);

        Base62 base62 = new Base62();
        System.out.println(base62.toBase62(987948554334L));
        System.out.println(base62.toBase10("HOOBS2A"));
    }
}
