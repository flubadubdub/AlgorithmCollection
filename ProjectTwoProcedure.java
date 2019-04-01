
import java.util.ArrayList;

/**
 *
 * @author Matthew
 */
public class ProjectTwoProcedure {
    
    public void run(){
        
        int numIterations = 100;
        int outerIterations = 30;
        ArrayList<Double> blindTimesTen = new ArrayList();
        ArrayList<Double> blindTimesTwenty = new ArrayList();
        ArrayList<Double> blindTimesThirty = new ArrayList();
        ArrayList<Double> blindAverageTen = new ArrayList();
        ArrayList<Double> blindAverageTwenty = new ArrayList();
        ArrayList<Double> blindAverageThirty = new ArrayList();
        ArrayList<Double> blindDeviationTen = new ArrayList();
        ArrayList<Double> blindDeviationTwenty = new ArrayList();
        ArrayList<Double> blindDeviationThirty = new ArrayList();
        ArrayList<Integer> blindCallsTen = new ArrayList();
        
        //dummy BlindSearch to alleviate start-time slowness
        new BlindSearch(new Schwefel(5), 50);
        
        //Blind Search trials, 10 dimensions, 100 iterations
        BlindSearch schwefelTen = new BlindSearch(new Schwefel(10), numIterations);
        BlindSearch dejongTen = new BlindSearch(new DeJong(10), numIterations);
        BlindSearch rosenbrockTen = new BlindSearch(new Rosenbrock(10), numIterations);
        BlindSearch rastriginTen = new BlindSearch(new Rastrigin(10), numIterations);
        BlindSearch griewangkTen = new BlindSearch(new Griewangk(10), numIterations);
        BlindSearch seswTen = new BlindSearch(new SineEnvelopeSineWave(10), numIterations);
        BlindSearch svswTen = new BlindSearch(new StretchVSineWave(10), numIterations);
        BlindSearch ackOneTen = new BlindSearch(new AckleyOne(10), numIterations);
        BlindSearch ackTwoTen = new BlindSearch(new AckleyTwo(10), numIterations);
        BlindSearch eggHolderTen = new BlindSearch(new EggHolder(10), numIterations);
        BlindSearch ranaTen = new BlindSearch(new EggHolder(10), numIterations);
        BlindSearch pathTen = new BlindSearch(new Pathological(10), numIterations);
        BlindSearch michalewiczTen = new BlindSearch(new Michalewicz(10), numIterations);
        BlindSearch mcwTen = new BlindSearch(new MastersCosineWave(10), numIterations);
        BlindSearch shekelsTen = new BlindSearch(new ShekelsFoxhole(10), numIterations);
        
        for(int i = 0; i < outerIterations-1; i++){
            schwefelTen.rerun();                         dejongTen.rerun();
            rosenbrockTen.rerun();                       rastriginTen.rerun();
            griewangkTen.rerun();                        seswTen.rerun();
            svswTen.rerun();                             ackOneTen.rerun();
            ackTwoTen.rerun();                           eggHolderTen.rerun();
            ranaTen.rerun();                             pathTen.rerun();
            michalewiczTen.rerun();                      mcwTen.rerun();
            shekelsTen.rerun();
        }
        
        //Calculate averages for 10 dimension trials
        blindAverageTen.add(statAverage(schwefelTen.getBests()));
        blindAverageTen.add(statAverage(dejongTen.getBests()));
        blindAverageTen.add(statAverage(rosenbrockTen.getBests()));
        blindAverageTen.add(statAverage(rastriginTen.getBests()));
        blindAverageTen.add(statAverage(griewangkTen.getBests()));
        blindAverageTen.add(statAverage(seswTen.getBests()));
        blindAverageTen.add(statAverage(svswTen.getBests()));
        blindAverageTen.add(statAverage(ackOneTen.getBests()));
        blindAverageTen.add(statAverage(ackTwoTen.getBests()));
        blindAverageTen.add(statAverage(eggHolderTen.getBests()));
        blindAverageTen.add(statAverage(ranaTen.getBests()));
        blindAverageTen.add(statAverage(pathTen.getBests()));
        blindAverageTen.add(statAverage(michalewiczTen.getBests()));
        blindAverageTen.add(statAverage(mcwTen.getBests()));
        blindAverageTen.add(statAverage(shekelsTen.getBests()));
        
        //Blind Search 10 dimension trial times for 100 iterations
        blindTimesTen.add(schwefelTen.getTime());            blindTimesTen.add(dejongTen.getTime());
        blindTimesTen.add(rosenbrockTen.getTime());          blindTimesTen.add(rastriginTen.getTime());
        blindTimesTen.add(griewangkTen.getTime());           blindTimesTen.add(seswTen.getTime());
        blindTimesTen.add(svswTen.getTime());                blindTimesTen.add(ackOneTen.getTime());
        blindTimesTen.add(ackTwoTen.getTime());              blindTimesTen.add(eggHolderTen.getTime());
        blindTimesTen.add(ranaTen.getTime());                blindTimesTen.add(pathTen.getTime());
        blindTimesTen.add(michalewiczTen.getTime());         blindTimesTen.add(mcwTen.getTime());
        blindTimesTen.add(shekelsTen.getTime());
        
        //Calculate standard deviation for 10 dimension trials
        blindDeviationTen.add(standardDeviation(schwefelTen.getBests()));
        blindDeviationTen.add(standardDeviation(dejongTen.getBests()));
        blindDeviationTen.add(standardDeviation(rosenbrockTen.getBests()));
        blindDeviationTen.add(standardDeviation(rastriginTen.getBests()));
        blindDeviationTen.add(standardDeviation(griewangkTen.getBests()));
        blindDeviationTen.add(standardDeviation(seswTen.getBests()));
        blindDeviationTen.add(standardDeviation(svswTen.getBests()));
        blindDeviationTen.add(standardDeviation(ackOneTen.getBests()));
        blindDeviationTen.add(standardDeviation(ackTwoTen.getBests()));
        blindDeviationTen.add(standardDeviation(eggHolderTen.getBests()));
        blindDeviationTen.add(standardDeviation(ranaTen.getBests()));
        blindDeviationTen.add(standardDeviation(pathTen.getBests()));
        blindDeviationTen.add(standardDeviation(michalewiczTen.getBests()));
        blindDeviationTen.add(standardDeviation(mcwTen.getBests()));
        blindDeviationTen.add(standardDeviation(shekelsTen.getBests()));
        
        
        System.out.println("10 dimension times: " + blindTimesTen.toString());
        System.out.println("10 dimension averages: " + blindAverageTen.toString());
        System.out.println("10 dimension standard deviation: " + blindDeviationTen.toString());
        
        //Blind Search trials, 20 dimensions, 100 iterations
        BlindSearch schwefelTwenty = new BlindSearch(new Schwefel(20), numIterations);
        BlindSearch dejongTwenty = new BlindSearch(new DeJong(20), numIterations);
        BlindSearch rosenbrockTwenty = new BlindSearch(new Rosenbrock(20), numIterations);
        BlindSearch rastriginTwenty = new BlindSearch(new Rastrigin(20), numIterations);
        BlindSearch griewangkTwenty = new BlindSearch(new Griewangk(20), numIterations);
        BlindSearch seswTwenty = new BlindSearch(new SineEnvelopeSineWave(20), numIterations);
        BlindSearch svswTwenty = new BlindSearch(new StretchVSineWave(20), numIterations);
        BlindSearch ackOneTwenty = new BlindSearch(new AckleyOne(20), numIterations);
        BlindSearch ackTwoTwenty = new BlindSearch(new AckleyTwo(20), numIterations);
        BlindSearch eggHolderTwenty = new BlindSearch(new EggHolder(20), numIterations);
        BlindSearch ranaTwenty = new BlindSearch(new EggHolder(20), numIterations);
        BlindSearch pathTwenty = new BlindSearch(new Pathological(20), numIterations);
        BlindSearch michalewiczTwenty = new BlindSearch(new Michalewicz(20), numIterations);
        BlindSearch mcwTwenty = new BlindSearch(new MastersCosineWave(20), numIterations);
        BlindSearch shekelsTwenty = new BlindSearch(new ShekelsFoxhole(20), numIterations);
        
        for(int i = 0; i < outerIterations-1; i++){
            schwefelTwenty.rerun();                         dejongTwenty.rerun();
            rosenbrockTwenty.rerun();                       rastriginTwenty.rerun();
            griewangkTwenty.rerun();                        seswTwenty.rerun();
            svswTwenty.rerun();                             ackOneTwenty.rerun();
            ackTwoTwenty.rerun();                           eggHolderTwenty.rerun();
            ranaTwenty.rerun();                             pathTwenty.rerun();
            michalewiczTwenty.rerun();                      mcwTwenty.rerun();
            shekelsTwenty.rerun();
        }
        
        //Calculate averages for 20 dimension trials
        blindAverageTwenty.add(statAverage(schwefelTwenty.getBests()));
        blindAverageTwenty.add(statAverage(dejongTwenty.getBests()));
        blindAverageTwenty.add(statAverage(rosenbrockTwenty.getBests()));
        blindAverageTwenty.add(statAverage(rastriginTwenty.getBests()));
        blindAverageTwenty.add(statAverage(griewangkTwenty.getBests()));
        blindAverageTwenty.add(statAverage(seswTwenty.getBests()));
        blindAverageTwenty.add(statAverage(svswTwenty.getBests()));
        blindAverageTwenty.add(statAverage(ackOneTwenty.getBests()));
        blindAverageTwenty.add(statAverage(ackTwoTwenty.getBests()));
        blindAverageTwenty.add(statAverage(eggHolderTwenty.getBests()));
        blindAverageTwenty.add(statAverage(ranaTwenty.getBests()));
        blindAverageTwenty.add(statAverage(pathTwenty.getBests()));
        blindAverageTwenty.add(statAverage(michalewiczTwenty.getBests()));
        blindAverageTwenty.add(statAverage(mcwTwenty.getBests()));
        blindAverageTwenty.add(statAverage(shekelsTwenty.getBests()));
        
        //Calculate standard deviation for 20 dimension trials
        blindDeviationTwenty.add(standardDeviation(schwefelTwenty.getBests()));
        blindDeviationTwenty.add(standardDeviation(dejongTwenty.getBests()));
        blindDeviationTwenty.add(standardDeviation(rosenbrockTwenty.getBests()));
        blindDeviationTwenty.add(standardDeviation(rastriginTwenty.getBests()));
        blindDeviationTwenty.add(standardDeviation(griewangkTwenty.getBests()));
        blindDeviationTwenty.add(standardDeviation(seswTwenty.getBests()));
        blindDeviationTwenty.add(standardDeviation(svswTwenty.getBests()));
        blindDeviationTwenty.add(standardDeviation(ackOneTwenty.getBests()));
        blindDeviationTwenty.add(standardDeviation(ackTwoTwenty.getBests()));
        blindDeviationTwenty.add(standardDeviation(eggHolderTwenty.getBests()));
        blindDeviationTwenty.add(standardDeviation(ranaTwenty.getBests()));
        blindDeviationTwenty.add(standardDeviation(pathTwenty.getBests()));
        blindDeviationTwenty.add(standardDeviation(michalewiczTwenty.getBests()));
        blindDeviationTwenty.add(standardDeviation(mcwTwenty.getBests()));
        blindDeviationTwenty.add(standardDeviation(shekelsTwenty.getBests()));
        
        //Blind Search 20 dimension trial times for 100 iterations
        blindTimesTwenty.add(schwefelTwenty.getTime());          blindTimesTwenty.add(dejongTwenty.getTime());
        blindTimesTwenty.add(rosenbrockTwenty.getTime());        blindTimesTwenty.add(rastriginTwenty.getTime());
        blindTimesTwenty.add(griewangkTwenty.getTime());         blindTimesTwenty.add(seswTwenty.getTime());
        blindTimesTwenty.add(svswTwenty.getTime());              blindTimesTwenty.add(ackOneTwenty.getTime());
        blindTimesTwenty.add(ackTwoTwenty.getTime());            blindTimesTwenty.add(eggHolderTwenty.getTime());
        blindTimesTwenty.add(ranaTwenty.getTime());              blindTimesTwenty.add(pathTwenty.getTime());
        blindTimesTwenty.add(michalewiczTwenty.getTime());       blindTimesTwenty.add(mcwTwenty.getTime());
        blindTimesTwenty.add(shekelsTwenty.getTime());
        
        System.out.println("20 dimension times: " + blindTimesTwenty.toString());
        System.out.println("20 dimension averages: " + blindAverageTwenty.toString());
        System.out.println("20 dimension standard deviation: " + blindDeviationTwenty.toString());
        

        //Blind Search trials, 30 dimensions, 100 iterations, 30 runs
        BlindSearch schwefelThirty = new BlindSearch(new Schwefel(30), numIterations);
        BlindSearch dejongThirty = new BlindSearch(new DeJong(30), numIterations);
        BlindSearch rosenbrockThirty = new BlindSearch(new Rosenbrock(30), numIterations);
        BlindSearch rastriginThirty = new BlindSearch(new Rastrigin(30), numIterations);
        BlindSearch griewangkThirty = new BlindSearch(new Griewangk(30), numIterations);
        BlindSearch seswThirty = new BlindSearch(new SineEnvelopeSineWave(30), numIterations);
        BlindSearch svswThirty = new BlindSearch(new StretchVSineWave(30), numIterations);
        BlindSearch ackOneThirty = new BlindSearch(new AckleyOne(30), numIterations);
        BlindSearch ackTwoThirty = new BlindSearch(new AckleyTwo(30), numIterations);
        BlindSearch eggHolderThirty = new BlindSearch(new EggHolder(30), numIterations);
        BlindSearch ranaThirty = new BlindSearch(new EggHolder(30), numIterations);
        BlindSearch pathThirty = new BlindSearch(new Pathological(30), numIterations);
        BlindSearch michalewiczThirty = new BlindSearch(new Michalewicz(30), numIterations);
        BlindSearch mcwThirty = new BlindSearch(new MastersCosineWave(30), numIterations);
        BlindSearch shekelsThirty = new BlindSearch(new ShekelsFoxhole(30), numIterations);
        
        for(int i = 0; i < outerIterations-1; i++){
            schwefelThirty.rerun();                         dejongThirty.rerun();
            rosenbrockThirty.rerun();                       rastriginThirty.rerun();
            griewangkThirty.rerun();                        seswThirty.rerun();
            svswThirty.rerun();                             ackOneThirty.rerun();
            ackTwoThirty.rerun();                           eggHolderThirty.rerun();
            ranaThirty.rerun();                             pathThirty.rerun();
            michalewiczThirty.rerun();                      mcwThirty.rerun();
            shekelsThirty.rerun();
        }
        
        
        //Blind Search 30 dimension trial times for 100 iterations
        blindTimesThirty.add(schwefelThirty.getTime());          blindTimesThirty.add(dejongThirty.getTime());
        blindTimesThirty.add(rosenbrockThirty.getTime());        blindTimesThirty.add(rastriginThirty.getTime());
        blindTimesThirty.add(griewangkThirty.getTime());         blindTimesThirty.add(seswThirty.getTime());
        blindTimesThirty.add(svswThirty.getTime());              blindTimesThirty.add(ackOneThirty.getTime());
        blindTimesThirty.add(ackTwoThirty.getTime());            blindTimesThirty.add(eggHolderThirty.getTime());
        blindTimesThirty.add(ranaThirty.getTime());              blindTimesThirty.add(pathThirty.getTime());
        blindTimesThirty.add(michalewiczThirty.getTime());       blindTimesThirty.add(mcwThirty.getTime());
        blindTimesThirty.add(shekelsThirty.getTime());
        
        System.out.println("30 dimension times: " + blindTimesThirty.toString());
        
        //Calculate averages for 30 dimension trials
        blindAverageThirty.add(statAverage(schwefelThirty.getBests()));
        blindAverageThirty.add(statAverage(dejongThirty.getBests()));
        blindAverageThirty.add(statAverage(rosenbrockThirty.getBests()));
        blindAverageThirty.add(statAverage(rastriginThirty.getBests()));
        blindAverageThirty.add(statAverage(griewangkThirty.getBests()));
        blindAverageThirty.add(statAverage(seswThirty.getBests()));
        blindAverageThirty.add(statAverage(svswThirty.getBests()));
        blindAverageThirty.add(statAverage(ackOneThirty.getBests()));
        blindAverageThirty.add(statAverage(ackTwoThirty.getBests()));
        blindAverageThirty.add(statAverage(eggHolderThirty.getBests()));
        blindAverageThirty.add(statAverage(ranaThirty.getBests()));
        blindAverageThirty.add(statAverage(pathThirty.getBests()));
        blindAverageThirty.add(statAverage(michalewiczThirty.getBests()));
        blindAverageThirty.add(statAverage(mcwThirty.getBests()));
        blindAverageThirty.add(statAverage(shekelsThirty.getBests()));
        
        //Calculate standard deviation for 30 dimension trials
        blindDeviationThirty.add(standardDeviation(schwefelThirty.getBests()));
        blindDeviationThirty.add(standardDeviation(dejongThirty.getBests()));
        blindDeviationThirty.add(standardDeviation(rosenbrockThirty.getBests()));
        blindDeviationThirty.add(standardDeviation(rastriginThirty.getBests()));
        blindDeviationThirty.add(standardDeviation(griewangkThirty.getBests()));
        blindDeviationThirty.add(standardDeviation(seswThirty.getBests()));
        blindDeviationThirty.add(standardDeviation(svswThirty.getBests()));
        blindDeviationThirty.add(standardDeviation(ackOneThirty.getBests()));
        blindDeviationThirty.add(standardDeviation(ackTwoThirty.getBests()));
        blindDeviationThirty.add(standardDeviation(eggHolderThirty.getBests()));
        blindDeviationThirty.add(standardDeviation(ranaThirty.getBests()));
        blindDeviationThirty.add(standardDeviation(pathThirty.getBests()));
        blindDeviationThirty.add(standardDeviation(michalewiczThirty.getBests()));
        blindDeviationThirty.add(standardDeviation(mcwThirty.getBests()));
        blindDeviationThirty.add(standardDeviation(shekelsThirty.getBests()));
        
        System.out.println("30 dimension averages: " + blindAverageThirty.toString());
        System.out.println("30 dimension standard deviation: " + blindDeviationThirty.toString());
        
        //////////////////////////////////////////////////////////////////////////////////////////////////
        
        ArrayList<Double> localTimesTen = new ArrayList();
        ArrayList<Double> localTimesTwenty = new ArrayList();
        ArrayList<Double> localTimesThirty = new ArrayList();
        ArrayList<Double> localAverageTen = new ArrayList();
        ArrayList<Double> localAverageTwenty = new ArrayList();
        ArrayList<Double> localAverageThirty = new ArrayList();
        ArrayList<Double> localDeviationTen = new ArrayList();
        ArrayList<Double> localDeviationTwenty = new ArrayList();
        ArrayList<Double> localDeviationThirty = new ArrayList();
        ArrayList<Integer> localCallsTen = new ArrayList();
        
        LocalSearch loSchwefelTen = new LocalSearch(new Schwefel(10));
        LocalSearch loDeJongTen = new LocalSearch(new DeJong(10));
        LocalSearch loRosenbrockTen = new LocalSearch(new Rosenbrock(10));
        LocalSearch loRastriginTen = new LocalSearch(new Rastrigin(10));
        LocalSearch loGriewangkTen = new LocalSearch(new Griewangk(10));
        LocalSearch loSESWTen = new LocalSearch(new SineEnvelopeSineWave(10));
        LocalSearch loSVSWTen = new LocalSearch(new StretchVSineWave(10));
        LocalSearch loAckOneTen = new LocalSearch(new AckleyOne(10));
        LocalSearch loAckTwoTen = new LocalSearch(new AckleyTwo(10));
        LocalSearch loEggHolderTen = new LocalSearch(new EggHolder(10));
        LocalSearch loRanaTen = new LocalSearch(new Rana(10));
        LocalSearch loPathTen = new LocalSearch(new Pathological(10));
        LocalSearch loMichaTen = new LocalSearch(new Michalewicz(10));
        LocalSearch loMCWTen = new LocalSearch(new MastersCosineWave(10));
        LocalSearch loShekelsTen = new LocalSearch(new ShekelsFoxhole(10));
        
        for(int i = 0; i < outerIterations-1; i++){
            loSchwefelTen.rerun();          loDeJongTen.rerun();
            loRosenbrockTen.rerun();        loRastriginTen.rerun();
            loGriewangkTen.rerun();         loSESWTen.rerun();
            loSVSWTen.rerun();              loAckOneTen.rerun();
            loAckTwoTen.rerun();            loEggHolderTen.rerun();
            loRanaTen.rerun();              loPathTen.rerun();
            loMichaTen.rerun();             loMCWTen.rerun();
            loShekelsTen.rerun();
        }
        
        System.out.println("-------------------------------------------------------");
        
        localTimesTen.add(loSchwefelTen.getTime());
        localTimesTen.add(loDeJongTen.getTime());
        localTimesTen.add(loRosenbrockTen.getTime());
        localTimesTen.add(loRastriginTen.getTime());
        localTimesTen.add(loGriewangkTen.getTime());
        localTimesTen.add(loSESWTen.getTime());
        localTimesTen.add(loSVSWTen.getTime());
        localTimesTen.add(loAckOneTen.getTime());
        localTimesTen.add(loAckTwoTen.getTime());
        localTimesTen.add(loEggHolderTen.getTime());
        localTimesTen.add(loRanaTen.getTime());
        localTimesTen.add(loPathTen.getTime());
        localTimesTen.add(loMichaTen.getTime());
        localTimesTen.add(loMCWTen.getTime());
        localTimesTen.add(loShekelsTen.getTime());
        
        System.out.println("10 dimension times: " + localTimesTen.toString());
        
        localAverageTen.add(statAverage(loSchwefelTen.getSolutions()));
        localAverageTen.add(statAverage(loDeJongTen.getSolutions()));
        localAverageTen.add(statAverage(loRosenbrockTen.getSolutions()));
        localAverageTen.add(statAverage(loRastriginTen.getSolutions()));
        localAverageTen.add(statAverage(loGriewangkTen.getSolutions()));
        localAverageTen.add(statAverage(loSESWTen.getSolutions()));
        localAverageTen.add(statAverage(loSVSWTen.getSolutions()));
        localAverageTen.add(statAverage(loAckOneTen.getSolutions()));
        localAverageTen.add(statAverage(loAckTwoTen.getSolutions()));
        localAverageTen.add(statAverage(loEggHolderTen.getSolutions()));
        localAverageTen.add(statAverage(loRanaTen.getSolutions()));
        localAverageTen.add(statAverage(loPathTen.getSolutions()));
        localAverageTen.add(statAverage(loMichaTen.getSolutions()));
        localAverageTen.add(statAverage(loMCWTen.getSolutions()));
        localAverageTen.add(statAverage(loShekelsTen.getSolutions()));
        
        System.out.println("10 dimension averages: " + localAverageTen.toString());
        
        localDeviationTen.add(standardDeviation(loSchwefelTen.getSolutions()));
        localDeviationTen.add(standardDeviation(loDeJongTen.getSolutions()));
        localDeviationTen.add(standardDeviation(loRosenbrockTen.getSolutions()));
        localDeviationTen.add(standardDeviation(loRastriginTen.getSolutions()));
        localDeviationTen.add(standardDeviation(loGriewangkTen.getSolutions()));
        localDeviationTen.add(standardDeviation(loSESWTen.getSolutions()));
        localDeviationTen.add(standardDeviation(loSVSWTen.getSolutions()));
        localDeviationTen.add(standardDeviation(loAckOneTen.getSolutions()));
        localDeviationTen.add(standardDeviation(loAckTwoTen.getSolutions()));
        localDeviationTen.add(standardDeviation(loEggHolderTen.getSolutions()));
        localDeviationTen.add(standardDeviation(loRanaTen.getSolutions()));
        localDeviationTen.add(standardDeviation(loPathTen.getSolutions()));
        localDeviationTen.add(standardDeviation(loMichaTen.getSolutions()));
        localDeviationTen.add(standardDeviation(loMCWTen.getSolutions()));
        localDeviationTen.add(standardDeviation(loShekelsTen.getSolutions()));
        
        System.out.println("10 dimension standard deviation: " + localDeviationTen.toString());
        
        localCallsTen.add(loSchwefelTen.getNumCalls());
        localCallsTen.add(loDeJongTen.getNumCalls());
        localCallsTen.add(loRosenbrockTen.getNumCalls());
        localCallsTen.add(loRastriginTen.getNumCalls());
        localCallsTen.add(loGriewangkTen.getNumCalls());
        localCallsTen.add(loSESWTen.getNumCalls());
        localCallsTen.add(loSVSWTen.getNumCalls());
        localCallsTen.add(loAckOneTen.getNumCalls());
        localCallsTen.add(loAckTwoTen.getNumCalls());
        localCallsTen.add(loEggHolderTen.getNumCalls());
        localCallsTen.add(loRanaTen.getNumCalls());
        localCallsTen.add(loPathTen.getNumCalls());
        localCallsTen.add(loMichaTen.getNumCalls());
        localCallsTen.add(loMCWTen.getNumCalls());
        localCallsTen.add(loShekelsTen.getNumCalls());
        
        System.out.println("10 dimension function calls: " + localCallsTen.toString());
        System.out.println("--------------------------------------------------------");
        
        ArrayList<Double> ilsTimesTen = new ArrayList();
        ArrayList<Double> ilsTimesTwenty = new ArrayList();
        ArrayList<Double> ilsTimesThirty = new ArrayList();
        ArrayList<Double> ilsAverageTen = new ArrayList();
        ArrayList<Double> ilsAverageTwenty = new ArrayList();
        ArrayList<Double> ilsAverageThirty = new ArrayList();
        ArrayList<Double> ilsDeviationTen = new ArrayList();
        ArrayList<Double> ilsDeviationTwenty = new ArrayList();
        ArrayList<Double> ilsDeviationThirty = new ArrayList();
        ArrayList<Integer> ilsCallsTen = new ArrayList();
        
        IterativeLocalSearch ilsSchwefelTen = new IterativeLocalSearch(new Schwefel(10), 100);
        IterativeLocalSearch ilsDeJongTen = new IterativeLocalSearch(new DeJong(10), 100);
        IterativeLocalSearch ilsRosenbrockTen = new IterativeLocalSearch(new Rosenbrock(10), 100);
        IterativeLocalSearch ilsRastriginTen = new IterativeLocalSearch(new Rastrigin(10), 100);
        IterativeLocalSearch ilsGriewangkTen = new IterativeLocalSearch(new Griewangk(10), 100);
        IterativeLocalSearch ilsSESWTen = new IterativeLocalSearch(new SineEnvelopeSineWave(10), 100);
        IterativeLocalSearch ilsSVSWTen = new IterativeLocalSearch(new StretchVSineWave(10), 100);
        IterativeLocalSearch ilsAckOneTen = new IterativeLocalSearch(new AckleyOne(10), 100);
        IterativeLocalSearch ilsAckTwoTen = new IterativeLocalSearch(new AckleyTwo(10), 100);
        IterativeLocalSearch ilsEggHolderTen = new IterativeLocalSearch(new EggHolder(10), 100);
        IterativeLocalSearch ilsRanaTen = new IterativeLocalSearch(new Rana(10), 100);
        IterativeLocalSearch ilsPathTen = new IterativeLocalSearch(new Pathological(10), 100);
        IterativeLocalSearch ilsMichaTen = new IterativeLocalSearch(new Michalewicz(10), 100);
        IterativeLocalSearch ilsMCWTen = new IterativeLocalSearch(new MastersCosineWave(10), 100);
        IterativeLocalSearch ilsShekelsTen = new IterativeLocalSearch(new ShekelsFoxhole(10), 100);
        
        ilsTimesTen.add(ilsSchwefelTen.getTime());
        ilsTimesTen.add(ilsDeJongTen.getTime());
        ilsTimesTen.add(ilsRosenbrockTen.getTime());
        ilsTimesTen.add(ilsRastriginTen.getTime());
        ilsTimesTen.add(ilsGriewangkTen.getTime());
        ilsTimesTen.add(ilsSESWTen.getTime());
        ilsTimesTen.add(ilsSVSWTen.getTime());
        ilsTimesTen.add(ilsAckOneTen.getTime());
        ilsTimesTen.add(ilsAckTwoTen.getTime());
        ilsTimesTen.add(ilsEggHolderTen.getTime());
        ilsTimesTen.add(ilsRanaTen.getTime());
        ilsTimesTen.add(ilsPathTen.getTime());
        ilsTimesTen.add(ilsMichaTen.getTime());
        ilsTimesTen.add(ilsMCWTen.getTime());
        ilsTimesTen.add(ilsShekelsTen.getTime());
        
        System.out.println("10 dimension times: " + ilsTimesTen.toString());
        
        ilsAverageTen.add(statAverage(ilsSchwefelTen.getSolutions()));
        ilsAverageTen.add(statAverage(ilsDeJongTen.getSolutions()));
        ilsAverageTen.add(statAverage(ilsRosenbrockTen.getSolutions()));
        ilsAverageTen.add(statAverage(ilsRastriginTen.getSolutions()));
        ilsAverageTen.add(statAverage(ilsGriewangkTen.getSolutions()));
        ilsAverageTen.add(statAverage(ilsSESWTen.getSolutions()));
        ilsAverageTen.add(statAverage(ilsSVSWTen.getSolutions()));
        ilsAverageTen.add(statAverage(ilsAckOneTen.getSolutions()));
        ilsAverageTen.add(statAverage(ilsAckTwoTen.getSolutions()));
        ilsAverageTen.add(statAverage(ilsEggHolderTen.getSolutions()));
        ilsAverageTen.add(statAverage(ilsRanaTen.getSolutions()));
        ilsAverageTen.add(statAverage(ilsPathTen.getSolutions()));
        ilsAverageTen.add(statAverage(ilsMichaTen.getSolutions()));
        ilsAverageTen.add(statAverage(ilsMCWTen.getSolutions()));
        ilsAverageTen.add(statAverage(ilsShekelsTen.getSolutions()));
        
        System.out.println("10 dimension averages: " + ilsAverageTen.toString());
        
        
        ilsDeviationTen.add(standardDeviation(ilsSchwefelTen.getSolutions()));
        ilsDeviationTen.add(standardDeviation(ilsDeJongTen.getSolutions()));
        ilsDeviationTen.add(standardDeviation(ilsRosenbrockTen.getSolutions()));
        ilsDeviationTen.add(standardDeviation(ilsRastriginTen.getSolutions()));
        ilsDeviationTen.add(standardDeviation(ilsGriewangkTen.getSolutions()));
        ilsDeviationTen.add(standardDeviation(ilsSESWTen.getSolutions()));
        ilsDeviationTen.add(standardDeviation(ilsSVSWTen.getSolutions()));
        ilsDeviationTen.add(standardDeviation(ilsAckOneTen.getSolutions()));
        ilsDeviationTen.add(standardDeviation(ilsAckTwoTen.getSolutions()));
        ilsDeviationTen.add(standardDeviation(ilsEggHolderTen.getSolutions()));
        ilsDeviationTen.add(standardDeviation(ilsRanaTen.getSolutions()));
        ilsDeviationTen.add(standardDeviation(ilsPathTen.getSolutions()));
        ilsDeviationTen.add(standardDeviation(ilsMichaTen.getSolutions()));
        ilsDeviationTen.add(standardDeviation(ilsMCWTen.getSolutions()));
        ilsDeviationTen.add(standardDeviation(ilsShekelsTen.getSolutions()));
        
        System.out.println("10 dimension standard deviation: " + ilsDeviationTen.toString());
        
        
        
        
    }//end run method
    
    private double statAverage(ArrayList<Double> data){
        double avg = 0.0;
        for(int i = 0; i < data.size(); i++){
            avg += data.get(i);
        }//end for
        return (avg / data.size());
    }
    
        private double standardDeviation(ArrayList<Double> data){
        //first, calculate average of the data
        double mean = statAverage(data);
        ArrayList<Double> temp = new ArrayList<>();
        //second, subtract the average from each element in the data and then square it
        for(int i = 0; i < data.size(); i++){
            temp.add((data.get(i) - mean)*(data.get(i) - mean));
        }//end for
        //third, calculate the mean of this new data set
        double newMean = statAverage(temp);
        return (Math.sqrt(newMean));
    }//end standardDeviation
}
