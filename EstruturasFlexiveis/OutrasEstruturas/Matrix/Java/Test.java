package EstruturasFlexiveis.OutrasEstruturas.Matrix.Java;

public class Test {
    
    public static void main(String[] args) {
        Matrix<Integer> m1 = new Matrix<>(2, 3),
                        m2 = new Matrix<>(3, 2),
                        m3 = new Matrix<>(3, 3),
                        m4 = new Matrix<>(3, 3);
        
        for(int i = 0; i < m3.getLine(); i++) {
            int k = 0;
            for(int j = 0; j < m3.getColumn(); j++) {
                k++;
                m3.setObj(k, i, j);
                m4.setObj(k, i, j);
            }
        }

        for(int i = 0; i < m1.getLine(); i++) {
            int k = 0;
            for(int j = 0; j < m1.getColumn(); j++) {
                k++;
                m1.setObj(k, i, j);
            }
        }

        for(int i = 0; i < m2.getLine(); i++) {
            int k = 0;
            for(int j = 0; j < m2.getColumn(); j++) {
                k++;
                m2.setObj(k, i, j);
            }
        }

        System.out.println("MATRIZ 1");
        System.out.println(m1 + "\n");

        System.out.println("MATRIZ 2");
        System.out.println(m2 + "\n");

        System.out.println("MULTIPLICAÇÃO");
        System.out.println(m1.mult(m2) + "\n");

        System.out.println("MATRIZ 3");
        System.out.println(m3 + "\n");

        System.out.println("MATRIZ 4");
        System.out.println(m4 + "\n");

        System.out.println("SOMA");
        System.out.println(m3.sum(m4) + "\n");

        System.out.println("DIAGONAIS");
        System.out.println(m3.primaryDiagonal());
        System.out.println(m3.secondaryDiagonal());
    }

}
