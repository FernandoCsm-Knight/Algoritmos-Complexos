package EstruturasFlexiveis.OutrasEstruturas.Matrix;

public class Matrix<T> {
    //=====PRIVATE=====//
    private Node<T> start;
    private int line;
    private int column;

    //=====CONSTRUCTOR=====//
    public Matrix(int line, int column) {
        this.setStart(new Node<T>());
        this.setLine(line);
        this.setColumn(column);
        Node<T> node = this.getStart();

        for(int i = 0; i < this.getLine(); i++) {

            if(i != 0) {
                node = new Node<>(null, this.getNode(i - 1, 0), null, null, null);
                node.getTop().setBottom(node);
            }

            for(int j = 1; j < this.getColumn(); j++) {
                node.setRight(new Node<T>(null, null, null, node, null));
                node = node.getRight();

                if(i != 0) {
                    node.setTop(this.getNode(i - 1, j));
                    node.getTop().setBottom(node);
                }
            }
        }
    }

    //=====GET=====//
    private Node<T> getStart() {
        return start;
    }
    
    private Node<T> getNode(int i, int j) {
        Node<T> curr;

        if(i >= this.getLine() || j >= this.getColumn() || i < 0 || j < 0) 
            curr = null;
        else {
            curr = this.getStart();            
            for(int k = 0; k < i; k++) curr = curr.getBottom();
            for(int k = 0; k < j; k++) curr = curr.getRight();
        }

        return curr;
    }
    
    public int getLine() {
        return line;
    }
    
    public int getColumn() {
        return column;
    }

    public T get(int i, int j) {
        return this.getNode(i, j).getObj();
    }

    //=====SET=====//
    private void setStart(Node<T> start) {
        this.start = start;
    }

    private void setLine(int line) {
        this.line = line;
    }

    private void setColumn(int column) {
        this.column = column;
    }

    public void setObj(T obj, int i, int j) {
        this.getNode(i, j).setObj(obj);
    }

    //=====METODOS=====//
    public Boolean isSquare() {
        return this.getLine() == this.getColumn();
    }

    //=====DP=====//
    public String primaryDiagonal() {
        if(!isSquare()) throw new IndexOutOfBoundsException();

        StringBuffer sb = new StringBuffer("[");
        for(int i = 0; i < this.getLine(); i++) {
            sb.append(this.get(i, i));
            if(i != this.getLine() - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    //=====DS=====//
    public String secondaryDiagonal() {
        if(!isSquare()) throw new IndexOutOfBoundsException();
        
        StringBuffer sb = new StringBuffer("[");
        for(int i = this.getLine() - 1; i >= 0; i--) {
            sb.append(this.get(i, i));
            if(i != 0) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    //=====SUM=====//
    public Matrix<Integer> sum(Matrix<T> mat) {
        if(this.getLine() != mat.getLine() || this.getColumn() != mat.getColumn()) throw new IndexOutOfBoundsException();

        Matrix<Integer> aux = new Matrix<>(this.getLine(), this.getColumn());
        for(int i = 0; i < this.getLine(); i++) 
            for(int j = 0; j < this.getColumn(); j++) 
                aux.setObj((Integer)this.get(i, j) + (Integer)mat.get(i, j), i, j);
        
        return aux;
    }

    //=====MULTIPLY=====//
    public Matrix<Integer> mult(Matrix<T> mat) {
        if(this.getColumn() != mat.getLine()) throw new IndexOutOfBoundsException();

        Integer sum = 0;
        Matrix<Integer> aux = new Matrix<>(this.getLine(), mat.getColumn());
        for(int i = 0; i < aux.getLine(); i++) {
            for(int j = 0; j < aux.getColumn(); j++) {
                sum = 0;
                for(int k = 0; k < this.getColumn(); k++) 
                    sum += (Integer)this.get(i, k) * (Integer)mat.get(k, j);
                
                aux.setObj(sum, i, j);
            }
        }

        return aux;
    }

    //=====OVERRIDE=====//
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < this.getLine(); i++) {
            sb.append("[");
            for(int j = 0; j < this.getColumn(); j++) {
                sb.append(this.get(i, j));
                if(j != this.getColumn() - 1) sb.append(", ");
            }
            sb.append("]\n");
        }

        return sb.toString();
    }

}
