package br.com.dio.desafio.dominio;

import java.util.*;

public class Rank {

    private Bootcamp bootcamp;
    private Map<Dev, Double> ranking = new HashMap<>();

    public Rank(){}
    public Rank(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }

    public void incluirDev(Dev dev){
        double devXp = dev.getXpTotal();
        ranking.put(dev, devXp);
    }

    public void exibirRanking(){
        System.out.println("================ RANK ================");

        if (ranking.isEmpty()) {
            System.out.println("O ranking está vazio");
            return;
        }
        List<Map.Entry<Dev, Double>> rankList = new ArrayList<>(ranking.entrySet());
        rankList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        rankList.forEach(rank -> System.out.println(
                rank.getKey().getNome() + " : " + rank.getKey().getXpTotal()));

        System.out.println("================ RANK ================");
    }



}
