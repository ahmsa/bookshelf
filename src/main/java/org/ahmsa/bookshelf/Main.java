package org.ahmsa.bookshelf;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main {
    public static void main(String... args) {
        System.out.println("Executing custom main method before Quarkus starts.");
        Quarkus.run(args); // This line starts the Quarkus application
        System.out.println("Quarkus application has started or is running.");
    }
}
