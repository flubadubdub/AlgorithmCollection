

/**
 * @author Matthew Tabert
 */
public class Schwefel extends Algorithm {
    
    public Schwefel(int dim){
        dimension = dim;
        lowBound = -512;
        upBound = 512;
    }//end constructor
    
    @Override
    public double function(double[] vec){
        solution = 0;
        vector = vec;
        startTime = System.nanoTime();
        for(int i = 0; i < dimension; i++){
            solution += -vector[i]*Math.sin(Math.sqrt(Math.abs(vector[i])));
        }//end for
        endTime = System.nanoTime();
        runTime = (double)(endTime - startTime)/1000000;
        return solution;
    }//end function
    

    
}//end Schwefel class
