package com.tania.function_as_param;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by tanya on 09.11.17.
 */
public class FucnAsParamSecond {
    List<List<List<String>>> paragraphs = new ArrayList<>();

    private void populateParagraphs() {
        IntStream.range(0, 2).forEach(i -> {
            List<List<String>> paragraph = new ArrayList<>();
            IntStream.range(0, 3).forEach(j -> {
                List<String> line = IntStream.range(0, 10)
                        .mapToObj(k -> String.valueOf(100 * i + 10 * j + k))
                        .collect(Collectors.toList());
                paragraph.add(line);
            });
            paragraphs.add(paragraph);
        });
    }

    private void walkLines(Consumer<List<String>> lineConsumer) {
        for (List<List<String>> paragraph : paragraphs) {
            for (List<String> line : paragraph) {
                lineConsumer.accept(line);
            }
        }
    }

    private void printParagraphs() {
        for (List<List<String>> paragraph : paragraphs) {
            System.out.println("==========================");
            for (List<String> line : paragraph) {
                System.out.println(line);
            }
            System.out.println("==========================");
        }
        System.out.println();
    }

    private void runTest() {
        populateParagraphs();
        printParagraphs();
        // remove last word
        walkLines(line -> line.remove(line.size() - 1));
        printParagraphs();

        // collect words
        List<String> words = new ArrayList<>();
        walkLines(line -> words.addAll(line)); // or walkLines(words::addAll);
        System.out.println(words);


    }


    public static void main(String[] args) {
        new FunctionAsParameter().runTest();
    }
}
