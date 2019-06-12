package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Product {
   private List<Categorys> Women = new ArrayList<>();
   private List<Categorys> Men = new ArrayList<>();
   private List<Categorys> Kids = new ArrayList<>();

    public List<Categorys> getWomen() {
        return Women;
    }

    public void setWomen(List<Categorys> women) {
        Women = women;
    }

    public List<Categorys> getMen() {
        return Men;
    }

    public void setMen(List<Categorys> men) {
        Men = men;
    }

    public List<Categorys> getKids() {
        return Kids;
    }

    public void setKids(List<Categorys> kids) {
        Kids = kids;
    }

    public class Categorys {
        public String id_category;
        public String name;
        public String image;
        public List<Subcategory> subcategory = new ArrayList<>();

        public String getId_category() {
            return id_category;
        }

        public void setId_category(String id_category) {
            this.id_category = id_category;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public List<Subcategory> getSubcategory() {
            return subcategory;
        }

        public void setSubcategory(List<Subcategory> subcategory) {
            this.subcategory = subcategory;
        }
    }

    public class Subcategory {
        public String id_category_sub;
        public String name_sub;
        public String image;

        public String getId_category_sub() {
            return id_category_sub;
        }

        public void setId_category_sub(String id_category_sub) {
            this.id_category_sub = id_category_sub;
        }

        public String getName_sub() {
            return name_sub;
        }

        public void setName_sub(String name_sub) {
            this.name_sub = name_sub;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
