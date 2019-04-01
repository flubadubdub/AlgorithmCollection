

/**
 * @author Matthew Tabert
 */
public class AckleyTwo extends Algorithm{
    
    public AckleyTwo(int dim){
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
            solution += 20+Math.E-(20/(Math.exp(0.2)*Math.sqrt((vector[i]*vector[i]+vector[i+1]*vector[i+1])/2)))
                    -Math.exp(0.5*(Math.cos(2*Math.PI*vector[i]))+Math.cos(2*Math.PI*vector[i+1]));
        }//end for
        endTime = System.nanoTime();
        runTime = (double)(endTime - startTime)/1000000;
        return solution;
    }//end function
    
}//end AckleyTwo
