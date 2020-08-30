package hellocucumber.calculator;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StepDefsCalculator {

    private Calculator calc;

    @Given("a calculator I just turned on")
    public void a_calculator_i_just_turned_on() {
        this.calc = new Calculator();
    }

    @When("I add {int} and {int}")
    public void i_add_and(Integer int1, Integer int2) {
        calc.push(int1);
        calc.push(int2);
        calc.push("+");
    }

    @Then("the result is {double}")
    public void the_result_is(Double expected) {
        assertEquals(expected, calc.value());
    }

    @Given("the previous entries:")
    public void thePreviousEntries(List<Map<String, String>> entries) {
        for (Map<String, String> element: entries){
            calc.push(Integer.valueOf(element.get("first")));
            calc.push(Integer.valueOf(element.get("second")));
            calc.push(element.get("operation"));

        }
//        List<List<String>> rows = entries.asLists(String.class);
//        rows.remove(0);
//        List<Entry> entriess = new ArrayList<>();
//        for (List<String> row: rows) {
//            entriess.add(new Entry(row.get(0), row.get(1), row.get(2)));
//        }

//        for (Entry entry : entries) {
//            calc.push(entry.first);
//            calc.push(entry.second);
//            calc.push(entry.operation);
//        }
    }


    static final class Entry {
        private final Integer first;
        private final Integer second;
        private final String operation;

        public Entry(String first, String second, String operation) {
            this.first = Integer.valueOf(first);
            this.second = Integer.valueOf(second);
            this.operation = operation;
        }

    }

    @When("I press {string}")
    public void i_press(String what) {
        calc.push(what);
    }
}
