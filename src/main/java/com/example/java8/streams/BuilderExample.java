package com.example.java8.streams;

import java.util.stream.Stream;

/**
 * Created by eduardo on 05/11/17.
 */
public class BuilderExample {

    public static void main(String[] args) {
        Stream.Builder<String> b = Stream.builder();
        b.add("a");
        b.add("b");
        b.add("c");
        b.add("d");
        b.add("e");

        Stream<String> s = b.build(); //aqui realmente criou a lista
        s.forEach(System.out::println);

        //BUILDER EXAMPLE
        System.out.println(new ChatMessage.Builder("eduardo").message("hello").build());
    }
}
 class ChatMessage {

    private String message;
    private String username;

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }

    public static class Builder {
        private String mUsername;
        private String mMessage;

        public Builder(String username) {
            mUsername = username;
        }

        public Builder message(String message) {
            mMessage = message;
            return this;
        }

        public ChatMessage build() {
            ChatMessage message = new ChatMessage();
            message.username = mUsername;
            message.message = mMessage;
            return message;
        }
    }
}
