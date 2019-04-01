

/**
 * @author Matthew Tabert
 */
public class DeJong extends Algorithm{
    
    public DeJong(int dim){
        lowBound = -100;
        upBound = 100;
        dimension = dim;
    }//end constructor
    
    @Override
    public double function(double vec[]){
        solution = 0;
        vector = vec;
        startTime = System.nanoTime();
        for(int i = 0; i < dimension; i++){
            solution += vector[i]*vector[i];
        }//end for
        endTime = System.nanoTime();
        runTime = (double)(endTime - startTime)/1000000;
        return solution;
    }//end function
    
    @Override
    public double newVectorFunction(){
        vector = matrixGen.createArray(dimension, lowBound, upBound);
        return this.function(vector);
    }//end newVectorFunction
}//end DeJong
