package startsmart.base.utility.text;

/**
 * Created by sanjeev on 02/08/17.
 */
public class Page {

    private int pageNumber;
    private String content;

    public Page(int pageNumber, String content) {
        this.pageNumber = pageNumber;
        this.content = content;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public String getContent() {
        return content;
    }
}
