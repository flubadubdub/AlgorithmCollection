

/**
 * @author Matthew Tabert
 */
public class Pathological extends Algorithm{
    
    public Pathological(int dim, int upper, int lower){
        lowBound = -100;
        upBound = 100;
        dimension = dim;
    }//end constructor
    
    public Pathological(int dim){
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
            solution += 0.5+(Math.sin(Math.pow(Math.sqrt(100*vector[i]*vector[i]+vector[i+1]*vector[i+1]), 2))-0.5)/(1+0.001*Math.pow(vector[i]*vector[i]-2*vector[i]*vector[i+1]+vector[i+1]*vector[i+1], 2));
        }//end for
        endTime = System.nanoTime();
        runTime = (double)(endTime - startTime)/1000000;
        return solution;
    }//end function
    
}
