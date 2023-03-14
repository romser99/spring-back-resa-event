package fr.solutec.re.services;

import fr.solutec.re.entites.Role;
import fr.solutec.re.enums.RoleEnum;

import java.util.ArrayList;
import java.util.List;

import static fr.solutec.re.utils.Data.ROLE_LABELS;


public class RoleService {

    public Role create(Role role) {
        int id = (int)(Math.random() * 50 + 1);
        role.setId(id);
        return new Role(id, role.getLibelle());
    }
    public List<Role> list() {
        List<Role> roles = new ArrayList<>();
        for (RoleEnum roleLabel : ROLE_LABELS) {
            int id = (int)(Math.random() * 50 + 1);
            Role role = new Role();
            role.setLibelle(roleLabel);
            role.setId(id);
            roles.add(role);

        }
        return roles;
    }
    /**
     * retourne un role en fonction de son libelle
     * @param libelle
     * @return role
     */
    public Role read(RoleEnum libelle){
        // faire une requete
        List<Role> roles = this.list();
        Role role;
        switch (libelle) {
            case ADMIN :
                role= this.filter(roles, libelle);
                break;
            case GESTIONNAIRE :
                role= this.filter(roles, libelle);
                break;
            case UTILISATEUR :
                role= this.filter(roles, libelle);
                break;
            default :
                role= null;
                break;

        }
        return role;
    }

    public void delete(int id ) {

    }
    private Role filter (List<Role> roles, RoleEnum libelle) {
        return roles.stream().filter(role -> role.getLibelle().equals(libelle)).findFirst().get();
    }
}
