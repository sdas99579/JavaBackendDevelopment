package org.gfg;

import java.util.ArrayList;
import java.util.List;

public class ListKeyAnalyzer implements KeyAnalyzer{

    List<String> list;

    public ListKeyAnalyzer()
    {
        list = new ArrayList<>();
    }



    @Override
    public void storeKeywords(String keyword) {
        list.add(keyword);
    }

    @Override
    public List<String> getALlKeyword() {
        return list;
    }
}
