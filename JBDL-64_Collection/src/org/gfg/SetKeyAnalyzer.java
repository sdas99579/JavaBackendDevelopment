package org.gfg;

import java.util.*;

public class SetKeyAnalyzer implements KeyAnalyzer{
    Set<String> set;

    public  SetKeyAnalyzer()
    {
//        set = new HashSet<>();
//        set = new LinkedHashSet<>();
//        set = new TreeSet<>();

        set =  new TreeSet<>(Comparator.reverseOrder());
    }
    @Override
    public void storeKeywords(String keyword) {
        set.add(keyword);
    }

    @Override
    public List<String> getALlKeyword() {
        List<String> list = new ArrayList<>(set);
        return list;
    }
}
