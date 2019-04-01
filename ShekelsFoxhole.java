

/**
 * @author Matthew Tabert
 */
public class ShekelsFoxhole extends Algorithm{
    
    public ShekelsFoxhole(int dim){
        dimension = dim;
        lowBound = 0;
        upBound = 10;
    }//end constructor
    
    public double function(double vec[]){
        solution = 0;
        vector = matrixGen.createArray(dimension, lowBound, upBound);
        startTime = System.nanoTime();
        for(int i = 0; i < dimension; i++){
            solution += -vector[i]*Math.sin(Math.sqrt(Math.abs(vector[i])));
        }//end for
        
        return 0;
    }//end function
    
}
