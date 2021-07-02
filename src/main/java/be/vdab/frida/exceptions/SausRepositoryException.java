package be.vdab.frida.exceptions;

public class SausRepositoryException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public SausRepositoryException(String message) {
        super(message);
    }
}
