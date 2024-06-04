package pl.akadaemiaqa;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import pl.akademiaqa.factory.BrowserFactory;
import pl.akademiaqa.utils.Properties;
import pl.akademiaqa.utils.StringUtils;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    private BrowserFactory browserFactory;
    private Browser browser;
    protected BrowserContext browserContext;

    protected Page page;

    @BeforeAll
    void lunchBrowser() {

        browserFactory = new BrowserFactory();
        browser = browserFactory.getBrowser();

    }

    @BeforeEach
    void createContextAndPage() {
        browserContext = browser.newContext();

        if (isTracingEnabled()) {
            browserContext.tracing()
                    .start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
        }
        page = browserContext.newPage();
        page.setViewportSize(1920, 1080);
    }

    @AfterEach
    void closeContext(TestInfo testInfo) {

        if (isTracingEnabled()) {
            String traceName = "traces/trace_" + StringUtils.removeRoundBrackets(
                    testInfo.getDisplayName()) + "_" + LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern(Properties.getProperty("tracing.date.format"))) + ".zip";

            browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName)));
        }
        browserContext.close();
    }

    @AfterAll
    void closeBrowser() {
        browserFactory.getPlaywright().close();
    }

    private boolean isTracingEnabled() {
        return Boolean.parseBoolean(Properties.getProperty("tracing.enabled"));
    }
}
