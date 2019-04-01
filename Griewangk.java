

/**
 * @author Matthew Tabert
 */
public class Griewangk extends Algorithm{
    
    public Griewangk(int dim){
        lowBound = -500;
        upBound = 500;
        dimension = dim;
    }//end constructor
    
    @Override
    public double function(double vec[]){
        solution = 0;
        double product = 1;
        vector = vec;
        startTime = System.nanoTime();
        for(int i = 0; i < dimension; i++){
            solution += (vector[i]*vector[i])/4000;
            product = product*Math.cos(vector[i]/Math.sqrt(i+1));
        }//end for loop
        solution = solution - product;
        endTime = System.nanoTime();
        runTime = (double)(endTime - startTime)/1000000;
        return solution;
    }//end function
    
    @Override
    public double newVectorFunction(){
        vector = matrixGen.createArray(dimension, lowBound, upBound);
        return this.function(vector);
    }//end newVectorFunction
}//end Griewangk
