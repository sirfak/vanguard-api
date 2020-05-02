package au.com.vanguard;

import au.com.vanguard.test.models.NetAssetValue;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NetAssetValueTest {

    private String path = "";
    private String host = "https://www.vanguardinvestments.com.au";
    private String response = "";

    @Before
    public void setUp() {
        baseURI = host;
        RestAssured.registerParser("application/x-javascript", Parser.JSON);
        response = get("/retail/mvc/getNavPriceList.jsonp").asString();
    }

    @Test
    public void GiveAPIIsRunning_WhenGetRequestExecutes_ReturnsOK() {
        get("/retail/mvc/getNavPriceList.jsonp").then().statusCode(200);
    }

    @Test
    public void GivenAPIIsRunning_WhenGetExecutes_ThenBodyContainsArrayOfNAV() {

        NetAssetValue[] netAssetValue = new Gson().fromJson(response, NetAssetValue[].class);
        assertThat(netAssetValue.length, greaterThan(0));
    }

    @Test
    public void GivenAPIIsRunning_WhenGetExecutes_ThenAmountIsPresent() {

        NetAssetValue[] netAssetValue = new Gson().fromJson(response, NetAssetValue[].class);

        Arrays.asList(netAssetValue).forEach(
                nav -> nav.getNavPriceArray().forEach(priceArr ->
                {
                    assertThat(priceArr.getAmountChange(), notNullValue());

                })
        );

    }

    @Test
    public void GivenAPIIsRunning_WhenGetExecutes_ThenCurrencyIsAUD_WithDollarSymbol() {

        NetAssetValue[] netAssetValue = new Gson().fromJson(response, NetAssetValue[].class);
        Arrays.asList(netAssetValue).forEach(nav -> nav.getNavPriceArray().forEach(arr -> {

            assertThat(Util.getValidCurrencyCode().contains(arr.getCurrency().getCurrencyCode()), is(true));
            assertThat(arr.getCurrency().getCurrencySymbol(), is("$"));
        }));

    }


    @Test
    public void GivenAPIIsRunning_WhenGetExecutes_ThenPriceChangeIsValid() {
        NetAssetValue[] netAssetValue = new Gson().fromJson(response, NetAssetValue[].class);
        Arrays.asList(netAssetValue).forEach(nav -> nav.getNavPriceArray().forEach(arr ->
                assertThat(Util.isValidPerCentage(arr.getPercentChange()), is(true))));

    }


    @Test
    public void GivenAPIRunning_WhenGetExecutes_ReturnsValidPriceCode() {
        NetAssetValue[] netAssetValue = new Gson().fromJson(response, NetAssetValue[].class);
        Arrays.asList(netAssetValue).forEach(nav -> nav.getNavPriceArray().forEach(arr -> {
            assertThat(arr.getIsFinal(), is(true));
            assertThat(Util.getPriceStatusCode().contains(arr.getPriceStatusType().getPriceStatusCode()), is(true));
        }));
    }

    @Test
    public void GivenAPIRunning_WhenGetExecutes_DateIsNotFuture() {

        NetAssetValue[] netAssetValue = new Gson().fromJson(response, NetAssetValue[].class);
        assertThat(netAssetValue, notNullValue());
        assertThat(netAssetValue, arrayWithSize(greaterThan(0)));

        Arrays.asList(netAssetValue).forEach(a -> a.getNavPriceArray().forEach(
                b -> assertThat(Util.isValidDate(b.getAsOfDate()), is(false))));

    }

    @Test
    public void GivenAPIRunning_WhenGetExecutes_MeasureTypeIsNAV() {

        NetAssetValue[] netAssetValue = new Gson().fromJson(response, NetAssetValue[].class);
        Arrays.asList(netAssetValue).forEach(nav -> nav.getNavPriceArray().forEach(
                arr -> {
                    assertThat(arr.getMeasureType().getMeasureCode(), is("NAV"));
                }
        ));
    }

    @Test
    public void GivenAPIRunning_WhenGetExecutes_DateIsReturenedAndNotInFuture()
    {
        NetAssetValue[] netAssetValue = new Gson().fromJson(response, NetAssetValue[].class);
        Arrays.asList(netAssetValue).forEach(nav -> nav.getNavPriceArray().forEach(
                arr -> {
                    assertThat(arr.getAsOfDate(), notNullValue());
                    //TODO: assert date is not in future

                }
        ));
    }
}