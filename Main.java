public class Main {


    public static void main(String[] args) throws IncompatibleError {

        double[] dv1 = {1,5,10,6,8};
        double[] dv2 = {2,7,9,2,1};
        double[] dv3= {0,0,0,5,4};
        double[] dv4 = {2,8,9,11,6};
        double[] dv5 = {5,14,-1,-1,2};

        Vector vv1 = new Vector(dv1);
        Vector vv2 = new Vector(dv2);
        Vector vv3 = new Vector(dv3);
        Vector vv4 = new Vector(dv4);
        Vector vv5 = new Vector(dv5);

        Matrix matrix1 = new Matrix(vv1,vv2,vv3,vv4,vv5);

        System.out.println(matrix1.determinant());

        double[] int_arr_1 = {1,1,4,5};
        double[] int_arr_2 = {3,3,3,2};
        double[] int_arr_3 = {5,1,9,0};
        double[] int_arr_4 = {9,7,7,9};

        Vector v1 = new Vector(int_arr_1);
        Vector v2 = new Vector(int_arr_2);
        Vector v3 = new Vector(int_arr_3);
        Vector v4 = new Vector(int_arr_4);

        Matrix matrix = new Matrix(v1,v2,v3,v4);

        System.out.println(matrix.determinant());



        double[] a = {1,1,2};
        double[] b  = {2,2,5};
        double[] c = {3,3,8};

        Vector arr2_1 = new Vector(a);
        Vector arr2_2 = new Vector(b);
        Vector arr2_3 = new Vector(c);

        Matrix matrix2 = new Matrix(arr2_1, arr2_2, arr2_3);
        System.out.println(matrix2.determinant());


        double[] a1 = {1,3};
        double[] a2  = {2,4};

        Vector v_a1 = new Vector(a1);
        Vector v_a2 = new Vector(a2);

        Matrix m1 = new Matrix(v_a1, v_a2);

        System.out.println(m1.determinant());



    }
}
