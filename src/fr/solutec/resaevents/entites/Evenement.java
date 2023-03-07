package fr.solutec.resaevents.entites;

public class Evenement {
        private int id;
        private boolean active;
        private String nom;
        private String description;
        private Type type;
        //private Salle salle;


        public Evenement() {
        }

        public Evenement(int id, boolean active, String nom, String description, Type type) {
                this.id = id;
                this.active = active;
                this.nom = nom;
                this.description = description;
                this.type = type;
        }

        public void setId(int id) {
        this.id = id;
        }
        public int getId() {
        return this.id;
        }
        public void setNom(String nom) {
                this.nom = nom;
        }
        public String getNom() {
                return this.nom;
        }
        public void setDescription(String description) {
        this.description = description;
        }
        public String getDescription() {
            return this.description;
        }


        public void setType(Type type) { this.type = type; }
        public Type getType() { return this.type; }

       //public void setSalle(Salle idSalle) { this.salle = Salle.getId(); }
        // public int getSalle() { return this.salle }

}
