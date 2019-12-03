package com.example.demo;

import org.assertj.core.util.Lists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class day1 {

    public Integer day1A() throws IOException {

        return getValuesFromFile()
                .stream()
                .map(mass -> (int)Math.floor(mass / 3) - 2)
                .reduce((acc, comb) -> acc + comb)
                .get();
    }

    public static Integer day2B() throws IOException {
        return getValuesFromFile()
                .stream()
                .map(mass -> getFuelForOne(mass))
                .reduce((acc, comb) -> acc + comb)
                .get();
    }

    public static Integer getFuelForOne(Integer fuelMass) {
        Integer fuelRequired = 0;
        Integer massForFuel = (int)Math.floor(fuelMass / 3) - 2;

        if (massForFuel > 0) {
            fuelRequired += massForFuel + getFuelForOne(massForFuel);
        }
        return fuelRequired;
    }

    public static List<Integer> getValuesFromFile() throws IOException {
        File file = new File("/Users/txb3flf/Development/advent-of-code-2019/day1/src/main/resources/mass");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<Integer> masses = Lists.newArrayList();

        String massLines;

        while ((massLines = bufferedReader.readLine()) != null){
            masses.add(parseInt(massLines));
        }

        return masses;
    }


}
