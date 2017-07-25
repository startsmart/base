package startsmart.base.utility.file;

import startsmart.base.contract.general.ToPOJO;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by sanjeev on 25/07/17.
 */
public abstract class SVReader<T> {

    private final String rowSeparator;
    private final String colSeparator;
    private final ToPOJO<T> converter;

    public SVReader(String rowSeparator,
                    String colSeparator, ToPOJO<T> converter) {
        this.rowSeparator = Objects.requireNonNull(rowSeparator);
        this.colSeparator = Objects.requireNonNull(colSeparator);
        this.converter = Objects.requireNonNull(converter);
    }

    public List<T> read(File file) throws IOException {
        List<T> rData = new ArrayList<>();
        List<String[]> data = readData(file);
        Map<String, Integer> headerPositionMap = null;
        for(String[] col : data) {
            if(headerPositionMap == null) {
                headerPositionMap = createHeaderPositionMap(col);
            } else{
              rData.add(this.getConverter().convert(col, headerPositionMap));
            }
        }
        return rData;
    }

    public List<T> readFileWithNoHeaderRow(File file) throws IOException {
        List<T> rData = new ArrayList<>();
        List<String[]> data = readData(file);
        for(String[] col : data) {
            rData.add(this.getConverter().convert(col));
        }
        return rData;
    }

    public Map<String, T> read(File file, String keyColumnId) throws IOException {
        Map<String, T> rData = new HashMap<>();
        List<String[]> data = readData(file);
        Map<String, Integer> headerPositionMap = null;
        for(String[] col : data) {
            if(headerPositionMap == null) {
                headerPositionMap = createHeaderPositionMap(col);
            } else{
                T colData = this.getConverter().convert(col, headerPositionMap);
                String keyColValue = headerPositionMap.containsKey(keyColumnId)
                                        ? col[headerPositionMap.get(keyColumnId)]
                                        : col[0];
                rData.put(keyColValue, colData);

            }
        }
        return rData;
    }

    public String getRowSeparator() {
        return rowSeparator;
    }

    public String getColSeparator() {
        return colSeparator;
    }

    public ToPOJO<T> getConverter() {
        return converter;
    }

    protected Map<String,Integer> createHeaderPositionMap(String[] data){
        Map<String, Integer> map = new HashMap<>();
        Integer i = 0;
        for(String s : data){
            map.put(s, i);
            i++;
        }
        return map;
    }

    protected String[] splitColumn(String row) {
        String[] temp = row.split(this.getColSeparator());

        if (!row.contains("\""))
            return temp;

        List<String> store = new ArrayList<>();
        String holder = null;
        for (String s : temp) {
            if (s.contains("\"")) {
                if (s.endsWith("\"")) {
                    holder = holder == null ? "" : holder + this.getColSeparator();
                    holder = holder + s.replace("\"", "");
                    store.add(holder);
                    holder = null;
                } else {
                    holder = s.replace("\"", "");
                }
            } else if (holder == null) {
                store.add(s);
            } else {
                holder = holder + this.getColSeparator() + s;
            }
        }

        return store.toArray(new String[store.size()]);
    }

    protected List<String[]> readData(File file) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter(this.getRowSeparator());
            Map<String, Integer> headerPositionMap = null;
            while (scanner.hasNext()) {
                String row = scanner.next();
               data.add(splitColumn(row));
            }
        }
        return data;
    }
}
