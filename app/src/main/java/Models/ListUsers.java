package Models;

import java.util.ArrayList;

public class ListUsers<U> {

    private ArrayList<U> results;

    public ArrayList<U> getResults() {
        return results;
    }

    public void setResults(ArrayList<U> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ListUsers{" +
                "results=" + results +
                '}';
    }
}
