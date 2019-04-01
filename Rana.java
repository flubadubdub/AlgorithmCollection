
/**
 * @author Matthew Tabert
 */
public class Rana extends Algorithm{
    
    public Rana(int dim){
        lowBound = -500;
        upBound = 500;
        dimension = dim;
    }//end constructor
    
    @Override
    public double function(double vec[]){
        solution = 0;
        //vector = matrixGen.createArray(dimension, lowBound, upBound);
        startTime = System.nanoTime();
        for(int i = 0; i < dimension-1; i++){
            solution += vector[i]*Math.sin(Math.sqrt(Math.abs(vector[i+1]-vector[i]+1)))*
                Math.cos(Math.sqrt(Math.abs(vector[i+1]+vector[i]+1)))+(vector[i+1]+1)
                *Math.cos(Math.sqrt(Math.abs(vector[i+1]-vector[i]+1)))
                *Math.sin(Math.sqrt(Math.abs(vector[i+1]+vector[i]+1)));
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
}//end Rana
