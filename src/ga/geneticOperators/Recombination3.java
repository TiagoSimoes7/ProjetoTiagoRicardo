package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;


public class Recombination3<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {

    //TODO this class might require the definition of additional methods and/or attributes

    public Recombination3(double probability) {
        super(probability);
    }

    @Override
    public void recombine(I ind1, I ind2) {
        int cut1 = GeneticAlgorithm.random.nextInt(ind1.getNumGenes());
        int cut2 = GeneticAlgorithm.random.nextInt(ind1.getNumGenes());
        int cut3 = GeneticAlgorithm.random.nextInt(ind1.getNumGenes());
        if (cut1 > cut2) {
            int aux = cut1;
            cut1 = cut2;
            cut2 = aux;
        }
        for (int i = cut1; i < cut2; i++) {
            ind1.swapGenes(ind2, i);
        }

        if (cut2 > cut3){
            int aux = cut2;
            cut2 = cut3;
            cut3 = aux;
        }

        for (int i = cut2; i < cut3; i++) {
            ind1.swapGenes(ind2, i);
        }

    }

    @Override
    public String toString(){

        return "Three cuts recombination (" + probability + ")";
    }    
}