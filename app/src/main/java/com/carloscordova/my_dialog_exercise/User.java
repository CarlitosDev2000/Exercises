package com.carloscordova.my_dialog_exercise;

public class User {
        private String nameUser;
        private int ageUser ;
        private String emailUser;

        public User(String nameUser, int ageUser, String emailUser) {
            this.nameUser = nameUser;
            this.ageUser = ageUser;
            this.emailUser = emailUser;
        }
        public String getNameUser(){

            return nameUser;
        }
        public int getAgeUser(){

            return ageUser;
        }
        public String getEmailUser(){
            return emailUser;
    }
}
