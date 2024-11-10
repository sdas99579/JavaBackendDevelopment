package org.gfg;

import java.util.*;


public class MapKeyAnalyzer implements KeyAnalyzer{
//    public Map<String,Integer> hmap;
    public Map<String, Keyword> hmap;
    public Queue<Keyword> queue;
    public  MapKeyAnalyzer()
    {
//        hmap = new HashMap<>(); //Not follow order
//        hmap = new LinkedHashMap<>(); //follow order
        hmap = new TreeMap<>(); // follow order in alphabetical order

        queue = new PriorityQueue<>(comparator);
    }

    Comparator<Keyword> comparator = new Comparator<Keyword>() {
        @Override
        public int compare(Keyword o1, Keyword o2) {
//            if(o2.getCount()>o1.getCount())
//                return 1;
//            else
//                return -1;
            return Integer.compare(o2.getCount(),o1.getCount());
        }
    };



    @Override
//    public void storeKeywords(String keyword) {
//        if(hmap.containsKey(keyword))
//        {
//            hmap.put(keyword,hmap.get(keyword)+1);
//        }
//        else
//        {
//            hmap.put(keyword,1);
//        }
//    }//only return with no of count
    public void storeKeywords(String key) {
        int count =1;
        if(hmap.containsKey(key))
        {
            Keyword keyword = hmap.get(key);
            queue.remove(keyword);
            count = keyword.getCount();
            keyword.setCount(count+1);
            queue.add(keyword);
            hmap.put(key, keyword);

        }
        else {
            Keyword k = new Keyword(key,count);
            hmap.put(key,k);
            queue.add(k);
        }
    }

    @Override
    public List<String> getALlKeyword() {

        return null;
    }

    @Override
//    public Map<String,Integer> getAllKeysFrequencies()
    public Map<String,Keyword> getAllKeysFrequencies()
    {
        return null;
    }
//----------------------------------------------------------------------------//
//    @Override
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

//-------------------------------------------------------------------------------------------------------


    @Override
    public Map<String, Integer> getTop5Records() {

        HashMap<String,Integer> topFive = new HashMap<>();
        for(Keyword keyword: queue)
        {
            topFive.put(keyword.getKeyword(), keyword.getCount());
        }
        Map<String, Integer> hm1 = sortByValue(topFive);
        return hm1;
    }
}
