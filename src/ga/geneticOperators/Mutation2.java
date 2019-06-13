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
        int pos1 = GeneticAlgorithm.random.nextInt(ind.getNumGenes()/2);
        int pos2;
        int pos3;
        int pos4;
        do {
            pos2 = GeneticAlgorithm.random.nextInt(ind.getNumGenes());
        }while (pos1==pos2);
        do {
            pos3 = GeneticAlgorithm.random.nextInt(ind.getNumGenes());
        }while (pos3==pos2 || pos3==pos1);
        do {
            pos4 = GeneticAlgorithm.random.nextInt(ind.getNumGenes());
        }while (pos4==pos2 || pos4==pos3 || pos4==pos1);
        int aux1 =ind.getGene(pos1);
        int aux2 =ind.getGene(pos2);
        int aux3 =ind.getGene(pos3);
        int aux4 =ind.getGene(pos4);

        ind.setGene(pos1,aux4);
        ind.setGene(pos2,aux3);
        ind.setGene(pos3,aux2);
        ind.setGene(pos4,aux1);
    }

    @Override
    public String toString() {
        return "Inversion mutation (" + probability + ")";
    }
}