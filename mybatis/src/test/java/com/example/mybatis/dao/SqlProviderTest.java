package com.example.mybatis.dao;

import com.example.mybatis.bean.User;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SqlProviderTest {
    private SqlProvider sqlProvider = new SqlProvider();

    @Test
    public void prepareData() {
        Map<String, Object> map = new HashMap<>();
        User user = new User();
        user.setName("lufy");
        map.put("user", user);
        String str = sqlProvider.prepareData(map);

    }
    @Test
    public void listTest(){
        List<Aaa> aaas = new ArrayList<>();
        aaas.add(new Aaa());
        aaas = aaas.stream().filter(n->n.available).collect(Collectors.toList());
        System.out.println(aaas.size());
    }
    class Aaa {
        private boolean available;
        private String name;

        public Aaa() {
            this.name="lufy";
            this.available= false;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}