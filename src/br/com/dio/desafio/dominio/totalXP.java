package br.com.dio.desafio.dominio;

import java.util.concurrent.atomic.AtomicReference;

public class totalXP {

    public static double xpIndiv(Dev dev) {
        System.out.println("Dev: " + dev.getNome() + "\n \nConteudos Inscritos: ");

        dev.getConteudosInscritos().forEach(c ->
                System.out.println("- " + c.getTitulo())
        );

        System.out.println("\nConteudos ja concluidos: ");

        AtomicReference<Double> total = new AtomicReference<>(10d);

        dev.getConteudosConcluidos().forEach(c -> {
            System.out.println("- " + c.getTitulo());
            total.updateAndGet(v -> new Double((double) (v + c.calcularXp())));

        });

        System.out.println("XP total de " + dev.getNome() + ": " + total);

        return total.get();

    }
}
