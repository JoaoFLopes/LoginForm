package org.academiadecodigo.mavenlogin.persistence;

/**
 * Created by codecadet on 06/12/16.
 */
public class TransactionException extends RuntimeException {

    public TransactionException(Throwable ex){
        super(ex);
    }
}
