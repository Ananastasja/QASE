package adapters;

import io.restassured.response.ResponseBody;
import objects.Suite;

public class SuiteAdapter extends BaseAdapter {

    public static final String SUITE_URI = "/suite/%s";
    public static final String DELETE_SUITE_URI = SUITE_URI + "/%d";

    public int create(String projectCode, Suite suite) {
        return post(String.format(SUITE_URI, projectCode), converter.toJson(suite)).body().path("result.id"); //we just return a certain element
    }

    public ResponseBody createDemo(String projectCode, Suite suite) {
        return post(String.format(SUITE_URI, projectCode), converter.toJson(suite)).body(); //for asserting info from body
    }

    public boolean delete(String projectCode, int id) {
       return delete(String.format(DELETE_SUITE_URI, projectCode, id)).body().path("status");
    }
}
