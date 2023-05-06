package pages;

public class UploadFilePage extends BasePages{

    private String uploadFile = "//input[@id='file-upload']";

   public  UploadFilePage(){
        super(driver);
    }

    public void navigateToUploadFile(){
        navigateTo("https://the-internet.herokuapp.com/upload");
    }

    public void uploadFile(String path){
        uploadFile(uploadFile, path);
    }
    
    public void clickUploadButton(){
        clickElement("//input[@id='file-submit']");
    }
}
