

/**
 * @author Matthew Tabert
 */
public class Rosenbrock extends Algorithm{
    
    public Rosenbrock(int dim){
        lowBound = -100;
        upBound = 100;
        dimension = dim;
    }//end constructor
    
    @Override
    public double function(double vec[]){
        solution = 0;
        vector = vec;
        startTime = System.nanoTime();
        for(int i = 0; i < dimension-1; i++){
            solution += 100*(((vector[i]*vector[i])-vector[i+1])*((vector[i]*vector[i])-vector[i+1]))+((1-vector[i])*(1-vector[i]));
        }//end for
        endTime = System.nanoTime();
        runTime = (double)(endTime - startTime)/1000000;
        return solution;
    }//end function
    
    @Override
    public double newVectorFunction(){
        return this.function(matrixGen.createArray(dimension, lowBound, upBound));
    }
}//end Rosenbrock
