package entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("mindate")
    @Expose
    private String mindate;
    @SerializedName("maxdate")
    @Expose
    private String maxdate;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("datacoverage")
    @Expose
    private Double datacoverage;
    @SerializedName("id")
    @Expose
    private String id;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMindate() {
        return mindate;
    }

    public void setMindate(String mindate) {
        this.mindate = mindate;
    }

    public String getMaxdate() {
        return maxdate;
    }

    public void setMaxdate(String maxdate) {
        this.maxdate = maxdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDatacoverage() {
        return datacoverage;
    }

    public void setDatacoverage(Double datacoverage) {
        this.datacoverage = datacoverage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
