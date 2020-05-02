package au.com.vanguard.test.models;

import java.util.List;

public class NetAssetValue {

    private String portId;
    private List<NavPriceArray> navPriceArray = null;

    public String getPortId() {
        return portId;
    }

    public void setPortId(String portId) {
        this.portId = portId;
    }

    public List<NavPriceArray> getNavPriceArray() {
        return navPriceArray;
    }

    public void setNavPriceArray(List<NavPriceArray> navPriceArray) {
        this.navPriceArray = navPriceArray;
    }

}
