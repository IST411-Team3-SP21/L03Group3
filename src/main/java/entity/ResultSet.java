package entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultSet {

    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("limit")
    @Expose
    private Integer limit;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

}
