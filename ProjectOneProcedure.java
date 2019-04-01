
import java.util.ArrayList;

/**
 * @author Matthew Tabert
 */
public class ProjectOneProcedure {
    private final int numVectors, dimensionsOne, dimensionsTwo, dimensionsThree;
    private ArrayList<Double> fOne_One, fOne_Two, fOne_Three, fTwo_One, fTwo_Two,
            fTwo_Three, fThree_One, fThree_Two, fThree_Three, fFour_One, 
            fFour_Two, fFour_Three, fFive_One, fFive_Two, fFive_Three, fSix_One, 
            fSix_Two, fSix_Three, fSeven_One, fSeven_Two, fSeven_Three, 
            fEight_One, fEight_Two, fEight_Three, fNine_One, fNine_Two, 
            fNine_Three, fTen_One, fTen_Two, fTen_Three, fEleven_One,
            fEleven_Two, fEleven_Three, fTwelve_One, fTwelve_Two, fTwelve_Three,
            fThirteen_One, fThirteen_Two, fThirteen_Three, fFourteen_One, 
            fFourteen_Two, fFifteen_One, fFifteen_Two, fFifteen_Three;
    long startTime, endTime;
    private Schwefel schOne, schTwo, schThree;
    private DeJong djOne, djTwo, djThree;
    private Rosenbrock rbOne, rbTwo, rbThree;
    private Rastrigin rrOne, rrTwo, rrThree;
    private Griewangk gwOne, gwTwo, gwThree;
    private SineEnvelopeSineWave seswOne, seswTwo, seswThree;
    private StretchVSineWave svswOne, svswTwo, svswThree;
    private AckleyOne akoOne, akoTwo, akoThree;
    private AckleyTwo aktOne, aktTwo, aktThree;
    private EggHolder ehOne, ehTwo, ehThree;
    private Rana raOne, raTwo, raThree;
    private Pathological plOne, plTwo, plThree;
    private Michalewicz mwOne, mwTwo, mwThree;
    private MastersCosineWave mcwOne, mcwTwo, mcwThree;
    private ShekelsFoxhole sfOne, sfTwo, sfThree;
    
    ArrayList<Algorithm> runtimeAlgorithms = new ArrayList<>();
    
    public ProjectOneProcedure(int numVec, int dOne, int dTwo, int dThree){
        numVectors = numVec;
        dimensionsOne = dOne;
        dimensionsTwo = dTwo;
        dimensionsThree = dThree;
        
        schOne = new Schwefel(dimensionsOne);                schTwo = new Schwefel(dimensionsTwo);                schThree = new Schwefel(dimensionsThree);
        djOne = new DeJong(dimensionsOne);                   djTwo = new DeJong(dimensionsTwo);                   djThree = new DeJong(dimensionsThree);
        rbOne = new Rosenbrock(dimensionsOne);               rbTwo = new Rosenbrock(dimensionsTwo);               rbThree = new Rosenbrock(dimensionsThree);
        rrOne = new Rastrigin(dimensionsOne);                rrTwo = new Rastrigin(dimensionsTwo);                rrThree = new Rastrigin(dimensionsThree);
        gwOne = new Griewangk(dimensionsOne);                gwTwo = new Griewangk(dimensionsTwo);                gwThree = new Griewangk(dThree);
        seswOne = new SineEnvelopeSineWave(dimensionsOne);   seswTwo = new SineEnvelopeSineWave(dimensionsTwo);   seswThree = new SineEnvelopeSineWave(dimensionsThree);
        svswOne = new StretchVSineWave(dimensionsOne);       svswTwo = new StretchVSineWave(dimensionsTwo);       svswThree = new StretchVSineWave(dimensionsThree);
        akoOne = new AckleyOne(dimensionsOne);               akoTwo = new AckleyOne(dimensionsTwo);               akoThree = new AckleyOne(dimensionsThree);
        aktOne = new AckleyTwo(dimensionsOne);               aktTwo = new AckleyTwo(dimensionsTwo);               aktThree = new AckleyTwo(dimensionsThree);
        ehOne = new EggHolder(dimensionsOne);                ehTwo = new EggHolder(dimensionsTwo);                ehThree = new EggHolder(dimensionsThree);
        raOne = new Rana(dimensionsOne);                     raTwo = new Rana(dimensionsTwo);                     raThree = new Rana(dimensionsThree);
        plOne = new Pathological(dimensionsOne);             plTwo = new Pathological(dimensionsTwo);             plThree = new Pathological(dimensionsThree);
        mwOne = new Michalewicz(dimensionsOne);              mwTwo = new Michalewicz(dimensionsTwo);              mwThree = new Michalewicz(dimensionsThree);
        mcwOne = new MastersCosineWave(dimensionsOne);       mcwTwo = new MastersCosineWave(dimensionsTwo);       mcwThree = new MastersCosineWave(dimensionsThree);
        sfOne = new ShekelsFoxhole(dimensionsOne);           sfTwo = new ShekelsFoxhole(dimensionsTwo);           sfThree = new ShekelsFoxhole(dimensionsThree);
        
        runtimeAlgorithms.add(schOne);                       runtimeAlgorithms.add(schTwo);                       runtimeAlgorithms.add(schThree);
        runtimeAlgorithms.add(djOne);                        runtimeAlgorithms.add(djTwo);                        runtimeAlgorithms.add(djThree);
        runtimeAlgorithms.add(rbOne);                        runtimeAlgorithms.add(rbTwo);                        runtimeAlgorithms.add(rbThree);
        runtimeAlgorithms.add(gwOne);                        runtimeAlgorithms.add(gwTwo);                        runtimeAlgorithms.add(gwThree);
        runtimeAlgorithms.add(seswOne);                      runtimeAlgorithms.add(seswTwo);                      runtimeAlgorithms.add(seswThree);
        runtimeAlgorithms.add(svswOne);                      runtimeAlgorithms.add(svswTwo);                      runtimeAlgorithms.add(svswThree);
        runtimeAlgorithms.add(akoOne);                       runtimeAlgorithms.add(akoTwo);                       runtimeAlgorithms.add(akoThree);
        runtimeAlgorithms.add(aktOne);                       runtimeAlgorithms.add(aktTwo);                       runtimeAlgorithms.add(aktThree);
        runtimeAlgorithms.add(ehOne);                        runtimeAlgorithms.add(ehTwo);                        runtimeAlgorithms.add(ehThree);
        runtimeAlgorithms.add(raOne);                        runtimeAlgorithms.add(raTwo);                        runtimeAlgorithms.add(raThree);
        runtimeAlgorithms.add(plOne);                        runtimeAlgorithms.add(plTwo);                        runtimeAlgorithms.add(plThree);
        runtimeAlgorithms.add(mwOne);                        runtimeAlgorithms.add(mwTwo);                        runtimeAlgorithms.add(mwThree);
        runtimeAlgorithms.add(mcwOne);                       runtimeAlgorithms.add(mcwTwo);                       runtimeAlgorithms.add(mcwThree);
        runtimeAlgorithms.add(sfOne);                        runtimeAlgorithms.add(sfTwo);                        runtimeAlgorithms.add(sfThree);
    }//end constructor
    
    public boolean run(){
        for(int i = 0; i < runtimeAlgorithms.size(); i++){
            for(int j = 0; j < numVectors; j++){
                
            }
        }
        
        return true;
    }//end run
}//end ProjectOneProcedure
