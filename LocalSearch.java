

import java.util.ArrayList;

/**
 * @author Matthew Tabert
 * tmax=100
 */
public class LocalSearch {
    
    double bestSolution, bestVector[];
    private final int dimension;
    private final double initialSolution, initialVector[], lowBound, upBound;
    private double delta = 0.11;
    private int numCalls = 0;
    private final Algorithm fnc;
    private ArrayList<Double> solutions = new ArrayList();
    long startTime, endTime;
    double elapsedTime;
    
    public LocalSearch(Algorithm alg){
        fnc = alg;
        initialSolution = fnc.newVectorFunction();
        initialVector = fnc.getVector().clone();
        lowBound = fnc.getLowBound();
        upBound = fnc.getUpBound();
        dimension = fnc.getDimension();
        
        startTime = System.nanoTime();
        double[] currentVector = new double[dimension];
        currentVector = initialVector.clone();
        double currentSolution = bestSolution;
        boolean continueSearch = true;
        bestVector = initialVector.clone();
        
        while(continueSearch){
            continueSearch = false;
            
            for(int i = 0; i < dimension; i++){
                currentVector[i] = currentVector[i] + delta;
                currentSolution = fnc.function(currentVector);
                numCalls++;
                if(currentSolution < bestSolution){
                    bestSolution = currentSolution;
                    bestVector = currentVector.clone();
                    continueSearch = true;
                }//end if
                currentVector[i] = currentVector[i] - delta;
            }//end for
            currentVector = bestVector.clone();
        }//end while
        endTime = System.nanoTime();
        elapsedTime = (double)(endTime - startTime) / 1000000;
        solutions.add(bestSolution);
        
    }//end constructor
    
    public void rerun(){
        
        double rInitialSolution = fnc.newVectorFunction();
        double[] currentVector = fnc.getVector();
        double currentSolution = fnc.getSolution();
        bestSolution = Double.MAX_VALUE;
        boolean continueSearch = true;
        startTime = System.nanoTime();
        while(continueSearch){
            continueSearch = false;
            
            for(int i = 0; i < dimension; i++){
                currentVector[i] = currentVector[i] + delta;
                currentSolution = fnc.function(currentVector);
                numCalls++;
                if(currentSolution < bestSolution){
                    bestSolution = currentSolution;
                    bestVector = currentVector.clone();
                    continueSearch = true;
                }//end if
                currentVector[i] = currentVector[i] - delta;
            }//end for
            currentVector = bestVector.clone();
        }//end while
        endTime = System.nanoTime();
        elapsedTime += (double)(endTime - startTime) / 1000000;
        solutions.add(bestSolution);
        
    }
    
    public double getInitialSolution(){
        return initialSolution;
    }
    
    public double[] getInitalVector(){
        return initialVector;
    }
    
    public double getBestSolution(){
        return bestSolution;
    }//end getBestSolution
    
    public double[] getBestVector(){
        return bestVector;
    }//return getBestVector
    
    public int getNumCalls(){
        return numCalls;
    }
    public ArrayList<Double> getSolutions(){
        return solutions;
    }
    
    public double getTime(){
        return elapsedTime;
    }
}
