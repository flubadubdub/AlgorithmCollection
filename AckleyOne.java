/**
 * @author Matthew Tabert
 */
public class AckleyOne extends Algorithm{
    
    public AckleyOne(int dim){
        lowBound = -32;
        upBound = 32;
        dimension = dim;
    }//end constructor
    
    @Override
    public double function(double vec[]){
        solution = 0;
        vector = vec;
        startTime = System.nanoTime();
        for(int i = 0; i < dimension-1; i++){
              solution += (1/Math.exp(0.2))*Math.sqrt(vector[i]*vector[i]+vector[i+1]*vector[i+1])+3
                      *(Math.cos(vector[i]+vector[i])+Math.sin(vector[i+1]+vector[i+1]));
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
}//end AckleyOne
