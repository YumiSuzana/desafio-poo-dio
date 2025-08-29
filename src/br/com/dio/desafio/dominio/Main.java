package br.com.dio.desafio.dominio;

import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Mentoria;
import br.com.dio.desafio.dominio.totalXP;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args){

//        Criação de 3 cursos
        Curso curso1 = new Curso();
        curso1.setTitulo("Java basico");
        curso1.setDescricao("Curso introdutorio de JAVA");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Heranca e polimorfismo");
        curso2.setDescricao("Curso intermediario de JAVA");
        curso2.setCargaHoraria(12);

        Curso curso3 = new Curso();
        curso3.setTitulo("Seguranca na nuvem");
        curso3.setDescricao("Curso intermediario 2 de JAVA");
        curso3.setCargaHoraria(5);

//        Criação de 1 mentoria fixa geral
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de JAVA");
        mentoria.setDescricao("Do basico ao avancado");
        mentoria.setData(LocalDate.now().plusDays(2));

//        Criação de 1 Bootcamp que entrega tudo
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("GFT Start #7 -Java");
        bootcamp.setDescricao("Bootcamp completo para iniciantes");


//        Adicionar os cursos e a mentoria ao único bootcamp:
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(curso3);
        bootcamp.getConteudos().add(mentoria);

//        Inserção de 2 Devs (pra fazer ranking)
        Dev dev1 = new Dev();
        dev1.setNome("Dev 1");
        dev1.inscreverBootcamp(bootcamp);

        Dev dev2 = new Dev();
        dev2.setNome("Dev 2");
        dev2.inscreverBootcamp(bootcamp);



//        cursos concluidoss
        Set<Conteudo> concluidosY = new LinkedHashSet<>();
        concluidosY.add(curso1);
        concluidosY.add(curso2);
        dev1.setConteudosConcluidos(concluidosY);

        Set<Conteudo> concluidosS = new LinkedHashSet<>();
        concluidosS.add(curso1);
        concluidosS.add(mentoria);
        dev2.setConteudosConcluidos(concluidosS);


//        cursos inscritos & mentoria:
        Set <Conteudo> inscritosY = new LinkedHashSet<>();
        inscritosY.add(curso1);
        inscritosY.add(curso2);
        inscritosY.add(curso3);
        inscritosY.add(mentoria);
        dev1.setConteudosInscritos(inscritosY);

        Set <Conteudo> inscritosS = new LinkedHashSet<>();
        inscritosS.add(curso1);
        inscritosS.add(curso2);
        inscritosS.add(curso3);
        inscritosS.add(mentoria);
        dev2.setConteudosInscritos(inscritosS);





        totalXP totalDev1 = new totalXP();
        totalXP totalDev2 = new totalXP();

        if (totalDev1.xpIndiv(dev1) > totalDev2.xpIndiv(dev2)) {

            System.out.println("\nParabéns, " + dev1.getNome() + " você está com mais pontos!");

        } else if (totalDev1.xpIndiv(dev1) < totalDev2.xpIndiv(dev2)){

            System.out.println("\nParabéns, " + dev2.getNome() + " você está com mais pontos!");

        } else {

            System.out.println("\nA competição está intensa! Parabéns, " + dev2.getNome() +" e " + dev2.getNome());


        }




    }

}
