/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermp.service;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named
@SessionScoped
public class RawToken implements Serializable {

    private static String rtoken;

    public RawToken() {
    }

    public static void setRtoken(String rtoken) {
        RawToken.rtoken = rtoken;
    }

    public static String getRtoken() {
        return rtoken;
    }
}
