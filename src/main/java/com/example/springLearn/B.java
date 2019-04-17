package com.example.springLearn;

import java.util.List;

/**
 * @author liuji
 * @create 2019-04-17 16:44
 */
public class B {
    /**
     * Category : [{"categoryId":1,"categoryName":"饮品","categoryImage":"/upload/yinpin.jpg"},{"categoryId":2,"categoryName":"食品","categoryImage":"/upload/shiping.jpg"},{"categoryId":3,"categoryName":"酒类","categoryImage":"/upload/jiullei.jpg"}]
     * recommend : {"id":11,"productName":"统一老坛泡椒牛肉袋面香辣味110g*24袋","filenameSmall":"/upload/ty_ltpj_small.jpg","productPrice":48,"productCost":47.5}
     */

    private RecommendBean recommend;
    private List<CategoryBean> Category;

    public RecommendBean getRecommend() {
        return recommend;
    }

    public void setRecommend(RecommendBean recommend) {
        this.recommend = recommend;
    }

    public List<CategoryBean> getCategory() {
        return Category;
    }

    public void setCategory(List<CategoryBean> Category) {
        this.Category = Category;
    }

    public static class RecommendBean {
        /**
         * id : 11
         * productName : 统一老坛泡椒牛肉袋面香辣味110g*24袋
         * filenameSmall : /upload/ty_ltpj_small.jpg
         * productPrice : 48
         * productCost : 47.5
         */

        private int id;
        private String productName;
        private String filenameSmall;
        private int productPrice;
        private double productCost;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getFilenameSmall() {
            return filenameSmall;
        }

        public void setFilenameSmall(String filenameSmall) {
            this.filenameSmall = filenameSmall;
        }

        public int getProductPrice() {
            return productPrice;
        }

        public void setProductPrice(int productPrice) {
            this.productPrice = productPrice;
        }

        public double getProductCost() {
            return productCost;
        }

        public void setProductCost(double productCost) {
            this.productCost = productCost;
        }
    }

    public static class CategoryBean {
        /**
         * categoryId : 1
         * categoryName : 饮品
         * categoryImage : /upload/yinpin.jpg
         */

        private int categoryId;
        private String categoryName;
        private String categoryImage;

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryImage() {
            return categoryImage;
        }

        public void setCategoryImage(String categoryImage) {
            this.categoryImage = categoryImage;
        }
    }
}
