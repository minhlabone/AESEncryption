/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aesencryption;

/**
 *
 * @author Anhho
 */
public class DataEncryptionProvider {

    private String stringEncryptOrDecrypt;
    private double decryptEncryptTime;

    public DataEncryptionProvider(String stringEncryptOrDecrypt, double decryptEncryptTime) {
        this.stringEncryptOrDecrypt = stringEncryptOrDecrypt;
        this.decryptEncryptTime = decryptEncryptTime;
    }

    public String getStringEncryptOrDecrypt() {
        return stringEncryptOrDecrypt;
    }

    public void setStringEncryptOrDecrypt(String stringEncryptOrDecrypt) {
        this.stringEncryptOrDecrypt = stringEncryptOrDecrypt;
    }

    public double getDecryptEncryptTime() {
        return decryptEncryptTime;
    }

    public void setDecryptEncryptTime(double decryptEncryptTime) {
        this.decryptEncryptTime = decryptEncryptTime;
    }
}
