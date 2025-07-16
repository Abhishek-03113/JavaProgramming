import java.util.HashSet;
import java.util.Set;

interface contentManagement{
    void addContent(String content);
    void removeContent(String content);
    void modifyContent(String oldContent, String newContent);

}

public class ContentCuration implements contentManagement{
    private Set<String> contents;

    public ContentCuration(){
        contents = new HashSet<String>();
    }

    @Override
    public void addContent(String content) {
        if (!contents.contains(content)){
            this.contents.add(content);
        }
        else{
            System.out.println("Content already exists");
        }

    }

    @Override
    public void removeContent(String content) {
        if  (contents.contains(content)){
            this.contents.remove(content);
        }
        else{
            System.out.println("Content not exists");
        }

    }

    @Override
    public void modifyContent(String oldContent, String newContent) {
        if (!contents.contains(oldContent)){
            System.out.println("Content not exists");
        }
        else{
            this.contents.remove(oldContent);
            this.contents.add(newContent);
        }
    }
}
