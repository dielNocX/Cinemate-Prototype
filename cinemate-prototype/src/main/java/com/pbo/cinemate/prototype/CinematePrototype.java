/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pbo.cinemate.prototype;

/**
 *
 * @author Asus
 */
public class CinematePrototype {

    public static void main(String[] args) {
        User.register();
        User user1 = null;
        while (user1 == null) {
            user1 = User.login();
        }
        if (user1 != null) {
            user1.showProfile();   
        }
    }
}
