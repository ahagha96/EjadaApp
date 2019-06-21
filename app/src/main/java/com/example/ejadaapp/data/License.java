
package com.example.ejadaapp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class License {

    @SerializedName("key")
    @Expose
    public String key;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("spdx_id")
    @Expose
    public String spdxId;
    @SerializedName("url")
    @Expose
    public Object url;
    @SerializedName("node_id")
    @Expose
    public String nodeId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public License() {
    }

    /**
     * 
     * @param nodeId
     * @param spdxId
     * @param name
     * @param url
     * @param key
     */
    public License(String key, String name, String spdxId, Object url, String nodeId) {
        super();
        this.key = key;
        this.name = name;
        this.spdxId = spdxId;
        this.url = url;
        this.nodeId = nodeId;
    }

}
