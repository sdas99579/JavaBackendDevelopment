package org.gfg;

import java.util.List;
import java.util.Map;

public interface KeyAnalyzer {
    void storeKeywords(String keyword);
    List<String> getALlKeyword();

//    default Map<String,Integer> getAllKeysFrequencies()
default Map<String,Keyword> getAllKeysFrequencies()
    {
        return null;
    }

//    default Map<String ,Integer> getTop5Records()
default Map<String ,Integer> getTop5Records()
    {
        return null;
    }
}
