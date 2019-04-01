
/**
 * @author Matthew Tabert
 */
public class SineEnvelopeSineWave extends Algorithm{
    
    public SineEnvelopeSineWave(int dim){
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
             solution += 0.5 + (Math.sin((vector[i]*vector[i]+vector[i+1]*vector[i+1]-0.5)
                     *(vector[i]*vector[i]+vector[i+1]*vector[i+1]-0.5)))
                     /((1+0.001*(vector[i]*vector[i]+vector[i+1]*vector[i+1]))
                     *(1+0.001*(vector[i]*vector[i]+vector[i+1]*vector[i+1])));
        }//end for
        endTime = System.nanoTime();
        runTime = (double)(endTime - startTime)/1000000;
        return solution;
    }//end function
    
    @Override
    public double newVectorFunction(){
        return this.function(matrixGen.createArray(dimension, lowBound, upBound));
    }//end newVectorFunction
}//end SineEnvelopeSineWave
