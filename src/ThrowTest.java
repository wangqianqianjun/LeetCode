/**
 * @wangqianjun
 * @create 2017-11-08 22:59
 **/
public class ThrowTest {


    public static void main(String[] args) {

        ThrowTest t = new ThrowTest();
        try {

            t.ExT();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    boolean ExT3() throws Exception {
        boolean ret = true;
        try {

            for (int i = 2; i >= -1; i--) {
                int j = 12 / i;
                System.out.println(j);
            }
            ret = true;
            System.out.println(" iam " + ret);
            return ret;
        } catch (Exception e) {
            System.out.println("Ext3 was Exception!");
            ret = false;
            throw e;
        } finally {
            System.out.println("Ext3 was fiannly :" + ret);
            return ret;
        }
    }

    boolean ExT2() throws Exception {
        boolean ret = true;
        try {
            ret = ExT3();
            System.out.println("Ext2 was hi");
            return ret;
        } catch (Exception e) {
            System.out.println("Ext2 was Exception!");
            ret = false;
            throw e;
        } finally {
            System.out.println("Ext2 was finally :" + ret);
            return ret;
        }
    }

    boolean ExT() throws Exception {
        boolean ret = true;
        try {
            ret = ExT2();
            System.out.println("Ext was hi");
            return ret;
        } catch (Exception e) {
            System.out.println("Ext was Exception!");
            ret = false;
            throw e;
        } finally {
            System.out.println("Ext was finally :" + ret);
            return ret;
        }
    }


}
