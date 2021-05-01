package midterm.movie.shoppingAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class OrderBuy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public int product_id;
    public Date createdate;
    public Date editdate;
    public int createBy;
    public int editBy;
    public int userBuy_id;
    public int userSell_id;
    public int statusBuy_id;
    public String Tracking;

    public String getTracking() {
        return Tracking;
    }

    public void setTracking(String tracking) {
        Tracking = tracking;
    }

    public int getUserSell_id() {
        return userSell_id;
    }

    public void setUserSell_id(int userSell_id) {
        this.userSell_id = userSell_id;
    }

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

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
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
