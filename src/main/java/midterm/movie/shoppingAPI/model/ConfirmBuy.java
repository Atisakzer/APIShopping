package midterm.movie.shoppingAPI.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConfirmBuy {
    @Id
    public int id;
    public int product_id;
    public int userBuy_id;
    public int userSell_id;
    public String createdate;

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

    public int getUserBuy_id() {
        return userBuy_id;
    }

    public void setUserBuy_id(int userBuy_id) {
        this.userBuy_id = userBuy_id;
    }

    public int getUserSell_id() {
        return userSell_id;
    }

    public void setUserSell_id(int userSell_id) {
        this.userSell_id = userSell_id;
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

    public String editdate;
    public int createBy;
    public int editBy;
}
