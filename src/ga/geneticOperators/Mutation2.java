package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;


public class Mutation2<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public Mutation2(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I ind) {
        int cut1 = GeneticAlgorithm.random.nextInt(ind.getNumGenes()/2);
        int cut2;
        do {
            cut2 = GeneticAlgorithm.random.nextInt(ind.getNumGenes());
        }while (cut1==cut2);

        int aux1;
        int aux2;

        for (int i = cut1, j = cut2; i <= (cut2-cut1)/2 + cut1; i++, j--){
            aux1 = ind.getGene(i);
            aux2 = ind.getGene(j);

            ind.setGene(i,aux2);
            ind.setGene(j,aux1);
        }

    }

    @Override
    public String toString() {
        return "Inversion mutation (" + probability + ")";
    }
}