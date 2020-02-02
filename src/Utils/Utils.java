/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.robilife.service.PersonneService;
import com.robilife.service.PersonneService_Service;

/**
 *
 * @author khk
 */
public class Utils {
    
    private PersonneService personneService;

    public void initialize() {
        try {
            personneService = new PersonneService_Service().getPersonneServicePort();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PersonneService getPersonneService() {
        initialize();
        return personneService;
    }
}
