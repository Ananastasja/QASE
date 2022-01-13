package tests;

import adapters.BaseAdapter;
import adapters.ProjectsAdapter;
import adapters.SuiteAdapter;
import objects.Project;
import objects.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QaseTest {

    @Test
    public void getProjectTest() {
        new BaseAdapter().get("/project");
    }

    @Test
    public void createProjectTest() {
        Project project = Project.builder()
                .code("QA082021")
                .title("QA Auto")
                .description("It is a test project")
                .build();
        new ProjectsAdapter().create(project);
    }

    @Test
    public void createSuiteTest() {
        Suite suite = Suite.builder()
                .title("Smoke test")
                .description("This is the smoke test suite")
                .build();
        new SuiteAdapter().create("QA082021", suite);
    }

    @Test
    public void createSuite2Test() {
        Suite suite = Suite.builder()
                .title("Smoke test")
                .description("This is the smoke test suite")
                .build();
        boolean status = new SuiteAdapter().createDemo("QA082021", suite).path("status");
        Assert.assertTrue(status);
    }

    @Test
    public void createAndDeleteSuiteTest() {
        Suite suite = Suite.builder()
                .title("Regression test")
                .description("This is a regression test suite")
                .build();
        int projectId = new SuiteAdapter().create("QA082021", suite);
        boolean deleteSuite = new SuiteAdapter().delete("QA082021", projectId);
        Assert.assertTrue(deleteSuite);
    }
}
