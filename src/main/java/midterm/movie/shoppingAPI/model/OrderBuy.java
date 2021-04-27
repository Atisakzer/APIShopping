package midterm.movie.shoppingAPI.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderBuy {
    @Id
    public int id;
    public int product_id;
    public String createdate;
    public String editdate;
    public int createBy;
    public int editBy;
    public int userBuy_id;
    public int statusBuy_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getEditdate() {
        return editdate;
    }

    public void setEditdate(String editdate) {
        this.editdate = editdate;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public int getEditBy() {
        return editBy;
    }

    public void setEditBy(int editBy) {
        this.editBy = editBy;
    }

    public int getUserBuy_id() {
        return userBuy_id;
    }

    public void setUserBuy_id(int userBuy_id) {
        this.userBuy_id = userBuy_id;
    }

    public int getStatusBuy_id() {
        return statusBuy_id;
    }

    public void setStatusBuy_id(int statusBuy_id) {
        this.statusBuy_id = statusBuy_id;
    }

    public int getUserProduct_id() {
        return UserProduct_id;
    }

    public void setUserProduct_id(int userProduct_id) {
        UserProduct_id = userProduct_id;
    }

    public int UserProduct_id;
}
