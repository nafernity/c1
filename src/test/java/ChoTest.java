import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * Created by kei on 7/19/2017.
 */
public class ChoTest {
    @Test
    public void verifyThatNextIntHasBeenCalledOnceWithParameterEqual2() throws Exception {
        SpyRandom jsonBond= new SpyRandom();
        Cho cho = new Cho(jsonBond);
        int numprint=cho.getPattern();
        System.out.print("random number"+numprint);
        Assert.assertTrue(jsonBond.verifyThatNextInsHasBeenCallOnce());
    }
    @Test
    public void verifyThatNextIntHasBeenCalledOnceWithParameterEqual3() throws Exception {
        SpyRandom jsonBond= new SpyRandom();
        Cho cho = new Cho(jsonBond);
        int numprint=cho.getOperator();
        System.out.print("random number"+numprint);
        Assert.assertTrue(jsonBond.verifyThatNextInsHasBeenCallOnce());
    }
    @Test
    public void verifyThatNextIntHasBeenCalledOnceWithParameterEqual9() throws Exception {
        SpyRandom jsonBond= new SpyRandom();
        Cho cho = new Cho(jsonBond);
        int numprint=cho.getOperand();
        System.out.print("random number"+numprint);
        Assert.assertTrue(jsonBond.verifyThatNextInsHasBeenCallOnce());
    }
    class Cho{
        private Random random;
        public Cho(Random random){
            this.random = random;
        }
        public int getPattern() {
            return this.random.nextInt(2)+1 ;
        }
        public int getOperator(){
            return this.random.nextInt(3)+1 ;
        }
        public int getOperand(){
            return this.random.nextInt(9)+1 ;
        }
    }
    class SpyRandom extends Random {
        int signal = 0;
        int bound = 0;

        public int nextInt(int bound) {
            signal++;
            this.bound = bound;
            return 0;
        }

        public boolean verifyThatNextInsHasBeenCallOnce() {
            return signal == 1 && bound == 2;
        }

    }
}
