
package com.example.shop;

import java.util.List;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Products implements Parcelable
{

    @SerializedName("products")
    @Expose
    private List<Product> products;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("skip")
    @Expose
    private Integer skip;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    public final static Creator<Products> CREATOR = new Creator<Products>() {


        public Products createFromParcel(android.os.Parcel in) {
            return new Products(in);
        }

        public Products[] newArray(int size) {
            return (new Products[size]);
        }

    }
    ;

    @SuppressWarnings({
        "unchecked"
    })
    protected Products(android.os.Parcel in) {
        in.readList(this.products, (Product.class.getClassLoader()));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.skip = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.limit = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Products() {
    }

    /**
     * 
     * @param total
     * @param limit
     * @param skip
     * @param products
     */
    public Products(List<Product> products, Integer total, Integer skip, Integer limit) {
        super();
        this.products = products;
        this.total = total;
        this.skip = skip;
        this.limit = limit;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Products.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("products");
        sb.append('=');
        sb.append(((this.products == null)?"<null>":this.products));
        sb.append(',');
        sb.append("total");
        sb.append('=');
        sb.append(((this.total == null)?"<null>":this.total));
        sb.append(',');
        sb.append("skip");
        sb.append('=');
        sb.append(((this.skip == null)?"<null>":this.skip));
        sb.append(',');
        sb.append("limit");
        sb.append('=');
        sb.append(((this.limit == null)?"<null>":this.limit));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.limit == null)? 0 :this.limit.hashCode()));
        result = ((result* 31)+((this.total == null)? 0 :this.total.hashCode()));
        result = ((result* 31)+((this.skip == null)? 0 :this.skip.hashCode()));
        result = ((result* 31)+((this.products == null)? 0 :this.products.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Products) == false) {
            return false;
        }
        Products rhs = ((Products) other);
        return (((((this.limit == rhs.limit)||((this.limit!= null)&&this.limit.equals(rhs.limit)))&&((this.total == rhs.total)||((this.total!= null)&&this.total.equals(rhs.total))))&&((this.skip == rhs.skip)||((this.skip!= null)&&this.skip.equals(rhs.skip))))&&((this.products == rhs.products)||((this.products!= null)&&this.products.equals(rhs.products))));
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(products);
        dest.writeValue(total);
        dest.writeValue(skip);
        dest.writeValue(limit);
    }

    public int describeContents() {
        return  0;
    }

}
