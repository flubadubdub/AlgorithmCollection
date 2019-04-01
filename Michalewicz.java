/**
 * @author Matthew Tabert
 */
public class Michalewicz extends Algorithm{
    
    public Michalewicz(int dim, int upper, int lower){
        lowBound = -100;
        upBound = 100;
        dimension = dim;
    }//end 3-arg constructor
    
    public Michalewicz(int dim){
        lowBound = -100;
        upBound = 100;
        dimension = dim;
    }//end 1-arg constructor
    
    @Override
    public double function(double vec[]){
        solution = 0;
        vector = vec;
        startTime = System.nanoTime();
        for(int i = 0; i < dimension-1; i++){
            solution -= Math.sin(vector[i])*Math.sin((i*vector[i]*vector[i])/Math.PI);
        }//end for
        endTime = System.nanoTime();
        runTime = (double)(endTime - startTime)/1000000;
        return solution;
    }//end function
}
