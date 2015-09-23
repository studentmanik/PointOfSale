/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.BLL;

import pos.DAL.*;

/**
 *
 * @author Md Mamin
 */
public class UserManager {
    UserGateway anUserGate = new UserGateway();

    public boolean getUserByName(String id, String ps) {
        return anUserGate.getUserName(id, ps);
    }

}
