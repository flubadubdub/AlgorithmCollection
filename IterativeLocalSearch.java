
import java.util.ArrayList;
/**
 *
 * @author Matthew
 */
public class IterativeLocalSearch {
    
    private final Algorithm fnc;
    private final int iterations;
    private double bestVector[];
    private double bestResult = Double.MAX_VALUE;
    private long startTime, endTime;
    private double elapsedTime;
    private ArrayList<Double> solutions = new ArrayList();
    LocalSearch ls;
    
    public IterativeLocalSearch(Algorithm alg, int iterations){
        fnc = alg;
        this.iterations = iterations;
        ls = new LocalSearch(alg);
        
        startTime = System.nanoTime();
        //a random solution is generated at the start of each Local Search,
        //so simply run Local Search and compare the results from it
        for(int i = 0; i < iterations; i++){
            ls.rerun();
            if(ls.getBestSolution() < bestResult){
                bestResult = ls.getBestSolution();
            }
        }//end for
        endTime = System.nanoTime();
        elapsedTime = (double)(endTime - startTime) / 1000000;
        solutions.add(bestResult);
    }
    
    public void rerun(){
        startTime = System.nanoTime();
        //a random solution is generated at the start of each Local Search,
        //so simply run Local Search and compare the results from it
        for(int i = 0; i < iterations; i++){
            ls.rerun();
            if(ls.getBestSolution() < bestResult){
                bestResult = ls.getBestSolution();
            }
        }//end for
        endTime = System.nanoTime();
        elapsedTime += (double)(endTime - startTime) / 1000000;
        solutions.add(bestResult);
    }
    
    public double getTime(){
        return elapsedTime;
    }
    
    public ArrayList<Double> getSolutions(){
        return solutions;
    }
    
    public int getCalls(){
        return ls.getNumCalls();
    }
    
}
