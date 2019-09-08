package com.kv.expandablelistview;

import java.util.ArrayList;

public class RetorentDetail {
    private ArrayList<Menuitems> menuitems;

    public ArrayList<Menuitems> getMenuitems() {
        return menuitems;
    }

    public void setMenuitems(ArrayList<Menuitems> menuitems) {
        this.menuitems = menuitems;
    }

    public class Menuitems {
//        int food_type_id;
        private String food_type;
//        int menucount;
        private ArrayList<Menuitems1> menuitems;

        public ArrayList<Menuitems1> getMenuitems() {
            return menuitems;
        }

        public void setMenuitems(ArrayList<Menuitems1> menuitems) {
            this.menuitems = menuitems;
        }

        public String getFood_type() {
            return food_type;
        }

        public void setFood_type(String food_type) {
            this.food_type = food_type;
        }
    }

    public class Menuitems1 {
        int ID;
        int rest_id;
        String name;
        String currency;
        int price;
        String description;
        int vegeterian;
        int suitablefor;
        int gluten_free;
        int spice_level;
        String cuisine;
        String foodtype;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public int getRest_id() {
            return rest_id;
        }

        public void setRest_id(int rest_id) {
            this.rest_id = rest_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getVegeterian() {
            return vegeterian;
        }

        public void setVegeterian(int vegeterian) {
            this.vegeterian = vegeterian;
        }

        public int getSuitablefor() {
            return suitablefor;
        }

        public void setSuitablefor(int suitablefor) {
            this.suitablefor = suitablefor;
        }

        public int getGluten_free() {
            return gluten_free;
        }

        public void setGluten_free(int gluten_free) {
            this.gluten_free = gluten_free;
        }

        public int getSpice_level() {
            return spice_level;
        }

        public void setSpice_level(int spice_level) {
            this.spice_level = spice_level;
        }

        public String getCuisine() {
            return cuisine;
        }

        public void setCuisine(String cuisine) {
            this.cuisine = cuisine;
        }

        public String getFoodtype() {
            return foodtype;
        }

        public void setFoodtype(String foodtype) {
            this.foodtype = foodtype;
        }
    }
}