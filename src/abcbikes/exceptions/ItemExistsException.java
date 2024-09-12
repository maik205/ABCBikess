/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abcbikes.exceptions;

/**
 *
 * @author ASUS
 */
public class ItemExistsException extends Exception{
    public ItemExistsException(String message) {
        super(message);
    }
}
