
/**
 * @author Matthew Tabert
 */
public class EggHolder extends Algorithm{
    
    public EggHolder(int dim){
        lowBound = -500;
        upBound = 500;
        dimension = dim;
    }//end constructor
    
    @Override
    public double function(double vec[]){
        solution = 0;
        vector = vec;
        startTime = System.nanoTime();
        for(int i = 0; i < dimension-1; i++){
            solution += -vector[i]*Math.sin(Math.sqrt(Math.abs(vector[i]-vector[i+1]-47)))
                    -(vector[i+1]+47)*Math.sin(Math.sqrt(Math.abs(vector[i+1]+47+(vector[i]/2))));
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
}//end EggHolder
