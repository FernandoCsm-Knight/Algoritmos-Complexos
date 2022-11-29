package HashDiretaComReserva;

public class RemoveError extends RuntimeException {
   public RemoveError() {
      super();
   }
   
   public RemoveError(String s) {
      super(s);
   }
}
