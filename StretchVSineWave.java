

/**
 * @author Matthew Tabert
 */
public class StretchVSineWave extends Algorithm{
    
    public StretchVSineWave(int dim){
        lowBound = -30;
        upBound = 30;
        dimension = dim;
    }//end constructor
    
    @Override
    public double function(double vec[]){
        solution = 0;
        vector = vec;
        startTime = System.nanoTime();
        for(int i = 0; i < dimension-1; i++){
             solution += (Math.pow(vector[i]*vector[i]+vector[i+1]*vector[i+1], 0.25))
                     *Math.sin(50*Math.pow(vector[i]*vector[i]+vector[i+1]*vector[i+1], 0.1))+1;
        }//end for
        endTime = System.nanoTime();
        runTime = (double)(endTime - startTime)/1000000;
        return solution;
    }//end function
    
}//end StretchVSineWave
