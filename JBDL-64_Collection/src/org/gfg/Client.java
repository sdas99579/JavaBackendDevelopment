package org.gfg;

import java.security.Key;

public class Client {
    public static void main(String[] args) {
//        org.gfg.KeyAnalyzer keyAnalyzer = new org.gfg.ListKeyAnalyzer();
//        org.gfg.KeyAnalyzer keyAnalyzer = new org.gfg.SetKeyAnalyzer();
        KeyAnalyzer keyAnalyzer = new MapKeyAnalyzer();
        keyAnalyzer.storeKeywords("pen");
        keyAnalyzer.storeKeywords("pencil");
        keyAnalyzer.storeKeywords("pen");
        keyAnalyzer.storeKeywords("laptop");
        keyAnalyzer.storeKeywords("mobile");
        keyAnalyzer.storeKeywords("laptop");
        keyAnalyzer.storeKeywords("pen");
        keyAnalyzer.storeKeywords("mobile");
        keyAnalyzer.storeKeywords("bag");

//        System.out.println(keyAnalyzer.getAllKeysFrequencies());
        System.out.println(keyAnalyzer.getTop5Records());
//        System.out.println(keyAnalyzer.getAllKeysFrequencies().size());
    }
}
