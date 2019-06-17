package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

import java.util.Arrays;


public class Recombination2<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {

    private int[] child1, child2;

    private int cut1;
    private int cut2;

    public Recombination2(double probability) {
        super(probability);
    }

    @Override
    public void recombine(I ind1, I ind2) {
        child1 = new int[ind1.getNumGenes()];
        child2 = new int[ind2.getNumGenes()];
        cut1 = GeneticAlgorithm.random.nextInt(ind1.getNumGenes());
        do {
            cut2 = GeneticAlgorithm.random.nextInt(ind1.getNumGenes());
        } while (cut1 == cut2);
        if (cut1 > cut2) {
            int aux = cut1;
            cut1 = cut2;
            cut2 = aux;
        }

        for (int i = cut1; i <= cut2; i++){ //Parte do meio dos childs
            child1[i] = ind1.getGene(i);
            child2[i] = ind2.getGene(i);
        }


        preencherChild(ind1, child1);
        preencherChild(ind2, child2);


        System.arraycopy(child1, 0, ind1.getGenome(), 0, child1.length);
        System.arraycopy(child2, 0, ind2.getGenome(), 0, child2.length);

    }

    private void preencherChild(I ind, int[] child) {

        //Preencher resto do child
        for (int i = 0; i < ind.getNumGenes(); i++) { //percorrer todos os genes do parent
            if (ind.getGene(i) > 0) {
                for (int j = 0; j < child.length; j++) { //para cada gene do parent percorrer os genes do child

                    if (ind.getGene(i) == child[j]){ //verificar se ja existe no child
                        break;
                    }
                    if (child[j] == 0) {    //se ainda estiver fazio e nao existir
                        child[j] = ind.getGene(i);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public String toString(){

        return "Two cut recombination (" + probability + ")";
    }    
}