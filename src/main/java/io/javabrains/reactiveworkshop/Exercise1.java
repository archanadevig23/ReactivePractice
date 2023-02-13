package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream()
                .forEach(e -> System.out.print(e + " "));

        System.out.println("\n----------");

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream()
                .filter(number -> number<5)
                .forEach(number -> System.out.print(number + " "));

        System.out.println("\n----------");

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream()
                .filter(number -> number>5)
                .skip(1)
                .limit(2)
                .forEach(number -> System.out.print(number + " "));

        System.out.println("\n----------");

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer value = StreamSources.intNumbersStream()
                .filter(number -> number>5)
                .findFirst()
                .orElse(-1);
        System.out.println(value);

        System.out.println("\n----------");

        // Print first names of all users in userStream
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(System.out::println);

        System.out.println("\n----------");

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(id -> user.getId() == id))
                .forEach(user -> System.out.println(user.getFirstName()));

        System.out.println("\n----------");

        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(System.out::println);

    }

}
