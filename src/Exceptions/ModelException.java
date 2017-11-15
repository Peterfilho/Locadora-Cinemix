/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author peterson
 */
public class ModelException extends RuntimeException{
    public ModelException(String msg){
        super(msg);
    }
}
