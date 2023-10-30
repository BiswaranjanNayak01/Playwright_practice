package compare;

import base.BaseTest;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.nio.file.Path;
import java.nio.file.Paths;

import static pageDriverFactory.playwrightPageDriver.browserContext;

public class FileUpload extends BaseTest {
    @BeforeMethod(dependsOnMethods = "setup")
    public void br(){
        page=browserContext.newPage();
    }
    @AfterMethod
    public void waitAtLast() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Test
    public void upload() throws InterruptedException {
        page.navigate("https://boards.greenhouse.io/envoy/jobs/6938198002");
        FileChooser fileChooser = page.waitForFileChooser(() -> {
            page.locator("//button[@aria-describedby='resume-allowable-file-types']").click();
        });
        fileChooser.setFiles(Paths.get("src/test/resources/testData/LoadRunner_Installation_Guide.pdf"));

        //<button name="button" type="button" data-source="attach" class="unstyled-button link-button" aria-describedby="resume-allowable-file-types">Attach</button>
        /*
        here we are uploading in a button tag,which is different than upload tag. That's why we need to use setFile method along with FileChooser.
         */
    }

    @Test
    public void upload1() throws InterruptedException {
        page.navigate("https://demoqa.com/upload-download");
        page.setInputFiles("input#uploadFile", Paths.get("src/test/resources/testData/LoadRunner_Installation_Guide.pdf"));
        Thread.sleep(5000);
        page.setInputFiles("input#uploadFile", new Path[0]);
        // <input id="uploadFile" type="file" lang="en" class="form-control-file">
        /*
        multiple file can't be uploaded because,it does not support multifile upload.
         */
    }

    @Test
    public void multipleFileUpload() {
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
        page.setInputFiles("input#filesToUpload", new Path[]{
                Paths.get("src/test/resources/testData/LoadRunner_Installation_Guide.pdf"),
                Paths.get("src/test/resources/testData/Presentation 3.pdf")
        });
        //<input type="file" name="filesToUpload" id="filesToUpload" multiple="" onchange="if (!window.__cfRLUnblockHandlers) return false; makeFileList();">
        /*
        multiple files have been uploaded because,it supports multifile upload.
         */
    }
}
