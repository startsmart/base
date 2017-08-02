package startsmart.base.utility.text;

import startsmart.base.constant.StringConstants;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by sanjeev on 02/08/17.
 */
public abstract class SeparatedValue {

    private List<List<Object>> data;
    private String header;
    private List<String> headers;
    private int page = 0;

    private StringBuilder contentBuilder;
    private StringBuilder partContent;
    private String valueSeparator;
    private String lineSeparator;

    public SeparatedValue(String valueSeparator, String lineSeparator)
    {
        this.data = new LinkedList<>();
        this.contentBuilder = new StringBuilder();
        this.partContent =  new StringBuilder();
        this.valueSeparator = valueSeparator;
        this.lineSeparator =  lineSeparator;
    }

    protected abstract String escape(Object data);

    public void addLine(Object... data){
        if(data == null || data.length == 0) {
            addEmptyLine();
        } else {
            addLine(Arrays.asList(data));
        }
    }

    public void addLine(Collection<? extends Object> data){
        if(data == null || data.isEmpty()) {
            addEmptyLine();
        } else {
           synchronized (this){
               List<Object> col = new LinkedList<>(data);
               this.data.add(col);
               if(partContent.length() != 0){
                   partContent.append(lineSeparator);
               }
               partContent.append(constructCol(data));
           }
        }
    }

    public void addHeader(String... headers){
        if(headers != null && headers.length != 0){
            addHeader(Arrays.asList(headers));
        }
    }

    public void addHeader(Collection<String> headers){
        if(headers != null && !headers.isEmpty()){
            this.header = constructCol(headers).toString();
            this.headers = new ArrayList<>(headers);
        }
    }

    public void addEmptyLine(){
        synchronized (this){
            data.add(new LinkedList<>());
            partContent.append(lineSeparator);
        }
    }

    public String getValue(){
        return appendHeader(contentBuilder.toString() + partContent.toString());
    }

    @Override
    public String toString() {
        return getValue();
    }

    public List<String> getHeaders(){
        return headers;
    }

    public String getHeader() {
        return header;
    }

    public List<? extends Object> get(int rowIndex) {
        return data.get(rowIndex);
    }

    public Object get(int rowIndex, int colIndex) {
        List<? extends Object> temp = data.get(rowIndex);
        if(temp == null)
            return null;
        return temp.get(colIndex);
    }

    public Object get(int rowIndex, String colKey){
        int colIndex = getColIndex(colKey);
        if(colIndex == -1)
            throw new IndexOutOfBoundsException(colKey + " not found");
        return get(rowIndex, colIndex);
    }

    public boolean isEmptyLine(int rowIndex){
        List<? extends Object> temp = data.get(rowIndex);
        return temp.isEmpty();
    }

    public boolean hasHeader(){
        return !(headers == null || headers.isEmpty());
    }

    public boolean hasHeader(String colKey){
        return getColIndex(colKey) != -1;
    }

    public int getColIndex(String colKey){
        return headers == null ? -1 : headers.indexOf(colKey);
    }

    public Page page(){

        synchronized (this){
            this.contentBuilder.append(lineSeparator).append(partContent);
            String content = appendHeader(partContent.toString());
            partContent = new StringBuilder();
            page++;
            return new Page(page, content);
        }
    }

    private String appendHeader(String content){
      return  (header != null && !header.isEmpty() ?
                (header + lineSeparator) : StringConstants.EMPTY) + content;

    }
    private StringBuilder constructCol(Collection<? extends Object> data){
        Iterator<? extends Object> elementIterator = data.iterator();
        StringBuilder builder = null;
        if (elementIterator.hasNext()) {
            builder = new StringBuilder();
            builder.append(escape(elementIterator.next()));
            while (elementIterator.hasNext()) {
                builder.append(this.valueSeparator);
                builder.append(escape(elementIterator.next()));
            }
        }
        return builder;
    }
}
