package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;


public class Mutation3<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public Mutation3(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I ind) {
        int pos1 = GeneticAlgorithm.random.nextInt(ind.getNumGenes());
        int pos2;
        do {
            pos2 = GeneticAlgorithm.random.nextInt(ind.getNumGenes());
        }while (pos1==pos2);
        int aux=ind.getGene(pos1);
        ind.setGene(pos1,ind.getGene(pos2));
        ind.setGene(pos2,aux);
        throw new UnsupportedOperationException("Não implementado ainda");
    }

    @Override
    public String toString() {
        //TODO
        throw new UnsupportedOperationException("Não implementado ainda");
    }
}