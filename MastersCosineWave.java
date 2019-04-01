
/**
 * @author Matthew Tabert
 */
public class MastersCosineWave extends Algorithm{
    
    
    public MastersCosineWave(int dim){
        lowBound = -100;
        upBound = 100;
        dimension = dim;
    }//end 1-arg constructor
    
    public MastersCosineWave(int dim, int upper, int lower){
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
            solution -= Math.exp(-0.125*(vector[i]*vector[i]+vector[i+1]*vector[i+1]+0.5*vector[i+1]*vector[i]))*Math.cos(4*Math.sqrt(vector[i]*vector[i]+vector[i+1]*vector[i+1]+0.5*vector[i]*vector[i+1]));
        }//end for
        endTime = System.nanoTime();
        runTime = (double)(endTime - startTime)/1000000;
        return solution;
    }//end function
}
