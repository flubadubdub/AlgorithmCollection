

/**
 * @author Matthew Tabert
 */
public abstract class Algorithm {
    
    public abstract double function(double[] vec);  //method which handles the equation with an input
    protected double lowBound, upBound, solution, runTime;
    protected int dimension;
    protected double vector[];
    protected MatrixGen matrixGen = new MatrixGen();
    protected long startTime, endTime;
    
    public double getTime(){
        return runTime;
    }//end getTime
    
    public boolean setVector(double[] vec){
        vector = vec;
        return true;
    }//end setVector
    public double[] getVector(){
        return vector;
    }//end getVector
    
    public int getDimension(){
        return dimension;
    }//end getDimension
    
    public double getLowBound(){
        return lowBound;
    }//end getLowBound
    
    public double getUpBound(){
        return upBound;
    }//end getUpBound
    
    public double newVectorFunction(){
        return this.function(matrixGen.createArray(dimension, lowBound, upBound));
    }//end newVectorFunction
    
    public double getSolution(){
        return solution;
    }
    
    
}//end Algorithm class
