

/**
 * @author Matthew Tabert
 */
public class Rastrigin extends Algorithm{
    
    public Rastrigin(int dim){
        lowBound = -30;
        upBound = 30;
        dimension = dim;
    }//end constructor
    
    @Override
    public double function(double vec[]){
        solution = 0;
        vector = matrixGen.createArray(dimension, lowBound, upBound);
        startTime = System.nanoTime();
        for(int i = 0; i < dimension; i++){
            solution += (vector[i]*vector[i])-(10*Math.cos((2*Math.PI)*vector[i]));
        }//end for
        endTime = System.nanoTime();
        runTime = (double)(endTime - startTime)/1000000;
        return solution;
    }//end function
    
    @Override
    public double newVectorFunction(){
        return this.function(matrixGen.createArray(dimension, lowBound, upBound));
    }
}//end Rastrigin
