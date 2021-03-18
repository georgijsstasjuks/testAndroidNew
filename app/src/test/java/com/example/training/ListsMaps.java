package com.example.training;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ListsMaps {

    @Test
    public void list(){
        List<String> list=new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("f");
        list.add("g");
        list.add("h");

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i));
        }

        for(int i = 0; i < list.size(); i++){
           if( i % 2 == 0)list.remove(i);
       }
        System.out.println();
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i));
        }
        System.out.println();
        list.clear();
        System.out.println(list.size());

    }

    @Test
    public void map(){
        Map<String, Integer> clients = new HashMap<String, Integer>();
        clients.put("John",20);
        clients.put("Bob",50);
        clients.put("Donald",70);

        System.out.println(clients.get("John"));
        for(Map.Entry<String, Integer> item : clients.entrySet()){

            System.out.printf("Key: %s  Value: %d \n", item.getKey(), item.getValue());
        }

        clients.replace("John",77);
        clients.remove("Bob");

        System.out.println();

        Set<String> keys = clients.keySet();
        Collection<Integer> values = clients.values();

        System.out.println(keys);
        System.out.println(values);

    }


}
