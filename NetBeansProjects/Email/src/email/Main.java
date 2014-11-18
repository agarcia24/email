/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

/**
 *
 * @author a044877215y
 */
import java.util.*;

class Main {

    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        EMail email = new EMail();

        System.out.println("E-Mail: ");
        String sEmail = teclado.nextLine();

        if (email.validaEmail(sEmail)) {
            System.out.println("E-Mail válido");
        } else {
            System.out.println("E-Mail NO válido");

        }

    }
}
