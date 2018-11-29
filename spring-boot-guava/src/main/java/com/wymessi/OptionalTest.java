package com.wymessi;

import java.util.Optional;

public class OptionalTest {
    
    public static void main(String[] args) {
        Optional<String> o = Optional.of("test");
        System.out.println(o.isPresent());
        System.out.println(o.get());
    }
}
