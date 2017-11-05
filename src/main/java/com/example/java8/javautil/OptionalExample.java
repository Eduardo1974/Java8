package com.example.java8.javautil;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by eduardo on 05/11/17.
 */
public class OptionalExample {

    /*
        Ganhamos muito com essa nova introdução. Assim não precisamos
        escrever aqueles diversos ifs garantindo que o objeto não é nulo,
        temos uma forma muito mais interessante de representar nossas intenções.
        A classe Optional nos oferece uma variedade imensa de novos métodos que
        nos permite trabalhar de forma funcional com nossos valores, tirando maior
        proveito dos novos recursos de default methods, lambdas e method reference.
        Você pode ler mais sobre essa API em sua documentação:
     */

    public static void main(String[] args) {

        Optional<PrimeMinister> pm = Optional.of(new PrimeMinister());

        String pmName = pm.map(PrimeMinister::getName).orElse("None");
        System.out.println(pmName);

        //Assign Some Value to PrimeMinister.name
        pm = Optional.of(new PrimeMinister("Narendra Modi"));
        pmName = pm.map(PrimeMinister::getName).orElse("None");
        System.out.println(pmName);

        //Optional.flatMap()
        Optional<PrimeMinister> primeMinister = Optional.of(new PrimeMinister("Narendra Modi"));
        Optional<Country> country = Optional.of(new Country(primeMinister));
        Optional<Person> person = Optional.of(new Person(country));
        String pmName2 = person.flatMap(p -> p.getCountry()).flatMap(Country::getPrimeMinister)
                .map(PrimeMinister::getName).orElse("None"); //map = filtro (mudança de estado do retorno)
        System.out.println(pmName2);

        //Optional.filter()
        Optional<PrimeMinister> pm2 = Optional.of(new PrimeMinister("Narendra Modi"));
        //Using Optional.filter
        Predicate<PrimeMinister> pmPredicate = p-> p.getName().length() > 15;
        System.out.println(pm2.filter(pmPredicate));

        //Optional.ifPresent()
        Optional<PrimeMinister> pm3 = Optional.of(new PrimeMinister("Narendra Modi"));
        //Using Optional.ifPresent
        Consumer<PrimeMinister> pmConsumer = (PrimeMinister p) -> System.out.println(p.getName());
        pm3.ifPresent(pmConsumer); //se tiver um valor execute o que o consumer esta fazendo

        //Optional.isPresent()
        Optional<PrimeMinister> pm4 = Optional.of(new PrimeMinister("Narendra Modi"));
        //Using Optional.isPresent
        System.out.println(pm4.isPresent()); //verifica se existe um elemento
    }
}

class PrimeMinister {

    String name;

    public PrimeMinister() {
    }

    public PrimeMinister(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Country {

    Optional<PrimeMinister> primeMinister;

    public Country() {
    }

    public Country(Optional<PrimeMinister> primeMinister) {
        this.primeMinister = primeMinister;
    }

    public Optional<PrimeMinister> getPrimeMinister() {
        return primeMinister;
    }

    public void setPrimeMinister(Optional<PrimeMinister> primeMinister) {
        this.primeMinister = primeMinister;
    }
}

class Person {

    Optional<Country> country;

    public Person() {
    }

    public Person(Optional<Country> country) {
        this.country = country;
    }

    public Optional<Country> getCountry() {
        return country;
    }

    public void setCountry(Optional<Country> country) {
        this.country = country;
    }
}