package entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("resultset")
    @Expose
    private ResultSet resultset;

    public ResultSet getResultSet() {
        return resultset;
    }

    public void setResultSet(ResultSet resultset) {
        this.resultset = resultset;
    }

}
