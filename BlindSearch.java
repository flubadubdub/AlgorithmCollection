
import java.util.ArrayList;

/**
 * @author Matthew Tabert
 */
public class BlindSearch {
    
    double bestFit = Double.MAX_VALUE;
    double fit, bestVector[];
    long startTime, endTime;
    double elapsedTime;
    private int iterations;
    private int numCalls = 0;
    private Algorithm alg;
    private ArrayList<Double> solutions = new ArrayList();
    
    public BlindSearch(Algorithm alg, int iterations){
        this.iterations = iterations;
        this.alg = alg;
        startTime = System.nanoTime();
        for(int i = 0; i < iterations; i++){
            fit = alg.newVectorFunction();
            numCalls++;
            if(fit < bestFit){
                bestFit = fit;
                bestVector = alg.getVector();
            }//end if
        }//end for
        endTime = System.nanoTime();
        elapsedTime = (double)(endTime - startTime) / 1000000;
        solutions.add(fit);
    }//end constructor
    
    public void rerun(){
        startTime = System.nanoTime();
        for(int i = 0; i < iterations; i++){
            fit = alg.newVectorFunction();
            numCalls++;
            if(fit < bestFit){
                bestFit = fit;
                bestVector = alg.getVector();
            }//end if
        }//end for
        endTime = System.nanoTime();
        elapsedTime += (double)(endTime - startTime) / 1000000;
        solutions.add(fit);
    }
    
    public double getBestFit(){
        return bestFit;
    }//end getBestFit
    
    public double[] getBestVector(){
        return bestVector;
    }//end getBestVector
    
    public double getTime(){
        return elapsedTime;
    }
    
    public ArrayList<Double> getBests(){
        return solutions;
    }
    
}//end BlindSearch
