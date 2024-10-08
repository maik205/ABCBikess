/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abcbikes.models;

import abcbikes.interfaces.Queriable;
import abcbikes.services.DataServiceProvider;

/**
 * @author ASUS
 */
public class Product implements Queriable {
    private String productId;
    private String name;
    private String brandId;
    private String categoryId;
    private short modelYear;
    private long listPrice;

    public Product(String id, String name, String brandId, String categoryId, int modelYear, long listPrice) {
        this.productId = id;
        this.name = name;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.modelYear = (short) modelYear;
        this.listPrice = listPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String id) {
        this.productId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public short getModelYear() {
        return modelYear;
    }

    public void setModelYear(short modelYear) {
        this.modelYear = modelYear;
    }

    public long getListPrice() {
        return listPrice;
    }

    public void setListPrice(long listPrice) {
        this.listPrice = listPrice;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %s, Name: %s, BrandID: %s, CategoryID: %s, Model Year: %s, Price: %s",
                this.getId(),
                this.name,
                this.brandId,
                this.categoryId,
                this.modelYear,
                this.listPrice);
    }

    public String toFileString() {
        return String.format("%s, %s, %s, %s, %s, %s",
                this.getId(),
                this.getName(),
                this.getBrandId(),
                this.getCategoryId(),
                this.getModelYear(),
                this.getListPrice());
    }

    public String toLinkedString() {
        return String.format("%s, %s, %s, %s, %s, %s",
                this.getId(),
                this.getName(),
                DataServiceProvider.brandDataService.get(this.getBrandId()).getBrandName(),
                DataServiceProvider.categoryDataService.get(this.getCategoryId()).getCategoryName(),
                this.getModelYear(),
                this.getListPrice());
    }

    @Override
    public String getQueryString() {
        return "Product{" +
                "id='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", brandId='" + brandId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", modelYear=" + modelYear +
                ", listPrice=" + listPrice +
                '}';
    }

    @Override
    public String getId() {
        return this.productId;
    }

}
